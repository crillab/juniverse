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

/**
 * The VariableIntensionConstraint is an {@link IIntensionConstraint} that represents a
 * variable.
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public final class VariableIntensionConstraint implements IIntensionConstraint {

    /**
     * The identifier of the variable.
     */
    private String identifier;

    /**
     * Creates a new VariableIntensionConstraint.
     *
     * @param identifier The identifier of the variable.
     */
    public VariableIntensionConstraint(String identifier) {
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

    @Override
    public void accept(IIntensionConstraintVisitor visitor) {
        visitor.visit(this);
    }

}
