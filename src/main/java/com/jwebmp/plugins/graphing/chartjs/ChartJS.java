package com.jwebmp.plugins.graphing.chartjs;

import com.jwebmp.core.base.html.Canvas;

public class ChartJS extends Canvas<ChartJS>
{
	public ChartJS(String id)
	{
		setID(id);
	}
	
	public ChartJS setWidth(int width)
	{
		addAttribute("width", width + "");
		return this;
	}
	
	public ChartJS setHeight(int height)
	{
		addAttribute("height", height + "");
		return this;
	}
}
