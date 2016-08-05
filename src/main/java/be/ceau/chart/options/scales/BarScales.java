package be.ceau.chart.options.scales;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class BarScales extends CategoryScale {

	private List<BarScale> xAxes;
	
	private List<BarScale> yAxes;

	public List<BarScale> getxAxes() {
		return xAxes;
	}

	/**
	 * The bar chart officially supports only 1 x-axis but uses an array to keep
	 * the API consistent. Use a scatter chart if you need multiple x axes.
	 */
	public void setxAxes(List<BarScale> xAxes) {
		this.xAxes = xAxes;
	}

	public List<BarScale> getyAxes() {
		return yAxes;
	}

	public void setyAxes(List<BarScale> yAxes) {
		this.yAxes = yAxes;
	}

}
