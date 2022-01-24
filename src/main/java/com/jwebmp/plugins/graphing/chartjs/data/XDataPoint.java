package com.jwebmp.plugins.graphing.chartjs.data;

import com.fasterxml.jackson.annotation.*;

import java.math.*;

@SuppressWarnings({"unchecked", "unused"})
public class XDataPoint<T extends XDataPoint<T>> extends YDataPoint<T>
{
	private Object x;
	
	public XDataPoint(Object x, Number y)
	{
		super(y);
		this.x = x;
	}
	
	public T setX(String x)
	{
		this.x = x;
		return (T) this;
	}
	
	public T setX(Integer x)
	{
		this.x = x;
		return (T) this;
	}
	
	public T setX(Double x)
	{
		this.x = x;
		return (T) this;
	}
	
	public T setX(BigDecimal x, RoundingMode roundingMode)
	{
		x = x.setScale(3, roundingMode);
		this.x = x;
		return (T) this;
	}
	
	public Object getX()
	{
		return x;
	}
	
	public String getXAsString()
	{
		return x.toString();
	}
	
	public Integer getXAsInteger()
	{
		return (Integer) x;
	}
	
	public BigDecimal getXAsBigDecimal()
	{
		return (BigDecimal) x;
	}
	
	
	@JsonValue
	@JsonRawValue
	public String toString()
	{
		return "{\"x\":" + "\"" + x + "\"" + ",\"y\":" + getY() + "}";
	}
	
}
