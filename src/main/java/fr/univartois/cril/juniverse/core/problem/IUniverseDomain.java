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

package fr.univartois.cril.juniverse.core.problem;

import java.math.BigInteger;
import java.util.List;

/**
 * The IUniverseDomain represents the Domain of a Variable in constraint problem.
 * 
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.1.0
 * @see IUniverseVariable
 */
public interface IUniverseDomain {

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
     * Gives the number of values of this domain.
     * 
     * @return The number of values.
     */
    long size();

    /**
     * Gives the list of values of this domain.
     * 
     * @return The list of values.
     */
    List<BigInteger> getValues();
}
