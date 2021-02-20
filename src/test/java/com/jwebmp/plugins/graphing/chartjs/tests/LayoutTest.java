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

import com.jwebmp.plugins.graphing.chartjs.BarChart;
import com.jwebmp.plugins.graphing.chartjs.color.Color;
import com.jwebmp.plugins.graphing.chartjs.data.BarData;
import com.jwebmp.plugins.graphing.chartjs.dataset.BarDataset;
import com.jwebmp.plugins.graphing.chartjs.options.BarOptions;
import com.jwebmp.plugins.graphing.chartjs.tests.util.Opener;
import org.junit.jupiter.api.Test;

import com.jwebmp.plugins.graphing.chartjs.options.layout.Layout;
import com.jwebmp.plugins.graphing.chartjs.options.layout.Padding;

public class LayoutTest {

	private BarChart createBarChart() {
		
		BarDataset dataset = new BarDataset()
			.addData(213)
			.addBackgroundColor(Color.LIGHT_BLUE)
			.addData(1515)
			.addBackgroundColor(Color.LIGHT_SALMON)
			.addData(-135)
			.addBackgroundColor(Color.LIGHT_YELLOW);
		
		BarData data = new BarData()
				.addDataset(dataset)
				.addLabel("one")
				.addLabel("two")
				.addLabel("three");
		
		return new BarChart(data, new BarOptions());

	}
	
	private BarChart createIntegerChart() {
		
		BarChart chart = createBarChart();
		chart.getOptions().setLayout(new Layout(150));
		return chart;

	}
	
	private BarChart createPaddingChart() {

		Padding padding = new Padding();
		padding.setTop(0);
		padding.setRight(15);
		padding.setBottom(250);
		padding.setLeft(100);
		
		BarChart chart = createBarChart();
		chart.getOptions().setLayout(new Layout(padding));
		return chart;

	}
	
	/**
	 * @throws IOException
	 */
	@Test
	public void createExampleChart() throws IOException {
		Opener.inBrowser(createIntegerChart());
		Opener.inBrowser(createPaddingChart());
	}

}
