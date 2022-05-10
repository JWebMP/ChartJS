
module com.jwebmp.plugins.graphing.chartjs {
    exports com.jwebmp.plugins.graphing.chartjs;
    exports com.jwebmp.plugins.graphing.chartjs.color;
    exports com.jwebmp.plugins.graphing.chartjs.data;
    exports com.jwebmp.plugins.graphing.chartjs.datapoint;
    exports com.jwebmp.plugins.graphing.chartjs.dataset;
    exports com.jwebmp.plugins.graphing.chartjs.javascript;
    exports com.jwebmp.plugins.graphing.chartjs.enums;
    exports com.jwebmp.plugins.graphing.chartjs.objects;
    exports com.jwebmp.plugins.graphing.chartjs.options;
    exports com.jwebmp.plugins.graphing.chartjs.options.animation;
    exports com.jwebmp.plugins.graphing.chartjs.options.elements;
    exports com.jwebmp.plugins.graphing.chartjs.options.layout;
    exports com.jwebmp.plugins.graphing.chartjs.options.scales;
    exports com.jwebmp.plugins.graphing.chartjs.options.ticks;

    provides com.jwebmp.core.services.IPageConfigurator with com.jwebmp.plugins.graphing.chartjs.component.ChartJSPageConfigurator;
    provides com.guicedee.guicedinjection.interfaces.IGuiceScanModuleInclusions with com.jwebmp.plugins.graphing.chartjs.component.ChartJSInclusionsModule;
   
    requires com.fasterxml.jackson.databind;
    requires transitive com.jwebmp.core.angular;
    
    requires static java.desktop;
    
    opens com.jwebmp.plugins.graphing.chartjs to com.google.guice,com.fasterxml.jackson.databind,com.jwebmp.core;
   // opens com.jwebmp.plugins.graphing.chartjs.angularjs to com.google.guice,com.fasterxml.jackson.databind,com.jwebmp.core.angular,com.jwebmp.core;
    opens com.jwebmp.plugins.graphing.chartjs.component to com.google.guice,com.fasterxml.jackson.databind;
    opens com.jwebmp.plugins.graphing.chartjs.color to com.google.guice,com.fasterxml.jackson.databind;
    opens com.jwebmp.plugins.graphing.chartjs.data to com.google.guice,com.fasterxml.jackson.databind;
    opens com.jwebmp.plugins.graphing.chartjs.datapoint to com.google.guice,com.fasterxml.jackson.databind;
    opens com.jwebmp.plugins.graphing.chartjs.dataset to com.google.guice,com.fasterxml.jackson.databind;
    opens com.jwebmp.plugins.graphing.chartjs.javascript to com.google.guice,com.fasterxml.jackson.databind;
    opens com.jwebmp.plugins.graphing.chartjs.enums to com.google.guice,com.fasterxml.jackson.databind;
    opens com.jwebmp.plugins.graphing.chartjs.objects to com.google.guice,com.fasterxml.jackson.databind;
    opens com.jwebmp.plugins.graphing.chartjs.options to com.google.guice,com.fasterxml.jackson.databind;
    opens com.jwebmp.plugins.graphing.chartjs.options.animation to com.google.guice,com.fasterxml.jackson.databind;
    opens com.jwebmp.plugins.graphing.chartjs.options.elements to com.google.guice,com.fasterxml.jackson.databind;
    opens com.jwebmp.plugins.graphing.chartjs.options.layout to com.google.guice,com.fasterxml.jackson.databind;
    opens com.jwebmp.plugins.graphing.chartjs.options.scales to com.google.guice,com.fasterxml.jackson.databind;
    opens com.jwebmp.plugins.graphing.chartjs.options.ticks to com.google.guice,com.fasterxml.jackson.databind;

}