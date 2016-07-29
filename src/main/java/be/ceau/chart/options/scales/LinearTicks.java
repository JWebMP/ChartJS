package be.ceau.chart.options.scales;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class LinearTicks extends Ticks {

	/**
	 * @see #setBeginAtZero(Boolean)
	 */
	private Boolean beginAtZero;

	/**
	 * @see #setMin(BigDecimal)
	 */
	private BigDecimal min;

	/**
	 * @see #setMax(BigDecimal)
	 */
	private BigDecimal max;

	/**
	 * @see #setMaxTicksLimit(BigDecimal)
	 */
	private BigDecimal maxTicksLimit;

	/**
	 * @see #setFixedStepSize(BigDecimal)
	 */
	private BigDecimal fixedStepSize;

	/**
	 * @see #setStepSize(BigDecimal)
	 */
	private BigDecimal stepSize;

	/**
	 * @see #setSuggestedMax(BigDecimal)
	 */
	private BigDecimal suggestedMax;

	/**
	 * @see #setSuggestedMin(BigDecimal)
	 */
	private BigDecimal suggestedMin;

	/**
	 * @see #setBeginAtZero(Boolean)
	 */
	public Boolean getBeginAtZero() {
		return this.beginAtZero;
	}

	/**
	 * <p>
	 * if true, scale will inclulde 0 if it is not already included.
	 * </p>
	 * 
	 * <p>
	 * Default {@code -}
	 * </p>
	 */
	public void setBeginAtZero(Boolean beginAtZero) {
		this.beginAtZero = beginAtZero;
	}

	/**
	 * @see #setMin(BigDecimal)
	 */
	public BigDecimal getMin() {
		return this.min;
	}

	/**
	 * <p>
	 * User defined minimum number for the scale, overrides minimum value from
	 * data.
	 * </p>
	 * 
	 * <p>
	 * Default {@code -}
	 * </p>
	 */
	public void setMin(BigDecimal min) {
		this.min = min;
	}

	/**
	 * @see #setMax(BigDecimal)
	 */
	public BigDecimal getMax() {
		return this.max;
	}

	/**
	 * <p>
	 * User defined maximum number for the scale, overrides maximum value from
	 * data.
	 * </p>
	 * 
	 * <p>
	 * Default {@code -}
	 * </p>
	 */
	public void setMax(BigDecimal max) {
		this.max = max;
	}

	/**
	 * @see #setMaxTicksLimit(BigDecimal)
	 */
	public BigDecimal getMaxTicksLimit() {
		return this.maxTicksLimit;
	}

	/**
	 * <p>
	 * Maximum number of ticks and gridlines to show. If not defined, it will
	 * limit to 11 ticks but will show all gridlines.
	 * </p>
	 * 
	 * <p>
	 * Default {@code 11}
	 * </p>
	 */
	public void setMaxTicksLimit(BigDecimal maxTicksLimit) {
		this.maxTicksLimit = maxTicksLimit;
	}

	/**
	 * @see #setFixedStepSize(BigDecimal)
	 */
	public BigDecimal getFixedStepSize() {
		return this.fixedStepSize;
	}

	/**
	 * <p>
	 * User defined fixed step size for the scale. If set, the scale ticks will
	 * be enumerated by multiple of stepSize, having one tick per increment. If
	 * not set, the ticks are labeled automatically using the nice numbers
	 * algorithm.
	 * </p>
	 * 
	 * <p>
	 * Default {@code -}
	 * </p>
	 */
	public void setFixedStepSize(BigDecimal fixedStepSize) {
		this.fixedStepSize = fixedStepSize;
	}

	/**
	 * @see #setStepSize(BigDecimal)
	 */
	public BigDecimal getStepSize() {
		return this.stepSize;
	}

	/**
	 * <p>
	 * if defined, it can be used along with the min and the max to give a
	 * custom number of steps. See the example below.
	 * </p>
	 * 
	 * <p>
	 * Default {@code -}
	 * </p>
	 */
	public void setStepSize(BigDecimal stepSize) {
		this.stepSize = stepSize;
	}

	/**
	 * @see #setSuggestedMax(BigDecimal)
	 */
	public BigDecimal getSuggestedMax() {
		return this.suggestedMax;
	}

	/**
	 * <p>
	 * User defined maximum number for the scale, overrides maximum value except
	 * for if it is lower than the maximum value.
	 * </p>
	 * 
	 * <p>
	 * Default {@code -}
	 * </p>
	 */
	public void setSuggestedMax(BigDecimal suggestedMax) {
		this.suggestedMax = suggestedMax;
	}

	/**
	 * @see #setSuggestedMin(BigDecimal)
	 */
	public BigDecimal getSuggestedMin() {
		return this.suggestedMin;
	}

	/**
	 * <p>
	 * User defined minimum number for the scale, overrides minimum value except
	 * for if it is higher than the minimum value.
	 * </p>
	 * 
	 * <p>
	 * Default {@code -}
	 * </p>
	 */
	public void setSuggestedMin(BigDecimal suggestedMin) {
		this.suggestedMin = suggestedMin;
	}

}