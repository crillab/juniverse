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
 * The BinaryIntensionConstraint is an {@link IIntensionConstraint} that applies an
 * operator on two intension constraints.
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public class BinaryIntensionConstraint extends UniverseOperatorIntensionConstraint {

    /**
     * The left intension constraint on which an operator is applied.
     */
    private IIntensionConstraint left;

    /**
     * The right intension constraint on which an operator is applied.
     */
    private IIntensionConstraint right;

    /**
     * Creates a new BinaryIntensionConstraint.
     *
     * @param operator The operator applied by the constraint.
     * @param left The left intension constraint on which the operator is applied.
     * @param right The right intension constraint on which the operator is applied.
     */
    public BinaryIntensionConstraint(UniverseOperator operator, IIntensionConstraint left,
            IIntensionConstraint right) {
        super(operator);
        this.left = left;
        this.right = right;
    }

    @Override
    public void accept(IIntensionConstraintVisitor visitor) {
        left.accept(visitor);
        right.accept(visitor);
        visitor.visit(this);
    }


}
