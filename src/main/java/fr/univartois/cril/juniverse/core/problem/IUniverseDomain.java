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

package fr.univartois.cril.juniverse.core.problem;

import java.math.BigInteger;
import java.util.List;

/**
 * The IUniverseDomain represents the domain of a {@link IUniverseVariable} in
 * a constraint problem.
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.2.0
 */
public interface IUniverseDomain {

    /**
     * Gives the size of this domain, measured in number of values.
     *
     * @return The size of this domain.
     */
    long size();
    
    /**
     * Gives the current size of this domain, measured in number of values.
     *
     * @return The current size of this domain.
     */
    long currentSize();

    /**
     * Gives the minimum value of this domain.
     *
     * @return The minimum value.
     */
    BigInteger min();

    /**
     * Gives the maximum value of this domain.
     *
     * @return The maximum value.
     */
    BigInteger max();

    /**
     * Gives the list of values of the initial domain.
     *
     * @return The list of values.
     */
    List<BigInteger> getValues();
    
    /**
     * Gives the list of values of the current domain.
     *
     * @return The list of current values.
     */
    List<BigInteger> getCurrentValues();
    
    /**
     * Keeps in this domain only the values between {@code min} and {@code max}.
     * 
     * @param min The minimum value to keep (included).
     * @param max The maximum value to keep (excluded).
     */
    void keepValues(BigInteger min, BigInteger max);

    /**
     * Keeps in this domain only the values between {@code values}.
     * 
     * @param values The list of values to keep.
     */
    void keepValues(List<BigInteger> values);

    /**
     * Removes from this domain all the values between {@code min} and {@code max}.
     * 
     * @param min The minimum value to remove (included).
     * @param max The maximum value to remove (excluded).
     */
    void removeValues(BigInteger min, BigInteger max);

    /**
     * Removes from this domain all the values in {@code values}.
     * 
     * @param values The list of values to remove.
     */
    void removeValues(List<BigInteger> values);
    
}
