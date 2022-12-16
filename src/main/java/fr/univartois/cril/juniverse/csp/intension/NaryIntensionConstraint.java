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

import java.util.List;

import fr.univartois.cril.juniverse.csp.operator.UniverseOperator;

/**
 * The NaryIntensionConstraint is an {@link IIntensionConstraint} that applies an
 * operator on several intension constraints.
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public class NaryIntensionConstraint extends UniverseOperatorIntensionConstraint {

    /**
     * The intension constraints on which an operator is applied.
     */
    private List<? extends IIntensionConstraint> children;

    /**
     * Creates a new NaryIntensionConstraint.
     *
     * @param operator The operator applied by the constraint.
     * @param children The intension constraints on which the operator is applied.
     */
    public NaryIntensionConstraint(UniverseOperator operator,
            List<? extends IIntensionConstraint> children) {
        super(operator);
        this.children = children;
    }


    /**
     * Gives the arity of this constraints.
     *
     * @return The number of intension constraints on which the operator is applied.
     */
    public int getArity() {
        return children.size();
    }


    @Override
    public void accept(IIntensionConstraintVisitor visitor) {
        for(IIntensionConstraint c:children) {
            c.accept(visitor);
        }
        visitor.visit(this);
        
    }

}
