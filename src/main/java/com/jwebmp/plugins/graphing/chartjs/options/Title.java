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

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.jwebmp.plugins.graphing.chartjs.color.Color;
import com.jwebmp.plugins.graphing.chartjs.enums.FontStyle;
import com.jwebmp.plugins.graphing.chartjs.enums.TitlePosition;

@JsonInclude(Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class Title {

	/**
	 * @see #setDisplay(Boolean)
	 */
	private Boolean display;

	/**
	 * @see #setPosition(TitlePosition)
	 */
	private TitlePosition position;

	/**
	 * @see #setFullWidth(Boolean)
	 */
	private Boolean fullWidth;
	
	private Font font;

	/**
	 * @see #setPadding(Integer)
	 */
	private Integer padding;

	/**
	 * @see #setText(String)
	 */
	private String text;

	/**
	 * @see #setDisplay(Boolean)
	 */
	public Boolean getDisplay() {
		return this.display;
	}

	/**
	 * <p>
	 * Display the title block
	 * </p>
	 * 
	 * <p>
	 * Default {@code false}
	 * </p>
	 */
	public Title setDisplay(Boolean display) {
		this.display = display;
	    return this;
	}

	/**
	 * @see #setPosition(TitlePosition)
	 */
	public TitlePosition getPosition() {
		return this.position;
	}

	/**
	 * <p>
	 * Position of the title. Only 'top' or 'bottom' are currently allowed
	 * </p>
	 * 
	 * <p>
	 * Default {@code 'top'}
	 * </p>
	 */
	public Title setPosition(TitlePosition position) {
		this.position = position;
	    return this;
	}

	/**
	 * @see #setFullWidth(Boolean)
	 */
	public Boolean getFullWidth() {
		return this.fullWidth;
	}

	/**
	 * <p>
	 * Marks that this box should take the full width of the canvas (pushing
	 * down other boxes)
	 * </p>
	 * 
	 * <p>
	 * Default {@code true}
	 * </p>
	 */
	public Title setFullWidth(Boolean fullWidth) {
		this.fullWidth = fullWidth;
	    return this;
	}

	/**
	 * @see #setPadding(Integer)
	 */
	public Integer getPadding() {
		return this.padding;
	}

	/**
	 * <p>
	 * Number of pixels to add above and below the title text
	 * </p>
	 * 
	 * <p>
	 * Default {@code 10}
	 * </p>
	 */
	public Title setPadding(Integer padding) {
		this.padding = padding;
	    return this;
	}

	/**
	 * @see #setText(String)
	 */
	public String getText() {
		return this.text;
	}

	/**
	 * <p>
	 * Title text
	 * </p>
	 * 
	 * <p>
	 * Default {@code ""}
	 * </p>
	 */
	public Title setText(String text) {
		this.text = text;
	    return this;
	}
	
	public Font getFont()
	{
		return font;
	}
	
	public Title setFont(Font font)
	{
		this.font = font;
		return this;
	}
}
