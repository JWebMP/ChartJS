package com.jwebmp.plugins.graphing.chartjs.options;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public class Interaction
{
	private InteractionModes mode;
	private boolean intersect;
	
	private String axis;
	
	
	public InteractionModes getMode()
	{
		return mode;
	}
	
	public Interaction setMode(InteractionModes mode)
	{
		this.mode = mode;
		return this;
	}
	
	public boolean isIntersect()
	{
		return intersect;
	}
	
	public Interaction setIntersect(boolean intersect)
	{
		this.intersect = intersect;
		return this;
	}
	
	public String getAxis()
	{
		return axis;
	}
	
	public Interaction setAxis(String axis)
	{
		this.axis = axis;
		return this;
	}
}
