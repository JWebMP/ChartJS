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
package com.jwebmp.plugins.graphing.chartjs.tests;

import java.io.IOException;

import com.jwebmp.plugins.graphing.chartjs.options.elements.Fill;
import com.jwebmp.plugins.graphing.chartjs.Chart;
import com.jwebmp.plugins.graphing.chartjs.LineChart;
import com.jwebmp.plugins.graphing.chartjs.ScatterLineChart;
import com.jwebmp.plugins.graphing.chartjs.color.Color;
import com.jwebmp.plugins.graphing.chartjs.data.LineData;
import com.jwebmp.plugins.graphing.chartjs.data.ScatterLineData;
import com.jwebmp.plugins.graphing.chartjs.datapoint.ScatterDataPoint;
import com.jwebmp.plugins.graphing.chartjs.dataset.LineDataset;
import com.jwebmp.plugins.graphing.chartjs.dataset.ScatterLineDataset;
import com.jwebmp.plugins.graphing.chartjs.enums.BorderCapStyle;
import com.jwebmp.plugins.graphing.chartjs.enums.BorderJoinStyle;
import com.jwebmp.plugins.graphing.chartjs.enums.ScalesPosition;
import com.jwebmp.plugins.graphing.chartjs.options.LineOptions;
import com.jwebmp.plugins.graphing.chartjs.options.scales.LinearScale;
import com.jwebmp.plugins.graphing.chartjs.options.scales.LinearScales;
import com.jwebmp.plugins.graphing.chartjs.tests.util.Opener;
import com.jwebmp.plugins.graphing.chartjs.tests.util.TestFactory;
import org.junit.jupiter.api.Test;

public class LineTest extends ChartTest {

	@Override
	public Chart createChart() {
		LineChart chart = new LineChart();
		chart.setData(TestFactory.randomInstance(LineData.class));
		chart.setOptions(TestFactory.randomInstance(LineOptions.class));
		System.out.println("Chart is" + (chart.isDrawable() ? " " : " NOT ") + "drawable");
		return chart;
	}

	/**
	 * Create the example chart found at
	 * <a href="http://www.chartjs.org/docs/#line-chart-example-usage">Chart.js
	 * </a> web site
	 * 
	 * @throws IOException
	 */
	@Test
	public void createExampleChart() throws IOException {
		LineChart lineChart = new LineChart();
		lineChart.setData(createLineData());
		Opener.inBrowser(lineChart);
	}
	
	/**
	 * Create the example chart found at
	 * <a href="http://www.chartjs.org/docs/#line-chart-scatter-line-charts">Chart.js
	 * </a> web site
	 * 
	 * @throws IOException
	 */
	@Test
	public void createExampleScatterChart() throws IOException {

		ScatterLineDataset dataset = new ScatterLineDataset()
										.setLabel("Scatter Dataset")
							            .addData(new ScatterDataPoint(-10, 0))
							            .addData(new ScatterDataPoint(0, 10))
							            .addData(new ScatterDataPoint(10, 5));
		
		ScatterLineData data = new ScatterLineData().addDataset(dataset);
		ScatterLineChart chart = new ScatterLineChart();
		chart.setData(data);
		
		LineOptions options = new LineOptions();
		LinearScales scales = new LinearScales();
		options.setScales(scales);
		
		LinearScale scale = new LinearScale();
		scale.setPosition(ScalesPosition.BOTTOM);
		scales.addxAxis(scale);
		
		chart.setOptions(options);
		Opener.inBrowser(chart);

	}

	/**
	 * Create the example chart found at
	 * <a href="http://www.chartjs.org/docs/#line-chart-stacked-charts">Chart.js
	 * </a> web site
	 * 
	 * @throws IOException
	 */
	@Test
	public void createStackedChart() throws IOException {
		LineChart chart = new LineChart();
		LineData data = new LineData()
						.addDataset(createLineDataset().setBorderColor(Color.RED))
						.addDataset(createLineDataset().setBorderColor(Color.GREEN))
						.addLabels("January", "February", "March", "April", "May", "June", "July");
		chart.setData(data);
		LineOptions options = new LineOptions();
		LinearScales linearScales = new LinearScales();
		LinearScale linearScale = new LinearScale();
		linearScale.setStacked(true);
		linearScales.addyAxis(linearScale);
		options.setScales(linearScales);
		chart.setOptions(options);
		Opener.inBrowser(chart);
	}

	
	private LineData createLineData() {
		return new LineData()
				.addDataset(createLineDataset())
				.addLabels("January", "February", "March", "April", "May", "June", "July");

	}
	
	private LineDataset createLineDataset() {
		return new LineDataset()
				.setLabel("My First dataset")
				.setFill(new Fill(true))
				.setLineTension(0.1f)
				.setBackgroundColor(new Color(75, 192, 192, 0.4))
				.setBorderColor(new Color(75,192,192,1))
				.setBorderCapStyle(BorderCapStyle.BUTT)
				.setBorderDashOffset(0.0f)
				.setBorderJoinStyle(BorderJoinStyle.MITER)
				.addPointBorderColor(new Color(75, 192, 192, 1))					
				.addPointBackgroundColor(new Color(255, 255, 255, 1))
				.addPointBorderWidth(1)
				.addPointHoverRadius(5)
	            .addPointHoverBackgroundColor(new Color(75,192,192,1))
	            .addPointHoverBorderColor(new Color(220,220,220,1))
	            .addPointHoverBorderWidth(2)
	            .addPointRadius(1)
	            .addPointHitRadius(10)
	            .setSpanGaps(false)
	            //.setData(65, 59, 80, 81, 56, 55, 40)
				;
	}
	
}
