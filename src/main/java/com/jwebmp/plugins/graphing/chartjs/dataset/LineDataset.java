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
package com.jwebmp.plugins.graphing.chartjs.dataset;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect.*;
import com.fasterxml.jackson.annotation.JsonInclude.*;
import com.jwebmp.plugins.graphing.chartjs.datapoint.*;

import java.util.*;

@JsonInclude(Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class LineDataset extends BaseLineDataset<LineDataset, YDataPoint<?>>
{
	public LineDataset()
	{
		setType("line");
	}
	
	public LineDataset setData(YDataPoint<?>... data)
	{
		clearData();
		if (data != null)
		{
			for (int i = 0; i < data.length; i++)
			{
				this.data.add(data[i]);
			}
		}
		return this;
	}
	
	public LineDataset setData(Double... data)
	{
		clearData();
		if (data != null)
		{
			for (int i = 0; i < data.length; i++)
			{
				this.data.add(new YDataPoint<>(data[i]));
			}
		}
		return this;
	}
	
	
	/**
	 * Add the data point to this {@code Dataset}
	 *
	 * @see #setData(Collection)
	 */
	public LineDataset addData(YDataPoint<?> data)
	{
		this.data.add(data);
		return this;
	}
}
