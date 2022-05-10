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
package com.jwebmp.plugins.graphing.chartjs;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect.*;
import com.fasterxml.jackson.annotation.JsonInclude.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.jwebmp.plugins.graphing.chartjs.data.*;
import com.jwebmp.plugins.graphing.chartjs.dataset.*;
import com.jwebmp.plugins.graphing.chartjs.options.*;

@JsonInclude(Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public class MixedChart extends Chart<Data,MixedChart>
{
	
	private static final ObjectWriter WRITER = new ObjectMapper()
			.writerWithDefaultPrettyPrinter()
			.forType(MixedChart.class);
	
	/**
	 * Static factory, constructs an {@link Data} implementation appropriate for
	 * a {@link MixedChart}.
	 *
	 * @return a new {@link BarData} instance
	 */
	public static Data data()
	{
		return new BarData();
	}
	
	/**
	 * Static factory, constructs an {@link Options} implementation appropriate
	 * for a {@link MixedChart}.
	 *
	 * @return a new {@link BarOptions} instance
	 */
	public static Options options()
	{
		return new BarOptions();
	}
	
	@JsonIgnore
	private boolean vertical = true;
	
	private Data<?, ?, ?> data;
	
	private Options<?> options;
	
	public MixedChart()
	{
	}
	
	public MixedChart(Data data)
	{
		this.data = data;
	}
	
	public MixedChart(Data data, Options<?> options)
	{
		this.data = data;
		this.options = options;
	}
	
	public Data getData()
	{
		return data;
	}
	
	public MixedChart setData(Data data)
	{
		this.data = data;
		return this;
	}
	
	public Options getOptions()
	{
		return options;
	}
	
	public MixedChart setOptions(Options options)
	{
		this.options = options;
		return this;
	}
	
	/**
	 * <p>
	 * Draw this {@code BarChart} horizontally.
	 * </p>
	 * <p>
	 * Default is to draw a vertical {@code BarChart}.
	 * </p>
	 *
	 * @return this {@link MixedChart} for method chaining
	 * @see #setVertical()
	 */
	public MixedChart setHorizontal()
	{
		this.vertical = false;
		return this;
	}
	
	/**
	 * @return true if this {@code BarChart} is set to be drawn horizontally
	 * @see #setHorizontal()
	 */
	public boolean isHorizontal()
	{
		return !this.vertical;
	}
	
	/**
	 * <p>
	 * Draw this {@code BarChart} vertically.
	 * </p>
	 * <p>
	 * Vertical drawing is the default for {@code BarChart}.
	 * </p>
	 *
	 * @return this {@link MixedChart} for method chaining
	 * @see #setHorizontal()
	 */
	public MixedChart setVertical()
	{
		this.vertical = true;
		return this;
	}
	
	/**
	 * @return true if this {@code BarChart} is set to be drawn vertically
	 * @see #setVertical()
	 */
	public boolean isVertical()
	{
		return this.vertical;
	}
	
	@Override
	@JsonProperty("type")
	public String getType()
	{
		return this.vertical ? "bar" : "horizontalBar";
	}
	
	@Override
	public String toJson()
	{
		try
		{
			return WRITER.writeValueAsString(this);
		}
		catch (JsonProcessingException e)
		{
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * A {@code BarChart} is drawable if:
	 * </p>
	 * <ul>
	 * <li>at least one dataset has at least one data point
	 * <li>an xAxis scale exists with the id of the xAxisID set on a dataset, if
	 * such an id set
	 * <li>a yAxis scale exists with the id of the yAxisID set on a dataset, if
	 * such an id is set
	 * <li>there is at least one label in the {@link BarData}
	 * </ul>
	 *
	 * @return true if this {@link MixedChart} is drawable in its current state
	 */
	@Override
	public boolean isDrawable()
	{
		if (data.getLabels()
		        .isEmpty())
		{
			return false;
		}
		boolean sufficientData = false;
		for (Dataset dataset : data.getDatasets())
		{
			/*if (dataset.getXAxisID() != null && !hasXAxisWithId(dataset.getXAxisID())) {
				return false;
			}
			if (dataset.getYAxisID() != null && !hasYAxisWithId(dataset.getYAxisID())) {
				return false;
			}*/
			if (dataset.getData()
			           .size() > 0)
			{
				sufficientData = true;
			}
		}
		return sufficientData;
	}
	
	private boolean hasXAxisWithId(String id)
	{
		/*if (options != null && options.getScales() != null && options.getScales().getxAxes() != null) {
			for (XAxis<LinearTicks> xAxis : options.getScales().getxAxes()) {
				if (id.equals(xAxis.getId())) {
					return true;
				}
			}
		}*/
		return true;
	}
	
	private boolean hasYAxisWithId(String id)
	{
		/*if (options != null && options.getScales() != null && options.getScales().getyAxes() != null) {
			for (YAxis<LinearTicks> yAxis : options.getScales().getyAxes()) {
				if (id.equals(yAxis.getId())) {
					return true;
				}
			}
		}*/
		return true;
	}
	
}
