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
 * The IUniverseProblem represents a constraint problem to solve.
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.2.0
 */
public interface IUniverseProblem {

    /**
     * Adds a variable to this problem.
     *
     * @param variable The variable to add.
     */
    void addVariable(IUniverseVariable variable);

    /**
     * Gives the variables in this problem.
     *
     * @return The variables in this problem.
     */
    List<IUniverseVariable> getVariables();

    /**
     * Adds a constraint to this problem.
     *
     * @param constraint The constraint to add.
     */
    void addConstraint(IUniverseConstraint constraint);

    /**
     * Gives the constraints in this problem.
     *
     * @return The constraints in this problem.
     */
    List<IUniverseConstraint> getConstraints();

}
