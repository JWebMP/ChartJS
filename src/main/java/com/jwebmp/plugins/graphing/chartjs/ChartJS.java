package com.jwebmp.plugins.graphing.chartjs;

import com.guicedee.guicedinjection.*;
import com.guicedee.guicedservlets.websockets.*;
import com.jwebmp.core.base.ajax.*;
import com.jwebmp.core.base.angular.client.*;
import com.jwebmp.core.base.angular.client.annotations.constructors.*;
import com.jwebmp.core.base.angular.client.annotations.functions.*;
import com.jwebmp.core.base.angular.client.annotations.references.*;
import com.jwebmp.core.base.angular.client.annotations.structures.*;
import com.jwebmp.core.base.angular.client.services.*;
import com.jwebmp.core.base.angular.client.services.interfaces.*;
import com.jwebmp.core.base.angular.implementations.*;
import com.jwebmp.core.base.html.*;
import com.jwebmp.plugins.graphing.chartjs.dataset.*;

import java.util.*;
import java.util.List;

@NgImportReference(value = "Chart,Point,ChartDataset,DefaultDataPoint,registerables,ChartConfiguration", reference = "chart.js")
@NgImportReference(value = "AfterViewInit, ElementRef, ViewChild,HostListener,HostBinding", reference = "@angular/core")

@NgField("@ViewChild('chart')\n" +
         "  private chartRef? : ElementRef;")

@NgField("private chart?: Chart;")

@NgField("private chartConfiguration? : ChartConfiguration;")

@NgField("private datasets?: ChartDataset[];")

@NgOnDestroy("this.chart?.destroy();")
@NgOnDestroy("this.datasets = [];")

@NgImportReference(value = "Injectable", reference = "@angular/core")
@NgImportReference(value = "Observable,Observer,Subscription", reference = "rxjs")
@NgImportReference(value = "Subject,bufferTime", reference = "rxjs")


//===========================
@NgComponentReference(SocketClientService.class)
@NgComponentReference(DynamicData.class)


@NgField("private subscription?: Subscription;")
@NgField("private subscriptionDataSets?: Subscription;")

@NgOnDestroy("this.subscription?.unsubscribe();")
@NgOnDestroy("this.subscriptionDataSets?.unsubscribe();")
@NgOnDestroy("this.socketClientService.deregisterListener(this.listenerName);")
@NgOnDestroy("this.socketClientService.deregisterListener(this.listenerName + 'DataSets');")

@NgConstructorBody("Chart.register(...registerables);")
@NgAfterViewInit("""
                   this.subscription = this.socketClientService.registerListener(this.listenerName)
                               .pipe(bufferTime(100))
                               .subscribe((message: any) => {
                                   //   alert('message for chart config - ' + JSON.stringify(message));
                                   if (message) {
                                       if (Array.isArray(message)) {
                                           // alert('is array - message for chart config - ');
                                           for (let m of message) {
                                               //   alert('is array - message for chart config - m - ' + JSON.stringify(m));
                                               if (m && m.out && m.out[0]) {
                                                   //       alert('apply chart config - m - ' + JSON.stringify(m.out[0]));
                                                   if (this.chartRef) {
                                                       //   alert('create chart - ' + JSON.stringify(message.out[0]));
                                                       this.chartConfiguration = m.out[0];
                                                       setTimeout(() => {
                                                           if (this.chartConfiguration) {
                                                               if (!this.chart) {
                                                                   this.chart = new Chart(this.chartRef?.nativeElement, this.chartConfiguration);
                                                                   this.datasets = this.chart?.data.datasets;
                                                               } else {
                                                             //      alert('update datasets');
                                                             //      this.chart?.data.datasets.forEach((dataset) => {
                                                             //          dataset.data.pop();
                                                             //      });

                                                                   this.datasets = this.chartConfiguration?.data.datasets;
                                                                   for (const dataset of this.datasets) {
                                                                       if (dataset && dataset.label) {
                                                                           this.updateDataset(dataset.label, dataset);
                                                                       }
                                                                   }
                                                               }
                                                           }
                                                       }, 50);
                                                   }
                                               }
                                           }
                                       } else if (message.out && message.out[0]) {
                                           if (this.chartRef) {
                                               //   alert('create chart - ' + JSON.stringify(message.out[0]));
                                               this.chartConfiguration = message.out[0];
                                               setTimeout(() => {
                                                   if (this.chartConfiguration) {
                                                       if (!this.chart) {
                                                           this.chart = new Chart(this.chartRef?.nativeElement, this.chartConfiguration);
                                                           this.datasets = this.chartConfiguration?.data.datasets;
                                                       } else {
                                                         //  alert('update datasets');
                                                   //        this.chart?.data.datasets.forEach((dataset) => {
                                                    //           dataset.data.pop();
                                                   //        });

                                                           this.datasets = this.chartConfiguration?.data.datasets;
                                                           for (const dataset of this.datasets) {
                                                               if (dataset && dataset.label) {
                                                                   this.updateDataset(dataset.label, dataset);
                                                               }
                                                           }
                                                       }
                                                   }
                                               }, 50);
                                           }
                                       }
                                   }
                               });
                   """)

