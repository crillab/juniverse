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
 * The UniverseSolverResult represents the result returned by the solver at the end of its
 * execution.
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.2.0
 */
public enum UniverseSolverResult {

    /**
     * The result returned by the solver when it has proven the problem to be
     * inconsistent.
     */
    UNSATISFIABLE,

    /**
     * The result returned by the solver when it has found a solution.
     */
    SATISFIABLE,

    /**
     * The result returned by the solver when it has found an optimal solution.
     */
    OPTIMUM_FOUND,

    /**
     * The result returned by the solver when it has not been able to decide the
     * consistency of the problem.
     */
    UNKNOWN,

    /**
     * The result returned by the solver when the input problem contains unsupported
     * features.
     */
    UNSUPPORTED

}
