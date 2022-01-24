package com.jwebmp.plugins.graphing.chartjs;

import com.jwebmp.core.base.html.*;
import com.jwebmp.plugins.graphing.chartjs.javascript.*;

public class ChartJS<O extends Chart<O>> extends Canvas<ChartJS<O>>
{
	private final  Chart<?> options;
	private String dataFetchUrl;
	private Integer dataFetchTimeout;
	
	public ChartJS(String id, O defaultChartOptions)
	{
		this(id, defaultChartOptions, null, null);
	}
	
	public ChartJS(String id, O defaultChartOptions, String dataFetchUrl, Integer dataFetchTimeout)
	{
		setID(id);
		this.dataFetchUrl = dataFetchUrl;
		options = defaultChartOptions;
		this.dataFetchTimeout = dataFetchTimeout;
	}
	
	@Override
	public void init()
	{
		if(!isInitialized())
		{
			addAttribute("chart-js", "");
			addAttribute("options", options.toString(true));
			addAttribute("url", dataFetchUrl);
			addAttribute("delay", dataFetchTimeout + "");
			setInvertColonRender(true);
		}
		
		super.init();
	}
	
	@Override
	public O getOptions()
	{
		return (O) options;
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
	
	public String getDataFetchUrl()
	{
		return dataFetchUrl;
	}
	
	public ChartJS<O> setDataFetchUrl(String dataFetchUrl)
	{
		this.dataFetchUrl = dataFetchUrl;
		return this;
	}
	
	public Integer getDataFetchTimeout()
	{
		return dataFetchTimeout;
	}
	
	public ChartJS<O> setDataFetchTimeout(Integer dataFetchTimeout)
	{
		this.dataFetchTimeout = dataFetchTimeout;
		return this;
	}
	
	
	
}
