/**
 * JUniverse, a solver interface.
 * Copyright (c) 2022 - Univ Artois, CNRS  Exakis Nelite.
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

package fr.univartois.cril.juniverse.sat;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import fr.univartois.cril.juniverse.core.IUniverseSolver;
import fr.univartois.cril.juniverse.core.UniverseAssumption;
import fr.univartois.cril.juniverse.core.UniverseSolverResult;

/**
 * The IUniverseSatSolver
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public interface IUniverseSatSolver extends IUniverseSolver{
    /**
     * Create a clause from a set of literals The literals are represented by
     * non null integers such that opposite literals a represented by opposite
     * values. (classical Dimacs way of representing literals).
     *
     * @param literals
     *            a set of literals
     */
     void addClause( List<Integer> literals);

    /**
     * Create clauses from a set of set of literals. This is convenient to
     * create in a single call all the clauses.
     * It is mainly a loop to addClause().
     *
     * @param clauses
     *            a vector of set (VecInt) of literals in the dimacs format. The
     *            vector can be reused since the solver is not supposed to keep
     *            a reference to that vector.
     */
     default void addAllClauses( List<List<Integer>> clauses){
        for(var v:clauses){
            addClause(v);
        }
    }

     /**
      * Solves the problem associated to this solver.
      *
      * @param assumptions The assumptions to consider when solving.
      *
      * @return The outcome of the search conducted by the solver.
      */
     UniverseSolverResult solveBoolean(List<UniverseAssumption<Boolean>> assumptions);

     /**
      * Solves the problem associated to this solver.
      *
      * @param assumptions The assumptions to consider when solving.
      *
      * @return The outcome of the search conducted by the solver.
      */
    default UniverseSolverResult solve(List<UniverseAssumption<BigInteger>> assumptions){
        List<UniverseAssumption<Boolean>> booleanAssumptions=new ArrayList<>(assumptions.size());
        for(var i:assumptions){
            BigInteger v = i.getValue();
            boolean e = i.isEqual();

            if(v.signum()!=0  && !v.equals(BigInteger.ONE)){
                throw new IllegalArgumentException("Assumption must be boolean");
            }

            booleanAssumptions.add(new UniverseAssumption<>(i.getVariableId(),e,v.equals(BigInteger.ONE)));
        }
        return solveBoolean(booleanAssumptions);
    }
}

