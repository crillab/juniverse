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

/**
 * The UniverseSetIntensionConstraint is an {@link IUniverseIntensionConstraint} that
 * represents a set of intension constraints.
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.2.0
 */
public final class UniverseSetIntensionConstraint implements IUniverseIntensionConstraint {

    /**
     * The intension constraints in this set.
     */
    private List<? extends IUniverseIntensionConstraint> constraints;

    /**
     * Creates a new UniverseSetIntensionConstraint.
     *
     * @param set The set of intension constraints to represent.
     */
    public UniverseSetIntensionConstraint(List<? extends IUniverseIntensionConstraint> set) {
        this.constraints = set;
    }

    /**
     * Gives the number of intension constraints in this set.
     *
     * @return The size of this set.
     */
    public int size() {
        return constraints.size();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.cril.juniverse.csp.intension.IIntensionConstraint#accept(fr.
     * univartois.cril.juniverse.csp.intension.IIntensionConstraintVisitor)
     */
    @Override
    public void accept(IUniverseIntensionConstraintVisitor visitor) {
        for (var constraint : constraints) {
            constraint.accept(visitor);
        }
        visitor.visit(this);
    }

}
