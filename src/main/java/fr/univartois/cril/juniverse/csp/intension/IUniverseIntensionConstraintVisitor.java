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

package fr.univartois.cril.juniverse.csp.intension;

/**
 * The IUniverseIntensionConstraintVisitor allows visiting intension constraints to
 * discover its semantics.
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.2.0
 */
public interface IUniverseIntensionConstraintVisitor {

    /**
     * Visits a unary constraint that appears in an {@code intension} constraint.
     *
     * @param constr The constraint to visit.
     */
    void visit(UniverseUnaryIntensionConstraint constr);

    /**
     * Visits a binary constraint that appears in an {@code intension} constraint.
     *
     * @param constr The constraint to visit.
     */
    void visit(UniverseBinaryIntensionConstraint constr);

    /**
     * Visits an n-ary constraint that appears in an {@code intension} constraint.
     *
     * @param constr The constraint to visit.
     */
    void visit(UniverseNaryIntensionConstraint constr);

    /**
     * Visits an if-then-else constraint that appears in an {@code intension} constraint.
     *
     * @param ifThenElse The constraint to visit.
     */
    void visit(UniverseIfThenElseIntensionConstraint ifThenElse);

    /**
     * Visits a set that appears in an {@code intension} constraint.
     *
     * @param set The set to visit.
     */
    void visit(UniverseSetIntensionConstraint set);

    /**
     * Visits a range that appears in an {@code intension} constraint.
     *
     * @param range The range to visit.
     */
    void visit(UniverseRangeIntensionConstraint range);

    /**
     * Visits a variable that appears in an {@code intension} constraint.
     *
     * @param variable The variable to visit.
     */
    void visit(UniverseVariableIntensionConstraint variable);

    /**
     * Visits a constant that appears in an {@code intension} constraint.
     *
     * @param constant The constant to visit.
     */
    void visit(UniverseConstantIntensionConstraint constant);

}
