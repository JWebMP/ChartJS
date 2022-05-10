package com.jwebmp.plugins.graphing.chartjs.datapoint;

import com.fasterxml.jackson.annotation.*;
import com.jwebmp.plugins.graphing.chartjs.data.*;

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
	@JsonRawValue
	public String toString()
	{
		return y + "";
	}
	
}
