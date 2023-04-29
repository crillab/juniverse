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

package fr.univartois.cril.juniverse.listener;

import java.math.BigInteger;
import java.util.Map;

import fr.univartois.cril.juniverse.core.UniverseSolverResult;
import fr.univartois.cril.juniverse.core.problem.IUniverseConstraint;
import fr.univartois.cril.juniverse.core.problem.IUniverseVariable;

/**
 * The IUniverseSearchListener interface defines a listener for listening to the events
 * occurring during the search performed by a solver.
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.2.0
 */
public interface IUniverseSearchListener {

    /**
     * Notifies this listener that the solver starts its search.
     */
    default void start() {
        // This method does nothing by default.
    }

    /**
     * Notifies this listener that a positive decision (a variable assignment
     * {@code x = v}) is going to be taken.
     *
     * @param decisionVariable The variable on which the decision is taken.
     * @param value The value assigned to the variable.
     */
    default void onPositiveDecision(IUniverseVariable decisionVariable, BigInteger value) {
        // This method does nothing by default.
    }

    /**
     * Notifies this listener that a negative decision (a variable refutation
     * {@code x != v}) is going to be taken.
     *
     * @param decisionVariable The variable on which the decision is taken.
     * @param value The value refuted for the variable.
     */
    default void onNegativeDecision(IUniverseVariable decisionVariable, BigInteger value) {
        // This method does nothing by default.
    }

    /**
     * Notifies this listener that a variable assignment has been enforced by propagation.
     *
     * @param variable The variable for which an assignment has been enforced.
     * @param value The value propagated for the variable.
     */
    default void onPropagation(IUniverseVariable variable, BigInteger value) {
        // This method does nothing by default.
    }

    /**
     * Notifies this listener that a variable is being assigned (either following a
     * decision or a propagation).
     *
     * @param variable The variable that is being assigned.
     * @param value The value assigned to the variable.
     */
    default void onAssignment(IUniverseVariable variable, BigInteger value) {
        // This method does nothing by default.
    }

    /**
     * Notifies this listener that a variable assignment {@code x = v} has immediately
     * failed due to propagations.
     *
     * @param variable The variable that has been assigned.
     * @param value The value assigned to the variable.
     */
    default void onFailedAssignment(IUniverseVariable variable, BigInteger value) {
        // This method does nothing by default.
    }

    /**
     * Notifies this listener that a conflict has occurred.
     *
     * @param constraint A conflicting constraint.
     * @param variable A conflicting variable in the constraint.
     */
    default void onConflict(IUniverseConstraint constraint, IUniverseVariable variable) {
        // This method does nothing by default.
    }

    /**
     * Notifies this listener that a constraint has been learned, following a conflict
     * analysis or a similar process.
     *
     * @param noGood The learned constraint.
     */
    default void onLearning(IUniverseConstraint noGood) {
        // This method does nothing by default.
    }

    /**
     * Notifies this listener that the solver is performing a backtrack (or backjump).
     *
     * @param level The decision level at which the solver is backtracking.
     */
    default void onBacktrack(int level) {
        // This method does nothing by default.
    }

    /**
     * Notifies this listener that the solver is performing a backtrack (or backjump).
     *
     * @param decisionVariable The decision variable to which the solver is backtracking.
     */
    default void onBacktrack(IUniverseVariable decisionVariable) {
        // This method does nothing by default.
    }

    /**
     * Notifies this listener that a variable is being unassigned (during a backtrack for
     * instance).
     *
     * @param variable The variable that is being unassigned.
     */
    default void onUnassignment(IUniverseVariable variable) {
        // This method does nothing by default.
    }

    /**
     * Notifies this listener that the solver is performing a restart.
     */
    default void onRestart() {
        // This method does nothing by default.
    }

    /**
     * Notifies this listener that the solver is cleaning its no-good database.
     */
    default void onCleaning() {
        // This method does nothing by default.
    }

    /**
     * Notifies this listener that the solver is deleting one of its no-goods.
     *
     * @param noGood The no-good that is being deleted.
     */
    default void onDelete(IUniverseConstraint noGood) {
        // This method does nothing by default.
    }

    /**
     * Notifies this listener that the solver has found a solution.
     *
     * @param solution The solution that has been found.
     */
    default void onSolutionFound(Map<? extends IUniverseVariable, BigInteger> solution) {
        // This method does nothing by default.
    }

    /**
     * Notifies this listener that the solver has found a solution.
     *
     * @param solution The solution that has been found.
     * @param cost The cost of the solution (determined by an objective function given to
     *        the solver).
     */
    default void onSolutionFound(Map<? extends IUniverseVariable, BigInteger> solution,
            BigInteger cost) {
        // This method does nothing by default.
    }

    /**
     * Notifies this listener that the solver has ended its search.
     *
     * @param result The result obtained by the solver.
     */
    default void end(UniverseSolverResult result) {
        // This method does nothing by default.
    }

}
