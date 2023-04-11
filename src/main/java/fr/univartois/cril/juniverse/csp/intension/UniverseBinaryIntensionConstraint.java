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

package fr.univartois.cril.juniverse.csp.intension;

import fr.univartois.cril.juniverse.csp.operator.UniverseOperator;

/**
 * The UniverseBinaryIntensionConstraint is an {@link IUniverseIntensionConstraint} that
 * applies an operator on two intension constraints.
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.2.0
 */
public final class UniverseBinaryIntensionConstraint extends UniverseOperatorIntensionConstraint {

    /**
     * The left intension constraint on which an operator is applied.
     */
    private IUniverseIntensionConstraint left;

    /**
     * The right intension constraint on which an operator is applied.
     */
    private IUniverseIntensionConstraint right;

    /**
     * Creates a new UniverseBinaryIntensionConstraint.
     *
     * @param operator The operator applied by the constraint.
     * @param left The left intension constraint on which the operator is applied.
     * @param right The right intension constraint on which the operator is applied.
     */
    public UniverseBinaryIntensionConstraint(UniverseOperator operator,
            IUniverseIntensionConstraint left, IUniverseIntensionConstraint right) {
        super(operator);
        this.left = left;
        this.right = right;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.cril.juniverse.csp.intension.IIntensionConstraint#accept(fr.
     * univartois.cril.juniverse.csp.intension.IIntensionConstraintVisitor)
     */
    @Override
    public void accept(IUniverseIntensionConstraintVisitor visitor) {
        left.accept(visitor);
        right.accept(visitor);
        visitor.visit(this);
    }

}
