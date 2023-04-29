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

package fr.univartois.cril.juniverse.config;

import java.util.List;

import fr.univartois.cril.juniverse.core.IUniverseSolver;

/**
 * The IUniverseConfigurableSolver interface defines the contract of a solver that can be
 * configured.
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.2.0
 */
public interface IUniverseConfigurableSolver extends IUniverseSolver {

    /**
     * Gives all "main" solver configurations for this solver.
     *
     * @return The list of the main configurations.
     */
    List<UniverseConfiguration> getSolverConfigurations();

    /**
     * Gives all configurations recognized by this solver for its variable selection
     * heuristic.
     *
     * @return The variable selection heuristics recognized by this solver.
     */
    List<UniverseConfiguration> getVariableSelectionHeuristics();

    /**
     * Gives all configurations recognized by this solver for its value selection
     * heuristic.
     *
     * @return The value selection heuristics recognized by this solver.
     */
    List<UniverseConfiguration> getValueSelectionHeuristics();

    /**
     * Gives all configurations recognized by this solver for its restart policy.
     *
     * @return The restart policies recognized by this solver.
     */
    List<UniverseConfiguration> getRestartPolicies();

    /**
     * Gives all configurations recognized by this solver for its learned constraint
     * deletion strategies.
     *
     * @return The learned constraint deletion strategies recognized by this solver.
     */
    List<UniverseConfiguration> getLearnedConstraintDeletionStrategies();

    /**
     * Gives the "main" solver configuration currently used this solver.
     *
     * @return The current main configuration.
     */
    UniverseConfiguration getCurrentSolverConfiguration();

    /**
     * Gives the variable selection heuristic currently used by this solver.
     *
     * @return The current variable selection heuristic.
     */
    UniverseConfiguration getCurrentVariableSelectionHeuristic();

    /**
     * Gives the value selection heuristic currently used by this solver.
     *
     * @return The current value selection heuristic.
     */
    UniverseConfiguration getCurrentValueSelectionHeuristic();

    /**
     * Gives the restart policy currently used by this solver.
     *
     * @return The current restart policy.
     */
    UniverseConfiguration getCurrentRestartPolicy();

    /**
     * Gives the learned constraint deletion strategy currently used by this solver.
     *
     * @return The current learned constraint deletion strategy.
     */
    UniverseConfiguration getCurrentLearntConstraintDeletionStrategy();

    /**
     * Sets the "main" solver configuration currently to use in this solver.
     *
     * @param solverConfiguration The main configuration to use.
     */
    void setSolverConfiguration(UniverseConfiguration solverConfiguration);

    /**
     * Sets the variable selection heuristic to use in this solver.
     *
     * @param varh The variable selection heuristic to use.
     */
    void setVariableSelectionHeuristic(UniverseConfiguration varh);

    /**
     * Sets the value selection heuristic to use in this solver.
     *
     * @param valh The value selection heuristic to use.
     */
    void setValueSelectionHeuristic(UniverseConfiguration valh);

    /**
     * Sets the restart policy to use in this solver.
     *
     * @param restart The restart policy to use.
     */
    void setRestartPolicy(UniverseConfiguration restart);

    /**
     * Forces this solver to perform a restart now.
     */
    void restartNow();

    /**
     * Sets the learned constraint deletion strategy to use in this solver.
     *
     * @param deletion The learned constraint deletion strategy to use.
     */
    void setLearntConstraintDeletionStrategy(UniverseConfiguration deletion);

    /**
     * Forces this solver to clean its learned constraints now.
     */
    void cleanNow();

}
