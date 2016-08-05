package be.ceau.chart.options.scales;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The category scale will be familiar to those who have used v1.0. Labels are
 * drawn from one of the label arrays included in the chart data. If only
 * data.labels is defined, this will be used. If data.xLabels is defined and the
 * axis is horizontal, this will be used. Similarly, if data.yLabels is defined
 * and the axis is vertical, this property will be used. Using both xLabels and
 * yLabels together can create a chart that uses strings for both the X and Y
 * axes.
 */
@JsonInclude(Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class CategoryScales {
	
	private List<CategoryScale> xAxes;
	
	private List<CategoryScale> yAxes;

	public List<CategoryScale> getxAxes() {
		return xAxes;
	}

	public void setxAxes(List<CategoryScale> xAxes) {
		this.xAxes = xAxes;
	}

	public List<CategoryScale> getyAxes() {
		return yAxes;
	}

	public void setyAxes(List<CategoryScale> yAxes) {
		this.yAxes = yAxes;
	}

}
