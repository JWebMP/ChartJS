package com.jwebmp.plugins.graphing.chartjs;

import com.guicedee.client.IGuiceContext;
import com.guicedee.guicedservlets.websockets.options.IGuicedWebSocket;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.angular.client.DynamicData;
import com.jwebmp.core.base.angular.client.annotations.constructors.NgConstructorBody;
import com.jwebmp.core.base.angular.client.annotations.functions.NgAfterViewInit;
import com.jwebmp.core.base.angular.client.annotations.functions.NgOnDestroy;
import com.jwebmp.core.base.angular.client.annotations.references.NgComponentReference;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportModule;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.annotations.structures.NgField;
import com.jwebmp.core.base.angular.client.annotations.structures.NgMethod;
import com.jwebmp.core.base.angular.client.annotations.structures.NgSignal;
import com.jwebmp.core.base.angular.client.services.EventBusService;
import com.jwebmp.core.base.angular.client.services.interfaces.AnnotationUtils;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.angular.implementations.WebSocketAbstractCallReceiver;
import com.jwebmp.core.base.html.Canvas;

import java.util.ArrayList;
import java.util.List;

//@NgImportReference(value = "Chart,Point,ChartDataset,DefaultDataPoint,registerables,ChartConfiguration",
//        reference = "chart.js")
//@NgImportReference(value = "AfterViewInit", reference = "@angular/core")
//@NgImportReference(value = "ElementRef", reference = "@angular/core")
@NgImportReference(value = "ViewChild", reference = "@angular/core")
@NgImportReference(value = "HostListener", reference = "@angular/core")
//@NgImportReference(value = "HostBinding", reference = "@angular/core")
//@NgImportReference(value = "Injectable", reference = "@angular/core")
//@NgImportReference(value = "Observable", reference = "rxjs")
//@NgImportReference(value = "Observer", reference = "rxjs")
@NgImportReference(value = "Subscription", reference = "rxjs")
//@NgImportReference(value = "Subject", reference = "rxjs")
//@NgImportReference(value = "bufferTime", reference = "rxjs")


//@NgImportReference(value = "inject", reference = "@angular/core")
//@NgField(value = "private readonly eventBusService = inject(EventBusService); // Injected EventBus service.")

//@NgConstructorParameter("private socketClientService : SocketClientService")
//@NgComponentReference(DynamicData.class)

//@NgField("private chart?: Chart;")

//@NgField("private chartConfiguration? : ChartConfiguration;")

//@NgField("private datasets?: ChartDataset[];")
//@NgField("private labels?: string[];")

//@NgOnDestroy("this.chart?.destroy();")
//@NgOnDestroy("this.datasets = [];")


@NgField("readonly subscription?: Subscription;")
@NgField("readonly subscriptionDataSets?: Subscription;")

@NgField("readonly handlerId :string;")
@NgField("readonly datasetHandlerId :string;")
@NgConstructorBody("this.datasetHandlerId = this.generateHandlerId();")
@NgConstructorBody("this.handlerId = this.generateHandlerId();")

@NgOnDestroy("this.subscription?.unsubscribe();")
@NgOnDestroy("this.subscriptionDataSets?.unsubscribe();")
//@NgOnDestroy("this.eventBusService.unregisterListener(this.listenerName);")
//@NgOnDestroy("this.eventBusService.unregisterListener(this.listenerName + 'DataSets');")

//@NgConstructorBody("Chart.register(...registerables);")

@NgImportReference(value = "v4 as uuidv4", reference = "uuid")
@NgMethod("""
        private generateHandlerId(): string {
            return `${this.listenerName}-${uuidv4()}`;
        }
        """)

