package com.jwebmp.plugins.graphing.chartjs.options;

import com.fasterxml.jackson.annotation.*;
import com.jwebmp.plugins.graphing.chartjs.enums.*;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class Font
{
	/**
	 * default "'Helvetica Neue', 'Helvetica', 'Arial', sans-serif"	Default font family for all text, follows CSS font-family options
	 */
	private String family;
	/**
	 * 	Default font size (in px) for text. Does not apply to radialLinear scale point labels.
	 */
	private Integer size;
	/**
	 *	Default font style. Does not apply to tooltip title or footer. Does not apply to chart title. Follows CSS font-style options (i.e. normal, italic, oblique, initial, inherit).
	 */
	private FontStyle style;
	/**
	 * Default font weight (boldness). (see MDN
	 * ).
	 */
	private String weight;
	/**
	 * Height of an individual line of text
	 */
	private Double lineHeight;
	
	/**
	 * default "'Helvetica Neue', 'Helvetica', 'Arial', sans-serif"	Default font family for all text, follows CSS font-family options
	 * @return
	 */
	public String getFamily()
	{
		return family;
	}
	
	/**
	 * default "'Helvetica Neue', 'Helvetica', 'Arial', sans-serif"	Default font family for all text, follows CSS font-family options
	 * @param family
	 * @return
	 */
	public Font setFamily(String family)
	{
		this.family = family;
		return this;
	}
	
	/**
	 * 	Default font size (in px) for text. Does not apply to radialLinear scale point labels.
	 * @return
	 */
	public Integer getSize()
	{
		return size;
	}
	
	/**
	 * 	Default font size (in px) for text. Does not apply to radialLinear scale point labels.
	 * @param size
	 * @return
	 */
	public Font setSize(Integer size)
	{
		this.size = size;
		return this;
	}
	
	/**
	 * 	Default font style. Does not apply to tooltip title or footer. Does not apply to chart title. Follows CSS font-style options (i.e. normal, italic, oblique, initial, inherit).
	 * @return
	 */
	public FontStyle getStyle()
	{
		return style;
	}
	
	/**
	 * 	Default font style. Does not apply to tooltip title or footer. Does not apply to chart title. Follows CSS font-style options (i.e. normal, italic, oblique, initial, inherit).
	 * @param style
	 * @return
	 */
	public Font setStyle(FontStyle style)
	{
		this.style = style;
		return this;
	}
	
	/**
	 * Default font weight (boldness). (see MDN
	 * ).
	 * @return
	 */
	public String getWeight()
	{
		return weight;
	}
	
	/**
	 * Default font weight (boldness). (see MDN
	 * ).
	 * @param weight
	 * @return
	 */
	public Font setWeight(String weight)
	{
		this.weight = weight;
		return this;
	}
	
	/**
	 * Height of an individual line of text
	 * @return
	 */
	public Double getLineHeight()
	{
		return lineHeight;
	}
	
	/**
	 * Height of an individual line of text
	 * @param lineHeight
	 * @return
	 */
	public Font setLineHeight(Double lineHeight)
	{
		this.lineHeight = lineHeight;
		return this;
	}
}
