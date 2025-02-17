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
package com.jwebmp.plugins.graphing.chartjs.data;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.jwebmp.plugins.graphing.chartjs.dataset.Dataset;

@JsonInclude(Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class Data<D extends Data<D, T, O>, T extends Dataset<T, O>, O> implements Serializable
{
    @Serial
    private static final long serialVersionUID = 1L;

    private final List<String> labels = new ArrayList<>();
    private final List<T> datasets = new ArrayList<>();

    /**
     * @return unmodifiable list of all labels, never {@code null}
     */
    public List<String> getLabels()
    {
        return Collections.unmodifiableList(labels);
    }

    /**
     * Sets the backing label list, replacing any labels previously added or set
     *
     * @param labels
     * @return this object to allow method chaining
     */
    @SuppressWarnings("unchecked")
    public D setLabels(Collection<String> labels)
    {
        this.labels.clear();
        if (labels != null)
        {
            this.labels.addAll(labels);
        }
        return (D) this;
    }

    /**
     * Sets the backing label list, replacing any labels previously added or set
     *
     * @param labels
     * @return this object to allow method chaining
     */
    @SuppressWarnings("unchecked")
    public D setLabels(String... labels)
    {
        this.labels.clear();
        if (labels != null)
        {
            this.labels.addAll(Arrays.asList(labels));
        }
        return (D) this;
    }

    /**
     * Removes all labels from the backing list
     *
     * @return this object to allow method chaining
     */
    @SuppressWarnings("unchecked")
    public D clearLabels()
    {
        this.labels.clear();
        return (D) this;
    }

    /**
     * Adds the label to the backing label list
     *
     * @return this object to allow method chaining
     */
    @SuppressWarnings("unchecked")
    public D addLabel(String label)
    {
        this.labels.add(label);
        return (D) this;
    }

    /**
     * Adds the labels to the backing label list
     *
     * @return this object to allow method chaining
     */
    @SuppressWarnings("unchecked")
    public D addLabels(String... label)
    {
        this.labels.addAll(Arrays.asList(label));
        return (D) this;
    }

    /**
     * @return unmodifiable list of all datasets, never
     * {@code null}
     */
    public List<T> getDatasets()
    {
        return Collections.unmodifiableList(datasets);
    }

    /**
     * @return this object to allow method chaining
     */
    @SuppressWarnings("unchecked")
    public D setDatasets(Collection<T> datasets)
    {
        this.datasets.clear();
        if (datasets != null)
        {
            this.datasets.addAll(datasets);
        }
        return (D) this;
    }

    /**
     * @return this object to allow method chaining
     */
    @SuppressWarnings("unchecked")
    public D addDataset(T dataset)
    {
        this.datasets.add(dataset);
        return (D) this;
    }

    /**
     * x or y
     */
    private Character indexAxis;

    /**
     * x or y
     *
     * @return
     */
    public Character getIndexAxis()
    {
        return indexAxis;
    }

    /**
     * x or y
     *
     * @param indexAxis
     * @return
     */
    public Data<D, T, O> setIndexAxis(char indexAxis)
    {
        this.indexAxis = indexAxis;
        return this;
    }
}
