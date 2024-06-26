/*
	Copyright 2020 Marceau Dewilde <m@ceau.be>

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

		http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
*/
package com.jwebmp.plugins.graphing.chartjs.options;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect.*;
import com.fasterxml.jackson.annotation.JsonInclude.*;
import com.jwebmp.plugins.graphing.chartjs.enums.*;
import com.jwebmp.plugins.graphing.chartjs.javascript.*;
import com.jwebmp.plugins.graphing.chartjs.options.animation.*;
import com.jwebmp.plugins.graphing.chartjs.options.layout.*;

import java.util.*;

@JsonInclude(Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class Options<T extends Options<T>>
{
	
	private Boolean responsive;
	private Integer responsiveAnimationDuration;
	private Boolean maintainAspectRatio;
	private final Set<Event> events = EnumSet.noneOf(Event.class);
	private JavaScriptFunction onClick;
	private JavaScriptFunction legendCallback;
	private JavaScriptFunction onResize;
	private Title title;
	private Legend legend;
	private Tooltips tooltips;
	private Hover hover;
	private Animation<?> animation;
	private Layout layout;
	private Map<String, Object> plugins;
	private Interaction interaction;
	private boolean parsing;
	
	
	/**
	 * @see #setResponsive(Boolean)
	 */
	public Boolean getResponsive()
	{
		return this.responsive;
	}
	
	/**
	 * Default {@code true} Resizes when the canvas container does.
	 */
	@SuppressWarnings("unchecked")
	public T setResponsive(Boolean responsive)
	{
		this.responsive = responsive;
		return (T) this;
	}
	
	/**
	 * @see #setResponsiveAnimationDuration(Integer)
	 */
	public Integer getResponsiveAnimationDuration()
	{
		return this.responsiveAnimationDuration;
	}
	
	/**
	 * Default {@code 0} Duration in milliseconds it takes to animate to new
	 * size after a resize event.
	 */
	@SuppressWarnings("unchecked")
	public T setResponsiveAnimationDuration(Integer responsiveAnimationDuration)
	{
		this.responsiveAnimationDuration = responsiveAnimationDuration;
		return (T) this;
	}
	
	/**
	 * @see #setMaintainAspectRatio(Boolean)
	 */
	public Boolean getMaintainAspectRatio()
	{
		return this.maintainAspectRatio;
	}
	
	/**
	 * Default {@code true} Maintain the original canvas aspect ratio (width /
	 * height) when resizing
	 */
	@SuppressWarnings("unchecked")
	public T setMaintainAspectRatio(Boolean maintainAspectRatio)
	{
		this.maintainAspectRatio = maintainAspectRatio;
		return (T) this;
	}
	
	/**
	 * @see #setEvents(Collection)
	 */
	public Set<Event> getEvents()
	{
		return this.events;
	}
	
	/**
	 * Default
	 * {@code ["mousemove", "mouseout", "click", "touchstart", "touchmove", "touchend"]}
	 * Events that the chart should listen to for tooltips and hovering
	 */
	@SuppressWarnings("unchecked")
	public T setEvents(Collection<Event> events)
	{
		this.events.clear();
		if (events != null)
		{
			this.events.addAll(events);
		}
		return (T) this;
	}
	
	/**
	 * @see #setOnClick(JavaScriptFunction)
	 */
	public JavaScriptFunction getOnClick()
	{
		return this.onClick;
	}
	
	/**
	 * Default {@code null} Called if the event is of type 'mouseup' or 'click'.
	 * Called in the context of the chart and passed an array of active
	 * arcElements
	 */
	@SuppressWarnings("unchecked")
	public T setOnClick(JavaScriptFunction onClick)
	{
		this.onClick = onClick;
		return (T) this;
	}
	
	/**
	 * @see #setLegendCallback(JavaScriptFunction)
	 */
	public JavaScriptFunction getLegendCallback()
	{
		return this.legendCallback;
	}
	
	/**
	 * Default {@code function (chart) { }} Function to generate a legend.
	 * Receives the chart object to generate a legend from. Default
	 * implementation returns an HTML string.
	 */
	@SuppressWarnings("unchecked")
	public T setLegendCallback(JavaScriptFunction legendCallback)
	{
		this.legendCallback = legendCallback;
		return (T) this;
	}
	
	/**
	 * @see #setOnResize(JavaScriptFunction)
	 */
	public JavaScriptFunction getOnResize()
	{
		return this.onResize;
	}
	
	/**
	 * Default {@code null} Called when a resize occurs. Gets passed two
	 * arguemnts: the chart instance and the new size.
	 */
	@SuppressWarnings("unchecked")
	public T setOnResize(JavaScriptFunction onResize)
	{
		this.onResize = onResize;
		return (T) this;
	}
	
	/**
	 * @see #setTitle(Title)
	 */
	public Title getTitle()
	{
		if (title == null)
		{
			title = new Title();
		}
		return title;
	}
	
	/**
	 * The title configuration is passed into the options.title namespace. The
	 * global options for the chart title is defined in
	 * Chart.defaults.global.title.
	 */
	@SuppressWarnings("unchecked")
	public T setTitle(Title title)
	{
		this.title = title;
		return (T) this;
	}
	
	/**
	 * @see #setLegend(Legend)
	 */
	public Legend getLegend()
	{
		if (legend == null)
		{
			legend = new Legend();
		}
		return legend;
	}
	
	/**
	 * The legend configuration is passed into the options.legend namespace. The
	 * global options for the chart legend is defined in
	 * Chart.defaults.global.legend.
	 */
	@SuppressWarnings("unchecked")
	public T setLegend(Legend legend)
	{
		this.legend = legend;
		return (T) this;
	}
	
	/**
	 * @see #setTooltips(Tooltips)
	 */
	public Tooltips getTooltips()
	{
		if (tooltips == null)
		{
			tooltips = new Tooltips();
		}
		return tooltips;
	}
	
	/**
	 * The tooltip label configuration is nested below the tooltip configuration
	 * using the callbacks key. The tooltip has the following callbacks for
	 * providing text. For all functions, 'this' will be the tooltip object
	 * created from the Chart.Tooltip constructor.
	 * <p>
	 * All functions are called with the same arguments: a tooltip item and the
	 * data object passed to the chart. All functions must return either a
	 * string or an array of strings. Arrays of strings are treated as multiple
	 * lines of text.
	 */
	@SuppressWarnings("unchecked")
	public T setTooltips(Tooltips tooltips)
	{
		this.tooltips = tooltips;
		return (T) this;
	}
	
	/**
	 * @see #setHover(Hover)
	 */
	public Hover getHover()
	{
		if (hover == null)
		{
			hover = new Hover();
		}
		return hover;
	}
	
	/**
	 * The hover configuration is passed into the options.hover namespace. The
	 * global hover configuration is at Chart.defaults.global.hover.
	 */
	@SuppressWarnings("unchecked")
	public T setHover(Hover hover)
	{
		this.hover = hover;
		return (T) this;
	}
	
	/**
	 * @see #setAnimation(Animation)
	 */
	public Animation<?> getAnimation()
	{
		if (animation == null)
		{
			animation = new Animation<>();
		}
		return animation;
	}
	
	/**
	 * The following animation options are available. The global options for are
	 * defined in Chart.defaults.global.animation.
	 */
	@SuppressWarnings("unchecked")
	public T setAnimation(Animation<?> animation)
	{
		this.animation = animation;
		return (T) this;
	}
	
	/**
	 * @return {@link Layout} instance or {@code null}
	 */
	public Layout getLayout()
	{
		if (layout == null)
		{
			layout = new Layout();
		}
		return layout;
	}
	
	/**
	 * @param layout {@link Layout} instance or {@code null}
	 * @return {@code this} instance for chaining
	 */
	@SuppressWarnings("unchecked")
	public T setLayout(Layout layout)
	{
		this.layout = layout;
		return (T) this;
	}
	
	/**
	 * @see #setPlugins(Map<String,Object>)
	 */
	public Map<String, Object> getPlugins()
	{
		if (plugins == null)
		{
			plugins = new HashMap<>();
		}
		return plugins;
	}
	
	/**
	 * A placeholder in which configuration options for plugins may be passed.
	 *
	 * @param plugins {@link Map<String,Object>} or {@code null}
	 * @return {@code this} instance for chaining
	 */
	@SuppressWarnings("unchecked")
	public T setPlugins(Map<String, Object> plugins)
	{
		this.plugins = plugins;
		return (T) this;
	}

	public Interaction getInteraction()
	{
		return interaction;
	}
	
	public Options<T> setInteraction(Interaction interaction)
	{
		this.interaction = interaction;
		return this;
	}
	
	public boolean isParsing()
	{
		return parsing;
	}
	
	public Options<T> setParsing(boolean parsing)
	{
		this.parsing = parsing;
		return this;
	}
}
