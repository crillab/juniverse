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

import java.math.BigInteger;
import java.util.List;

import fr.univartois.cril.juniverse.csp.operator.UniverseArithmeticOperator;
import fr.univartois.cril.juniverse.csp.operator.UniverseBooleanOperator;
import fr.univartois.cril.juniverse.csp.operator.UniverseOperator;
import fr.univartois.cril.juniverse.csp.operator.UniverseRelationalOperator;
import fr.univartois.cril.juniverse.csp.operator.UniverseSetBelongingOperator;

/**
 * The UniverseIntensionConstraintFactory makes easier the construction of {@code intension}
 * constraints from the solver's API, by providing a functional notation similar to that
 * used to define the constraints using XCSP3.
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.2.0
 */
public final class UniverseIntensionConstraintFactory {

    /**
     * Disables instantiation.
     */
    private UniverseIntensionConstraintFactory() {
        throw new AssertionError("No IntensionConstraintFactory instances for you!");
    }

    /**
     * Wraps a constant value in its representation as an {@code intension} constraint.
     *
     * @param value The value of the constant.
     *
     * @return The created {@code intension} constraint.
     */
    public static IUniverseIntensionConstraint constant(long value) {
        return new UniverseConstantIntensionConstraint(BigInteger.valueOf(value));
    }

    /**
     * Wraps a constant value in its representation as an {@code intension} constraint.
     *
     * @param value The value of the constant.
     *
     * @return The created {@code intension} constraint.
     */
    public static IUniverseIntensionConstraint constant(BigInteger value) {
        return new UniverseConstantIntensionConstraint(value);
    }

