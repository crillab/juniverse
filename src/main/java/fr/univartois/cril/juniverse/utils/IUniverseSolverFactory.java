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

package fr.univartois.cril.juniverse.utils;

import fr.univartois.cril.juniverse.csp.IUniverseCSPSolver;
import fr.univartois.cril.juniverse.pb.IUniversePseudoBooleanSolver;
import fr.univartois.cril.juniverse.sat.IUniverseSatSolver;

/**
 * The IUniverseSolverFactory defines an abstract factory for instantiating solvers
 * implementing different interfaces.
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.2.0
 */
public interface IUniverseSolverFactory {

    /**
     * Creates a SAT solver implementing JUniverse's interface.
     *
     * @return The created solver.
     */
    IUniverseSatSolver createSatSolver();

    /**
     * Creates a pseudo-Boolean solver implementing JUniverse's interface.
     *
     * @return The created solver.
     */
    IUniversePseudoBooleanSolver createPseudoBooleanSolver();

    /**
     * Creates a CSP solver implementing JUniverse's interface.
     *
     * @return The created solver.
     */
    IUniverseCSPSolver createCspSolver();

}
