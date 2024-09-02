package com.jwebmp.plugins.graphing.chartjs;

import com.jwebmp.core.base.angular.client.annotations.angular.*;
import com.jwebmp.plugins.graphing.chartjs.data.*;
import com.jwebmp.plugins.graphing.chartjs.dataset.*;

@NgComponent("chart-mixed-comp")
public class ChartJSMixedComp extends ChartJS<Data, MixedChart, ChartJSMixedComp>
{
    public ChartJSMixedComp()
    {
        super("chmixed");

    }

    @Override
    protected void init()
    {

        super.init();
    }

    @Override
    public Chart<Data, MixedChart> getInitialOptions()
    {
        return new MixedChart(new Data().addLabel("Category 1")
                                        .addLabel("Category 2")
                                        .addLabel("Category 3")
                                        .addDataset(new LineDataset()
                                                            .setLabel("Data Label 1")
                                                            .setData(4.0, 2.0, 3.0)
                                        )
                                        .addDataset(new BarDataset()
                                                            .setLabel("Data Label 1")
                                                            .setData(2.0, 3.0, 4.0)
                                        )
        );
    }
}
