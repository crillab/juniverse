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

package fr.univartois.cril.juniverse.core;

import java.io.Serializable;

/**
 * The UniverseContradictionException is an exception that is thrown when a trivial
 * inconsistency is detected by the solver.
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.2.0
 */
public final class UniverseContradictionException extends RuntimeException {

    /**
     * The {@code serialVersionUID} of this {@link Serializable} class.
     */
    private static final long serialVersionUID = 6613914071597146350L;

    /**
     * Creates a new UniverseContradictionException.
     */
    public UniverseContradictionException() {
        // Nothing more to do.
    }

    /**
     * Creates a new UniverseContradictionException.
     *
     * @param message The message describing the reason of the contradiction.
     */
    public UniverseContradictionException(String message) {
        super(message);
    }

    /**
     * Creates a new UniverseContradictionException.
     *
     * @param cause The cause of the exception.
     */
    public UniverseContradictionException(Throwable cause) {
        super(cause);
    }

    /**
     * Creates a new UniverseContradictionException.
     *
     * @param message The message describing the reason of the contradiction.
     * @param cause The cause of the exception.
     */
    public UniverseContradictionException(String message, Throwable cause) {
        super(message, cause);
    }

}
