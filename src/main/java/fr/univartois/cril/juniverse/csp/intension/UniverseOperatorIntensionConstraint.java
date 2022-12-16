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

package fr.univartois.cril.juniverse.csp.intension;

import fr.univartois.cril.juniverse.csp.operator.UniverseOperator;

/**
 * The OperatorIntensionConstraint is the parent class of all the implementations of
 * {@link IIntensionConstraint} that apply an operator on some other intension
 * constraint(s).
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public abstract class UniverseOperatorIntensionConstraint implements IIntensionConstraint {

    /**
     * The operator applied by this constraint.
     */
    protected UniverseOperator operator;

    /**
     * Creates a new OperatorIntensionConstraint.
     *
     * @param operator The operator applied by the constraint.
     */
    protected UniverseOperatorIntensionConstraint(UniverseOperator operator) {
        this.operator = operator;
    }

    /**
     * Gives the operator applied by this constraint.
     *
     * @return The operator applied by this constraint.
     */
    public UniverseOperator getOperator() {
        return operator;
    }

}
