package com.jwebmp.plugins.graphing.chartjs.data;

import com.fasterxml.jackson.annotation.*;

@SuppressWarnings({"unchecked", "unused"})
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public abstract class DataPoint<T extends DataPoint<T>>
{

}