    /**
     * Wraps a variable in its representation as an {@code intension} constraint.
     *
     * @param id The identifier of the variable.
     *
     * @return The created {@code intension} constraint.
     */
    public static IUniverseIntensionConstraint variable(String id) {
        return new UniverseVariableIntensionConstraint(id);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code opposite} operator.
     *
     * @param constr The constraint on which to apply the operator.
     *
     * @return The created {@code intension} constraint.
     */
    public static IUniverseIntensionConstraint neg(IUniverseIntensionConstraint constr) {
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
    public static IUniverseIntensionConstraint abs(IUniverseIntensionConstraint constr) {
        return unary(UniverseArithmeticOperator.ABS, constr);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code addition} operator.
     *
     * @param constrs The constraints on which to apply the operator.
     *
     * @return The created {@code intension} constraint.
     */
    public static IUniverseIntensionConstraint add(IUniverseIntensionConstraint... constrs) {
        return nary(UniverseArithmeticOperator.ADD, constrs);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code addition} operator.
     *
     * @param constrs The constraints on which to apply the operator.
     *
     * @return The created {@code intension} constraint.
     */
    public static IUniverseIntensionConstraint add(List<IUniverseIntensionConstraint> constrs) {
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
    public static IUniverseIntensionConstraint sub(IUniverseIntensionConstraint left, IUniverseIntensionConstraint right) {
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
    public static IUniverseIntensionConstraint mult(IUniverseIntensionConstraint... constrs) {
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
    public static IUniverseIntensionConstraint mult(List<IUniverseIntensionConstraint> constrs) {
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
    public static IUniverseIntensionConstraint div(IUniverseIntensionConstraint left, IUniverseIntensionConstraint right) {
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
    public static IUniverseIntensionConstraint mod(IUniverseIntensionConstraint left, IUniverseIntensionConstraint right) {
        return binary(UniverseArithmeticOperator.MOD, left, right);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code square} operator.
     *
     * @param constr The constraint on which to apply the operator.
     *
     * @return The created {@code intension} constraint.
     */
    public static IUniverseIntensionConstraint sqr(IUniverseIntensionConstraint constr) {
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
    public static IUniverseIntensionConstraint pow(IUniverseIntensionConstraint constr,
            IUniverseIntensionConstraint exponent) {
        return binary(UniverseArithmeticOperator.POW, constr, exponent);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code minimum} operator.
     *
     * @param constrs The constraints on which to apply the operator.
     *
     * @return The created {@code intension} constraint.
     */
    public static IUniverseIntensionConstraint min(IUniverseIntensionConstraint... constrs) {
        return nary(UniverseArithmeticOperator.MIN, constrs);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code minimum} operator.
     *
     * @param constrs The constraints on which to apply the operator.
     *
     * @return The created {@code intension} constraint.
     */
    public static IUniverseIntensionConstraint min(List<IUniverseIntensionConstraint> constrs) {
        return nary(UniverseArithmeticOperator.MIN, constrs);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code maximum} operator.
     *
     * @param constrs The constraints on which to apply the operator.
     *
     * @return The created {@code intension} constraint.
     */
    public static IUniverseIntensionConstraint max(IUniverseIntensionConstraint... constrs) {
        return nary(UniverseArithmeticOperator.MAX, constrs);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code maximum} operator.
     *
     * @param constrs The constraints on which to apply the operator.
     *
     * @return The created {@code intension} constraint.
     */
    public static IUniverseIntensionConstraint max(List<IUniverseIntensionConstraint> constrs) {
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
    public static IUniverseIntensionConstraint dist(IUniverseIntensionConstraint left, IUniverseIntensionConstraint right) {
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
    public static IUniverseIntensionConstraint lt(IUniverseIntensionConstraint left, IUniverseIntensionConstraint right) {
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
    public static IUniverseIntensionConstraint le(IUniverseIntensionConstraint left, IUniverseIntensionConstraint right) {
        return binary(UniverseRelationalOperator.LE, left, right);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code equal} operator.
     *
     * @param constrs The constraints on which to apply the operator.
     *
     * @return The created {@code intension} constraint.
     */
    public static IUniverseIntensionConstraint eq(IUniverseIntensionConstraint... constrs) {
        return nary(UniverseBooleanOperator.EQUIV, constrs);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code equal} operator.
     *
     * @param constrs The constraints on which to apply the operator.
     *
     * @return The created {@code intension} constraint.
     */
    public static IUniverseIntensionConstraint eq(List<IUniverseIntensionConstraint> constrs) {
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
    public static IUniverseIntensionConstraint neq(IUniverseIntensionConstraint left, IUniverseIntensionConstraint right) {
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
    public static IUniverseIntensionConstraint ge(IUniverseIntensionConstraint left, IUniverseIntensionConstraint right) {
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
    public static IUniverseIntensionConstraint gt(IUniverseIntensionConstraint left, IUniverseIntensionConstraint right) {
        return binary(UniverseRelationalOperator.GT, left, right);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code not} operator.
     *
     * @param constr The constraint on which to apply the operator.
     *
     * @return The created {@code intension} constraint.
     */
    public static IUniverseIntensionConstraint not(IUniverseIntensionConstraint constr) {
        return unary(UniverseBooleanOperator.NOT, constr);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code conjunction} operator.
     *
     * @param constrs The constraints on which to apply the operator.
     *
     * @return The created {@code intension} constraint.
     */
    public static IUniverseIntensionConstraint and(IUniverseIntensionConstraint... constrs) {
        return nary(UniverseBooleanOperator.AND, constrs);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code conjunction} operator.
     *
     * @param constrs The constraints on which to apply the operator.
     *
     * @return The created {@code intension} constraint.
     */
    public static IUniverseIntensionConstraint and(List<IUniverseIntensionConstraint> constrs) {
        return nary(UniverseBooleanOperator.AND, constrs);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code disjunction} operator.
     *
     * @param constrs The constraints on which to apply the operator.
     *
     * @return The created {@code intension} constraint.
     */
    public static IUniverseIntensionConstraint or(IUniverseIntensionConstraint... constrs) {
        return nary(UniverseBooleanOperator.OR, constrs);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code disjunction} operator.
     *
     * @param constrs The constraints on which to apply the operator.
     *
     * @return The created {@code intension} constraint.
     */
    public static IUniverseIntensionConstraint or(List<IUniverseIntensionConstraint> constrs) {
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
    public static IUniverseIntensionConstraint xor(IUniverseIntensionConstraint... constrs) {
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
    public static IUniverseIntensionConstraint xor(List<IUniverseIntensionConstraint> constrs) {
        return nary(UniverseBooleanOperator.XOR, constrs);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code equivalence} operator.
     *
     * @param constrs The constraints on which to apply the operator.
     *
     * @return The created {@code intension} constraint.
     */
    public static IUniverseIntensionConstraint equiv(IUniverseIntensionConstraint... constrs) {
        return nary(UniverseBooleanOperator.EQUIV, constrs);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code equivalence} operator.
     *
     * @param constrs The constraints on which to apply the operator.
     *
     * @return The created {@code intension} constraint.
     */
    public static IUniverseIntensionConstraint equiv(List<IUniverseIntensionConstraint> constrs) {
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
    public static IUniverseIntensionConstraint impl(IUniverseIntensionConstraint left, IUniverseIntensionConstraint right) {
        return binary(UniverseBooleanOperator.IMPL, left, right);
    }

    /**
     * Creates an {@code intension} constraint applying the {@code in} operator w.r.t. a
     * range of values.
     *
     * @param constraint The constraint that should be in the range.
     * @param min The minimum value in the range.
     * @param max The maximum value in the range.
     *
     * @return The created {@code intension} constraint.
     */
    public static IUniverseIntensionConstraint in(IUniverseIntensionConstraint constraint,
            BigInteger min, BigInteger max) {
        return binary(UniverseSetBelongingOperator.IN, constraint,
                new UniverseRangeIntensionConstraint(min, max));
    }

    /**
     * Creates an {@code intension} constraint applying the {@code in} operator w.r.t. a
     * set.
     *
     * @param constraint The constraint that should be in the range.
     * @param constrs The constraints in the set.
     *
     * @return The created {@code intension} constraint.
     */
    public static IUniverseIntensionConstraint in(IUniverseIntensionConstraint constraint,
            IUniverseIntensionConstraint... constrs) {
        return binary(UniverseSetBelongingOperator.IN, constraint,
                new UniverseSetIntensionConstraint(List.of(constrs)));
    }

    /**
     * Creates an {@code intension} constraint applying the {@code in} operator w.r.t. a
     * set.
     *
     * @param constraint The constraint that should be in the range.
     * @param constrs The constraints in the set.
     *
     * @return The created {@code intension} constraint.
     */
    public static IUniverseIntensionConstraint in(IUniverseIntensionConstraint constraint,
            List<IUniverseIntensionConstraint> constrs) {
        return binary(UniverseSetBelongingOperator.IN, constraint,
                new UniverseSetIntensionConstraint(constrs));
    }

    /**
     * Creates an {@code intension} constraint applying the {@code not-in} operator w.r.t.
     * a range of values.
     *
     * @param constraint The constraint that should be in the range.
     * @param min The minimum value in the range.
     * @param max The maximum value in the range.
     *
     * @return The created {@code intension} constraint.
     */
    public static IUniverseIntensionConstraint notIn(IUniverseIntensionConstraint constraint,
            BigInteger min, BigInteger max) {
        return binary(UniverseSetBelongingOperator.NOT_IN, constraint,
                new UniverseRangeIntensionConstraint(min, max));
    }

    /**
     * Creates an {@code intension} constraint applying the {@code not-in} operator w.r.t.
     * a set.
     *
     * @param constraint The constraint that should be in the range.
     * @param constrs The constraints in the set.
     *
     * @return The created {@code intension} constraint.
     */
    public static IUniverseIntensionConstraint notIn(IUniverseIntensionConstraint constraint,
            IUniverseIntensionConstraint... constrs) {
        return binary(UniverseSetBelongingOperator.NOT_IN, constraint,
                new UniverseSetIntensionConstraint(List.of(constrs)));
    }

    /**
     * Creates an {@code intension} constraint applying the {@code not-in} operator w.r.t.
     * a set.
     *
     * @param constraint The constraint that should be in the range.
     * @param constrs The constraints in the set.
     *
     * @return The created {@code intension} constraint.
     */
    public static IUniverseIntensionConstraint notIn(IUniverseIntensionConstraint constraint,
            List<IUniverseIntensionConstraint> constrs) {
        return binary(UniverseSetBelongingOperator.NOT_IN, constraint,
                new UniverseSetIntensionConstraint(constrs));
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
    public static IUniverseIntensionConstraint ite(IUniverseIntensionConstraint condition,
            IUniverseIntensionConstraint ifTrue, IUniverseIntensionConstraint ifFalse) {
        return new UniverseIfThenElseIntensionConstraint(condition, ifTrue, ifFalse);
    }

    /**
     * Creates a new unary {@code intension} constraint.
     *
     * @param operator The operator applied by the constraint.
     * @param constr The constraint on which the operator is applied.
     *
     * @return The created {@code intension} constraint.
     */
    public static IUniverseIntensionConstraint unary(UniverseOperator operator,
            IUniverseIntensionConstraint constr) {
        return new UniverseUnaryIntensionConstraint(operator, constr);
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
    public static IUniverseIntensionConstraint binary(UniverseOperator operator, IUniverseIntensionConstraint left,
            IUniverseIntensionConstraint right) {
        return new UniverseBinaryIntensionConstraint(operator, left, right);
    }

    /**
     * Creates a new n-ary {@code intension} constraint.
     *
     * @param operator The operator applied by the constraint.
     * @param constrs The constraints on which the operator is applied.
     *
     * @return The created {@code intension} constraint.
     */
    public static IUniverseIntensionConstraint nary(UniverseOperator operator,
            IUniverseIntensionConstraint... constrs) {
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
    public static IUniverseIntensionConstraint nary(UniverseOperator operator,
            List<IUniverseIntensionConstraint> constrs) {
        return new UniverseNaryIntensionConstraint(operator, constrs);
    }

}
