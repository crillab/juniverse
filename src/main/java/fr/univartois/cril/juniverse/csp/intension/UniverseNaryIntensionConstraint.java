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

import java.util.List;

import fr.univartois.cril.juniverse.csp.operator.UniverseOperator;

/**
 * The UniverseOperatorIntensionConstraint is an {@link IUniverseIntensionConstraint} that
 * applies an operator on several intension constraints.
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.2.0
 */
public final class UniverseNaryIntensionConstraint extends UniverseOperatorIntensionConstraint {

    /**
     * The intension constraints on which an operator is applied.
     */
    private List<? extends IUniverseIntensionConstraint> children;

    /**
     * Creates a new UniverseOperatorIntensionConstraint.
     *
     * @param operator The operator applied by the constraint.
     * @param children The intension constraints on which the operator is applied.
     */
    public UniverseNaryIntensionConstraint(UniverseOperator operator,
            List<? extends IUniverseIntensionConstraint> children) {
        super(operator);
        this.children = children;
    }

    /**
     * Gives the arity of this constraint.
     *
     * @return The number of intension constraints on which the operator is applied.
     */
    public int getArity() {
        return children.size();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.cril.juniverse.csp.intension.IIntensionConstraint#accept(fr.
     * univartois.cril.juniverse.csp.intension.IIntensionConstraintVisitor)
     */
    @Override
    public void accept(IUniverseIntensionConstraintVisitor visitor) {
        for (IUniverseIntensionConstraint c : children) {
            c.accept(visitor);
        }
        visitor.visit(this);
    }

}
