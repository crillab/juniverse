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
 * The UniverseVariableIntensionConstraint is an {@link IUniverseIntensionConstraint} that
 * represents a variable.
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.2.0
 */
public final class UniverseVariableIntensionConstraint implements IUniverseIntensionConstraint {

    /**
     * The identifier of the variable.
     */
    private String identifier;

    /**
     * Creates a new UniverseVariableIntensionConstraint.
     *
     * @param identifier The identifier of the variable.
     */
    public UniverseVariableIntensionConstraint(String identifier) {
        this.identifier = identifier;
    }

    /**
     * Gives the identifier of the variable of this constraint.
     *
     * @return The identifier of the variable.
     */
    public String getIdentifier() {
        return identifier;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.cril.juniverse.csp.intension.IIntensionConstraint#accept(fr.
     * univartois.cril.juniverse.csp.intension.IIntensionConstraintVisitor)
     */
    @Override
    public void accept(IUniverseIntensionConstraintVisitor visitor) {
        visitor.visit(this);
    }

}
