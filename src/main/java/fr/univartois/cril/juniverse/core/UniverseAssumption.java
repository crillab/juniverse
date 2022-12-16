/**
 * JUniverse, a solver interface.
 * Copyright (c) 2022 - Univ Artois, CNRS & Exakis Nelite.
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
 * If not, see {@link http://www.gnu.org/licenses}.
 */

package fr.univartois.cril.juniverse.core;

/**
 * The UniverseAssumption represents an assumption made when solving constraint problem.
 * 
 * @param <T> The type of the assumed value.
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public class UniverseAssumption<T> {

    /**
     * The variableId of the variable involved in this assumption.
     */
    private int variableId;

    /**
     * Indicates if this assumption represents a equality or not.
     */
    private boolean equal;

    /**
     * The value of the variable in this assumption.
     */
    private T value;

    /**
     * Creates a new UniverseAssumption.
     * 
     * @param variableId The variableId of the variable involved in this assumption.
     * @param equal Indicates if this assumption represents a equality or not.
     * @param value The value of the variable in this assumption.
     */
    public UniverseAssumption(int variableId, boolean equal, T value) {
        super();
        this.variableId = variableId;
        this.equal = equal;
        this.value = value;
    }

    /**
     * Gives the variableId of this UniverseAssumption.
     *
     * @return This UniverseAssumption's variableId.
     */
    public int getVariableId() {
        return variableId;
    }

    /**
     * Gives the equal of this UniverseAssumption.
     *
     * @return This UniverseAssumption's equal.
     */
    public boolean isEqual() {
        return equal;
    }

    /**
     * Gives the value of this UniverseAssumption.
     *
     * @return This UniverseAssumption's value.
     */
    public T getValue() {
        return value;
    }

}
