/**
 * juniverse
 * Copyright (c) 2023 - Romain Wallon.
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

package fr.univartois.cril.juniverse.listener;

import java.math.BigInteger;
import java.util.Map;

import fr.univartois.cril.juniverse.core.UniverseSolverResult;
import fr.univartois.cril.juniverse.core.problem.IUniverseConstraint;
import fr.univartois.cril.juniverse.core.problem.IUniverseVariable;

/**
 * The IUniverseSearchListener
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public interface IUniverseSearchListener {

    /**
     * Called when a positive decision (variable assignment x=a) is going to be taken
     * 
     * @param x
     *        a variable
     * @param a
     *        a value for the variable x
     */
    default void beforePositiveDecision(IUniverseVariable x, BigInteger a) {
    }

    /**
     * Called when a negative decision (value refutation x !=a) is going to be taken
     * 
     * @param x
     *        a variable
     * @param a
     *        a value for the variable x
     */
    default void beforeNegativeDecision(IUniverseVariable x, BigInteger a) {
    }

    /**
     * Called after the variable assignment x=a has been taken
     * 
     * @param x
     *        a variable
     * @param a
     *        a value for the variable x
     */
    default void afterAssignment(IUniverseVariable x, BigInteger a) {
    }

    /**
     * Called after the variable assignment x=a has been taken, but immediately failed
     * when running propagation
     * 
     * @param x
     *        a variable
     * @param a
     *        a value for the variable x
     */
    default void afterFailedAssignment(IUniverseVariable x, BigInteger a) {
    }

    /**
     * Called after the variable x has been unassigned (due to backtrack)
     * 
     * @param x
     *        a variable
     */
    default void afterUnassignment(IUniverseVariable x) {
    }

    /**
     * Called when the domain of the specified variable has become empty (so-called domain
     * wipeout) when filtering
     * with the specified constraint
     * 
     * @param c
     *        a constraint
     * @param x
     *        a variable involved in the constraint
     */
    default void whenConflict(IUniverseConstraint c, IUniverseVariable x) {
    }

    /**
     * Called when the solver is about to backtrack
     */
    default void whenBacktrack() {
    }

    default void onRestart() {
    }

    default void onClean() {
    }
    
    default void learn(IUniverseConstraint c) {}
    
    default void onSolution(Map<? extends IUniverseVariable,BigInteger> solution) {}
    
    default void start() {}
    default void end(UniverseSolverResult result) {}
}
