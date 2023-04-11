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

/**
 * The UniverseIfThenElseIntensionConstraint is an {@link IUniverseIntensionConstraint}
 * that represents an {@code if-then-else} (ternary) constraint.
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.2.0
 */
public final class UniverseIfThenElseIntensionConstraint implements IUniverseIntensionConstraint {

    /**
     * The condition of this constraint.
     */
    private IUniverseIntensionConstraint condition;

    /**
     * The intension constraint corresponding to the case in which {@link #condition}
     * evaluates to {@code true}.
     */
    private IUniverseIntensionConstraint ifTrue;

    /**
     * The intension constraint corresponding to the case in which {@link #condition}
     * evaluates to {@code false}.
     */
    private IUniverseIntensionConstraint ifFalse;

    /**
     * Creates a new UniverseIfThenElseIntensionConstraint.
     *
     * @param condition The condition of the constraint.
     * @param ifTrue The intension constraint corresponding to the case in which the
     *        condition evaluates to {@code true}.
     * @param ifFalse The intension constraint corresponding to the case in which the
     *        condition evaluates to {@code false}.
     */
    public UniverseIfThenElseIntensionConstraint(IUniverseIntensionConstraint condition,
            IUniverseIntensionConstraint ifTrue, IUniverseIntensionConstraint ifFalse) {
        this.condition = condition;
        this.ifTrue = ifTrue;
        this.ifFalse = ifFalse;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.cril.juniverse.csp.intension.IIntensionConstraint#accept(fr.
     * univartois.cril.juniverse.csp.intension.IIntensionConstraintVisitor)
     */
    @Override
    public void accept(IUniverseIntensionConstraintVisitor visitor) {
        condition.accept(visitor);
        ifTrue.accept(visitor);
        ifFalse.accept(visitor);
        visitor.visit(this);
    }

}
