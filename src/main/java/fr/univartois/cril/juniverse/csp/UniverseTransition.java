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

package fr.univartois.cril.juniverse.csp;

/**
 * The UniverseTransition represents a transition in a constraint representing an
 * automaton.
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.2.0
 */
public final class UniverseTransition {

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
     *
     * @param start The source state, where the transition begins.
     * @param value The value (object) labeling the transition.
     * @param end The target state, where the transition ends.
     */
    public UniverseTransition(String start, int value, String end) {
        this.start = start;
        this.value = value;
        this.end = end;
    }

    /**
     * Gives the source state, where the transition begins.
     *
     * @return The source state.
     */
    public String getStart() {
        return start;
    }

    /**
     * Gives the value (object) labeling the transition.
     *
     * @return The value labeling the transition.
     */
    public int getValue() {
        return value;
    }

    /**
     * Gives the target state, where the transition ends.
     *
     * @return The target state.
     */
    public String getEnd() {
        return end;
    }

}
