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

package fr.univartois.cril.juniverse.core;


/**
 * The UniverseConstradictionException
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public class UniverseContradictionException extends RuntimeException {

    /**
     * Creates a new UniverseConstradictionException.
     */
    public UniverseContradictionException() {
    }

    /**
     * Creates a new UniverseConstradictionException.
     * @param message
     */
    public UniverseContradictionException(String message) {
        super(message);
    }

    /**
     * Creates a new UniverseConstradictionException.
     * @param cause
     */
    public UniverseContradictionException(Throwable cause) {
        super(cause);
    }

    /**
     * Creates a new UniverseConstradictionException.
     * @param message
     * @param cause
     */
    public UniverseContradictionException(String message, Throwable cause) {
        super(message, cause);
    }

}

