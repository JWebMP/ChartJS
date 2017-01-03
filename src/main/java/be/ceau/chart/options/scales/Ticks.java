/*
	Copyright 2016 Marceau Dewilde <m@ceau.be>

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
package be.ceau.chart.options.scales;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import be.ceau.chart.color.Color;
import be.ceau.chart.enums.FontStyle;
import be.ceau.chart.javascript.JavaScriptFunction;

/**
 * The grid line configuration is nested under the scale configuration in the
 * ticks key. It defines options for the tick marks that are generated by the
 * axis.
 */
@JsonInclude(Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class Ticks {

	/**
	 * @see #setAutoSkip(Boolean)
	 */
	private Boolean autoSkip;

	/**
	 * @see #setCallback(JavaScriptFunction)
	 */
	private JavaScriptFunction callback;

	/**
	 * @see #setDisplay(Boolean)
	 */
	private Boolean display;

	/**
	 * @see #setFontColor(Color)
	 */
	private Color fontColor;

	/**
	 * @see #setFontFamily(String)
	 */
	private String fontFamily;

	/**
	 * @see #setFontSize(BigDecimal)
	 */
	private BigDecimal fontSize;

	/**
	 * @see #setFontStyle(FontStyle)
	 */
	private FontStyle fontStyle;

	/**
	 * @see #setLabelOffset(BigDecimal)
	 */
	private BigDecimal labelOffset;

	/**
	 * @see #setMaxRotation(BigDecimal)
	 */
	private BigDecimal maxRotation;

	/**
	 * @see #setMinRotation(BigDecimal)
	 */
	private BigDecimal minRotation;

	/**
	 * @see #setMirror(Boolean)
	 */
	private Boolean mirror;

	/**
	 * @see #setPadding(BigDecimal)
	 */
	private BigDecimal padding;

	/**
	 * @see #setReverse(Boolean)
	 */
	private Boolean reverse;

	/**
	 * @see #setAutoSkip(Boolean)
	 */
	public Boolean getAutoSkip() {
	    return this.autoSkip;
	}

	/**
	 * <p>
	 * If true, automatically calculates how many labels that can be shown and hides labels accordingly. Turn it off to show all labels no matter what
	 * </p>
	 * 
	 * <p>
	 * Default {@code true}
	 * </p>
	 */
	public void setAutoSkip(Boolean autoSkip) {
	    this.autoSkip = autoSkip;
	}

	/**
	 * @see #setCallback(JavaScriptFunction)
	 */
	public JavaScriptFunction getCallback() {
	    return this.callback;
	}

	/**
	 * <p>
	 * Returns the string representation of the tick value as it should be displayed on the chart. See callback section below.
	 * </p>
	 * 
	 * <p>
	 * Default {@code function(value) { return helpers.isArray(value) ? value : '' + value; }}
	 * </p>
	 */
	public void setCallback(JavaScriptFunction callback) {
	    this.callback = callback;
	}

	/**
	 * @see #setDisplay(Boolean)
	 */
	public Boolean getDisplay() {
	    return this.display;
	}

	/**
	 * <p>
	 * If true, show the ticks.
	 * </p>
	 * 
	 * <p>
	 * Default {@code true}
	 * </p>
	 */
	public void setDisplay(Boolean display) {
	    this.display = display;
	}

	/**
	 * @see #setFontColor(Color)
	 */
	public Color getFontColor() {
	    return this.fontColor;
	}

	/**
	 * <p>
	 * Font color for the tick labels.
	 * </p>
	 * 
	 * <p>
	 * Default {@code "#666"}
	 * </p>
	 */
	public void setFontColor(Color fontColor) {
	    this.fontColor = fontColor;
	}

	/**
	 * @see #setFontFamily(String)
	 */
	public String getFontFamily() {
	    return this.fontFamily;
	}

	/**
	 * <p>
	 * Font family for the tick labels, follows CSS font-family options.
	 * </p>
	 * 
	 * <p>
	 * Default {@code "'Helvetica Neue', 'Helvetica', 'Arial', sans-serif"}
	 * </p>
	 */
	public void setFontFamily(String fontFamily) {
	    this.fontFamily = fontFamily;
	}

	/**
	 * @see #setFontSize(BigDecimal)
	 */
	public BigDecimal getFontSize() {
	    return this.fontSize;
	}

	/**
	 * <p>
	 * Font size for the tick labels.
	 * </p>
	 * 
	 * <p>
	 * Default {@code 12}
	 * </p>
	 */
	public void setFontSize(BigDecimal fontSize) {
	    this.fontSize = fontSize;
	}

	/**
	 * @see #setFontStyle(FontStyle)
	 */
	public FontStyle getFontStyle() {
	    return this.fontStyle;
	}

	/**
	 * <p>
	 * Font style for the tick labels, follows CSS font-style options (i.e. normal, italic, oblique, initial, inherit).
	 * </p>
	 * 
	 * <p>
	 * Default {@code "normal"}
	 * </p>
	 */
	public void setFontStyle(FontStyle fontStyle) {
	    this.fontStyle = fontStyle;
	}

	/**
	 * @see #setLabelOffset(BigDecimal)
	 */
	public BigDecimal getLabelOffset() {
	    return this.labelOffset;
	}

	/**
	 * <p>
	 * Distance in pixels to offset the label from the centre point of the tick (in the y direction for the x axis, and the x direction for the y axis). Note: this can cause labels at the edges to be cropped by the edge of the canvas
	 * </p>
	 * 
	 * <p>
	 * Default {@code 0}
	 * </p>
	 */
	public void setLabelOffset(BigDecimal labelOffset) {
	    this.labelOffset = labelOffset;
	}

	/**
	 * @see #setMaxRotation(BigDecimal)
	 */
	public BigDecimal getMaxRotation() {
	    return this.maxRotation;
	}

	/**
	 * <p>
	 * Maximum rotation for tick labels when rotating to condense labels. Note: Rotation doesn't occur until necessary. Note: Only applicable to horizontal scales.
	 * </p>
	 * 
	 * <p>
	 * Default {@code 90}
	 * </p>
	 */
	public void setMaxRotation(BigDecimal maxRotation) {
	    this.maxRotation = maxRotation;
	}

	/**
	 * @see #setMinRotation(BigDecimal)
	 */
	public BigDecimal getMinRotation() {
	    return this.minRotation;
	}

	/**
	 * <p>
	 * Minimum rotation for tick labels. Note: Only applicable to horizontal scales.
	 * </p>
	 * 
	 * <p>
	 * Default {@code 0}
	 * </p>
	 */
	public void setMinRotation(BigDecimal minRotation) {
	    this.minRotation = minRotation;
	}

	/**
	 * @see #setMirror(Boolean)
	 */
	public Boolean getMirror() {
	    return this.mirror;
	}

	/**
	 * <p>
	 * Flips tick labels around axis, displaying the labels inside the chart instead of outside. Note: Only applicable to vertical scales.
	 * </p>
	 * 
	 * <p>
	 * Default {@code false}
	 * </p>
	 */
	public void setMirror(Boolean mirror) {
	    this.mirror = mirror;
	}

	/**
	 * @see #setPadding(BigDecimal)
	 */
	public BigDecimal getPadding() {
	    return this.padding;
	}

	/**
	 * <p>
	 * Padding between the tick label and the axis. Note: Only applicable to horizontal scales.
	 * </p>
	 * 
	 * <p>
	 * Default {@code 10}
	 * </p>
	 */
	public void setPadding(BigDecimal padding) {
	    this.padding = padding;
	}

	/**
	 * @see #setReverse(Boolean)
	 */
	public Boolean getReverse() {
	    return this.reverse;
	}

	/**
	 * <p>
	 * Reverses order of tick labels.
	 * </p>
	 * 
	 * <p>
	 * Default {@code false}
	 * </p>
	 */
	public void setReverse(Boolean reverse) {
	    this.reverse = reverse;
	}

}