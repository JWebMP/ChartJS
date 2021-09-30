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
package com.jwebmp.plugins.graphing.chartjs;

import com.jwebmp.core.htmlbuilder.javascript.*;

public abstract class Chart<J extends Chart<J>> extends JavaScriptPart<J>
{
	/**
	 * @return type of this {@link Chart} implementation for proper drawing in
	 * JavaScript.
	 */
	public abstract String getType();
	
	/**
	 * <p>
	 * Convert {@code this} instance to Json for use with Chart.js library.
	 * </p>
	 *
	 * @return json representation of {@code this} {@link Chart}
	 */
	public abstract String toJson();
	
	/**
	 * <p>
	 * Optional check to determine whether the current state of this
	 * {@link Chart} implementation instance will generate a drawable JSON
	 * string.
	 * </p>
	 * <p>
	 * Implementations provide a best-effort evaluation, and can not guarantee
	 * that the serialized chart will be rendered correctly.
	 * </p>
	 *
	 * @return true if {@code this} {@link Chart} is drawable in its current
	 * state
	 */
	public abstract boolean isDrawable();
	
}
