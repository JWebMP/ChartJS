package com.jwebmp.plugins.graphing.chartjs.tests;

import java.io.IOException;

import com.jwebmp.plugins.graphing.chartjs.BarChart;
import com.jwebmp.plugins.graphing.chartjs.data.BarData;
import com.jwebmp.plugins.graphing.chartjs.dataset.BarDataset;
import com.jwebmp.plugins.graphing.chartjs.options.BarOptions;
import com.jwebmp.plugins.graphing.chartjs.options.ticks.LinearTicks;
import com.jwebmp.plugins.graphing.chartjs.tests.util.Opener;
import org.junit.jupiter.api.Test;

import com.jwebmp.plugins.graphing.chartjs.options.scales.BarScale;

/*
 * Debugging for https://github.com/mdewilde/chart/issues/3
 */
public class TickTest {

	@Test
	public void tickTest() throws IOException {

		BarDataset dataset = new BarDataset()
				.setLabel("TickTest")
				.addData(65)
				.addData(59)
				.addData(80)
				.addData(81)
				.addData(56)
				.addData(55)
				.setBorderWidth(1);

		BarData data = BarChart.data()
				.addLabel("January")
				.addLabel("February")
				.addLabel("March")
				.addDataset(dataset);

		LinearTicks ticks = new LinearTicks()
				.setMin(0)
				.setMax(100)
				.setStepSize(10);

		BarScale barScale = new BarScale()
				.addyAxes(BarScale.yAxis().setTicks(ticks));

		BarOptions options = BarChart.options()
				.setScales(barScale);

		Opener.inBrowser(new BarChart(data, options));

	}
}
