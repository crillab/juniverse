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

package fr.univartois.cril.juniverse.pb;

import java.math.BigInteger;
import java.util.List;

import fr.univartois.cril.juniverse.sat.IUniverseSatSolver;
import fr.univartois.cril.juniverse.core.UniverseContradictionException;


/**
 * The IUniversePseudoBooleanSolver
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public interface IUniversePseudoBooleanSolver extends IUniverseSatSolver {
    /**
     * Create a Pseudo-Boolean constraint of the type "at least n or at most n
     * of those literals must be satisfied"
     *
     * @param lits
     *            a set of literals. The vector can be reused since the solver
     *            is not supposed to keep a reference to that vector.
     * @param coeffs
     *            the coefficients of the literals. The vector can be reused
     *            since the solver is not supposed to keep a reference to that
     *            vector.
     * @param moreThan
     *            true if it is a constraint &gt;= degree, false if it is a
     *            constraint &lt;= degree
     * @param d
     *            the degree of the cardinality constraint
     * @throws UniverseContradictionException
     *             iff the vector of literals is empty or if the constraint is
     *             falsified after unit propagation
     * 
     */
     void addPseudoBoolean(List<Integer> lits, List<BigInteger> coeffs,
                                  boolean moreThan, BigInteger d);

    /**
     * Create a pseudo boolean constraint of the type "at most".
     * 
     * @param literals
     *            a set of literals The vector can be reused since the solver is
     *            not supposed to keep a reference to that vector.
     * @param coeffs
     *            the coefficients of the literals. The vector can be reused
     *            since the solver is not supposed to keep a reference to that
     *            vector.
     * @param degree
     *            the degree of the pseudo-boolean constraint
     * @throws UniverseContradictionException
     *             iff the constraint is found trivially unsat.
     * 
     * 
     */

     void addAtMost(List<Integer> literals, List<Integer> coeffs, int degree);

    /**
     * Create a pseudo boolean constraint of the type "at most".
     * 
     * @param literals
     *            a set of literals The vector can be reused since the solver is
     *            not supposed to keep a reference to that vector.
     * @param coeffs
     *            the coefficients of the literals. The vector can be reused
     *            since the solver is not supposed to keep a reference to that
     *            vector.
     * @param degree
     *            the degree of the pseudo-boolean constraint
     * @throws UniverseContradictionException
     *             iff the constraint is found trivially unsat.
     * 
     * 
     */

     void addAtMost(List<Integer> literals, List<BigInteger> coeffs,
                           BigInteger degree);

    /**
     * Create a pseudo-boolean constraint of the type "at least".
     * 
     * @param literals
     *            a set of literals. The vector can be reused since the solver
     *            is not supposed to keep a reference to that vector.
     * @param coeffs
     *            the coefficients of the literals. The vector can be reused
     *            since the solver is not supposed to keep a reference to that
     *            vector.
     * @param degree
     *            the degree of the pseudo-boolean constraint
     * @throws UniverseContradictionException
     *             iff the constraint is found trivially unsat.
     * 
     * 
     */
     void addAtLeast(List<Integer> literals, List<Integer> coeffs, int degree);

    /**
     * Create a pseudo-boolean constraint of the type "at least".
     * 
     * @param literals
     *            a set of literals. The vector can be reused since the solver
     *            is not supposed to keep a reference to that vector.
     * @param coeffs
     *            the coefficients of the literals. The vector can be reused
     *            since the solver is not supposed to keep a reference to that
     *            vector.
     * @param degree
     *            the degree of the pseudo-boolean constraint
     * @throws UniverseContradictionException
     *             iff the constraint is found trivially unsat.
     * 
     * 
     */
     void addAtLeast(List<Integer> literals, List<BigInteger> coeffs,
                            BigInteger degree);

    /**
     * Create a pseudo-boolean constraint of the type "subset sum".
     * 
     * @param literals
     *            a set of literals. The vector can be reused since the solver
     *            is not supposed to keep a reference to that vector.
     * @param coeffs
     *            the coefficients of the literals. The vector can be reused
     *            since the solver is not supposed to keep a reference to that
     *            vector.
     * @param weight
     *            the number of literals that must be satisfied
     * @throws UniverseContradictionException
     *             iff the constraint is trivially unsatisfiable.
     * 
     */
     void addExactly(List<Integer> literals, List<Integer> coeffs, int weight);

    /**
     * Create a pseudo-boolean constraint of the type "subset sum".
     * 
     * @param literals
     *            a set of literals. The vector can be reused since the solver
     *            is not supposed to keep a reference to that vector.
     * @param coeffs
     *            the coefficients of the literals. The vector can be reused
     *            since the solver is not supposed to keep a reference to that
     *            vector.
     * @param weight
     *            the number of literals that must be satisfied
     * @throws UniverseContradictionException
     *             iff the constraint is trivially unsatisfiable.
     * 
     */
     void addExactly(List<Integer> literals, List<BigInteger> coeffs,
                            BigInteger weight);
}

