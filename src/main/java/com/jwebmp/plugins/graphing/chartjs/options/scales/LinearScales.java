/*
	Copyright 2020 Marceau Dewilde <m@ceau.be>

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

		http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
*/
package com.jwebmp.plugins.graphing.chartjs.options.scales;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect.*;
import com.fasterxml.jackson.annotation.JsonInclude.*;

import java.util.*;

/**
 * The linear scale is use to chart numerical data. It can be placed on either
 * the x or y axis. The scatter chart type automatically configures a line chart
 * to use one of these scales for the x axis. As the name suggests, linear
 * interpolation is used to determine where a value lies on the axis.
 */
@JsonInclude(Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class LinearScales
{
	
	private XAxis<?> x;
	private YAxis<?> y;
	
	private final List<LinearScale> xAxes = new ArrayList<>();
	
	private final List<LinearScale> yAxes = new ArrayList<>();
	
	public List<LinearScale> getxAxes()
	{
		return xAxes;
	}
	
	public LinearScales addxAxis(LinearScale xAxis)
	{
		this.xAxes.add(xAxis);
		return this;
	}
	
	public LinearScales setxAxes(List<LinearScale> xAxes)
	{
		this.xAxes.clear();
		if (xAxes != null)
		{
			this.xAxes.addAll(xAxes);
		}
		return this;
	}
	
	public List<LinearScale> getyAxes()
	{
		return yAxes;
	}
	
	public LinearScales addyAxis(LinearScale yAxis)
	{
		this.yAxes.add(yAxis);
		return this;
	}
	
	public LinearScales setyAxes(List<LinearScale> yAxes)
	{
		this.yAxes.clear();
		if (yAxes != null)
		{
			this.yAxes.addAll(yAxes);
		}
		return this;
	}
	
	
	public XAxis<?> getX()
	{
		return x;
	}
	
	public YAxis<?> getY()
	{
		return y;
	}
	
	public LinearScales setX(XAxis<?> x)
	{
		this.x = x;
		return this;
	}
	
	public LinearScales setY(YAxis<?> y)
	{
		this.y = y;
		return this;
	}
}
