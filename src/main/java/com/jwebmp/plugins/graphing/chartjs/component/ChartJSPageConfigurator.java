package com.jwebmp.plugins.graphing.chartjs.component;

import com.jwebmp.core.Page;
import com.jwebmp.core.services.IPageConfigurator;
import jakarta.validation.constraints.NotNull;

public class ChartJSPageConfigurator implements IPageConfigurator<ChartJSPageConfigurator> {

    public static boolean enabled = true;

    @Override
    public @NotNull Page<?> configure(Page page) {

        page.getBody().addCssReference(ChartJSReferences.ChartJSReferences.getCssReference());
        page.getBody().addJavaScriptReference(ChartJSReferences.ChartJSReferences.getReference());

        return page;
    }

    @Override
    public boolean enabled() {
        return enabled;
    }
}
