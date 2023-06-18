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

package fr.univartois.cril.juniverse.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

/**
 * The SolverFactoryLoader loads all implementations of {@link IUniverseSolverFactory}
 * that are present in the classpath.
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.2.0
 */
public final class SolverFactoryLoader {

    /**
     * The single instance of this class.
     */
    private static final SolverFactoryLoader INSTANCE = new SolverFactoryLoader();

    /**
     * Disables external instantiation.
     */
    private SolverFactoryLoader() {
        // Nothing to do: Singleton Design Pattern
    }

    /**
     * Gives the single instance of SolverFactoryLoader.
     *
     * @return The SolverFactoryLoader's single instance.
     */
    public static SolverFactoryLoader getInstance() {
        return INSTANCE;
    }

    /**
     * Gives a list of instances of all available {@link IUniverseSolverFactory}
     * implementations in the classpath.
     *
     * @return A list of available factories.
     */
    public List<IUniverseSolverFactory> getFactories() {
        ServiceLoader<IUniverseSolverFactory> services = ServiceLoader
                .load(IUniverseSolverFactory.class);
        List<IUniverseSolverFactory> list = new ArrayList<>();
        services.iterator().forEachRemaining(list::add);
        return list;
    }

}
