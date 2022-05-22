package com.jwebmp.plugins.graphing.chartjs.component;

import com.jwebmp.core.*;
import com.jwebmp.core.base.angular.services.annotations.*;
import com.jwebmp.core.base.references.*;
import com.jwebmp.core.services.*;
import jakarta.validation.constraints.*;

@TsDependency(value = "chart.js", version = "*")
public class ChartJSPageConfigurator implements IPageConfigurator<ChartJSPageConfigurator>
{
	
	public static boolean enabled = true;
	
	@Override
	public @NotNull Page<?> configure(Page page)
	{
		return page;
	}
	
	@Override
	public boolean enabled()
	{
		return enabled;
	}
}
