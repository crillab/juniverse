/**
 * JUniverse, a solver interface.
 * Copyright (c) 2022 - Univ Artois, CNRS & Exakis Nelite.
 * All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
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

package fr.univartois.cril.juniverse.csp;


/**
 * The UniverseTransition
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public class UniverseTransition {
    /**
     * The source state, where the transition begins.
     */
    private String start;

    /**
     * The value (object) labeling the transition.
     */
    private int value;

    /**
     * The target state, where the transition ends.
     */
    private String end;

    /**
     * Creates a new UniverseTransition.
     * @param start
     * @param value
     * @param end
     */
    public UniverseTransition(String start, int value, String end) {
        super();
        this.start = start;
        this.value = value;
        this.end = end;
    }

    
    /**
     * Gives the start of this UniverseTransition.
     *
     * @return This UniverseTransition's start.
     */
    public String getStart() {
        return start;
    }

    
    /**
     * Gives the value of this UniverseTransition.
     *
     * @return This UniverseTransition's value.
     */
    public int getValue() {
        return value;
    }

    
    /**
     * Gives the end of this UniverseTransition.
     *
     * @return This UniverseTransition's end.
     */
    public String getEnd() {
        return end;
    }
    
    
}

