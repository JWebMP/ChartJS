package com.jwebmp.plugins.graphing.chartjs.tests;

import java.io.IOException;

import com.jwebmp.plugins.graphing.chartjs.LineChart;
import com.jwebmp.plugins.graphing.chartjs.data.LineData;
import com.jwebmp.plugins.graphing.chartjs.dataset.LineDataset;
import com.jwebmp.plugins.graphing.chartjs.enums.FontStyle;
import com.jwebmp.plugins.graphing.chartjs.options.*;
import com.jwebmp.plugins.graphing.chartjs.options.scales.LinearScale;
import com.jwebmp.plugins.graphing.chartjs.options.scales.LinearScales;
import com.jwebmp.plugins.graphing.chartjs.tests.util.Opener;
import org.junit.jupiter.api.Test;

import com.jwebmp.plugins.graphing.chartjs.options.ticks.LinearTicks;

/*
 * Debugging for https://github.com/mdewilde/chart/issues/11
 */
public class TypelessLinearScaleTest {

	@Test
	public void typelessLinearScaleTest() throws IOException {

		LineDataset dataset = new LineDataset()
				.setLabel("typelessLinearScaleTest")
				.addData(65)
				.addData(59)
				.addData(80)
				.setBorderWidth(1);

		LineData data = LineChart.data()
				.addLabel("January")
				.addLabel("February")
				.addLabel("March")
				.addDataset(dataset);

		LinearTicks ticks = new LinearTicks();
		ticks.setFont(new Font().setStyle(FontStyle.BOLD));
		LinearScale axis = new LinearScale().setTicks(ticks);
		LinearScales scales = new LinearScales().addxAxis(axis);
		LineOptions options = new LineOptions().setScales(scales);

		Opener.inBrowser(new LineChart(data, options));

	}
	
	
}