/*
@NgAfterViewInit("""
        this.subscription = this.eventBusService.listen(this.listenerName,this.handlerId)
                           //        .pipe(bufferTime(100))
                                   .subscribe((message: any) => {
                                       if (message) {
                                           if (Array.isArray(message)) {
                                               for (let m of message) {
                       							if(typeof m == 'string')
                                                    this.chartConfiguration = JSON.parse(m);
                                               else
                                                   this.chartConfiguration = m;
                       								if (this.chartConfiguration) {
                       									if (!this.chart) {
                       										this.chart = new Chart(this.chartRef?.nativeElement, this.chartConfiguration);
                       										this.datasets = this.chart?.data.datasets;
                       										this.labels = this.chart?.data.labels as string[];
                       									} else {
                       										this.datasets = this.chartConfiguration?.data.datasets;
                       										for (const dataset of this.datasets) {
                       											if (dataset && dataset.label) {
                       												this.updateDataset(dataset.label, dataset);
                       											}
                       										}
                       									}
                       								}
        
                                               }
                                           } else {
                                               if (this.chartRef) {
                       							if (this.chartConfiguration) {
                       								if (!this.chart) {
                       									this.chart = new Chart(this.chartRef?.nativeElement, this.chartConfiguration);
                       									this.datasets = this.chartConfiguration?.data.datasets;
                       								} else {
                       									if(typeof message == 'string')
                                                           this.chartConfiguration = JSON.parse(message);
                                                       else
                                                        this.chartConfiguration = message;
                       									this.datasets = this.chartConfiguration?.data.datasets;
                       									if(this.datasets)
                       									for (const dataset of this.datasets) {
                       										if (dataset && dataset.label) {
                       											this.updateDataset(dataset.label, dataset);
                       										}
                       									}
                       								}
                       							}
                       							else {
                                                      if (typeof message == 'string')
                                                          this.chartConfiguration = JSON.parse(message);
                                                      else
                                                          this.chartConfiguration = message;
                                                      if (this.chartConfiguration) {
                                                          if (!this.chart) {
                                                              this.chart = new Chart(this.chartRef?.nativeElement, this.chartConfiguration);
                                                              this.datasets = this.chart?.data.datasets;
                                                              this.labels = this.chart?.data.labels as string[];
                                                          } else {
                                                              this.datasets = this.chartConfiguration?.data.datasets;
                                                              for (const dataset of this.datasets) {
                                                                  if (dataset && dataset.label) {
                                                                      this.updateDataset(dataset.label, dataset);
                                                                  }
                                                              }
                                                          }
                                                      }
                                                  }
                                               }
                                           }
                                       }
                                   });
        """)*/

/*@NgAfterViewInit("""
        this.subscriptionDataSets = this.eventBusService.listen(this.listenerName + 'DataSets',this.datasetHandlerId)
                             //      .pipe(bufferTime(100))
                                   .subscribe((message: any) => {
                                       if (message) {
                                           if (Array.isArray(message)) {
                                               for (let m of message) {
                       							for (const messageElement of message) {
                       							let m;
                                                  if (typeof messageElement == 'string') {
                                                      m = JSON.parse(messageElement);
                                                  } else {
                                                      m = messageElement;
                                                  }
                       								if (m && m.label) {
                       									this.updateDataset(m.label, m);
                       								}
                       							}
                                               }
                                           } else {
                                           let m;
                                               if(typeof message == 'string')
                                                   m = JSON.parse(message);
                                               else m = message;
                       							this.updateDataset(m.label, m);
                                           }
                                       }
                                   });
        """)*/
@NgMethod("""
        @HostListener('window:beforeprint')
         beforePrintHandler() {
             for (let id in Chart.instances) {
                 Chart.instances[id].resize(1240, 350);
             }
         }
        
         @HostListener('window:afterprint')
         afterPrintHandler() {
             for (let id in Chart.instances) {
                 Chart.instances[id].resize();
             }
         }""")
@NgOnDestroy("""
        \tthis.eventBusService.unregisterListener(this.listenerName, this.handlerId);
                  this.eventBusService.unregisterListener(this.listenerName +'Datasets', this.datasetHandlerId);
        """)


@NgImportReference(value = "BaseChartDirective", reference = "ng2-charts")
@NgImportModule("BaseChartDirective")

@NgComponentReference(EventBusService.class)
@NgField("@ViewChild('chart')\n" +
        "\t\tprivate chart! : BaseChartDirective;")


@NgField("readonly chartData = computed(()=>this.chartConfiguration()?.data);")
@NgField("readonly chartOptions = computed(()=>this.chartConfiguration()?.options);")
@NgField("readonly labels = computed(()=>this.chartConfiguration()?.data?.labels);")
@NgImportReference(value = "Chart", reference = "chart.js")
@NgImportReference(value = "ChartConfiguration", reference = "chart.js")
@NgImportReference(value = "ChartDataset", reference = "chart.js")
@NgImportReference(value = "ChartType", reference = "chart.js")
@NgImportReference(value = "ChartEvent", reference = "chart.js")
@NgSignal(type = "ChartConfiguration | undefined", referenceName = "chartConfiguration", value = "undefined")

