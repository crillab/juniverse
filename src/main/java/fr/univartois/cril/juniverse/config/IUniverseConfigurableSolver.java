/**
 * juniverse
 * Copyright (c) 2023 - Romain Wallon.
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

package fr.univartois.cril.juniverse.config;

import java.util.List;

/**
 * The IUniverseConfigurableSolver
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public interface IUniverseConfigurableSolver {
    List<UniverseConfiguration> getVariableSelectionHeuristics();
    List<UniverseConfiguration> getValueSelectionHeuristics();
    List<UniverseConfiguration> getRestartPolicies();
    List<UniverseConfiguration> getLearntConstraintDeletionStrategies();
    List<UniverseConfiguration> getSolverConfigurations();
    
    UniverseConfiguration getCurrentVariableSelectionHeuristic();
    UniverseConfiguration getCurrentValueSelectionHeuristic();
    UniverseConfiguration getCurrentRestartPolicy();
    UniverseConfiguration getCurrentLearntConstraintDeletionStrategy();
    UniverseConfiguration getCurrentSolverConfiguration();
    
    void setCurrentVariableSelectionHeuristic(UniverseConfiguration varh);
    void setCurrentValueSelectionHeuristic(UniverseConfiguration valh);
    void setCurrentRestartPolicy(UniverseConfiguration restart);
    void setCurrentLearntConstraintDeletionStrategy(UniverseConfiguration learnt);
    void setCurrentSolverConfiguration(UniverseConfiguration solverConfiguration);
    
    void restartNow();
    void cleanNow();
}

