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
package com.jwebmp.plugins.graphing.chartjs.datapoint;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class ScatterDataPoint implements Serializable
{
    @Serial
    private static final long serialVersionUID = 1L;

    private BigDecimal x;

    private BigDecimal y;

    public ScatterDataPoint()
    {
    }

    public ScatterDataPoint(int x, int y)
    {
        setX(x);
        setY(y);
    }

    public ScatterDataPoint(double x, double y)
    {
        setX(x);
        setY(y);
    }

    public ScatterDataPoint(BigDecimal x, BigDecimal y)
    {
        setX(x);
        setY(y);
    }

    public BigDecimal getX()
    {
        return x;
    }

    public ScatterDataPoint setX(int x)
    {
        this.x = new BigDecimal(x);
        return this;
    }

    public ScatterDataPoint setX(double x)
    {
        this.x = new BigDecimal(String.valueOf(x));
        return this;
    }

    public ScatterDataPoint setX(BigDecimal x)
    {
        this.x = x;
        return this;
    }

    public BigDecimal getY()
    {
        return y;
    }

    public ScatterDataPoint setY(int y)
    {
        this.y = new BigDecimal(y);
        return this;
    }

    public ScatterDataPoint setY(double y)
    {
        this.y = new BigDecimal(String.valueOf(y));
        return this;
    }

    public ScatterDataPoint setY(BigDecimal y)
    {
        this.y = y;
        return this;
    }

}
