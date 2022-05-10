package com.jwebmp.plugins.graphing.chartjs;

import com.jwebmp.core.base.angular.modules.services.*;
import com.jwebmp.core.base.angular.services.annotations.functions.*;
import com.jwebmp.core.base.angular.services.annotations.references.*;
import com.jwebmp.core.base.angular.services.annotations.structures.*;
import com.jwebmp.core.base.angular.services.interfaces.*;
import com.jwebmp.core.base.html.*;

import java.util.List;
import java.util.*;

@NgImportReference(name = "Chart,Point,ChartDataset,DefaultDataPoint,registerables,ChartConfiguration", reference = "chart.js")
@NgImportReference(name = "AfterViewInit, ElementRef, ViewChild", reference = "@angular/core")

@NgField("@ViewChild('chart')\n" +
         "  private chartRef? : ElementRef;")

@NgField("private chart?: Chart;")

@NgField("private chartConfiguration : ChartConfiguration;")

@NgField("private datasets: ChartDataset[];")

@NgField("private dataSourceSubscription: Subscription;")

@NgOnDestroy(onDestroy = {"this.dataSourceSubscription.unsubscribe();",
		"this.socketClientService.deregisterListener(this.listenerName);",
		"this.chart?.destroy();",
		"this.datasets = [];"
})


@NgComponentReference(SocketClientService.class)
@NgImportReference(name = "Injectable", reference = "@angular/core")
@NgImportReference(name = "Observable,Observer,Subscription", reference = "rxjs")
@NgImportReference(name = "Subject,bufferTime", reference = "rxjs")

public class ChartJS<D, O extends Chart<D, O>, J extends ChartJS<D, O, J>> extends Canvas<J> implements INgComponent<J>
{
	private Chart<D, O> options;
	
	public ChartJS(String id)
	{
		setID(id);
		addAttribute("#chart", "");
	}
	
	@Override
	public List<String> interfaces()
	{
		return List.of("AfterViewInit");
	}
	
	@Override
	public List<String> componentConstructorBody()
	{
		return List.of("Chart.register(...registerables);",
				"this.chartConfiguration = " + getOptions().toJson() + ";",
				"this.datasets = this.chartConfiguration.data.datasets;",
				"this.dataSourceSubscription = this.socketClientService.registerListener(this.listenerName)\n" +
				"            .pipe(bufferTime(1500))\n" +
				"            .subscribe((message: ChartDataset[]) => {\n" +
				"            if(message.length > 0)\n" +
				"            {\n" +
				"                for (const messageElement of message) {\n" +
				"                    if(messageElement && messageElement.label)\n" +
				"                    {\n" +
				"                        this.updateDataset(messageElement.label,messageElement);\n" +
				"                    }\n" +
				"                }\n" +
				"            }\n" +
				"        });"
		);
	}
	
	@Override
	public List<String> componentMethods()
	{
		List<String> out = new ArrayList<>();
		//getOptions().getData().
		out.add("ngAfterViewInit() {\n" +
		        "if(this.chartRef){\n" +
		        "\tthis.chart = new Chart(this.chartRef.nativeElement, this.chartConfiguration);\n" +
		        "\t}\n" +
		        "}\n");
		
		out.add("updateDataset(label : string, dataset: ChartDataset )\n" +
		        "    {\n" +
		        "       let found : boolean = false;" +
		        "        for (const dataset1 of this.datasets) {\n" +
		        "            if(dataset1.label == label)\n" +
		        "            {\n" +
		        "                dataset1.data = dataset.data;\n" +
		        "                found = true; " +
		        "                break;\n" +
		        "            }\n" +
		        "        }\n" +
		        "       if(!found)\n" +
		        "        {\n" +
		        "            this.datasets.push(dataset);\n" +
		        "        }" +
		        "        this.chart?.update();\n" +
		        "    }");
		return out;
	}
	
	@Override
	public List<String> componentFields()
	{
		return List.of("private listenerName : string = \"" + getID() + "\";");
	}
	
	@Override
	public List<String> styles()
	{
		return List.of(":host {" +
		               "display: inline-block;" +
		               "position: relative;" +
		               "}");
	}
	
	
	@Override
	public O getOptions()
	{
		return (O) options;
	}
	
	public J setWidth(int width)
	{
		addAttribute("width", width + "");
		return (J) this;
	}
	
	public J setHeight(int height)
	{
		addAttribute("height", height + "");
		return (J) this;
	}
	
	public J setOptions(Chart<D, O> options)
	{
		this.options = options;
		return (J) this;
	}
}
