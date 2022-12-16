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

package fr.univartois.cril.juniverse.csp.intension;


/**
 * The IIntensionConstraintVisitor visits an intension constraint in order to compute its
 * encoding using pseudo-Boolean constraints.
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public interface IIntensionConstraintVisitor {

    /**
     * Visits a unary constraint that appears in an {@code intension} constraint.
     *
     * @param constr The constraint to visit.
     *
     * @throws ContradictionException If visiting (and encoding) the constraint results in
     *         a trivial inconsistency.
     */
    void visit(UnaryIntensionConstraint constr);

    /**
     * Visits a binary constraint that appears in an {@code intension} constraint.
     *
     * @param constr The constraint to visit.
     *
     * @throws ContradictionException If visiting (and encoding) the constraint results in
     *         a trivial inconsistency.
     */
    void visit(BinaryIntensionConstraint constr);

    /**
     * Visits an n-ary constraint that appears in an {@code intension} constraint.
     *
     * @param constr The constraint to visit.
     *
     * @throws ContradictionException If visiting (and encoding) the constraint results in
     *         a trivial inconsistency.
     */
    void visit(NaryIntensionConstraint constr);

    /**
     * Visits an if-then-else constraint that appears in an {@code intension} constraint.
     *
     * @param ifThenElse The constraint to visit.
     *
     * @throws ContradictionException If visiting (and encoding) the constraint results in
     *         a trivial inconsistency.
     */
    void visit(IfThenElseIntensionConstraint ifThenElse);

    /**
     * Visits a variable that appears in an {@code intension} constraint.
     *
     * @param variable The variable to visit.
     *
     */
    void visit(VariableIntensionConstraint variable);

    /**
     * Visits a constant that appears in an {@code intension} constraint.
     *
     * @param constant The constant to visit.
     *
     */
    void visit(ConstantIntensionConstraint constant);


}
