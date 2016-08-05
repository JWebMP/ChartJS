package be.ceau.chart.options.scales;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The time scale is used to display times and dates. It can only be placed on
 * the X axis. When building its ticks, it will automatically calculate the most
 * comfortable unit base on the size of the scale.
 */
@JsonInclude(Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class TimeScales {

	private List<TimeScale> xAxes;
	
	private List<TimeScale> yAxes;

	public List<TimeScale> getxAxes() {
		return xAxes;
	}

	public void setxAxes(List<TimeScale> xAxes) {
		this.xAxes = xAxes;
	}

	public List<TimeScale> getyAxes() {
		return yAxes;
	}

	public void setyAxes(List<TimeScale> yAxes) {
		this.yAxes = yAxes;
	}

}
