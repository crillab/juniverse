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
 * The ArithmeticOperator enumerates all possible arithmetic operators.
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public enum UniverseArithmeticOperator implements UniverseOperator {

    /**
     * The arithmetic operator for computing the opposite of a value.
     */
    NEG,

    /**
     * The arithmetic operator for computing the absolute value of a value.
     */
    ABS,

    /**
     * The arithmetic operator for computing the addition of several values.
     */
    ADD,

    /**
     * The arithmetic operator for computing the subtraction of two values.
     */
    SUB,

    /**
     * The arithmetic operator for computing the multiplication of several values.
     */
    MULT,

    /**
     * The arithmetic operator for computing the division of two values.
     */
    DIV,

    /**
     * The arithmetic operator for computing the remainder of two values.
     */
    MOD,

    /**
     * The arithmetic operator for computing the square of a value.
     */
    SQR,

    /**
     * The arithmetic operator for computing a value raised to the power of another.
     */
    POW,

    /**
     * The arithmetic operator for computing the minimum of several values.
     */
    MIN,

    /**
     * The arithmetic operator for computing the maximum of several values.
     */
    MAX,

    /**
     * The arithmetic operator for computing the distance between two values.
     */
    DIST;

}
