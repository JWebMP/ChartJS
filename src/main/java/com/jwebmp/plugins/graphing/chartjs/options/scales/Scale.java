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
package com.jwebmp.plugins.graphing.chartjs.options.scales;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.jwebmp.plugins.graphing.chartjs.enums.ScalesPosition;
import com.jwebmp.plugins.graphing.chartjs.javascript.JavaScriptFunction;
import com.jwebmp.plugins.graphing.chartjs.options.ticks.Ticks;

@JsonInclude(Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public abstract class Scale<T extends Scale<T>> {
	
	/**
	 * @see #setDisplay(Boolean)
	 */
	private Boolean display;

	/**
	 * @see #setPosition(ScalesPosition)
	 */
	private ScalesPosition position;

	/**
	 * @see #setId(String)
	 */
	private String id;

	/**
	 * @see #setBeforeUpdate(JavaScriptFunction)
	 */
	private JavaScriptFunction beforeUpdate;

	/**
	 * @see #setBeforeSetDimensions(JavaScriptFunction)
	 */
	private JavaScriptFunction beforeSetDimensions;

	/**
	 * @see #setAfterSetDimensions(JavaScriptFunction)
	 */
	private JavaScriptFunction afterSetDimensions;

	/**
	 * @see #setBeforeDataLimits(JavaScriptFunction)
	 */
	private JavaScriptFunction beforeDataLimits;

	/**
	 * @see #setAfterDataLimits(JavaScriptFunction)
	 */
	private JavaScriptFunction afterDataLimits;

	/**
	 * @see #setBeforeBuildTicks(JavaScriptFunction)
	 */
	private JavaScriptFunction beforeBuildTicks;

	/**
	 * @see #setAfterBuildTicks(JavaScriptFunction)
	 */
	private JavaScriptFunction afterBuildTicks;

	/**
	 * @see #setBeforeTickToLabelConversion(JavaScriptFunction)
	 */
	private JavaScriptFunction beforeTickToLabelConversion;

	/**
	 * @see #setAfterTickToLabelConversion(JavaScriptFunction)
	 */
	private JavaScriptFunction afterTickToLabelConversion;

	/**
	 * @see #setBeforeCalculateTickRotation(JavaScriptFunction)
	 */
	private JavaScriptFunction beforeCalculateTickRotation;

	/**
	 * @see #setAfterCalculateTickRotation(JavaScriptFunction)
	 */
	private JavaScriptFunction afterCalculateTickRotation;

	/**
	 * @see #setBeforeFit(JavaScriptFunction)
	 */
	private JavaScriptFunction beforeFit;

	/**
	 * @see #setAfterFit(JavaScriptFunction)
	 */
	private JavaScriptFunction afterFit;

	/**
	 * @see #setAfterUpdate(JavaScriptFunction)
	 */
	private JavaScriptFunction afterUpdate;

	/**
	 * @see #setGridLines(GridLines)
	 */
	private GridLines gridLines;

	/**
	 * @see #setScaleLabel(ScaleLabel)
	 */
	private ScaleLabel scaleLabel;
	
	/**
	 * @see #setDisplay(Boolean)
	 */
	public Boolean getDisplay() {
		return this.display;
	}

	/**
	 * <p>
	 * If true, show the scale including gridlines, ticks, and labels. Overrides
	 * gridLines.display, scaleLabel.display, and ticks.display.
	 * </p>
	 * 
	 * <p>
	 * Default {@code true}
	 * </p>
	 */
	@SuppressWarnings("unchecked")
	public T setDisplay(Boolean display) {
		this.display = display;
	    return (T) this;
	}

	/**
	 * @see #setPosition(ScalesPosition)
	 */
	public ScalesPosition getPosition() {
		return this.position;
	}

	/**
	 * <p>
	 * Position of the scale. Possible values are 'top', 'left', 'bottom' and
	 * 'right'.
	 * </p>
	 * 
	 * <p>
	 * Default {@code "left"}
	 * </p>
	 */
	@SuppressWarnings("unchecked")
	public T setPosition(ScalesPosition position) {
		this.position = position;
	    return (T) this;
	}

	/**
	 * @see #setId(String)
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * <p>
	 * The ID is used to link datasets and scale axes together. The properties
	 * datasets.xAxisID or datasets.yAxisID have to match the scale properties
	 * scales.xAxes.id or scales.yAxes.id. This is especially needed if
	 * multi-axes charts are used.
	 * </p>
	 * 
	 * <p>
	 * Default {@code }
	 * </p>
	 */
	@SuppressWarnings("unchecked")
	public T setId(String id) {
		this.id = id;
	    return (T) this;
	}

	/**
	 * @see #setBeforeUpdate(JavaScriptFunction)
	 */
	public JavaScriptFunction getBeforeUpdate() {
		return this.beforeUpdate;
	}

	/**
	 * <p>
	 * Callback called before the update process starts. Passed a single
	 * argument, the scale instance.
	 * </p>
	 * 
	 * <p>
	 * Default {@code undefined}
	 * </p>
	 */
	@SuppressWarnings("unchecked")
	public T setBeforeUpdate(JavaScriptFunction beforeUpdate) {
		this.beforeUpdate = beforeUpdate;
	    return (T) this;
	}

	/**
	 * @see #setBeforeSetDimensions(JavaScriptFunction)
	 */
	public JavaScriptFunction getBeforeSetDimensions() {
		return this.beforeSetDimensions;
	}

	/**
	 * <p>
	 * Callback that runs before dimensions are set. Passed a single argument,
	 * the scale instance.
	 * </p>
	 * 
	 * <p>
	 * Default {@code undefined}
	 * </p>
	 */
	@SuppressWarnings("unchecked")
	public T setBeforeSetDimensions(JavaScriptFunction beforeSetDimensions) {
		this.beforeSetDimensions = beforeSetDimensions;
	    return (T) this;
	}

	/**
	 * @see #setAfterSetDimensions(JavaScriptFunction)
	 */
	public JavaScriptFunction getAfterSetDimensions() {
		return this.afterSetDimensions;
	}

	/**
	 * <p>
	 * Callback that runs after dimensions are set. Passed a single argument,
	 * the scale instance.
	 * </p>
	 * 
	 * <p>
	 * Default {@code undefined}
	 * </p>
	 */
	@SuppressWarnings("unchecked")
	public T setAfterSetDimensions(JavaScriptFunction afterSetDimensions) {
		this.afterSetDimensions = afterSetDimensions;
	    return (T) this;
	}

	/**
	 * @see #setBeforeDataLimits(JavaScriptFunction)
	 */
	public JavaScriptFunction getBeforeDataLimits() {
		return this.beforeDataLimits;
	}

	/**
	 * <p>
	 * Callback that runs before data limits are determined. Passed a single
	 * argument, the scale instance.
	 * </p>
	 * 
	 * <p>
	 * Default {@code undefined}
	 * </p>
	 */
	@SuppressWarnings("unchecked")
	public T setBeforeDataLimits(JavaScriptFunction beforeDataLimits) {
		this.beforeDataLimits = beforeDataLimits;
	    return (T) this;
	}

	/**
	 * @see #setAfterDataLimits(JavaScriptFunction)
	 */
	public JavaScriptFunction getAfterDataLimits() {
		return this.afterDataLimits;
	}

	/**
	 * <p>
	 * Callback that runs after data limits are determined. Passed a single
	 * argument, the scale instance.
	 * </p>
	 * 
	 * <p>
	 * Default {@code undefined}
	 * </p>
	 */
	@SuppressWarnings("unchecked")
	public T setAfterDataLimits(JavaScriptFunction afterDataLimits) {
		this.afterDataLimits = afterDataLimits;
	    return (T) this;
	}

	/**
	 * @see #setBeforeBuildTicks(JavaScriptFunction)
	 */
	public JavaScriptFunction getBeforeBuildTicks() {
		return this.beforeBuildTicks;
	}

	/**
	 * <p>
	 * Callback that runs before ticks are created. Passed a single argument,
	 * the scale instance.
	 * </p>
	 * 
	 * <p>
	 * Default {@code undefined}
	 * </p>
	 */
	@SuppressWarnings("unchecked")
	public T setBeforeBuildTicks(JavaScriptFunction beforeBuildTicks) {
		this.beforeBuildTicks = beforeBuildTicks;
	    return (T) this;
	}

	/**
	 * @see #setAfterBuildTicks(JavaScriptFunction)
	 */
	public JavaScriptFunction getAfterBuildTicks() {
		return this.afterBuildTicks;
	}

	/**
	 * <p>
	 * Callback that runs after ticks are created. Useful for filtering ticks.
	 * Passed a single argument, the scale instance.
	 * </p>
	 * 
	 * <p>
	 * Default {@code undefined}
	 * </p>
	 */
	@SuppressWarnings("unchecked")
	public T setAfterBuildTicks(JavaScriptFunction afterBuildTicks) {
		this.afterBuildTicks = afterBuildTicks;
	    return (T) this;
	}

	/**
	 * @see #setBeforeTickToLabelConversion(JavaScriptFunction)
	 */
	public JavaScriptFunction getBeforeTickToLabelConversion() {
		return this.beforeTickToLabelConversion;
	}

	/**
	 * <p>
	 * Callback that runs before ticks are converted into strings. Passed a
	 * single argument, the scale instance.
	 * </p>
	 * 
	 * <p>
	 * Default {@code undefined}
	 * </p>
	 */
	@SuppressWarnings("unchecked")
	public T setBeforeTickToLabelConversion(JavaScriptFunction beforeTickToLabelConversion) {
		this.beforeTickToLabelConversion = beforeTickToLabelConversion;
	    return (T) this;
	}

	/**
	 * @see #setAfterTickToLabelConversion(JavaScriptFunction)
	 */
	public JavaScriptFunction getAfterTickToLabelConversion() {
		return this.afterTickToLabelConversion;
	}

	/**
	 * <p>
	 * Callback that runs after ticks are converted into strings. Passed a
	 * single argument, the scale instance.
	 * </p>
	 * 
	 * <p>
	 * Default {@code undefined}
	 * </p>
	 */
	@SuppressWarnings("unchecked")
	public T setAfterTickToLabelConversion(JavaScriptFunction afterTickToLabelConversion) {
		this.afterTickToLabelConversion = afterTickToLabelConversion;
	    return (T) this;
	}

	/**
	 * @see #setBeforeCalculateTickRotation(JavaScriptFunction)
	 */
	public JavaScriptFunction getBeforeCalculateTickRotation() {
		return this.beforeCalculateTickRotation;
	}

	/**
	 * <p>
	 * Callback that runs before tick rotation is determined. Passed a single
	 * argument, the scale instance.
	 * </p>
	 * 
	 * <p>
	 * Default {@code undefined}
	 * </p>
	 */
	@SuppressWarnings("unchecked")
	public T setBeforeCalculateTickRotation(JavaScriptFunction beforeCalculateTickRotation) {
		this.beforeCalculateTickRotation = beforeCalculateTickRotation;
	    return (T) this;
	}

	/**
	 * @see #setAfterCalculateTickRotation(JavaScriptFunction)
	 */
	public JavaScriptFunction getAfterCalculateTickRotation() {
		return this.afterCalculateTickRotation;
	}

	/**
	 * <p>
	 * Callback that runs after tick rotation is determined. Passed a single
	 * argument, the scale instance.
	 * </p>
	 * 
	 * <p>
	 * Default {@code undefined}
	 * </p>
	 */
	@SuppressWarnings("unchecked")
	public T setAfterCalculateTickRotation(JavaScriptFunction afterCalculateTickRotation) {
		this.afterCalculateTickRotation = afterCalculateTickRotation;
	    return (T) this;
	}

	/**
	 * @see #setBeforeFit(JavaScriptFunction)
	 */
	public JavaScriptFunction getBeforeFit() {
		return this.beforeFit;
	}

	/**
	 * <p>
	 * Callback that runs before the scale fits to the canvas. Passed a single
	 * argument, the scale instance.
	 * </p>
	 * 
	 * <p>
	 * Default {@code undefined}
	 * </p>
	 */
	@SuppressWarnings("unchecked")
	public T setBeforeFit(JavaScriptFunction beforeFit) {
		this.beforeFit = beforeFit;
	    return (T) this;
	}

	/**
	 * @see #setAfterFit(JavaScriptFunction)
	 */
	public JavaScriptFunction getAfterFit() {
		return this.afterFit;
	}

	/**
	 * <p>
	 * Callback that runs after the scale fits to the canvas. Passed a single
	 * argument, the scale instance.
	 * </p>
	 * 
	 * <p>
	 * Default {@code undefined}
	 * </p>
	 */
	@SuppressWarnings("unchecked")
	public T setAfterFit(JavaScriptFunction afterFit) {
		this.afterFit = afterFit;
	    return (T) this;
	}

	/**
	 * @see #setAfterUpdate(JavaScriptFunction)
	 */
	public JavaScriptFunction getAfterUpdate() {
		return this.afterUpdate;
	}

	/**
	 * <p>
	 * Callback that runs at the end of the update process. Passed a single
	 * argument, the scale instance.
	 * </p>
	 * 
	 * <p>
	 * Default {@code undefined}
	 * </p>
	 */
	@SuppressWarnings("unchecked")
	public T setAfterUpdate(JavaScriptFunction afterUpdate) {
		this.afterUpdate = afterUpdate;
	    return (T) this;
	}

	/**
	 * @see #setGridLines(GridLines)
	 */
	public GridLines getGridLines() {
		return this.gridLines;
	}

	/**
	 * <p>
	 * See grid line configuration section.
	 * </p>
	 * 
	 * <p>
	 * Default {@code -}
	 * </p>
	 */
	@SuppressWarnings("unchecked")
	public T setGridLines(GridLines gridLines) {
		this.gridLines = gridLines;
	    return (T) this;
	}

	/**
	 * @see #setScaleLabel(ScaleLabel)
	 */
	public ScaleLabel getScaleLabel() {
		return this.scaleLabel;
	}

	/**
	 * <p>
	 * See scale title configuration section.
	 * </p>
	 * 
	 * <p>
	 * Default {@code }
	 * </p>
	 */
	@SuppressWarnings("unchecked")
	public T setScaleLabel(ScaleLabel scaleLabel) {
		this.scaleLabel = scaleLabel;
	    return (T) this;
	}

	public abstract Ticks<?> getTicks();

	
}
