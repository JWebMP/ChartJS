/*
 * Copyright (C) 2017 GedMarc
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.jwebmp.plugins.graphing.chartjs;

import com.jwebmp.core.*;

/**
 * This is the default implementation of the JQPlot Graph Library
 *
 * @author mmagon
 * @version 2.0
 * <p>
 * 2016/02/26 Update to the feature for 1.0.9 and updates to the JavaScript Engine
 * @since 2014/07/08
 */
public class ChartJSFeature
		extends Feature<ChartJSFeature, Chart<?>, ChartJSFeature>
{
	/**
	 * The graph this feature is linked to
	 */
	private ChartJS<?> graph;
	
	public ChartJSFeature(ChartJS<?> forGraph,Chart<?> options)
	{
		super("ChartJSFeature");
		setComponent(forGraph);
		graph = forGraph;
		setOptions(options);
	}
	
	public String getVariableName()
	{
		return graph.getID();
	}
	
	@Override
	public int hashCode()
	{
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object o)
	{
		return super.equals(o);
	}
	
	@Override
	public Chart<?> getOptions()
	{
		return super.getOptions();
	}
	
	@Override
	public void assignFunctionsToComponent()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("if(jw.chartjs === undefined) {jw.chartjs = {};}" +
		          "" +
		          "if(jw.chartjs." + getVariableName() + ")" +
		          "     {try{jw.chartjs" + getVariableName() + ".destroy();}catch(e){}}" +
		          "" +
		          "" +
		          "jw.chartjs." + getVariableName())
		  .append(" =  new Chart($('" + getComponent().asBase()
		                                              .getID(true)
		          + "')," + getNewLine() +
		          getOptions()
		          + ");" + getNewLine() +
		          "" + getNewLine() +
		          "" + getNewLine() +
		          ""
		  );
		addQuery(sb.toString());
	}
	
	/**
	 * Gets the graph with this feature
	 *
	 * @return
	 */
	public ChartJS<?> getGraph()
	{
		return graph;
	}
	
	/**
	 * Sets the graph for this feature
	 *
	 * @param graph
	 */
	public void setGraph(ChartJS<?> graph)
	{
		this.graph = graph;
	}
	
}
