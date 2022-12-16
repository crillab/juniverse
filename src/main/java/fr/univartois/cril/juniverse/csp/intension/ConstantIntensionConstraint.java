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

import java.math.BigInteger;

/**
 * The ConstantIntensionConstraint is an {@link IIntensionConstraint} that represents a
 * constant value.
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public final class ConstantIntensionConstraint implements IIntensionConstraint {

    /**
     * The value of the constant.
     */
    private BigInteger value;

    /**
     * Creates a new ConstantIntensionConstraint.
     *
     * @param value The value of the constant.
     */
    public ConstantIntensionConstraint(BigInteger value) {
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

    @Override
    public void accept(IIntensionConstraintVisitor visitor) {

        visitor.visit(this);

    }

}
