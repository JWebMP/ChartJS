package com.jwebmp.plugins.graphing.chartjs;

import com.guicedee.guicedinjection.*;
import com.jwebmp.core.base.angular.client.annotations.angular.*;
import com.jwebmp.core.base.angular.client.services.interfaces.*;
import com.jwebmp.core.base.angular.services.*;
import com.jwebmp.core.base.angular.services.compiler.*;

import org.junit.jupiter.api.*;

import java.io.*;

import static com.jwebmp.core.base.angular.client.services.interfaces.AnnotationUtils.*;

@NgApp(value = "chartjsapp", bootComponent = ChartJSKitchenSink.class)
public class ChartJSApp extends NGApplication<ChartJSApp>
{
    public ChartJSApp()
    {
        getOptions().setTitle("ChartJS Kitchen Sink");
    }


    @Test
    public void testAppSearch() throws IOException
    {
        System.out.println("Chart : " + new ChartJSComp().toString(0));
        GuiceContext.instance()
                    .inject();
        for (INgApp<?> app : JWebMPTypeScriptCompiler.getAllApps())
        {
            JWebMPTypeScriptCompiler compiler = new JWebMPTypeScriptCompiler(app);

            System.out.println("Generating @NgApp (" + getTsFilename(app.getClass()) + ") " +
                    "in folder " + IComponent.getClassDirectory(app.getClass()));
            System.out.println("================");
            //	compiler.renderAppTS(app);
            System.out.println("================");
        }
    }
}
