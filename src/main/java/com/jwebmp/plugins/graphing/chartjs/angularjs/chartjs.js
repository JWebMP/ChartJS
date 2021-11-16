JW_APP_NAME.directive('chartJs', ['$rootScope','$interval','$timeout', function ($rootScope,$interval,$timeout) {
    return {
        restrict: 'A',
        scope: {
            options: '@options',
            url: '@url',
            delay: '@delay',
            websocketGroup: '@websocket'
        },
        controllerAs: 'vm',
        //bindToController: true,
        controller: ['$http', '$rootScope',  '$scope', function ($http, $rootScope, $scope) {

            $scope.ctrlFn = function (element) {
                var opts = JSON.parse($scope.options);
                $scope.chart = new Chart(element.attr('id'), opts);
            };

        }],

        link: function ($scope, element, attrs) {
            $scope.ctrlFn(element);
            var stopTime;
            function updateChart()
            {
                var id = element.attr('id');
                if($scope.url !== undefined) {
                    if ($('#' + id + ':visible')) {
                        $.get($scope.url, function (data) {
                            data.data.datasets.forEach(function (currentValue, index, arr) {
                                if ($scope.chart.data.datasets === undefined || $scope.chart.data.datasets.length < data.data.datasets.length) {
                                    $scope.chart.data.datasets = data.data.datasets;
                                } else {
                                    $scope.chart.data.datasets[index].data = data.data.datasets[index].data;
                                }
                                $scope.chart.update();
                            })
                        });
                    }
                }
            }

            if($scope.url !== undefined && $scope.delay !== undefined) {
                $timeout( stopTime = $interval(updateChart, $scope.delay),2000);
            }

            if($scope.url !== undefined) {
                element.on('$destroy', function () {
                    $interval.cancel(stopTime);
                    stopTime = undefined;
                    $scope.chart.destroy();
                    $scope.chart = undefined;
                });
            }

        }
    };
}]);
