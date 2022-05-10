package com.jwebmp.plugins.graphing.chartjs.tests;

import java.io.IOException;
import java.util.Arrays;

import com.jwebmp.plugins.graphing.chartjs.BarChart;
import com.jwebmp.plugins.graphing.chartjs.LineChart;
import com.jwebmp.plugins.graphing.chartjs.color.Color;
import com.jwebmp.plugins.graphing.chartjs.data.*;
import com.jwebmp.plugins.graphing.chartjs.datapoint.*;
import com.jwebmp.plugins.graphing.chartjs.dataset.BarDataset;
import com.jwebmp.plugins.graphing.chartjs.dataset.LineDataset;
import com.jwebmp.plugins.graphing.chartjs.options.BarOptions;
import com.jwebmp.plugins.graphing.chartjs.options.LineOptions;
import com.jwebmp.plugins.graphing.chartjs.tests.util.Opener;
import org.junit.jupiter.api.Test;

import com.jwebmp.plugins.graphing.chartjs.options.elements.Line;
import com.jwebmp.plugins.graphing.chartjs.options.elements.LineElements;
import com.jwebmp.plugins.graphing.chartjs.options.elements.Point;
import com.jwebmp.plugins.graphing.chartjs.options.elements.Rectangle;
import com.jwebmp.plugins.graphing.chartjs.options.elements.RectangleElements;

public class ElementsTest {

	@Test
	public void barChartWithRectangle() throws IOException {

		BarDataset dataset = new BarDataset()
				.setData(129, 510, 239, 122);

		BarData data = BarChart.data()
				.addLabels("monday", "tuesday", "wednesday", "thursday")
				.addDataset(dataset);

		Rectangle rectangle = new Rectangle()
				.setBackgroundColor(Color.RED)
				.setBorderWidth(20);

		BarOptions options = BarChart.options()
				.setElements(new RectangleElements(rectangle));

		BarChart chart = new BarChart(data, options);

		Opener.inBrowser(chart);
		
	}

	@Test
	public void linechartElements() throws IOException {

		@SuppressWarnings("RedundantArrayCreation")
		LineDataset dataset = new LineDataset()
				.setData(new XDataPoint[]{new XDataPoint(1,129),new XDataPoint(2,510), new XDataPoint(3, 239), new XDataPoint(4,122)});

		LineData data = LineChart.data()
				.addLabels("monday", "tuesday", "wednesday", "thursday")
				.addDataset(dataset);

		Line line = new Line()
				.setBackgroundColor(Color.BLUE)
				.setBorderDash(Arrays.asList(4, 8, 2, 1));
		
		Point point = new Point()
				.setBackgroundColor(Color.YELLOW)
				.setRadius(7)
				.setHoverRadius(11);
		
		LineElements lineElements = new LineElements(line, point);

		LineOptions options = LineChart.options()
				.setElements(lineElements);

		LineChart chart = new LineChart(data, options);

		Opener.inBrowser(chart);
		
	}

}
