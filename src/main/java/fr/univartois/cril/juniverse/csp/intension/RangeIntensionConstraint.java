/**
 * JUniverse, a solver interface.
 * Copyright (c) 2022 - Univ Artois, CNRS & Exakis Nelite.
 * All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
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
 * The RangeIntensionConstraint
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public class RangeIntensionConstraint implements IIntensionConstraint {
    
    private BigInteger min;
    private BigInteger max;
    
    public RangeIntensionConstraint(BigInteger min,BigInteger max) {
        this.min=min;
        this.max=max;
    }

    
    /**
     * Gives the min of this RangeIntensionConstraint.
     *
     * @return This RangeIntensionConstraint's min.
     */
    public BigInteger getMin() {
        return min;
    }

    
    /**
     * Gives the max of this RangeIntensionConstraint.
     *
     * @return This RangeIntensionConstraint's max.
     */
    public BigInteger getMax() {
        return max;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.cril.juniverse.csp.intension.IIntensionConstraint#accept(fr.univartois.cril.juniverse.csp.intension.IIntensionConstraintVisitor)
     */
    @Override
    public void accept(IIntensionConstraintVisitor visitor) {
        visitor.visit(this);

    }

}

