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

package fr.univartois.cril.juniverse.sat;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import fr.univartois.cril.juniverse.core.IUniverseSolver;
import fr.univartois.cril.juniverse.core.UniverseAssumption;
import fr.univartois.cril.juniverse.core.UniverseContradictionException;
import fr.univartois.cril.juniverse.core.UniverseSolverResult;

/**
 * The IUniverseSatSolver interface defines the contract for SAT solvers.
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.2.0
 */
public interface IUniverseSatSolver extends IUniverseSolver {

    /**
     * Adds to this solver a clause from a set of literals.
     * The literals are represented by non-null integers such that opposite literals are
     * represented by opposite values (using the classical DIMACS way of representing
     * literals).
     *
     * @param literals The literals of the clause to add.
     *
     * @throws UniverseContradictionException If the clause to add is inconsistent.
     */
    void addClause(List<Integer> literals);

    /**
     * Adds to this solver several clauses from a set of sets of literals.
     * This is convenient to create in a single call all the clauses.
     * It is mainly a loop to {@link #addClause(List)}.
     *
     * @param clauses A list of list of literals in the DIMACS format.
     *
     * @throws UniverseContradictionException If one of the clauses to add is inconsistent.
     *
     * @see #addClause(List)
     */
    default void addAllClauses(List<List<Integer>> clauses) {
        for (List<Integer> v : clauses) {
            addClause(v);
        }
    }

    /**
     * Solves the problem associated to this solver.
     *
     * @param assumptions The assumptions to consider when solving (as a set of literals).
     *
     * @return The outcome of the search conducted by the solver.
     */
    default UniverseSolverResult solveDimacs(List<Integer> assumptions) {
    	ArrayList<UniverseAssumption<BigInteger>> integerAssumptions = new ArrayList<UniverseAssumption<BigInteger>>(assumptions.size());

        for (Integer a : assumptions) {
            if (a < 0) {
                integerAssumptions.add(new UniverseAssumption<>(Integer.toString(-a), true, ZERO));

            } else {
                integerAssumptions.add(new UniverseAssumption<>(a.toString(), true, ONE));
            }
        }

        return solve(integerAssumptions);
    }

    /**
     * Solves the problem associated to this solver.
     *
     * @param assumptions The assumptions to consider when solving.
     *
     * @return The outcome of the search conducted by the solver.
     */
    default UniverseSolverResult solveBoolean(List<UniverseAssumption<Boolean>> assumptions) {
    	ArrayList<UniverseAssumption<BigInteger>> integerAssumptions = new ArrayList<UniverseAssumption<BigInteger>>(assumptions.size());

        for (UniverseAssumption<Boolean> a : assumptions) {
            if (Boolean.TRUE.equals(a.getValue())) {
                integerAssumptions.add(new UniverseAssumption<>(a.getVariableId(), a.isEqual(), ONE));

            } else {
                integerAssumptions.add(new UniverseAssumption<>(a.getVariableId(), a.isEqual(), ZERO));
            }
        }

        return solve(integerAssumptions);
    }

}
