package com.jwebmp.plugins.graphing.chartjs;

import com.jwebmp.core.base.html.*;

public class ChartJS<O extends Chart<O>> extends Canvas<ChartJS<O>>
{
	private ChartJSFeature feature;
	
	public ChartJS(String id,O defaultChartOptions)
	{
		setID(id);
		feature = new ChartJSFeature(this,defaultChartOptions);
		addFeature(feature);
	}
	
	@Override
	public O getOptions()
	{
		return (O) feature.getOptions();
	}
	
	public ChartJS<O> setWidth(int width)
	{
		addAttribute("width", width + "");
		return this;
	}
	
	public ChartJS<O> setHeight(int height)
	{
		addAttribute("height", height + "");
		return this;
	}
}
