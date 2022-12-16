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

package fr.univartois.cril.juniverse.csp.operator;

/**
 * The RelationalOperator enumerates all possible relational operators.
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public enum UniverseRelationalOperator implements UniverseOperator {

    /**
     * The lesser-than ({@code <}) relational operator.
     */
    LT("GT"),

    /**
     * The lesser-than-or-equal ({@code <=}) relational operator.
     */
    LE("GE"),

    /**
     * The equal ({@code ==}) relational operator.
     */
    EQ("EQ"),

    /**
     * The not-equal ({@code !=}) relational operator.
     */
    NEQ("NEQ"),

    /**
     * The greater-than-or-equal ({@code >=}) relational operator.
     */
    GE("LE"),

    /**
     * The greater-than ({@code >}) relational operator.
     */
    GT("LT");

    /**
     * The identifier of the operator that is the reverse of this one.
     */
    private final String reverse;

    /**
     * Creates a new RelationalOperator.
     *
     * @param reverse The identifier of the reverse operator.
     */
    private UniverseRelationalOperator(String reverse) {
        this.reverse = reverse;
    }

    /**
     * Gives the operator that is the reverse of this one.
     *
     * @return The reverse operator.
     */
    public UniverseRelationalOperator reverse() {
        return valueOf(reverse);
    }

}
