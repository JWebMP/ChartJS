package be.ceau.chart.options.scales;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The linear scale is use to chart numerical data. It can be placed on either
 * the x or y axis. The scatter chart type automatically configures a line chart
 * to use one of these scales for the x axis. As the name suggests, linear
 * interpolation is used to determine where a value lies on the axis.
 */
@JsonInclude(Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class LinearScales {

	private List<LinearScale> xAxes;
	
	private List<LinearScale> yAxes;

	public List<LinearScale> getxAxes() {
		return xAxes;
	}

	public void setxAxes(List<LinearScale> xAxes) {
		this.xAxes = xAxes;
	}

	public List<LinearScale> getyAxes() {
		return yAxes;
	}

	public void setyAxes(List<LinearScale> yAxes) {
		this.yAxes = yAxes;
	}

}
