package com.jwebmp.plugins.graphing.chartjs;

import com.jwebmp.core.base.angular.client.annotations.angular.*;
import com.jwebmp.plugins.graphing.chartjs.data.*;
import com.jwebmp.plugins.graphing.chartjs.dataset.*;

@NgComponent("chart-line-comp")
public class ChartJSLineComp extends ChartJS<LineData, LineChart, ChartJSLineComp>
{
    public ChartJSLineComp()
    {
        super("chline");
    }

    @Override
    public io.smallrye.mutiny.Uni<LineChart> getInitialOptions()
    {
        return io.smallrye.mutiny.Uni.createFrom().item(() -> new LineChart(new LineData()
                .addLabel("Category 1")
                .addLabel("Category 2")
                .addLabel("Category 3")
                .addDataset(new LineDataset().setLabel("Data Label 1"))
        ));
    }

    @Override
    public String getType()
    {
        return "line";
    }

    @Override
    protected void init()
    {

        super.init();
    }
}
