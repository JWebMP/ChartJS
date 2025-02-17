package com.jwebmp.plugins.graphing.chartjs;

import com.guicedee.client.IGuiceContext;
import com.jwebmp.core.base.angular.client.annotations.angular.NgApp;
import com.jwebmp.core.base.angular.client.services.interfaces.IComponent;
import com.jwebmp.core.base.angular.client.services.interfaces.INgApp;
import com.jwebmp.core.base.angular.services.NGApplication;
import com.jwebmp.core.base.angular.services.compiler.JWebMPTypeScriptCompiler;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.jwebmp.core.base.angular.client.services.interfaces.AnnotationUtils.getTsFilename;

@NgApp(value = "chartjsapp", bootComponent = ChartJSKitchenSink.class)
public class ChartJSApp extends NGApplication<ChartJSApp>
{
    public ChartJSApp()
    {
        getOptions().setTitle("ChartJS Kitchen Sink");
    }

    public static void main(String[] args)
    {
        IGuiceContext.instance().inject();
    }

    @Test
    public void testAppSearch() throws IOException
    {
        System.out.println("Chart : " + new ChartJSComp().toString(0));
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
