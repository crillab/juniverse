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

import java.math.BigInteger;
import java.util.List;

import fr.univartois.cril.juniverse.csp.operator.UniverseArithmeticOperator;
import fr.univartois.cril.juniverse.csp.operator.UniverseBooleanOperator;
import fr.univartois.cril.juniverse.csp.operator.UniverseOperator;
import fr.univartois.cril.juniverse.csp.operator.UniverseRelationalOperator;

/**
 * The IntensionConstraintFactory makes easier the construction of {@code intension}
 * constraints from the solver's API, by providing a functional notation similar to that
 * used to define the constraints using XCSP3.
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public final class IntensionConstraintFactory {

    /**
     * Disables instantiation.
     */
    private IntensionConstraintFactory() {
        throw new AssertionError("No IntensionConstraintFactory instances for you!");
    }

    /**
     * Wraps a constant value in its representation as an {@code intension} constraint.
     *
     * @param value The value of the constant.
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint constant(long value) {
        return new ConstantIntensionConstraint(BigInteger.valueOf(value));
    }

    /**
     * Wraps a constant value in its representation as an {@code intension} constraint.
     *
     * @param value The value of the constant.
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint constant(BigInteger value) {
        return new ConstantIntensionConstraint(value);
    }

    /**
     * Wraps a variable in its representation as an {@code intension} constraint.
     *
     * @param id The identifier of the variable.
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint variable(String id) {
        return new VariableIntensionConstraint(id);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code opposite} operator.
     *
     * @param constr The constraint on which to apply the operator.
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint neg(IIntensionConstraint constr) {
        return unary(UniverseArithmeticOperator.NEG, constr);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code absolute-value}
     * operator.
     *
     * @param constr The constraint on which to apply the operator.
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint abs(IIntensionConstraint constr) {
        return unary(UniverseArithmeticOperator.ABS, constr);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code addition} operator.
     *
     * @param constrs The constraints on which to apply the operator.
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint add(IIntensionConstraint... constrs) {
        return nary(UniverseArithmeticOperator.ADD, constrs);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code addition} operator.
     *
     * @param constrs The constraints on which to apply the operator.
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint add(List<IIntensionConstraint> constrs) {
        return nary(UniverseArithmeticOperator.ADD, constrs);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code subtraction} operator.
     *
     * @param left The left constraint on which the operator is applied.
     * @param right The right constraint on which the operator is applied.
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint sub(IIntensionConstraint left, IIntensionConstraint right) {
        return binary(UniverseArithmeticOperator.SUB, left, right);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code multiplication}
     * operator.
     *
     * @param constrs The constraints on which to apply the operator.
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint mult(IIntensionConstraint... constrs) {
        return nary(UniverseArithmeticOperator.MULT, constrs);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code multiplication}
     * operator.
     *
     * @param constrs The constraints on which to apply the operator.
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint mult(List<IIntensionConstraint> constrs) {
        return nary(UniverseArithmeticOperator.MULT, constrs);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code division} operator.
     *
     * @param left The left constraint on which the operator is applied.
     * @param right The right constraint on which the operator is applied.
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint div(IIntensionConstraint left, IIntensionConstraint right) {
        return binary(UniverseArithmeticOperator.DIV, left, right);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code modulo} operator.
     *
     * @param left The left constraint on which the operator is applied.
     * @param right The right constraint on which the operator is applied.
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint mod(IIntensionConstraint left, IIntensionConstraint right) {
        return binary(UniverseArithmeticOperator.MOD, left, right);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code square} operator.
     *
     * @param constr The constraint on which to apply the operator.
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint sqr(IIntensionConstraint constr) {
        return unary(UniverseArithmeticOperator.SQR, constr);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code power} operator.
     *
     * @param constr The left constraint on which the operator is applied.
     * @param exponent The exponent in the power operation
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint pow(IIntensionConstraint constr, IIntensionConstraint exponent) {
        return binary(UniverseArithmeticOperator.POW, constr, exponent);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code minimum} operator.
     *
     * @param constrs The constraints on which to apply the operator.
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint min(IIntensionConstraint... constrs) {
        return nary(UniverseArithmeticOperator.MIN, constrs);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code minimum} operator.
     *
     * @param constrs The constraints on which to apply the operator.
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint min(List<IIntensionConstraint> constrs) {
        return nary(UniverseArithmeticOperator.MIN, constrs);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code maximum} operator.
     *
     * @param constrs The constraints on which to apply the operator.
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint max(IIntensionConstraint... constrs) {
        return nary(UniverseArithmeticOperator.MAX, constrs);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code maximum} operator.
     *
     * @param constrs The constraints on which to apply the operator.
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint max(List<IIntensionConstraint> constrs) {
        return nary(UniverseArithmeticOperator.MAX, constrs);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code distance} operator.
     *
     * @param left The left constraint on which the operator is applied.
     * @param right The right constraint on which the operator is applied.
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint dist(IIntensionConstraint left, IIntensionConstraint right) {
        return binary(UniverseArithmeticOperator.DIST, left, right);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code less-than} operator.
     *
     * @param left The left constraint on which the operator is applied.
     * @param right The right constraint on which the operator is applied.
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint lt(IIntensionConstraint left, IIntensionConstraint right) {
        return binary(UniverseRelationalOperator.LT, left, right);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code less-or-equal}
     * operator.
     *
     * @param left The left constraint on which the operator is applied.
     * @param right The right constraint on which the operator is applied.
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint le(IIntensionConstraint left, IIntensionConstraint right) {
        return binary(UniverseRelationalOperator.LE, left, right);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code equal} operator.
     *
     * @param constrs The constraints on which to apply the operator.
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint eq(IIntensionConstraint... constrs) {
        return nary(UniverseBooleanOperator.EQUIV, constrs);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code equal} operator.
     *
     * @param constrs The constraints on which to apply the operator.
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint eq(List<IIntensionConstraint> constrs) {
        return nary(UniverseBooleanOperator.EQUIV, constrs);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code different} operator.
     *
     * @param left The left constraint on which the operator is applied.
     * @param right The right constraint on which the operator is applied.
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint neq(IIntensionConstraint left, IIntensionConstraint right) {
        return binary(UniverseRelationalOperator.NEQ, left, right);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code greater-or-equal}
     * operator.
     *
     * @param left The left constraint on which the operator is applied.
     * @param right The right constraint on which the operator is applied.
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint ge(IIntensionConstraint left, IIntensionConstraint right) {
        return binary(UniverseRelationalOperator.GE, left, right);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code greater-than} operator.
     *
     * @param left The left constraint on which the operator is applied.
     * @param right The right constraint on which the operator is applied.
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint gt(IIntensionConstraint left, IIntensionConstraint right) {
        return binary(UniverseRelationalOperator.GT, left, right);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code not} operator.
     *
     * @param constr The constraint on which to apply the operator.
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint not(IIntensionConstraint constr) {
        return unary(UniverseBooleanOperator.NOT, constr);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code conjunction} operator.
     *
     * @param constrs The constraints on which to apply the operator.
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint and(IIntensionConstraint... constrs) {
        return nary(UniverseBooleanOperator.AND, constrs);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code conjunction} operator.
     *
     * @param constrs The constraints on which to apply the operator.
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint and(List<IIntensionConstraint> constrs) {
        return nary(UniverseBooleanOperator.AND, constrs);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code disjunction} operator.
     *
     * @param constrs The constraints on which to apply the operator.
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint or(IIntensionConstraint... constrs) {
        return nary(UniverseBooleanOperator.OR, constrs);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code disjunction} operator.
     *
     * @param constrs The constraints on which to apply the operator.
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint or(List<IIntensionConstraint> constrs) {
        return nary(UniverseBooleanOperator.OR, constrs);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code exclusive-disjunction}
     * operator.
     *
     * @param constrs The constraints on which to apply the operator.
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint xor(IIntensionConstraint... constrs) {
        return nary(UniverseBooleanOperator.XOR, constrs);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code exclusive-disjunction}
     * operator.
     *
     * @param constrs The constraints on which to apply the operator.
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint xor(List<IIntensionConstraint> constrs) {
        return nary(UniverseBooleanOperator.XOR, constrs);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code equivalence} operator.
     *
     * @param constrs The constraints on which to apply the operator.
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint equiv(IIntensionConstraint... constrs) {
        return nary(UniverseBooleanOperator.EQUIV, constrs);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code equivalence} operator.
     *
     * @param constrs The constraints on which to apply the operator.
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint equiv(List<IIntensionConstraint> constrs) {
        return nary(UniverseBooleanOperator.EQUIV, constrs);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code implication}
     * operator.
     *
     * @param left The left constraint on which the operator is applied.
     * @param right The right constraint on which the operator is applied.
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint impl(IIntensionConstraint left, IIntensionConstraint right) {
        return binary(UniverseBooleanOperator.IMPL, left, right);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code if-then-else} operator.
     *
     * @param condition The condition of the constraint.
     * @param ifTrue The intension constraint corresponding to the case in which the
     *        condition evaluates to {@code true}.
     * @param ifFalse The intension constraint corresponding to the case in which the
     *        condition evaluates to {@code false}.
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint ite(IIntensionConstraint condition,
            IIntensionConstraint ifTrue, IIntensionConstraint ifFalse) {
        return new IfThenElseIntensionConstraint(condition, ifTrue, ifFalse);
    }

    /**
     * Creates a new unary {@code intension} constraint.
     *
     * @param operator The operator applied by the constraint.
     * @param constr The constraint on which the operator is applied.
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint unary(UniverseOperator operator, IIntensionConstraint constr) {
        return new UnaryIntensionConstraint(operator, constr);
    }

    /**
     * Creates a new binary {@code intension} constraint.
     *
     * @param operator The operator applied by the constraint.
     * @param left The left constraint on which the operator is applied.
     * @param right The right constraint on which the operator is applied.
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint binary(UniverseOperator operator, IIntensionConstraint left,
            IIntensionConstraint right) {
        return new BinaryIntensionConstraint(operator, left, right);
    }

    /**
     * Creates a new n-ary {@code intension} constraint.
     *
     * @param operator The operator applied by the constraint.
     * @param constrs The constraints on which the operator is applied.
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint nary(UniverseOperator operator, IIntensionConstraint... constrs) {
        return nary(operator, List.of(constrs));
    }

    /**
     * Creates a new n-ary {@code intension} constraint.
     *
     * @param operator The operator applied by the constraint.
     * @param constrs The constraints on which the operator is applied.
     *
     * @return The created {@code intension} constraint.
     */
    public static IIntensionConstraint nary(UniverseOperator operator, List<IIntensionConstraint> constrs) {
        return new NaryIntensionConstraint(operator, constrs);
    }

}
