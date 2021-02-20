package com.jwebmp.plugins.graphing.chartjs.component;

import com.guicedee.guicedinjection.interfaces.IGuiceScanModuleInclusions;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

public class ChartJSInclusionsModule implements IGuiceScanModuleInclusions<ChartJSInclusionsModule>
{
	@Override
	public @NotNull Set<String> includeModules()
	{
		Set<String> set = new HashSet<>();
		set.add("com.jwebmp.plugins.graphing.chartjs");
		return set;
	}
}
