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
import com.jwebmp.plugins.graphing.chartjs.data.DoughnutData;
import com.jwebmp.plugins.graphing.chartjs.options.DoughnutOptions;
import com.jwebmp.plugins.graphing.chartjs.options.Options;

@JsonInclude(Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public class DoughnutChart extends Chart<DoughnutData,DoughnutChart> {

	private static final ObjectWriter WRITER = new ObjectMapper()
			.writerWithDefaultPrettyPrinter()
			.forType(DoughnutChart.class);

	/**
	 * Static factory, constructs an {@link Data} implementation appropriate
	 * for a {@link DoughnutChart}.
	 * 
	 * @return a new {@link DoughnutData} instance
	 */
	public static DoughnutData data() {
		return new DoughnutData();
	}

	/**
	 * Static factory, constructs an {@link Options} implementation appropriate
	 * for a {@link DoughnutChart}.
	 * 
	 * @return a new {@link DoughnutOptions} instance
	 */
	public static DoughnutOptions options() {
		return new DoughnutOptions();
	}

	private final String type = "doughnut";

	private DoughnutData data;

	private DoughnutOptions options;

	public DoughnutChart() {
	}

	public DoughnutChart(DoughnutData data) {
		this.data = data;
	}

	public DoughnutChart(DoughnutData data, DoughnutOptions options) {
		this.data = data;
		this.options = options;
	}

	public DoughnutData getData() {
		return data;
	}

	public DoughnutChart setData(DoughnutData data) {
		this.data = data;
		return this;
	}

	public DoughnutOptions getOptions() {
		return options;
	}

	public DoughnutChart setOptions(DoughnutOptions options) {
		this.options = options;
		return this;
	}

	@Override
	public String getType() {
		return type;
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
	 * {@code DoughnutChart} is drawable if at least one dataset has at least
	 * one data point.
	 * </p>
	 */
	@Override
	public boolean isDrawable() {
		return data != null && !data.getDatasets().isEmpty();
	}

}