@NgConstructorBody("""
        this.subscription = this.eventBusService.listen(this.listenerName, this.handlerId)
              .subscribe({
                  next: (message: any) => {
                      if (message) {
                          if (Array.isArray(message)) {
                              for (let m of message) {
                                  if (typeof m == 'string')
                                      this.chartConfiguration.set(JSON.parse(m));
                                  else
                                      this.chartConfiguration.set(m);
                              }
                          }
                      }else {
                          if (typeof message == 'string')
                              this.chartConfiguration.set(JSON.parse(message));
                          else
                              this.chartConfiguration.set(message);
                      }
                  },
                  error: (error: any) => {
                      console.log(error);
                  },
              })
        """)
@NgConstructorBody("""
        this.subscriptionDataSets = this.eventBusService.listen(this.listenerName + 'DataSets',this.datasetHandlerId)
            .subscribe({
                next: (message: any) => {
                    if (message) {
                        if (Array.isArray(message)) {
                            for (let m of message) {
                                for (const messageElement of message) {
                                    let m;
                                    if (typeof messageElement == 'string') {
                                        m = JSON.parse(messageElement);
                                    } else {
                                        m = messageElement;
                                    }
                                    if (m && m.label) {
                                        this.updateDataset(m.label, m);
                                    }
                                }
                            }
                        } else {
                            let m;
                            if(typeof message == 'string')
                                m = JSON.parse(message);
                            else m = message;
                            this.updateDataset(m.label, m);
                        }
                    }
                },
                error: (error: any) => {
                    console.log(error);
                },
            })""")
@NgAfterViewInit("""
        this.eventBusService.send(this.listenerName, {
                    className: this.clazzName,
                    listenerName: this.listenerName
                }, this.listenerName);""")
@NgMethod("""
        updateDataset(label: string, dataset: ChartDataset) {
            let found: boolean = false;
            let index: number = -1;
            let existingDataSet = undefined;
        
            if (this.chart && this.chart.chart && this.chart.chart.config) {
                if (this.chart.chart.data.datasets)
                    for (let i = 0; i < this.chart.chart.data.datasets.length; i++) {
                        const dataset1 = this.chart.chart.data.datasets[i];
                        if (dataset1.label == label) {
                            //console.log('dataset equals [' + dataset1.label+ ']/[' + label+ ']');
                            index = i;
                            existingDataSet = dataset1;
                            found = true;
                            break;
                        }
                    }
                const labels = this.labels();
                if (labels) {
                    if (found && existingDataSet) {
                        for (let i = 0; i < dataset.data.length; i++) {
                            if (this.labels() && this.chart.chart.config.data.labels) {
                                for (let j = 0; j < labels.length; j++) {
                                    const labelPositionJ = labels[j];
        
                                    for (let k = 0; k < this.chart.chart.config.data.labels?.length; k++) {
                                        const labelPositionK = this.chart.chart.config.data.labels[k];
                                        if (labelPositionJ == labelPositionK) {
                                            let d = existingDataSet.data[j];
                                            let d2 = dataset.data[k];
                                            if (d != d2 && index != -1) {
                                                //console.log('updating [' + label + '][' + index + '] to ' + d2 + '[' + j + ']');
                                                this.chart.chart.config.data.datasets[index].data.splice(j, 1, d2);
                                            }
                                            break;
                                        }
                                    }
                                }
                            } else {
                                console.log('no labels and chart data labels to compare');
                            }
                        }
                        if (dataset.data.length != existingDataSet?.data.length) {
                            //console.log('lengths are not equal  = ' + dataset.data.length + ' / existing in array = ' + existingDataSet?.data.length);
                        }
                        this.chart.chart.update();
                    }
                }
            }
        }""")
