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

package fr.univartois.cril.juniverse.optim;

import java.math.BigInteger;

import fr.univartois.cril.juniverse.core.IUniverseSolver;

/**
 * The IUniversePseudoBooleanSolver interface defines the contract for optimization
 * solvers.
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.2.0
 */
public interface IUniverseOptimizationSolver extends IUniverseSolver {

    /**
     * Checks whether the underlying problem is a minimization problem.
     *
     * @return Whether the underlying problem is a minimization problem.
     */
    boolean isMinimization();

    /**
     * Sets the bounds for the optimization problem to solve.
     *
     * @param lb The lower bound to set.
     * @param ub The upper bound to set.
     */
    void setBounds(BigInteger lb, BigInteger ub);

    /**
     * Sets the lower bound for the optimization problem to solve.
     *
     * @param lb The lower bound to set.
     */
    void setLowerBound(BigInteger lb);

    /**
     * Gives the current (best) lower bound of the underlying optimization problem.
     *
     * @return The current lower bound.
     */
    BigInteger getLowerBound();

    /**
     * Sets the upper bound for the optimization problem to solve.
     *
     * @param ub The upper bound to set.
     */
    void setUpperBound(BigInteger ub);

    /**
     * Gives the current (best) upper bound of the underlying optimization problem.
     *
     * @return The current upper bound.
     */
    BigInteger getUpperBound();

    /**
     * Gives the current (best) bound that have been found by this solver.
     * It is the current lower or upper bound, depending on whether the problem is a
     * minimization or maximization problem.
     *
     * @return The current best bound.
     *
     * @see #isMinimization()
     */
    BigInteger getCurrentBound();

}
