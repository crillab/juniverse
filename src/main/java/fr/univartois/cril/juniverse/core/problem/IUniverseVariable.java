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

package fr.univartois.cril.juniverse.core.problem;

import java.util.List;

/**
 * The IUniverseVariable represents a variable in a constraint problem.
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.2.0
 */
public interface IUniverseVariable {

    /**
     * Gives the name of this variable.
     *
     * @return The name of this variable.
     */
    String getName();

    /**
     * Gives the (internal) identifier of this variable.
     *
     * @return The (internal) identifier of this variable.
     */
    int getId();

    /**
     * Gives the domain of this variable.
     *
     * @return The domain of this variable.
     */
    IUniverseDomain getDomain();

    /**
     * Gives the constraints containing this variable.
     *
     * @return The constraints of this variable.
     */
    List<IUniverseConstraint> getConstraints();

}
