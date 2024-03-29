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
 * The UniverseRangeIntensionConstraint is an {@link IUniverseIntensionConstraint} that
 * represents a range of values.
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.2.0
 */
public final class UniverseRangeIntensionConstraint implements IUniverseIntensionConstraint {

    /**
     * The minimum value of this range.
     */
    private BigInteger min;

    /**
     * The maximum value of this range.
     */
    private BigInteger max;

    /**
     * Creates a new UniverseRangeIntensionConstraint.
     *
     * @param min The minimum value of the range.
     * @param max The maximum value of the range.
     */
    public UniverseRangeIntensionConstraint(BigInteger min, BigInteger max) {
        this.min = min;
        this.max = max;
    }

    /**
     * Gives the minimum value of this range.
     *
     * @return The minimum value of this range.
     */
    public BigInteger getMin() {
        return min;
    }

    /**
     * Gives the maximum value of this range.
     *
     * @return The maximum value of this range.
     */
    public BigInteger getMax() {
        return max;
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
