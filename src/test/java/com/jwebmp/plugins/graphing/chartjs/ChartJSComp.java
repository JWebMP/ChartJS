package com.jwebmp.plugins.graphing.chartjs;

import com.jwebmp.core.base.angular.client.annotations.angular.*;
import com.jwebmp.plugins.graphing.chartjs.data.*;
import com.jwebmp.plugins.graphing.chartjs.dataset.*;

@NgComponent("chart-comp")
public class ChartJSComp extends ChartJS<BarData, BarChart, ChartJSComp>
{
	public ChartJSComp()
	{
		super("ch");
		setOptions(new BarChart(new BarData().addLabel("Category 1")
		                                     .addLabel("Category 2")
		                                     .addLabel("Category 3")
		                                     .addDataset(new BarDataset()
		                                                                 .setLabel("Data Label 1"))
				)
		);
	}
	
	@Override
	public void init()
	{
		
		super.init();
	}
}
