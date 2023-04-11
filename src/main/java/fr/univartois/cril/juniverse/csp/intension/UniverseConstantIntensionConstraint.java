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

import java.math.BigInteger;

/**
 * The UniverseConstantIntensionConstraint is an {@link IUniverseIntensionConstraint} that
 * represents a constant value.
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.2.0
 */
public final class UniverseConstantIntensionConstraint implements IUniverseIntensionConstraint {

    /**
     * The value of the constant.
     */
    private BigInteger value;

    /**
     * Creates a new ConstantIntensionConstraint.
     *
     * @param value The value of the constant.
     */
    public UniverseConstantIntensionConstraint(BigInteger value) {
        this.value = value;
    }

    /**
     * Gives the value of the constant.
     *
     * @return The value of the constant.
     */
    public BigInteger getValue() {
        return value;
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
