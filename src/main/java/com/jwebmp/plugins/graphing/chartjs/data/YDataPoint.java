package com.jwebmp.plugins.graphing.chartjs.data;

import com.fasterxml.jackson.annotation.*;

public class YDataPoint<T extends YDataPoint<T>> extends DataPoint<T>
{
	private Number y;
	
	public YDataPoint(Number y)
	{
		this.y = y;
	}
	
	public Number getY()
	{
		return y;
	}
	
	public T setY(Number y)
	{
		this.y = y;
		return (T) this;
	}
	
	
	@JsonValue
	public String toString()
	{
		return "{y:" + y + "}";
	}
	
}
