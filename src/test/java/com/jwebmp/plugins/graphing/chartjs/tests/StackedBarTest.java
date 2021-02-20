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

import com.jwebmp.plugins.graphing.chartjs.BarChart;
import com.jwebmp.plugins.graphing.chartjs.Chart;
import com.jwebmp.plugins.graphing.chartjs.color.Color;
import com.jwebmp.plugins.graphing.chartjs.data.BarData;
import com.jwebmp.plugins.graphing.chartjs.dataset.BarDataset;
import com.jwebmp.plugins.graphing.chartjs.options.BarOptions;
import com.jwebmp.plugins.graphing.chartjs.options.scales.BarScale;
import com.jwebmp.plugins.graphing.chartjs.options.ticks.LinearTicks;

/**
 * Example code to demonstrate stack property as requested in
 * <a href="https://github.com/mdewilde/chart/issues/14">issue 14</a>
 * 
 */
public class StackedBarTest extends ChartTest {

	@Override
	public Chart createChart() {
		BarDataset dataset1 = new BarDataset()
				.setLabel("First stack")
				.setData(65, 59, 80)
				.addBackgroundColors(Color.RED, Color.GREEN, Color.BLUE);
		
		BarDataset dataset2 = new BarDataset()
				.setLabel("Second stack")
				.setData(28, 45, 10)
				.addBackgroundColors(Color.GREEN, Color.BLUE, Color.RED);

		BarData data = new BarData()
				.addLabels("First", "Second", "Third")
				.addDataset(dataset1)
				.addDataset(dataset2);

		LinearTicks ticks = new LinearTicks()
				.setMin(20)
				.setMax(100)
				.setStepSize(5);

		BarScale scale = new BarScale()
				.addxAxes(BarScale.xAxis().setStacked(true))
				.addyAxes(BarScale.yAxis().setTicks(ticks).setStacked(true));

		BarOptions options = new BarOptions()
				.setScales(scale);

		return new BarChart(data, options);
	}

}
