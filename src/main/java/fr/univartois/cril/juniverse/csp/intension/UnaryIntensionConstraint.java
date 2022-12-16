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
 * The UnaryIntensionConstraint is an {@link IIntensionConstraint} that applies an
 * operator on a single intension constraint.
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public class UnaryIntensionConstraint extends UniverseOperatorIntensionConstraint {

    /**
     * The intension constraint on which an operator is applied.
     */
    private IIntensionConstraint child;

    /**
     * Creates a new UnaryIntensionConstraint.
     *
     * @param operator The operator applied by the constraint.
     * @param child The intension constraint on which the operator is applied.
     */
    public UnaryIntensionConstraint(UniverseOperator operator, IIntensionConstraint child) {
        super(operator);
        this.child = child;
    }

    @Override
    public void accept(IIntensionConstraintVisitor visitor) {
        child.accept(visitor);
        visitor.visit(this);
        
    }


}
