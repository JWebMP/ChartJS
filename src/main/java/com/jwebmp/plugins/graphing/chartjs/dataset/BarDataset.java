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
package com.jwebmp.plugins.graphing.chartjs.dataset;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect.*;
import com.fasterxml.jackson.annotation.JsonInclude.*;
import com.jwebmp.plugins.graphing.chartjs.datapoint.*;
import com.jwebmp.plugins.graphing.chartjs.enums.*;
import com.jwebmp.plugins.graphing.chartjs.objects.*;

import java.math.*;
import java.util.*;

@JsonInclude(Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class BarDataset extends BackgroundBorderHoverDataset<BarDataset, YDataPoint<?>>
{
	
	/**
	 * @see #setLabel(String)
	 */
	private String label;
	
	/**
	 * @see #setXAxisID(String)
	 */
	private String xAxisID;
	
	/**
	 * @see #setYAxisID(String)
	 */
	private String yAxisID;
	
	/**
	 * @see #setBorderSkipped(List)
	 */
	private final List<BorderSkipped> borderSkipped = new OptionalArray<>();
	
	public BarDataset()
	{
		setType("bar");
	}
	
	/**
	 * @see #setLabel(String)
	 */
	public String getLabel()
	{
		return this.label;
	}
	
	/**
	 * The label for the dataset which appears in the legend and tooltips
	 */
	public BarDataset setLabel(String label)
	{
		this.label = label;
		return this;
	}
	
	/**
	 * @see #setXAxisID(String)
	 */
	public String getXAxisID()
	{
		return this.xAxisID;
	}
	
	/**
	 * The ID of the x axis to plot this dataset on
	 */
	public BarDataset setXAxisID(String xAxisID)
	{
		this.xAxisID = xAxisID;
		return this;
	}
	
	/**
	 * @see #setYAxisID(String)
	 */
	public String getYAxisID()
	{
		return this.yAxisID;
	}
	
	/**
	 * The ID of the y axis to plot this dataset on
	 */
	public BarDataset setYAxisID(String yAxisID)
	{
		this.yAxisID = yAxisID;
		return this;
	}
	
	/**
	 * @see #setBorderSkipped(List)
	 */
	public List<BorderSkipped> getBorderSkipped()
	{
		return this.borderSkipped;
	}
	
	/**
	 * @see #setBorderSkipped(List)
	 */
	public BarDataset addBorderSkipped(BorderSkipped borderSkipped)
	{
		this.borderSkipped.add(borderSkipped);
		return this;
	}
	
	/**
	 * Which edge to skip drawing the border for. Options are 'bottom', 'left', 'top', and 'right'
	 */
	public BarDataset setBorderSkipped(List<BorderSkipped> borderSkipped)
	{
		this.borderSkipped.clear();
		if (borderSkipped != null)
		{
			this.borderSkipped.addAll(borderSkipped);
		}
		return this;
	}
	
	/**
	 * Sets the backing data list to the argument, replacing any data already
	 * added or set
	 *
	 * @param data The data to plot in a line
	 */
	public BarDataset setData(int... data)
	{
		clearData();
		if (data != null)
		{
			for (int i = 0; i < data.length; i++)
			{
				this.data.add(new YDataPoint<>(new BigDecimal(data[i])));
			}
		}
		return this;
	}
	
	/**
	 * Sets the backing data list to the argument, replacing any data already
	 * added or set
	 *
	 * @param data The data to plot in a line
	 */
	public BarDataset setData(double... data)
	{
		clearData();
		if (data != null)
		{
			for (int i = 0; i < data.length; i++)
			{
				this.data.add(new YDataPoint<>(new BigDecimal(String.valueOf(data[i]))));
			}
		}
		return this;
	}
	
	/**
	 * Add the data point to this {@code Dataset}
	 *
	 * @see #setData(Collection)
	 */
	public BarDataset addData(int data)
	{
		this.data.add(new YDataPoint<>(new BigDecimal(data)));
		return this;
	}
	
	/**
	 * Add the data point to this {@code Dataset}
	 *
	 * @see #setData(Collection)
	 */
	public BarDataset addData(double data)
	{
		this.data.add(new YDataPoint<>(new BigDecimal(String.valueOf(data))));
		return this;
	}
	
	/**
	 * Add the data point to this {@code Dataset}
	 *
	 * @see #setData(Collection)
	 */
	public BarDataset addData(String label, double data)
	{
		this.data.add(new YDataPoint<>(new BigDecimal(String.valueOf(data))));
		return this;
	}
	
	/**
	 * Add the data point to this {@code Dataset}
	 *
	 * @see #setData(Collection)
	 */
	public BarDataset addData(String label, int data)
	{
		this.data.add(new YDataPoint<>(new BigDecimal(String.valueOf(data))));
		return this;
	}
	
	/**
	 * Add the data point to this {@code Dataset}
	 *
	 * @see #setData(Collection)
	 */
	public BarDataset addData(XDataPoint<?> data)
	{
		this.data.add(data);
		return this;
	}
	
	private String stack;
	
	public String getStack()
	{
		return stack;
	}
	
	public BarDataset setStack(String stack)
	{
		this.stack = stack;
		return this;
	}
	
	private String barThickness;
	private Double barPercentage;
	private Double categoryPercentage;
	private Double borderRadius;
	private Double inflateAmount;
	private Double maxBarThickness;
	private Double minBarLength;
	
	public String getxAxisID()
	{
		return xAxisID;
	}
	
	public BarDataset setxAxisID(String xAxisID)
	{
		this.xAxisID = xAxisID;
		return this;
	}
	
	public String getyAxisID()
	{
		return yAxisID;
	}
	
	public BarDataset setyAxisID(String yAxisID)
	{
		this.yAxisID = yAxisID;
		return this;
	}
	
	public String getBarThickness()
	{
		return barThickness;
	}
	
	public BarDataset setBarThickness(String barThickness)
	{
		this.barThickness = barThickness;
		return this;
	}
	
	public Double getBarPercentage()
	{
		return barPercentage;
	}
	
	public BarDataset setBarPercentage(Double barPercentage)
	{
		this.barPercentage = barPercentage;
		return this;
	}
	
	public Double getCategoryPercentage()
	{
		return categoryPercentage;
	}
	
	public BarDataset setCategoryPercentage(Double categoryPercentage)
	{
		this.categoryPercentage = categoryPercentage;
		return this;
	}
	
	public Double getBorderRadius()
	{
		return borderRadius;
	}
	
	public BarDataset setBorderRadius(Double borderRadius)
	{
		this.borderRadius = borderRadius;
		return this;
	}
	
	public Double getInflateAmount()
	{
		return inflateAmount;
	}
	
	public BarDataset setInflateAmount(Double inflateAmount)
	{
		this.inflateAmount = inflateAmount;
		return this;
	}
	
	public Double getMaxBarThickness()
	{
		return maxBarThickness;
	}
	
	public BarDataset setMaxBarThickness(Double maxBarThickness)
	{
		this.maxBarThickness = maxBarThickness;
		return this;
	}
	
	public Double getMinBarLength()
	{
		return minBarLength;
	}
	
	public BarDataset setMinBarLength(Double minBarLength)
	{
		this.minBarLength = minBarLength;
		return this;
	}
}