@NgAfterViewInit("""
                   this.subscriptionDataSets = this.socketClientService.registerListener(this.listenerName + 'DataSets')
                               .pipe(bufferTime(100))
                               .subscribe((message: any) => {
                                   if (message) {
                                       if (Array.isArray(message)) {
                                           // alert('is array - message for chart config - ');
                                           for (let m of message) {
                                               //   alert('is array - message for chart config - m - ' + JSON.stringify(m));
                                               if (m && m.out && m.out[0]) {
                                                   if (m.length > 0) {
                                                       for (const messageElement of m.out[0]) {
                                                           if (messageElement && messageElement.label) {
                                                               this.updateDataset(messageElement.label, messageElement);
                                                           }
                                                       }
                                                   }
                                               }
                                           }
                                       } else {
                                           if (message.out && message.out[0])
                                               if (message.length > 0) {
                                                   for (const messageElement of message.out[0]) {
                                                       if (messageElement && messageElement.label) {
                                                           this.updateDataset(messageElement.label, messageElement);
                                                       }
                                                   }
                                               }
                                       }
                                   }
                               });
                   """)
@NgMethod("""
          @HostListener('window:beforeprint')
           beforePrintHandler() {
               for (let id in Chart.instances) {
                   Chart.instances[id].resize(800, 350);
               }
           }
           
           @HostListener('window:afterprint')
           afterPrintHandler() {
               for (let id in Chart.instances) {
                   Chart.instances[id].resize();
               }
           }""")

@NgAfterViewInit("")
public abstract class ChartJS<D, O extends Chart<D, O>, J extends ChartJS<D, O, J>> extends Canvas<J> implements INgComponent<J>
{
	private Chart<D, O> options;
	
	public ChartJS(String id)
	{
		setID(id);
		addAttribute("#chart", "");
	}
	
	protected String getListenerName()
	{
		return getID();
	}
	
	protected String getListenerNameDataSets()
	{
		return getID() + "DataSets";
	}
	
	@Override
	public void init()
	{
		registerWebSocketListeners();
		super.init();
	}
	
	@Override
	public List<String> componentFields()
	{
		List<String>  out = INgComponent.super.componentFields();
		if (out == null)
		{
			out = new ArrayList<>();
		}
		out.add(" private listenerName = '" + getID() + "';\n");
		return out;
	}
	
	@Override
	public List<String> componentMethods()
	{
		List<String> out = INgComponent.super.componentMethods();
		out.add("""
		        updateDataset(label: string, dataset: ChartDataset) {
		                let found: boolean = false;
		                let index: number = -1;
		                let existingDataSet = undefined;
		                if (this.chart?.data.datasets)
		                    for (let i = 0; i < this.chart?.data.datasets.length; i++) {
		                        const dataset1 = this.chart?.data.datasets[i];
		                        if (dataset1.label == label) {
		                            index = i;
		                            existingDataSet = dataset1;
		                            found = true;
		                            break;
		                        }
		                    }
		        		
		                if (dataset.data.length != existingDataSet?.data.length) {
		                //    console.log('lengths are not equal incoming = ' + dataset.data.length + ' / existing in array = ' + existingDataSet?.data.length);
		                }
		        //
		              //  console.log('found dataset [' + label + '] - ' + found + ' - ' + index);
		                if (found && existingDataSet) {
		        		
		                   // this.chart?.data.datasets[index].data.splice(0, this.chart?.data.datasets[index].data.length, ...dataset.data);
		                    for (let i = 0; i < dataset.data.length; i++) {
		                        let d = existingDataSet.data[i];
		                        let d2 = dataset.data[i];
		                        if (d2)
                                   if (d !== d2) {
                                       console.log('updating [' + label + '][' + i + '] to ' + d2);
                                       this.chart?.data.datasets[index].data.splice(i, 1, d2);
                                   }
		                    }
		                    if (dataset.data.length != existingDataSet?.data.length) {
		                        console.log('lengths are not equal  = ' + dataset.data.length + ' / existing in array = ' + existingDataSet?.data.length);
		                    }
		        		
		                    //   alert('updating');
		                    this.chart?.update();
		                }
		            }""");
		return out;
	}
	
