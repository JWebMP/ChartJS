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

import com.jwebmp.plugins.graphing.chartjs.Chart;
import com.jwebmp.plugins.graphing.chartjs.PieChart;
import com.jwebmp.plugins.graphing.chartjs.color.Color;
import com.jwebmp.plugins.graphing.chartjs.data.PieData;
import com.jwebmp.plugins.graphing.chartjs.dataset.PieDataset;
import com.jwebmp.plugins.graphing.chartjs.options.Legend;
import com.jwebmp.plugins.graphing.chartjs.options.PieOptions;
import com.jwebmp.plugins.graphing.chartjs.tests.util.Opener;
import org.junit.jupiter.api.Test;

/**
 * Test for issue #5
 * 
 * https://github.com/mdewilde/chart/issues/5
 */
public class LegendPositionTest extends ChartTest {

	@Override
	public Chart createChart() {
		
		PieDataset dataset = new PieDataset()
				.addData(12).addBackgroundColor(Color.RED)
				.addData(19).addBackgroundColor(Color.GREEN)
				.addData(1).addBackgroundColor(Color.BLUE);
		
		PieData data = new PieData()
				.addDataset(dataset)
				.addLabels("first", "second", "third");
		
		
		Legend legend = new Legend()
				.setDisplay(true)
				.setPosition(Legend.Position.BOTTOM);

		PieChart chart = new PieChart(data,
				new PieOptions().setLegend(legend));
		
		return chart;
	}

	@Test
	public void createExampleChart() throws IOException {
		Opener.inBrowser(createChart());
	}

	@Test
	public void leftLegend() throws IOException {
		PieDataset dataset = new PieDataset()
				.addData(12).addBackgroundColor(Color.RED)
				.addData(19).addBackgroundColor(Color.GREEN)
				.addData(1).addBackgroundColor(Color.BLUE);
		
		PieData data = new PieData()
				.addDataset(dataset)
				.addLabels("first", "second", "third");
		
		
		Legend legend = new Legend()
				.setDisplay(true)
				.setPosition(Legend.Position.LEFT);

		PieChart chart = new PieChart(data,
				new PieOptions().setLegend(legend));
		
		Opener.inBrowser(chart);
		
		legend = new Legend()
				.setDisplay(true)
				.setPosition(Legend.Position.RIGHT);

		chart = new PieChart(data,
				new PieOptions().setLegend(legend));

		Opener.inBrowser(chart);

	}
	
}