public abstract class ChartJS<D, O extends Chart<D, O>, J extends ChartJS<D, O, J>> extends Canvas<J> implements
        INgComponent<J>
{
    private Chart<D, O> options;

    public ChartJS(String id)
    {
        setID(id);
        addAttribute("#chart", "");
        addAttribute("baseChart", "");

        addAttribute("[data]", "chartData()");
        addAttribute("[options]", "chartOptions()");
        addAttribute("[labels]", "labels()");
        addAttribute("[type]", "chartType");
        addAttribute("*ngIf", "chartConfiguration() && chartData() && chartOptions() && labels() && chartType");

        addConfiguration(AnnotationUtils.getNgField("readonly clazzName = '%s';".formatted(getClass().getCanonicalName())));
    }

    protected String getListenerName()
    {
        return getID();
    }

    protected String getListenerNameDataSets()
    {
        return getID() + "DataSets";
    }

    public String getType()
    {
        return getInitialOptions().getType();
    }

    @Override
    protected void init()
    {
        if (!isInitialized())
        {
            addConfiguration(AnnotationUtils.getNgField("readonly chartType : ChartType = '" + getType() + "'"));
            registerWebSocketListeners();
        }
        super.init();
    }

    @Override
    public List<String> fields()
    {
        List<String> out = INgComponent.super.fields();
        if (out == null)
        {
            out = new ArrayList<>();
        }
        out.add(" readonly listenerName = '" + getID() + "';\n");
        return out;
    }

    /*@Override
    public List<String> methods()
    {
        List<String> out = INgComponent.super.methods();
        out.add("""
                \t\t\tupdateDataset(label: string, dataset: ChartDataset) {
                             let found: boolean = false;
                             let index: number = -1;
                             let existingDataSet = undefined;
                             if (this.chart?.data.datasets)
                                 for (let i = 0; i < this.chart?.data.datasets.length; i++) {
                                     const dataset1 = this.chart?.data.datasets[i];
                                     if (dataset1.label == label) {
                                     	//console.log('dataset equals [' + dataset1.label+ ']/[' + label+ ']');
                                         index = i;
                                         existingDataSet = dataset1;
                                         found = true;
                                         break;
                                     }
                                 }
                             if (found && existingDataSet) {
                                 for (let i = 0; i < dataset.data.length; i++) {
                
                                     if(this.labels && this.chartConfiguration?.data?.labels) {
                                         for (let j = 0; j < this.labels.length; j++) {
                                             var labelPositionJ = this.labels[j];
                
                                             for (let k = 0; k < this.chartConfiguration?.data?.labels?.length; k++) {
                                                 var labelPositionK = this.chartConfiguration?.data?.labels[k];
                                                 if(labelPositionJ == labelPositionK)
                                                 {
                                                   //  console.log('match station label update - ' + labelPositionJ + "/" + labelPositionK);
                                                     let d = existingDataSet.data[j];
                                                     let d2 = dataset.data[k];
                                                     if (d != d2 && index != -1) {
                                                      //   console.log('updating [' + label + '][' + index + '] to ' + d2 + '[' + j + ']');
                                                         this.chart?.data.datasets[index].data.splice(j, 1, d2);
                                                     }
                                                     break;
                                                 }
                                             }
                
                                         }
                                     }else {
                                         console.log('no labels and chart data labels to compare');
                                     }
                
                                     //if (d2)
                
                                 }
                                 if (dataset.data.length != existingDataSet?.data.length) {
                                     console.log('lengths are not equal  = ' + dataset.data.length + ' / existing in array = ' + existingDataSet?.data.length);
                                 }
                                 try {
                                 	this.chart?.update();
                                 }catch(e)
                                 {
                                 	console.log(e);
                                 }
                             }
                         }""");
        return out;
    }*/

    public abstract Chart<D, O> getInitialOptions();

    protected void registerWebSocketListeners()
    {
        if (!IGuicedWebSocket.isWebSocketReceiverRegistered(getListenerName()))
        {
            IGuicedWebSocket.addWebSocketMessageReceiver(new InitialOptionsReceiver(getListenerName(), getClass()));
        }
        if (!IGuicedWebSocket.isWebSocketReceiverRegistered(getListenerNameDataSets()))
        {
            IGuicedWebSocket.addWebSocketMessageReceiver(new DataSetsReceiver(getListenerNameDataSets(), getClass()));
        }
    }

    @Override
    public List<String> styles()
    {
        List<String> out = INgComponent.super.styles();
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
            var initialEvents = IGuiceContext.get(actionClass)
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
            var initialEvents = IGuiceContext.get(actionClass)
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