	public abstract Chart<D, O> getInitialOptions();
	
	protected void registerWebSocketListeners()
	{
		if (!GuicedWebSocket.isWebSocketReceiverRegistered(getListenerName()))
		{
			GuicedWebSocket.addWebSocketMessageReceiver(new InitialOptionsReceiver(getListenerName(), getClass()));
		}
		if (!GuicedWebSocket.isWebSocketReceiverRegistered(getListenerNameDataSets()))
		{
			GuicedWebSocket.addWebSocketMessageReceiver(new DataSetsReceiver(getListenerNameDataSets(), getClass()));
		}
		
	}
	
	@Override
	public List<String> afterViewInit()
	{
		List<String> out =  INgComponent.super.afterViewInit();
		out.add("this.socketClientService.send(this.listenerName, {\n" +
		        "            className: '" + getClass().getCanonicalName() + "',\n" +
		        "            listenerName: this.listenerName\n" +
		        "        }, this.listenerName);\n");
		return out;
	}
	
	@Override
	public List<String> styles()
	{
		List<String> out  = INgComponent.super.styles();
		out.add(":host {" +
		               "display: inline-block;" +
		               "position: relative;" +
		               "}");
		return out;
	}
	
	@Override
	public O getOptions()
	{
		return (O) options;
	}
	
	public J setOptions(Chart<D, O> options)
	{
		this.options = options;
		return (J) this;
	}
	
	protected static class InitialOptionsReceiver extends WebSocketAbstractCallReceiver
	{
		private String listenerName;
		private Class<? extends ChartJS> actionClass;
		
		public InitialOptionsReceiver()
		{
		}
		
		public InitialOptionsReceiver(String listenerName, Class<? extends ChartJS> actionClass)
		{
			this.listenerName = listenerName;
			this.actionClass = actionClass;
		}
		
		@Override
		public String getMessageDirector()
		{
			return listenerName;
		}
		
		@Override
		public AjaxResponse<?> action(AjaxCall<?> call, AjaxResponse<?> response)
		{
			try
			{
				actionClass = (Class<? extends ChartJS>) Class.forName(call.getClassName());
				listenerName = call.getUnknownFields()
				                   .get("listenerName")
				                   .toString();
			}
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			var initialEvents = GuiceContext.get(actionClass)
			                                                   .getInitialOptions();
			if (initialEvents == null)
			{
				return null;
			}
			response.addDataResponse(listenerName, initialEvents);
			return response;
		}
	}
	
	protected static class DataSetsReceiver extends WebSocketAbstractCallReceiver
	{
		private String listenerName;
		private Class<? extends ChartJS> actionClass;
		
		public DataSetsReceiver()
		{
		}
		
		public DataSetsReceiver(String listenerName, Class<? extends ChartJS> actionClass)
		{
			this.listenerName = listenerName;
			this.actionClass = actionClass;
		}
		
		@Override
		public String getMessageDirector()
		{
			return listenerName;
		}
		
		@Override
		public AjaxResponse<?> action(AjaxCall<?> call, AjaxResponse<?> response)
		{
			try
			{
				actionClass = (Class<? extends ChartJS>) Class.forName(call.getClassName());
				listenerName = call.getUnknownFields()
				                   .get("listenerName")
				                   .toString();
			}
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			var initialEvents = GuiceContext.get(actionClass)
			                                .getListenerNameDataSets();
			if (initialEvents == null)
			{
				return null;
			}
			response.addDataResponse(listenerName, initialEvents);
			return response;
		}
	}
	
}
