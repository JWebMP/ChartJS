package com.jwebmp.plugins.graphing.chartjs.component;

import com.jwebmp.core.Page;
import com.jwebmp.core.base.angular.client.annotations.typescript.TsDependency;
import com.jwebmp.core.services.IPage;
import com.jwebmp.core.services.IPageConfigurator;
import jakarta.validation.constraints.NotNull;

@TsDependency(value = "chart.js", version = "^4.4.1")
public class ChartJSPageConfigurator implements IPageConfigurator<ChartJSPageConfigurator>
{

    public static boolean enabled = true;

    @Override
    public @NotNull IPage<?> configure(IPage<?> page)
    {
        return page;
    }

    @Override
    public boolean enabled()
    {
        return enabled;
    }
}
