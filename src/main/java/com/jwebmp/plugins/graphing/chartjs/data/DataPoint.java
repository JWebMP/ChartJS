package com.jwebmp.plugins.graphing.chartjs.data;

import com.fasterxml.jackson.annotation.*;

import java.io.Serial;
import java.io.Serializable;

@SuppressWarnings({"unchecked", "unused"})
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public abstract class DataPoint<T extends DataPoint<T>> implements Serializable
{
    @Serial
    private static final long serialVersionUID = 1L;

}
