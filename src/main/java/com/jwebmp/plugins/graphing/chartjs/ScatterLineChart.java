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

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import com.jwebmp.plugins.graphing.chartjs.data.Data;
import com.jwebmp.plugins.graphing.chartjs.data.ScatterLineData;
import com.jwebmp.plugins.graphing.chartjs.dataset.ScatterLineDataset;
import com.jwebmp.plugins.graphing.chartjs.options.LineOptions;
import com.jwebmp.plugins.graphing.chartjs.options.Options;
import com.jwebmp.plugins.graphing.chartjs.options.scales.LinearScale;

@JsonInclude(Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public class ScatterLineChart extends Chart<ScatterLineData,ScatterLineChart> {

	private static final ObjectWriter WRITER = new ObjectMapper()
			.writerWithDefaultPrettyPrinter()
			.forType(ScatterLineChart.class);

	/**
	 * Static factory, constructs an {@link Data} implementation appropriate
	 * for a {@link ScatterLineChart}.
	 * 
	 * @return a new {@link ScatterLineData} instance
	 */
	public static ScatterLineData data() {
		return new ScatterLineData();
	}

	/**
	 * Static factory, constructs an {@link Options} implementation appropriate
	 * for a {@link ScatterLineChart}.
	 * 
	 * @return a new {@link LineOptions} instance
	 */
	public static LineOptions options() {
		return new LineOptions();
	}

	private final String type = "line";

	private ScatterLineData data;

	private LineOptions options;

	public ScatterLineChart() {
	}

	public ScatterLineChart(ScatterLineData data) {
		this.data = data;
	}

	public ScatterLineChart(ScatterLineData data, LineOptions options) {
		this.data = data;
		this.options = options;
	}

	@Override
	public String getType() {
		return type;
	}

	public ScatterLineData getData() {
		return data;
	}

	public ScatterLineChart setData(ScatterLineData data) {
		this.data = data;
		return this;
	}

	public LineOptions getOptions() {
		return options;
	}

	public ScatterLineChart setOptions(LineOptions options) {
		this.options = options;
		return this;
	}

	@Override
	public String toJson() {
		try {
			return WRITER.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * <p>
	 * {@code LineChart} is drawable if at least one dataset has at least one
	 * data point.<br>
	 * If an xAxisID is set on a dataset, an xAxis scale must exist with that id.
	 * <br>
	 * If an yAxisID is set on a dataset, a yAxis scale must exist with that id.
	 * </p>
	 */
	@Override
	public boolean isDrawable() {
		boolean sufficientData = false;
		for (ScatterLineDataset dataset : data.getDatasets()) {
			if (dataset.getXAxisID() != null && !hasXAxisWithId(dataset.getXAxisID())) {
				return false;
			}
			if (dataset.getYAxisID() != null && !hasYAxisWithId(dataset.getYAxisID())) {
				return false;
			}
			if (dataset.getData().size() > 0) {
				sufficientData = true;
			}
		}
		return sufficientData;
	}
	
	private boolean hasXAxisWithId(String id) {
		if (options != null && options.getScales() != null && options.getScales().getxAxes() != null) {
			for (LinearScale xAxis : options.getScales().getxAxes()) {
				if (id.equals(xAxis.getId())) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean hasYAxisWithId(String id) {
		if (options != null && options.getScales() != null && options.getScales().getyAxes() != null) {
			for (LinearScale yAxis : options.getScales().getyAxes()) {
				if (id.equals(yAxis.getId())) {
					return true;
				}
			}
		}
		return false;
	}

}
