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

package fr.univartois.cril.juniverse.pb;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

import fr.univartois.cril.juniverse.core.UniverseContradictionException;
import fr.univartois.cril.juniverse.sat.IUniverseSatSolver;

/**
 * The IUniversePseudoBooleanSolver interface defines the contract for
 * pseudo-Boolean solvers.
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.2.0
 */
public interface IUniversePseudoBooleanSolver extends IUniverseSatSolver {

    /**
     * Creates a pseudo-Boolean constraint of type {@code at-least} or {@code at-most}.
     *
     * @param literals The literals of the constraint to add.
     * @param coefficients The coefficients of the literals.
     * @param moreThan Whether the constraint is an {@code at-least} constraint, or an
     *        {@code at-most} constraint.
     * @param degree The degree of the constraint.
     *
     * @throws UniverseContradictionException If the constraint to add is inconsistent.
     */
    void addPseudoBoolean(List<Integer> literals, List<BigInteger> coefficients, boolean moreThan,
            BigInteger degree);

    /**
     * Creates an {@code at-most} cardinality constraint.
     *
     * @param literals The literals of the constraint to add.
     * @param degree The degree of the constraint.
     *
     * @throws UniverseContradictionException If the constraint to add is inconsistent.
     */
    default void addAtMost(List<Integer> literals, int degree) {
        addAtMost(literals, Collections.nCopies(literals.size(), 1), degree);
    }

    /**
     * Creates an {@code at-most} pseudo-Boolean constraint.
     *
     * @param literals The literals of the constraint to add.
     * @param coefficients The coefficients of the literals.
     * @param degree The degree of the constraint.
     *
     * @throws UniverseContradictionException If the constraint to add is inconsistent.
     */
    void addAtMost(List<Integer> literals, List<Integer> coefficients, int degree);

    /**
     * Creates an {@code at-most} pseudo-Boolean constraint.
     *
     * @param literals The literals of the constraint to add.
     * @param coefficients The coefficients of the literals.
     * @param degree The degree of the constraint.
     *
     * @throws UniverseContradictionException If the constraint to add is inconsistent.
     */
    void addAtMost(List<Integer> literals, List<BigInteger> coefficients, BigInteger degree);

    /**
     * Creates an {@code at-least} cardinality constraint.
     *
     * @param literals The literals of the constraint to add.
     * @param degree The degree of the constraint.
     *
     * @throws UniverseContradictionException If the constraint to add is inconsistent.
     */
    default void addAtLeast(List<Integer> literals, int degree) {
        addAtLeast(literals, Collections.nCopies(literals.size(), 1), degree);
    }

    /**
     * Creates an {@code at-least} pseudo-Boolean constraint.
     *
     * @param literals The literals of the constraint to add.
     * @param coefficients The coefficients of the literals.
     * @param degree The degree of the constraint.
     *
     * @throws UniverseContradictionException If the constraint to add is inconsistent.
     */
    void addAtLeast(List<Integer> literals, List<Integer> coefficients, int degree);

    /**
     * Creates an {@code at-least} pseudo-Boolean constraint.
     *
     * @param literals The literals of the constraint to add.
     * @param coefficients The coefficients of the literals.
     * @param degree The degree of the constraint.
     *
     * @throws UniverseContradictionException If the constraint to add is inconsistent.
     */
    void addAtLeast(List<Integer> literals, List<BigInteger> coefficients, BigInteger degree);

    /**
     * Creates an {@code exactly} cardinality constraint.
     *
     * @param literals The literals of the constraint to add.
     * @param degree The degree of the constraint.
     *
     * @throws UniverseContradictionException If the constraint to add is inconsistent.
     */
    default void addExactly(List<Integer> literals, int degree) {
        addExactly(literals, Collections.nCopies(literals.size(), 1), degree);
    }

    /**
     * Creates an {@code exactly} pseudo-Boolean constraint.
     *
     * @param literals The literals of the constraint to add.
     * @param coefficients The coefficients of the literals.
     * @param degree The degree of the constraint.
     *
     * @throws UniverseContradictionException If the constraint to add is inconsistent.
     */
    void addExactly(List<Integer> literals, List<Integer> coefficients, int degree);

    /**
     * Creates an {@code exactly} pseudo-Boolean constraint.
     *
     * @param literals The literals of the constraint to add.
     * @param coefficients The coefficients of the literals.
     * @param degree The degree of the constraint.
     *
     * @throws UniverseContradictionException If the constraint to add is inconsistent.
     */
    void addExactly(List<Integer> literals, List<BigInteger> coefficients, BigInteger degree);

}
