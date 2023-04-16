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

import java.util.HashMap;
import java.util.Map;

/**
 * The UniverseConfiguration
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public class UniverseConfiguration {
    private Map<String,Class<?>> configurationTypeMap;
    private Map<String,Object> configurationValueMap;
    private String name;
    
    public UniverseConfiguration(String name) {
        configurationTypeMap=new HashMap<>();
        configurationValueMap=new HashMap<>();
        this.name=name;
    }
    
    public void addConfiguration(String key, Object value) {
        this.configurationTypeMap.put(key, value.getClass());
        this.configurationValueMap.put(key, value);
    }
    
    public String getName() {
        return this.name;
    }
}

