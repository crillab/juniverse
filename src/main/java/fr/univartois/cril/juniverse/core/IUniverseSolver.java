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

import java.io.OutputStream;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import fr.univartois.cril.juniverse.core.problem.IUniverseVariable;
import fr.univartois.cril.juniverse.listener.IUniverseSearchListener;

/**
 * The IUniverseSolver interface is the root interface defining the base contract
 * for all solvers.
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.2.0
 */
public interface IUniverseSolver {

    /**
     * Resets this solver in its original state.
     */
    void reset();

    /**
     * Gives the number of variables defined in this solver.
     *
     * @return The number of variables.
     */
    int nVariables();

    /**
     * Gives the mapping of the variables in this solver.
     *
     * @return The mapping of the variables.
     */
    Map<String, IUniverseVariable> getVariablesMapping();

    /**
     * Advises this solver to focus on some variables to make decisions.
     *
     * @param variables The variables on which to make decisions.
     */
    void decisionVariables(List<String> variables);

    /**
     * Gives the number of constraints defined in this solver.
     *
     * @return The number of constraints.
     */
    int nConstraints();

    /**
     * Checks whether the associated problem is an optimization problem.
     *
     * @return Whether the problem is an optimization problem.
     */
    boolean isOptimization();

    /**
     * Sets the time limit before interrupting the search.
     *
     * @param seconds The time limit to set (in seconds).
     */
    void setTimeout(long seconds);

    /**
     * Sets the time limit before interrupting the search.
     *
     * @param mseconds The time limit to set (in milliseconds).
     */
    void setTimeoutMs(long mseconds);

    /**
     * Sets the verbosity level of the solver.
     * Extreme values (outside the range expected by the underlying solver) should be
     * handled silently as the minimum or maximum value supported by the solver.
     *
     * @param level The verbosity level to set.
     */
    void setVerbosity(int level);

    /**
     * Adds a listener to this solver, which listens to the events occurring in
     * the solver during the search.
     *
     * @param listener The listener to add.
     *
     * @throws UnsupportedOperationException If this solver does not support
     *         search events.
     */
    default void addSearchListener(IUniverseSearchListener listener) {
        throw new UnsupportedOperationException();
    }

    /**
     * Sets the log file to be used by the solver.
     *
     * @param filename The name of the log file.
     */
    void setLogFile(String filename);

    /**
     * Sets the output stream to be used by the solver for logging.
     *
     * @param stream The logging output stream.
     */
    void setLogStream(OutputStream stream);

    /**
     * Loads a problem stored in the given file.
     * The solver is expected to parse the problem itself.
     *
     * @param filename The name of the file containing the problem to solve.
     */
    void loadInstance(String filename);

    /**
     * Solves the problem associated to this solver.
     *
     * @return The outcome of the search conducted by the solver.
     */
    UniverseSolverResult solve();

    /**
     * Solves the problem stored in the given file.
     * The solver is expected to parse the problem itself.
     *
     * @param filename The name of the file containing the problem to solve.
     *
     * @return The outcome of the search conducted by the solver.
     */
    UniverseSolverResult solve(String filename);

    /**
     * Solves the problem associated to this solver.
     *
     * @param assumptions The assumptions to consider when solving.
     *
     * @return The outcome of the search conducted by the solver.
     */
    UniverseSolverResult solve(
            List<UniverseAssumption<BigInteger>> assumptions);

    /**
     * Interrupts (asynchronously) the search currently performed by this solver.
     */
    void interrupt();

    /**
     * Gives the solution found by this solver (if any).
     *
     * @return The solution found by this solver.
     */
    List<BigInteger> solution();

    /**
     * Gives the mapping between the identifiers of the variables and the assignment found
     * by this solver (if any).
     *
     * @return The solution found by this solver.
     */
    Map<String, BigInteger> mapSolution();

    /**
     * Gives the mapping between the identifiers of the variables and the assignment found
     * by this solver (if any).
     *
     * @param excludeAux Whether auxiliary variables should be excluded from the solution.
     *
     * @return The solution found by this solver.
     */
    Map<String, BigInteger> mapSolution(boolean excludeAux);

}
