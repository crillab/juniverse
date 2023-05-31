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
 * The UniverseAssumption represents a solving assumption, i.e., an hypothesis made about
 * the assignment of a variable.
 *
 * @param <T> The type of the value used in the hypothesis.
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.2.0
 */
public final class UniverseAssumption<T> {

    /**
     * The name of the variable involved in this assumption.
     */
    private String variableId;

    /**
     * Whether this assumption represents an equality.
     */
    private boolean equal;

    /**
     * The assumed value.
     */
    private T value;

    /**
     * Creates a new UniverseAssumption.
     *
     * @param variableId The name of the variable involved in the assumption.
     * @param equal Whether this assumption represents an equality.
     * @param value The value of the variable in this assumption.
     */
    public UniverseAssumption(String variableId, boolean equal, T value) {
        this.variableId = variableId;
        this.equal = equal;
        this.value = value;
    }

    /**
     * Gives the name of the variable involved in this assumption.
     *
     * @return The name of the variable involved in this assumption.
     */
    public String getVariableId() {
        return variableId;
    }

    /**
     * Checks whether this assumption represents an equality.
     *
     * @return Whether this assumption represents an equality.
     */
    public boolean isEqual() {
        return equal;
    }

    /**
     * Gives the assumed value.
     *
     * @return The assumed value.
     */
    public T getValue() {
        return value;
    }

}
