package com.jwebmp.plugins.graphing.chartjs.component;

import com.jwebmp.core.base.references.CSSReference;
import com.jwebmp.core.base.references.JavascriptReference;

public enum ChartJSReferences {
    /**
     * The basic core for the graphing system
     */
    ChartJSReferences(new JavascriptReference("ChartJS", 3.51, "chartjs/chart.js", "https://www.jsdelivr.com/package/npm/chart.js?path=dist", 15),
            new CSSReference("ChartJS",3.51,"chartjs/Chart.css","https://www.jsdelivr.com/package/npm/chart.css?path=dist",15)),
    ;
    private final JavascriptReference reference;
    private final CSSReference cssReference;

    ChartJSReferences(JavascriptReference reference,CSSReference cssReference)
    {
        this.reference = reference;
        this.cssReference = cssReference;

    }

    public JavascriptReference getReference() {
        return reference;
    }

    public CSSReference getCssReference() {
        return cssReference;
    }
}
