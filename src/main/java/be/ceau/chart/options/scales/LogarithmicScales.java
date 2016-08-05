package be.ceau.chart.options.scales;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The logarithmic scale is use to chart numerical data. It can be placed on
 * either the x or y axis. As the name suggests, logarithmic interpolation is
 * used to determine where a value lies on the axis.
 */
@JsonInclude(Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class LogarithmicScales {

	private List<LogarithmicScale> xAxes;
	
	private List<LogarithmicScale> yAxes;

	public List<LogarithmicScale> getxAxes() {
		return xAxes;
	}

	public void setxAxes(List<LogarithmicScale> xAxes) {
		this.xAxes = xAxes;
	}

	public List<LogarithmicScale> getyAxes() {
		return yAxes;
	}

	public void setyAxes(List<LogarithmicScale> yAxes) {
		this.yAxes = yAxes;
	}

}
