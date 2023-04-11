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

package fr.univartois.cril.juniverse.core;

/**
 * The UniverseAssumption represents an assumption made when solving constraint problems.
 *
 * @param <T> The type of the assumed value.
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.2.0
 */
public final class UniverseAssumption<T> {

    /**
     * The identifier of the variable involved in this assumption.
     */
    private String variableId;

    /**
     * Whether this assumption represents an equality or not.
     */
    private boolean equal;

    /**
     * The value of the variable in this assumption.
     */
    private T value;

    /**
     * Creates a new UniverseAssumption.
     *
     * @param variableId The identifier of the variable involved in this assumption.
     * @param equal Whether this assumption represents an equality or not.
     * @param value The value of the variable in this assumption.
     */
    public UniverseAssumption(String variableId, boolean equal, T value) {
        this.variableId = variableId;
        this.equal = equal;
        this.value = value;
    }

    /**
     * Gives the identifier of the variable involved in this assumption.
     *
     * @return The identifier of the variable involved in this assumption.
     */
    public String getVariableId() {
        return variableId;
    }

    /**
     * Checks whether this assumption represents an equality or not.
     *
     * @return Whether this assumption represents an equality or not.
     */
    public boolean isEqual() {
        return equal;
    }

    /**
     * Gives the value of the variable in this assumption.
     *
     * @return The value of the variable in this assumption.
     */
    public T getValue() {
        return value;
    }

}
