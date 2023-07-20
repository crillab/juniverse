/**
 * JUniverse, a universal solver interface.
 * Copyright (c) 2022-2023 - Univ Artois, CNRS & Exakis Nelite.
 * All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library.
 * If not, see <http://www.gnu.org/licenses/>.
 */

package fr.univartois.cril.juniverse.config;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * The UniverseConfiguration provides all information for configuring a particular element
 * of an {@link IUniverseConfigurableSolver}.
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.2.0
 */
public class UniverseConfiguration {

    /**
     * The name of the strategy being configured.
     */
    private final String name;

    /**
     * The map associating each configuration key to its type.
     */
    private final Map<String, Class<?>> parameterTypeMap;

    /**
     * The map associating each configuration key to its value.
     */
    private final Map<String, Object> parameterValueMap;

    /**
     * Creates a new UniverseConfiguration.
     *
     * @param name The name of the strategy being configured.
     */
    public UniverseConfiguration(String name) {
        this.name = name;
        this.parameterTypeMap = new HashMap<>();
        this.parameterValueMap = new HashMap<>();
    }

    /**
     * Gives the name of the strategy being configured.
     *
     * @return The name of the strategy.
     */
    public String getName() {
        return name;
    }

    /**
     * Adds a parameter to this configuration.
     *
     * @param key The key identifying the parameter.
     * @param value The value for the parameter.
     */
    public void addParameter(String key, Object value) {
        parameterTypeMap.put(key, value.getClass());
        parameterValueMap.put(key, value);
    }

    /**
     * Adds a parameter to this configuration.
     *
     * @param <T> The type of the parameter.
     *
     * @param key The key identifying the parameter.
     * @param type The type of the parameter.
     * @param value The value for the parameter.
     */
    public <T> void addParameter(String key, Class<T> type, T value) {
        parameterTypeMap.put(key, type);
        parameterValueMap.put(key, value);
    }

    /**
     * Gives the parameter that are recognized to configure the associated strategy.
     *
     * @return The recognized parameter names.
     */
    public Collection<String> getParameters() {
        return parameterTypeMap.keySet();
    }

    /**
     * Gives the type of the given parameter.
     *
     * @param key The key identifying the parameter.
     *
     * @return The type of the parameter.
     */
    public Class<?> getTypeOf(String key) {
        return parameterTypeMap.get(key);
    }

    /**
     * Gives the value of the given parameter.
     *
     * @param <T> The type of the parameter.
     *
     * @param key The key identifying the parameter.
     *
     * @return The value of the parameter.
     */
    public <T> T get(String key) {
        @SuppressWarnings("unchecked")
        T value = (T) parameterValueMap.get(key);
        return value;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return name;
    }

}
