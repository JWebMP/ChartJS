package com.jwebmp.plugins.graphing.chartjs;

import com.jwebmp.core.base.angular.client.annotations.angular.*;
import com.jwebmp.core.base.angular.client.services.interfaces.*;
import com.jwebmp.core.base.html.*;

@NgComponent("chartjs-kitchen-sink")
public class ChartJSKitchenSink extends DivSimple<ChartJSKitchenSink>
        implements INgComponent<ChartJSKitchenSink>
{

    public ChartJSKitchenSink()
    {
        add(new ChartJSComp());
        add(new ChartJSLineComp());
        add(new ChartJSMixedComp());
    }
}
