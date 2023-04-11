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

package fr.univartois.cril.juniverse.csp;

import java.math.BigInteger;
import java.util.List;

import fr.univartois.cril.juniverse.core.UniverseContradictionException;
import fr.univartois.cril.juniverse.csp.intension.IUniverseIntensionConstraint;
import fr.univartois.cril.juniverse.csp.operator.UniverseArithmeticOperator;
import fr.univartois.cril.juniverse.csp.operator.UniverseBooleanOperator;
import fr.univartois.cril.juniverse.csp.operator.UniverseRelationalOperator;
import fr.univartois.cril.juniverse.csp.operator.UniverseSetBelongingOperator;
import fr.univartois.cril.juniverse.pb.IUniversePseudoBooleanSolver;

/**
 * The IUniverseCSPSolver interface defines the contract for CSP solvers.
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.2.0
 */
public interface IUniverseCSPSolver extends IUniversePseudoBooleanSolver {

    /**
     * Adds a new variable to this solver.
     *
     * @param id The identifier of the variable to create.
     * @param min The minimum value of the domain of the variable.
     * @param max The maximum value of the domain of the variable.
     */
    void newVariable(String id, int min, int max);

    /**
     * Adds a new variable to this solver.
     *
     * @param id The identifier of the variable to create.
     * @param min The minimum value of the domain of the variable.
     * @param max The maximum value of the domain of the variable.
     */
    void newVariable(String id, BigInteger min, BigInteger max);

    /**
     * Adds a new variable to this solver.
     *
     * @param id The identifier of the variable to create.
     * @param values The values of the domain of the variable.
     */
    void newVariable(String id, List<? extends Number> values);

    /**
     * Adds a new symbolic variable to this solver.
     *
     * @param id The identifier of the variable to create.
     * @param values The values of the domain of the variable.
     */
    void newVariableSymbolic(String id, List<String> values);

    /**
     * Adds an {@code instantiation} constraint to this solver.
     *
     * @param variable The variable to assign.
     * @param value The value to assign to the variable.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addInstantiation(String variable, int value);

    /**
     * Adds an {@code instantiation} constraint to this solver.
     *
     * @param variable The variable to assign.
     * @param value The value to assign to the variable.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addInstantiation(String variable, BigInteger value);

    /**
     * Adds an {@code instantiation} constraint to this solver.
     *
     * @param variable The symbolic variable to assign.
     * @param value The value to assign to the variable.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addInstantiationSymbolic(String variable, String value);

    /**
     * Adds an {@code instantiation} constraint to this solver.
     *
     * @param variables The variables to assign.
     * @param values The values to assign to the variables.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addInstantiation(List<String> variables, List<? extends Number> values);

    /**
     * Adds an {@code instantiation} constraint to this solver.
     *
     * @param variables The variables to assign.
     * @param values The values to assign to the variables.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addInstantiationSymbolic(List<String> variables, List<String> values);

    /**
     * Adds a {@code clause} constraint to this solver.
     *
     * @param positive The (Boolean) variables appearing positively in the clause.
     * @param negative The (Boolean) variables appearing negatively in the clause.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addClause(List<String> positive, List<String> negative);

    /**
     * Adds a {@code logical} constraint to this solver.
     *
     * @param operator The Boolean operator to apply on the variables.
     * @param variables The (Boolean) variables on which the operator is applied.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addLogical(UniverseBooleanOperator operator, List<String> variables);

    /**
     * Adds a {@code logical} constraint to this solver.
     *
     * @param variable The (Boolean) variable whose assignment depends on the truth
     *        value of the logical operations.
     * @param equiv Whether {@code variable} must be equivalent to the truth
     *        value of the logical operations.
     * @param operator The Boolean operator to apply on the variables.
     * @param variables The (Boolean) variables on which the operator is applied.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addLogical(String variable, boolean equiv, UniverseBooleanOperator operator,
            List<String> variables);

    /**
     * Adds a {@code logical} constraint to this solver.
     *
     * @param variable The (Boolean) variable whose assignment depends on the truth
     *        value of the comparison between {@code left} and {@code right}.
     * @param left The variable on the left-hand side of the comparison.
     * @param operator The relational operator used to compare {@code left} and
     *        {@code right}.
     * @param right The value on the right-hand side of the comparison.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addLogical(String variable, String left, UniverseRelationalOperator operator,
            BigInteger right);

    /**
     * Adds a {@code logical} constraint to this solver.
     *
     * @param variable The (Boolean) variable whose assignment depends on the truth
     *        value of the comparison between {@code left} and {@code right}.
     * @param left The variable on the left-hand side of the comparison.
     * @param operator The relational operator used to compare {@code left} and
     *        {@code right}.
     * @param right The variable on the right-hand side of the comparison.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addLogical(String variable, String left, UniverseRelationalOperator operator,
            String right);

    /**
     * Adds an {@code all-different} constraint to this solver.
     *
     * @param variables The variables that should all be different.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addAllDifferent(List<String> variables);

    /**
     * Adds an {@code all-different} constraint to this solver.
     *
     * @param variables The variables that should all be different.
     * @param except The values not to consider in the constraint.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addAllDifferent(List<String> variables, List<BigInteger> except);

    /**
     * Adds an {@code all-different} constraint to this solver.
     *
     * @param variableMatrix The matrix of variables that should all be different.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addAllDifferentMatrix(List<List<String>> variableMatrix);

    /**
     * Adds an {@code all-different} constraint to this solver.
     *
     * @param variableMatrix The matrix of variables that should all be different.
     * @param except The values not to consider in the constraint.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addAllDifferentMatrix(List<List<String>> variableMatrix, List<BigInteger> except);

    /**
     * Adds an {@code all-different} constraint to this solver.
     *
     * @param variableLists The lists of variables that should all be different.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addAllDifferentList(List<List<String>> variableLists);

    /**
     * Adds an {@code all-different} constraint to this solver.
     *
     * @param variableLists The lists of variables that should all be different.
     * @param except The values not to consider in the constraint.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addAllDifferentList(List<List<String>> variableLists, List<List<BigInteger>> except);

    /**
     * Adds an {@code all-different} constraint to this solver.
     *
     * @param intensionConstraints The intension constraints that should all be different.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addAllDifferentIntension(List<IUniverseIntensionConstraint> intensionConstraints);

    /**
     * Adds a {@code channel} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param startIndex The index at which the constraint starts.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addChannel(List<String> variables, int startIndex);

    /**
     * Adds a {@code channel} constraint to this solver.
     *
     * @param variables The variables among which exactly one should be satisfied starting
     *        from the given index.
     * @param startIndex The index at which the constraint starts.
     * @param value The variable containing the index of the satisfied variable.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addChannel(List<String> variables, int startIndex, String value);

    /**
     * Adds a {@code channel} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param startIndex The index at which the constraint starts on the first vector of
     *        variables.
     * @param otherVariables The variables with which to channel the variables of the
     *        first vector.
     * @param otherStartIndex The index at which the constraint starts on the second
     *        vector of variables.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addChannel(List<String> variables, int startIndex, List<String> otherVariables,
            int otherStartIndex);

    /**
     * Adds a {@code cardinality} constraint to this solver.
     *
     * @param variables The variables to count the assignments of.
     * @param values The assignable values to count.
     * @param occurs The number of times each value can be assigned.
     * @param closed Whether only the values in {@code value} can be assigned to the
     *        variables.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCardinalityWithConstantValuesAndConstantCounts(List<String> variables,
            List<BigInteger> values, List<BigInteger> occurs, boolean closed);

    /**
     * Adds a {@code cardinality} constraint to this solver.
     *
     * @param variables The variables to count the assignments of.
     * @param values The assignable values to count.
     * @param occursMin The minimum number of times each value can be assigned.
     * @param occursMax The maximum number of times each value can be assigned.
     * @param closed Whether only the values in {@code value} can be assigned to the
     *        variables.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCardinalityWithConstantValuesAndConstantIntervalCounts(List<String> variables,
            List<BigInteger> values, List<BigInteger> occursMin, List<BigInteger> occursMax,
            boolean closed);

    /**
     * Adds a {@code cardinality} constraint to this solver.
     *
     * @param variables The variables to count the assignments of.
     * @param values The assignable values to count.
     * @param occurs The variables encoding the number of times each value can be
     *        assigned.
     * @param closed Whether only the values in {@code value} can be assigned to the
     *        variables.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCardinalityWithConstantValuesAndVariableCounts(List<String> variables,
            List<BigInteger> values, List<String> occurs, boolean closed);

    /**
     * Adds a {@code cardinality} constraint to this solver.
     *
     * @param variables The variables to count the assignments of.
     * @param values The variables encoding the assignable values to count.
     * @param occurs The number of times each value can be assigned.
     * @param closed Whether only the values in {@code value} can be assigned to the
     *        variables.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCardinalityWithVariableValuesAndConstantCounts(List<String> variables,
            List<String> values, List<BigInteger> occurs, boolean closed);

    /**
     * Adds a {@code cardinality} constraint to this solver.
     *
     * @param variables The variables to count the assignments of.
     * @param values The variables encoding the assignable values to count.
     * @param occursMin The minimum number of times each value can be assigned.
     * @param occursMax The maximum number of times each value can be assigned.
     * @param closed Whether only the values in {@code value} can be assigned to the
     *        variables.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCardinalityWithVariableValuesAndConstantIntervalCounts(List<String> variables,
            List<String> values, List<BigInteger> occursMin, List<BigInteger> occursMax,
            boolean closed);

    /**
     * Adds a {@code cardinality} constraint to this solver.
     *
     * @param variables The variables to count the assignments of.
     * @param values The variables encoding the assignable values to count.
     * @param occurs The variables encoding the number of times each value can be
     *        assigned.
     * @param closed Whether only the values in {@code value} can be assigned to the
     *        variables.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCardinalityWithVariableValuesAndVariableCounts(List<String> variables,
            List<String> values, List<String> occurs, boolean closed);

    /**
     * Adds an {@code at-least} constraint to this solver.
     *
     * @param variables The variables to count the assignments of.
     * @param value The value to count the assignments of.
     * @param count The minimum number of times the value can be assigned among the
     *        variables.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addAtLeast(List<String> variables, BigInteger value, BigInteger count);

    /**
     * Adds an {@code exactly} constraint to this solver.
     *
     * @param variables The variables to count the assignments of.
     * @param value The value to count the assignments of.
     * @param count The number of times the value can be assigned among the variables.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addExactly(List<String> variables, BigInteger value, BigInteger count);

    /**
     * Adds an {@code exactly} constraint to this solver.
     *
     * @param variables The variables to count the assignments of.
     * @param value The value to count the assignments of.
     * @param count The variable encoding the number of times the value can be assigned
     *        among the variables.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addExactly(List<String> variables, BigInteger value, String count);

    /**
     * Adds an {@code among} constraint to this solver.
     *
     * @param variables The variables to count the assignments of.
     * @param values The values to count the assignments of.
     * @param count The number of times the value can be assigned among the variables.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addAmong(List<String> variables, List<BigInteger> values, BigInteger count);

    /**
     * Adds an {@code among} constraint to this solver.
     *
     * @param variables The variables to count the assignments of.
     * @param values The values to count the assignments of.
     * @param count The variable encoding the number of times the values can be assigned
     *        among the variables.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addAmong(List<String> variables, List<BigInteger> values, String count);

    /**
     * Adds an {@code at-most} constraint to this solver.
     *
     * @param variables The variables to count the assignments of.
     * @param value The value to count the assignments of.
     * @param count The maximum number of times the value can be assigned among
     *        the variables.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addAtMost(List<String> variables, BigInteger value, BigInteger count);

    /**
     * Adds a {@code count} constraint to this solver.
     *
     * @param variables The variables to count the assignments of.
     * @param values The values to count the assignments of.
     * @param operator The operator to use to compare the number of assignments to
     *        their expected count.
     * @param count The number of times the values can be assigned among the
     *        variables.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCountWithConstantValues(List<String> variables, List<BigInteger> values,
            UniverseRelationalOperator operator, BigInteger count);

    /**
     * Adds a {@code count} constraint to this solver.
     *
     * @param variables The variables to count the assignments of.
     * @param values The values to count the assignments of.
     * @param operator The operator to use to compare the number of assignments to
     *        their expected count.
     * @param count The variable encoding the number of times the values can be
     *        assigned among the variables.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCountWithConstantValues(List<String> variables, List<BigInteger> values,
            UniverseRelationalOperator operator, String count);

    /**
     * Adds a {@code count} constraint to this solver.
     *
     * @param variables The variables to count the assignments of.
     * @param values The values to count the assignments of.
     * @param operator The operator to use to check whether the number of assignments is
     *        within a set.
     * @param min The minimum number of times the value can be assigned among
     *        the variables.
     * @param max The maximum number of times the value can be assigned among
     *        the variables.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCountWithConstantValues(List<String> variables, List<BigInteger> values,
            UniverseSetBelongingOperator operator, BigInteger min, BigInteger max);

    /**
     * Adds a {@code count} constraint to this solver.
     *
     * @param variables The variables to count the assignments of.
     * @param values The values to count the assignments of.
     * @param operator The operator to use to check whether the number of assignments is
     *        within a set.
     * @param set The set containing the allowed numbers of times the values can be
     *        assigned among the variables.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCountWithConstantValues(List<String> variables, List<BigInteger> values,
            UniverseSetBelongingOperator operator, List<BigInteger> set);

    /**
     * Adds a {@code count} constraint to this solver.
     *
     * @param variables The variables to count the assignments of.
     * @param values The variables encoding the values to count the assignments of.
     * @param operator The operator to use to compare the number of assignments to
     *        their expected count.
     * @param count The number of times the values can be assigned among the
     *        variables.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCountWithVariableValues(List<String> variables, List<String> values,
            UniverseRelationalOperator operator, BigInteger count);

    /**
     * Adds a {@code count} constraint to this solver.
     *
     * @param variables The variables to count the assignments of.
     * @param values The variables encoding the values to count the assignments of.
     * @param operator The operator to use to compare the number of assignments to
     *        their expected count.
     * @param count The variable encoding the number of times the values can be
     *        assigned among the variables.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCountWithVariableValues(List<String> variables, List<String> values,
            UniverseRelationalOperator operator, String count);

    /**
     * Adds a {@code count} constraint to this solver.
     *
     * @param variables The variables to count the assignments of.
     * @param values The variables encoding the values to count the assignments of.
     * @param operator The operator to use to check whether the number of assignments is
     *        within a set.
     * @param min The minimum number of times the value can be assigned among
     *        the variables.
     * @param max The maximum number of times the value can be assigned among
     *        the variables.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCountWithVariableValues(List<String> variables, List<String> values,
            UniverseSetBelongingOperator operator, BigInteger min, BigInteger max);

    /**
     * Adds a {@code count} constraint to this solver.
     *
     * @param variables The variables to count the assignments of.
     * @param values The variables encoding the values to count the assignments of.
     * @param operator The operator to use to check whether the number of assignments is
     *        within a set.
     * @param set The set containing the allowed numbers of times the values can be
     *        assigned among the variables.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCountWithVariableValues(List<String> variables, List<String> values,
            UniverseSetBelongingOperator operator, List<BigInteger> set);

    /**
     * Adds a {@code count} constraint to this solver.
     *
     * @param expressions The expressions to count the assignments of.
     * @param values The values to count the assignments of.
     * @param operator The operator to use to compare the number of assignments
     *        to their expected count.
     * @param count The number of times the values can be assigned among the
     *        variables.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCountIntensionWithConstantValues(List<IUniverseIntensionConstraint> expressions,
            List<BigInteger> values, UniverseRelationalOperator operator, BigInteger count);

    /**
     * Adds a {@code count} constraint to this solver.
     *
     * @param expressions The expressions to count the assignments of.
     * @param values The values to count the assignments of.
     * @param operator The operator to use to compare the number of assignments
     *        to their expected count.
     * @param count The variable encoding the number of times the values can
     *        be assigned among the variables.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCountIntensionWithConstantValues(List<IUniverseIntensionConstraint> expressions,
            List<BigInteger> values, UniverseRelationalOperator operator, String count);

    /**
     * Adds a {@code count} constraint to this solver.
     *
     * @param expressions The expressions to count the assignments of.
     * @param values The values to count the assignments of.
     * @param operator The operator to use to check whether the number of assignments is
     *        within a set.
     * @param min The minimum number of times the value can be assigned among
     *        the variables.
     * @param max The maximum number of times the value can be assigned among
     *        the variables.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCountIntensionWithConstantValues(List<IUniverseIntensionConstraint> expressions,
            List<BigInteger> values, UniverseSetBelongingOperator operator,
            BigInteger min, BigInteger max);

    /**
     * Adds a {@code count} constraint to this solver.
     *
     * @param expressions The expressions to count the assignments of.
     * @param values The values to count the assignments of.
     * @param operator The operator to use to check whether the number of assignments is
     *        within a set.
     * @param set The set containing the allowed numbers of times the values can be
     *        assigned among the variables.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCountIntensionWithConstantValues(List<IUniverseIntensionConstraint> expressions,
            List<BigInteger> values, UniverseSetBelongingOperator operator, List<BigInteger> set);

    /**
     * Adds an {@code n-values} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param operator The relational operator used in the constraint.
     * @param nb The number of distinct values to count.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addNValues(List<String> variables, UniverseRelationalOperator operator, BigInteger nb);

    /**
     * Adds an {@code n-values} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param operator The relational operator used in the constraint.
     * @param nb The number of distinct values to count.
     * @param except The values that should not be counted.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addNValuesExcept(List<String> variables, UniverseRelationalOperator operator,
            BigInteger nb, List<BigInteger> except);

    /**
     * Adds an {@code n-values} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param operator The relational operator used in the constraint.
     * @param nb The variable counting the number of distinct values.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addNValues(List<String> variables, UniverseRelationalOperator operator, String nb);

    /**
     * Adds an {@code n-values} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param operator The relational operator used in the constraint.
     * @param nb The variable counting the number of distinct values.
     * @param except The values that should not be counted.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addNValuesExcept(List<String> variables, UniverseRelationalOperator operator, String nb,
            List<BigInteger> except);

    /**
     * Adds an {@code n-values} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param operator The set operator used in the constraint.
     * @param min The minimum number of distinct values to count.
     * @param max The maximum number of distinct values to count.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addNValues(List<String> variables, UniverseSetBelongingOperator operator, BigInteger min,
            BigInteger max);

    /**
     * Adds an {@code n-values} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param operator The set operator used in the constraint.
     * @param min The minimum number of distinct values to count.
     * @param max The maximum number of distinct values to count.
     * @param except The values that should not be counted.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addNValuesExcept(List<String> variables, UniverseSetBelongingOperator operator,
            BigInteger min, BigInteger max, List<BigInteger> except);

    /**
     * Adds an {@code n-values} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param operator The set operator used in the constraint.
     * @param set The allowed number of distinct values.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addNValues(List<String> variables, UniverseSetBelongingOperator operator,
            List<BigInteger> set);

    /**
     * Adds an {@code n-values} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param operator The set operator used in the constraint.
     * @param set The allowed number of distinct values.
     * @param except The values that should not be counted.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addNValuesExcept(List<String> variables, UniverseSetBelongingOperator operator,
            List<BigInteger> set, List<BigInteger> except);

    /**
     * Adds an {@code n-values} constraint to this solver.
     *
     * @param expressions The expressions appearing in the constraint.
     * @param operator The relational operator used in the constraint.
     * @param nb The number of distinct values to count.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addNValuesIntension(List<IUniverseIntensionConstraint> expressions,
            UniverseRelationalOperator operator, BigInteger nb);

    /**
     * Adds an {@code n-values} constraint to this solver.
     *
     * @param expressions The expressions appearing in the constraint.
     * @param operator The relational operator used in the constraint.
     * @param nb The variable counting the number of distinct values.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addNValuesIntension(List<IUniverseIntensionConstraint> expressions,
            UniverseRelationalOperator operator, String nb);

    /**
     * Adds an {@code n-values} constraint to this solver.
     *
     * @param expressions The expressions appearing in the constraint.
     * @param operator The set operator used in the constraint.
     * @param min The minimum number of distinct values to count.
     * @param max The maximum number of distinct values to count.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addNValuesIntension(List<IUniverseIntensionConstraint> expressions,
            UniverseSetBelongingOperator operator, BigInteger min, BigInteger max);

    /**
     * Adds an {@code n-values} constraint to this solver.
     *
     * @param expressions The expressions appearing in the constraint.
     * @param operator The set operator used in the constraint.
     * @param set The allowed number of distinct values.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addNValuesIntension(List<IUniverseIntensionConstraint> expressions,
            UniverseSetBelongingOperator operator, List<BigInteger> set);

    /**
     * Adds a {@code bin-packing} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param sizes The sizes of the elements to pack.
     * @param operator The operator used to ensure the capacity of the bin.
     * @param value The value of the bins capacity.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addBinPacking(List<String> variables, List<BigInteger> sizes,
            UniverseRelationalOperator operator, BigInteger value);

    /**
     * Adds a {@code bin-packing} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param sizes The sizes of the elements to pack.
     * @param operator The operator used to ensure the capacity of the bins.
     * @param variable The variable encoding the bins capacity.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addBinPacking(List<String> variables, List<BigInteger> sizes,
            UniverseRelationalOperator operator, String variable);

    /**
     * Adds a {@code bin-packing} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param sizes The sizes of the elements to pack.
     * @param operator The operator used to ensure the capacity of the bins.
     * @param min The minimum capacity of the bins.
     * @param max The maximum capacity of the bins.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addBinPacking(List<String> variables, List<BigInteger> sizes,
            UniverseSetBelongingOperator operator, BigInteger min, BigInteger max);

    /**
     * Adds a {@code bin-packing} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param sizes The sizes of the elements to pack.
     * @param operator The operator used to ensure the capacity of the bins.
     * @param set The allowed capacities for the bins.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addBinPacking(List<String> variables, List<BigInteger> sizes,
            UniverseSetBelongingOperator operator, List<BigInteger> set);

    /**
     * Adds a {@code bin-packing} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param sizes The sizes of the elements to pack.
     * @param capacities The capacities of each bin.
     * @param loads Whether bin loads should be computed.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addBinPackingWithConstantCapacities(List<String> variables, List<BigInteger> sizes,
            List<BigInteger> capacities, boolean loads);

    /**
     * Adds a {@code bin-packing} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param sizes The sizes of the elements to pack.
     * @param capacities The variables encoding the capacities of each bin.
     * @param loads Whether bin loads should be computed.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addBinPackingWithVariableCapacities(List<String> variables, List<BigInteger> sizes,
            List<String> capacities, boolean loads);

    /**
     * Adds a {@code cumulative} constraint to this solver.
     *
     * @param origins The variables encoding the origins of the resources.
     * @param lengths The lengths of the tasks to assign.
     * @param heights The heights of the tasks to assign.
     * @param operator The operator to compare the cumulative use with.
     * @param value The value for the cumulative use.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCumulativeConstantLengthsConstantHeights(List<String> origins, List<BigInteger> lengths,
            List<BigInteger> heights, UniverseRelationalOperator operator, BigInteger value);

    /**
     * Adds a {@code cumulative} constraint to this solver.
     *
     * @param origins The variables encoding the origins of the resources.
     * @param lengths The lengths of the tasks to assign.
     * @param ends The variables encoding the ends of the resources.
     * @param heights The heights of the tasks to assign.
     * @param operator The operator to compare the cumulative use with.
     * @param value The value for the cumulative use.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCumulativeConstantLengthsConstantHeights(List<String> origins, List<BigInteger> lengths,
            List<String> ends, List<BigInteger> heights, UniverseRelationalOperator operator,
            BigInteger value);

    /**
     * Adds a {@code cumulative} constraint to this solver.
     *
     * @param origins The variables encoding the origins of the resources.
     * @param lengths The lengths of the tasks to assign.
     * @param heights The heights of the tasks to assign.
     * @param operator The operator to compare the cumulative use with.
     * @param value The variable encoding the value for the cumulative use.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCumulativeConstantLengthsConstantHeights(List<String> origins, List<BigInteger> lengths,
            List<BigInteger> heights, UniverseRelationalOperator operator, String value);

    /**
     * Adds a {@code cumulative} constraint to this solver.
     *
     * @param origins The variables encoding the origins of the resources.
     * @param lengths The lengths of the tasks to assign.
     * @param ends The variables encoding the ends of the resources.
     * @param heights The heights of the tasks to assign.
     * @param operator The operator to compare the cumulative use with.
     * @param value The variable encoding the value for the cumulative use.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCumulativeConstantLengthsConstantHeights(List<String> origins, List<BigInteger> lengths,
            List<String> ends, List<BigInteger> heights, UniverseRelationalOperator operator,
            String value);

    /**
     * Adds a {@code cumulative} constraint to this solver.
     *
     * @param origins The variables encoding the origins of the resources.
     * @param lengths The lengths of the tasks to assign.
     * @param heights The heights of the tasks to assign.
     * @param operator The operator to use to check whether the cumulative use is
     *        within a set.
     * @param min The minimum cumulative use.
     * @param max The maximum cumulative use.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCumulativeConstantLengthsConstantHeights(List<String> origins, List<BigInteger> lengths,
            List<BigInteger> heights, UniverseSetBelongingOperator operator, BigInteger min,
            BigInteger max);

    /**
     * Adds a {@code cumulative} constraint to this solver.
     *
     * @param origins The variables encoding the origins of the resources.
     * @param lengths The lengths of the tasks to assign.
     * @param ends The variables encoding the ends of the resources.
     * @param heights The heights of the tasks to assign.
     * @param operator The operator to use to check whether the cumulative use is
     *        within a set.
     * @param min The minimum cumulative use.
     * @param max The maximum cumulative use.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCumulativeConstantLengthsConstantHeights(List<String> origins, List<BigInteger> lengths,
            List<String> ends, List<BigInteger> heights, UniverseSetBelongingOperator operator,
            BigInteger min, BigInteger max);

    /**
     * Adds a {@code cumulative} constraint to this solver.
     *
     * @param origins The variables encoding the origins of the resources.
     * @param lengths The lengths of the tasks to assign.
     * @param heights The heights of the tasks to assign.
     * @param operator The operator to use to check whether the number of assignments is
     *        within a set.
     * @param set The set containing the allowed cumulative uses.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCumulativeConstantLengthsConstantHeights(List<String> origins, List<BigInteger> lengths,
            List<BigInteger> heights, UniverseSetBelongingOperator operator, List<BigInteger> set);

    /**
     * Adds a {@code cumulative} constraint to this solver.
     *
     * @param origins The variables encoding the origins of the resources.
     * @param lengths The lengths of the tasks to assign.
     * @param ends The variables encoding the ends of the resources.
     * @param heights The heights of the tasks to assign.
     * @param operator The operator to use to check whether the number of assignments is
     *        within a set.
     * @param set The set containing the allowed cumulative uses.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCumulativeConstantLengthsConstantHeights(List<String> origins, List<BigInteger> lengths,
            List<String> ends, List<BigInteger> heights, UniverseSetBelongingOperator operator,
            List<BigInteger> set);

    /**
     * Adds a {@code cumulative} constraint to this solver.
     *
     * @param origins The variables encoding the origins of the resources.
     * @param lengths The lengths of the tasks to assign.
     * @param heights The variable encoding the heights of the tasks to assign.
     * @param operator The operator to compare the cumulative use with.
     * @param value The value for the cumulative use.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCumulativeConstantLengthsVariableHeights(List<String> origins, List<BigInteger> lengths,
            List<String> heights, UniverseRelationalOperator operator, BigInteger value);

    /**
     * Adds a {@code cumulative} constraint to this solver.
     *
     * @param origins The variables encoding the origins of the resources.
     * @param lengths The lengths of the tasks to assign.
     * @param ends The variables encoding the ends of the resources.
     * @param heights The variable encoding the heights of the tasks to assign.
     * @param operator The operator to compare the cumulative use with.
     * @param value The value for the cumulative use.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCumulativeConstantLengthsVariableHeights(List<String> origins, List<BigInteger> lengths,
            List<String> ends, List<String> heights, UniverseRelationalOperator operator,
            BigInteger value);

    /**
     * Adds a {@code cumulative} constraint to this solver.
     *
     * @param origins The variables encoding the origins of the resources.
     * @param lengths The lengths of the tasks to assign.
     * @param heights The variable encoding the heights of the tasks to assign.
     * @param operator The operator to compare the cumulative use with.
     * @param value The variable encoding the value for the cumulative use.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCumulativeConstantLengthsVariableHeights(List<String> origins, List<BigInteger> lengths,
            List<String> heights, UniverseRelationalOperator operator, String value);

    /**
     * Adds a {@code cumulative} constraint to this solver.
     *
     * @param origins The variables encoding the origins of the resources.
     * @param lengths The lengths of the tasks to assign.
     * @param ends The variables encoding the ends of the resources.
     * @param heights The variable encoding the heights of the tasks to assign.
     * @param operator The operator to compare the cumulative use with.
     * @param value The variable encoding the value for the cumulative use.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCumulativeConstantLengthsVariableHeights(List<String> origins, List<BigInteger> lengths,
            List<String> ends, List<String> heights, UniverseRelationalOperator operator,
            String value);

    /**
     * Adds a {@code cumulative} constraint to this solver.
     *
     * @param origins The variables encoding the origins of the resources.
     * @param lengths The lengths of the tasks to assign.
     * @param heights The variable encoding the heights of the tasks to assign.
     * @param operator The operator to use to check whether the cumulative use is
     *        within a set.
     * @param min The minimum cumulative use.
     * @param max The maximum cumulative use.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCumulativeConstantLengthsVariableHeights(List<String> origins, List<BigInteger> lengths,
            List<BigInteger> heights, UniverseSetBelongingOperator operator, BigInteger min,
            BigInteger max);

    /**
     * Adds a {@code cumulative} constraint to this solver.
     *
     * @param origins The variables encoding the origins of the resources.
     * @param lengths The lengths of the tasks to assign.
     * @param ends The variables encoding the ends of the resources.
     * @param heights The variable encoding the heights of the tasks to assign.
     * @param operator The operator to use to check whether the cumulative use is
     *        within a set.
     * @param min The minimum cumulative use.
     * @param max The maximum cumulative use.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCumulativeConstantLengthsVariableHeights(List<String> origins, List<BigInteger> lengths,
            List<String> ends, List<BigInteger> heights, UniverseSetBelongingOperator operator,
            BigInteger min, BigInteger max);

    /**
     * Adds a {@code cumulative} constraint to this solver.
     *
     * @param origins The variables encoding the origins of the resources.
     * @param lengths The lengths of the tasks to assign.
     * @param heights The variable encoding the heights of the tasks to assign.
     * @param operator The operator to use to check whether the number of assignments is
     *        within a set.
     * @param set The set containing the allowed cumulative uses.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCumulativeConstantLengthsVariableHeights(List<String> origins, List<BigInteger> lengths,
            List<BigInteger> heights, UniverseSetBelongingOperator operator, List<BigInteger> set);

    /**
     * Adds a {@code cumulative} constraint to this solver.
     *
     * @param origins The variables encoding the origins of the resources.
     * @param lengths The lengths of the tasks to assign.
     * @param ends The variables encoding the ends of the resources.
     * @param heights The variable encoding the heights of the tasks to assign.
     * @param operator The operator to use to check whether the number of assignments is
     *        within a set.
     * @param set The set containing the allowed cumulative uses.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCumulativeConstantLengthsVariableHeights(List<String> origins, List<BigInteger> lengths,
            List<String> ends, List<BigInteger> heights, UniverseSetBelongingOperator operator,
            List<BigInteger> set);

    /**
     * Adds a {@code cumulative} constraint to this solver.
     *
     * @param origins The variables encoding the origins of the resources.
     * @param lengths The variables encoding the lengths of the tasks to assign.
     * @param heights The heights of the tasks to assign.
     * @param operator The operator to compare the cumulative use with.
     * @param value The value for the cumulative use.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCumulativeVariableLengthsConstantHeights(List<String> origins, List<String> lengths,
            List<BigInteger> heights, UniverseRelationalOperator operator, BigInteger value);

    /**
     * Adds a {@code cumulative} constraint to this solver.
     *
     * @param origins The variables encoding the origins of the resources.
     * @param lengths The variables encoding the lengths of the tasks to assign.
     * @param ends The variables encoding the ends of the resources.
     * @param heights The heights of the tasks to assign.
     * @param operator The operator to compare the cumulative use with.
     * @param value The value for the cumulative use.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCumulativeVariableLengthsConstantHeights(List<String> origins, List<String> lengths,
            List<String> ends, List<BigInteger> heights, UniverseRelationalOperator operator,
            BigInteger value);

    /**
     * Adds a {@code cumulative} constraint to this solver.
     *
     * @param origins The variables encoding the origins of the resources.
     * @param lengths The variables encoding the lengths of the tasks to assign.
     * @param heights The heights of the tasks to assign.
     * @param operator The operator to compare the cumulative use with.
     * @param value The variable encoding the value for the cumulative use.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCumulativeVariableLengthsConstantHeights(List<String> origins, List<String> lengths,
            List<BigInteger> heights, UniverseRelationalOperator operator, String value);

    /**
     * Adds a {@code cumulative} constraint to this solver.
     *
     * @param origins The variables encoding the origins of the resources.
     * @param lengths The variables encoding the lengths of the tasks to assign.
     * @param ends The variables encoding the ends of the resources.
     * @param heights The heights of the tasks to assign.
     * @param operator The operator to compare the cumulative use with.
     * @param value The variable encoding the value for the cumulative use.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCumulativeVariableLengthsConstantHeights(List<String> origins, List<String> lengths,
            List<String> ends, List<BigInteger> heights, UniverseRelationalOperator operator,
            String value);

    /**
     * Adds a {@code cumulative} constraint to this solver.
     *
     * @param origins The variables encoding the origins of the resources.
     * @param lengths The variables encoding the lengths of the tasks to assign.
     * @param heights The heights of the tasks to assign.
     * @param operator The operator to use to check whether the cumulative use is
     *        within a set.
     * @param min The minimum cumulative use.
     * @param max The maximum cumulative use.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCumulativeVariableLengthsConstantHeights(List<String> origins, List<String> lengths,
            List<BigInteger> heights, UniverseSetBelongingOperator operator, BigInteger min,
            BigInteger max);

    /**
     * Adds a {@code cumulative} constraint to this solver.
     *
     * @param origins The variables encoding the origins of the resources.
     * @param lengths The variables encoding the lengths of the tasks to assign.
     * @param ends The variables encoding the ends of the resources.
     * @param heights The heights of the tasks to assign.
     * @param operator The operator to use to check whether the cumulative use is
     *        within a set.
     * @param min The minimum cumulative use.
     * @param max The maximum cumulative use.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCumulativeVariableLengthsConstantHeights(List<String> origins, List<String> lengths,
            List<String> ends, List<BigInteger> heights, UniverseSetBelongingOperator operator,
            BigInteger min, BigInteger max);

    /**
     * Adds a {@code cumulative} constraint to this solver.
     *
     * @param origins The variables encoding the origins of the resources.
     * @param lengths The variables encoding the lengths of the tasks to assign.
     * @param heights The heights of the tasks to assign.
     * @param operator The operator to use to check whether the number of assignments is
     *        within a set.
     * @param set The set containing the allowed cumulative uses.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCumulativeVariableLengthsConstantHeights(List<String> origins, List<String> lengths,
            List<BigInteger> heights, UniverseSetBelongingOperator operator, List<BigInteger> set);

    /**
     * Adds a {@code cumulative} constraint to this solver.
     *
     * @param origins The variables encoding the origins of the resources.
     * @param lengths The variables encoding the lengths of the tasks to assign.
     * @param ends The variables encoding the ends of the resources.
     * @param heights The heights of the tasks to assign.
     * @param operator The operator to use to check whether the number of assignments is
     *        within a set.
     * @param set The set containing the allowed cumulative uses.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCumulativeVariableLengthsConstantHeights(List<String> origins, List<String> lengths,
            List<String> ends, List<BigInteger> heights, UniverseSetBelongingOperator operator,
            List<BigInteger> set);

    /**
     * Adds a {@code cumulative} constraint to this solver.
     *
     * @param origins The variables encoding the origins of the resources.
     * @param lengths The variables encoding the lengths of the tasks to assign.
     * @param heights The variables encoding the heights of the tasks to assign.
     * @param operator The operator to compare the cumulative use with.
     * @param value The value for the cumulative use.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCumulativeVariableLengthsVariableHeights(List<String> origins, List<String> lengths,
            List<String> heights, UniverseRelationalOperator operator, BigInteger value);

    /**
     * Adds a {@code cumulative} constraint to this solver.
     *
     * @param origins The variables encoding the origins of the resources.
     * @param lengths The variables encoding the lengths of the tasks to assign.
     * @param ends The variables encoding the ends of the resources.
     * @param heights The variables encoding the heights of the tasks to assign.
     * @param operator The operator to compare the cumulative use with.
     * @param value The value for the cumulative use.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCumulativeVariableLengthsVariableHeights(List<String> origins, List<String> lengths,
            List<String> ends, List<String> heights, UniverseRelationalOperator operator,
            BigInteger value);

    /**
     * Adds a {@code cumulative} constraint to this solver.
     *
     * @param origins The variables encoding the origins of the resources.
     * @param lengths The variables encoding the lengths of the tasks to assign.
     * @param heights The variables encoding the heights of the tasks to assign.
     * @param operator The operator to compare the cumulative use with.
     * @param value The variable encoding the value for the cumulative use.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCumulativeVariableLengthsVariableHeights(List<String> origins, List<String> lengths,
            List<String> heights, UniverseRelationalOperator operator, String value);

    /**
     * Adds a {@code cumulative} constraint to this solver.
     *
     * @param origins The variables encoding the origins of the resources.
     * @param lengths The variables encoding the lengths of the tasks to assign.
     * @param ends The variables encoding the ends of the resources.
     * @param heights The variables encoding the heights of the tasks to assign.
     * @param operator The operator to compare the cumulative use with.
     * @param value The variable encoding the value for the cumulative use.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCumulativeVariableLengthsVariableHeights(List<String> origins, List<String> lengths,
            List<String> ends, List<String> heights, UniverseRelationalOperator operator,
            String value);

    /**
     * Adds a {@code cumulative} constraint to this solver.
     *
     * @param origins The variables encoding the origins of the resources.
     * @param lengths The variables encoding the lengths of the tasks to assign.
     * @param heights The variables encoding the heights of the tasks to assign.
     * @param operator The operator to use to check whether the cumulative use is
     *        within a set.
     * @param min The minimum cumulative use.
     * @param max The maximum cumulative use.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCumulativeVariableLengthsVariableHeights(List<String> origins, List<String> lengths,
            List<BigInteger> heights, UniverseSetBelongingOperator operator, BigInteger min,
            BigInteger max);

    /**
     * Adds a {@code cumulative} constraint to this solver.
     *
     * @param origins The variables encoding the origins of the resources.
     * @param lengths The variables encoding the lengths of the tasks to assign.
     * @param ends The variables encoding the ends of the resources.
     * @param heights The variables encoding the heights of the tasks to assign.
     * @param operator The operator to use to check whether the cumulative use is
     *        within a set.
     * @param min The minimum cumulative use.
     * @param max The maximum cumulative use.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCumulativeVariableLengthsVariableHeights(List<String> origins, List<String> lengths,
            List<String> ends, List<BigInteger> heights, UniverseSetBelongingOperator operator,
            BigInteger min, BigInteger max);

    /**
     * Adds a {@code cumulative} constraint to this solver.
     *
     * @param origins The variables encoding the origins of the resources.
     * @param lengths The variables encoding the lengths of the tasks to assign.
     * @param heights The variables encoding the heights of the tasks to assign.
     * @param operator The operator to use to check whether the number of assignments is
     *        within a set.
     * @param set The set containing the allowed cumulative uses.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCumulativeVariableLengthsVariableHeights(List<String> origins, List<String> lengths,
            List<BigInteger> heights, UniverseSetBelongingOperator operator, List<BigInteger> set);

    /**
     * Adds a {@code cumulative} constraint to this solver.
     *
     * @param origins The variables encoding the origins of the resources.
     * @param lengths The variables encoding the lengths of the tasks to assign.
     * @param ends The variables encoding the ends of the resources.
     * @param heights The variables encoding the heights of the tasks to assign.
     * @param operator The operator to use to check whether the number of assignments is
     *        within a set.
     * @param set The set containing the allowed cumulative uses.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCumulativeVariableLengthsVariableHeights(List<String> origins, List<String> lengths,
            List<String> ends, List<BigInteger> heights, UniverseSetBelongingOperator operator,
            List<BigInteger> set);

    /**
     * Adds a {@code knapsack} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param weights The weights of the elements to put in the knapsack.
     * @param wOperator The operator for comparing the weight of the knapsack.
     * @param wValue The total weight of the knapsack.
     * @param profits The profits of the elements to put in the knapsack.
     * @param pOperator The operator for comparing the profit of the knapsack.
     * @param pValue The total profit of the knapsack.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addKnapsack(List<String> variables, List<BigInteger> weights,
            UniverseRelationalOperator wOperator, BigInteger wValue, List<BigInteger> profits,
            UniverseRelationalOperator pOperator, BigInteger pValue);

    /**
     * Adds a {@code knapsack} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param weights The weights of the elements to put in the knapsack.
     * @param wOperator The operator for comparing the weight of the knapsack.
     * @param wValue The total weight of the knapsack.
     * @param profits The profits of the elements to put in the knapsack.
     * @param pOperator The operator for comparing the profit of the knapsack.
     * @param pVariable The variable encoding the total profit of the knapsack.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addKnapsack(List<String> variables, List<BigInteger> weights,
            UniverseRelationalOperator wOperator, BigInteger wValue, List<BigInteger> profits,
            UniverseRelationalOperator pOperator, String pVariable);

    /**
     * Adds a {@code knapsack} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param weights The weights of the elements to put in the knapsack.
     * @param wOperator The operator for comparing the weight of the knapsack.
     * @param wValue The total weight of the knapsack.
     * @param profits The profits of the elements to put in the knapsack.
     * @param pOperator The operator for comparing the profit of the knapsack.
     * @param pMin The minimum profit of the knapsack.
     * @param pMax The maximum profit of the knapsack.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addKnapsack(List<String> variables, List<BigInteger> weights,
            UniverseRelationalOperator wOperator, BigInteger wValue, List<BigInteger> profits,
            UniverseSetBelongingOperator pOperator, BigInteger pMin, BigInteger pMax);

    /**
     * Adds a {@code knapsack} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param weights The weights of the elements to put in the knapsack.
     * @param wOperator The operator for comparing the weight of the knapsack.
     * @param wValue The total weight of the knapsack.
     * @param profits The profits of the elements to put in the knapsack.
     * @param pOperator The operator for comparing the profit of the knapsack.
     * @param pSet The allowed total profits of the knapsack.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addKnapsack(List<String> variables, List<BigInteger> weights,
            UniverseRelationalOperator wOperator, BigInteger wValue, List<BigInteger> profits,
            UniverseSetBelongingOperator pOperator, List<BigInteger> pSet);

    /**
     * Adds a {@code knapsack} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param weights The weights of the elements to put in the knapsack.
     * @param wOperator The operator for comparing the weight of the knapsack.
     * @param wVariable The variable encoding the total weight of the knapsack.
     * @param profits The profits of the elements to put in the knapsack.
     * @param pOperator The operator for comparing the profit of the knapsack.
     * @param pValue The variable encoding the total profit of the knapsack.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addKnapsack(List<String> variables, List<BigInteger> weights,
            UniverseRelationalOperator wOperator, String wVariable, List<BigInteger> profits,
            UniverseRelationalOperator pOperator, BigInteger pValue);

    /**
     * Adds a {@code knapsack} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param weights The weights of the elements to put in the knapsack.
     * @param wOperator The operator for comparing the weight of the knapsack.
     * @param wVariable The variable encoding the total weight of the knapsack.
     * @param profits The profits of the elements to put in the knapsack.
     * @param pOperator The operator for comparing the profit of the knapsack.
     * @param pVariable The variable encoding the total profit of the knapsack.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addKnapsack(List<String> variables, List<BigInteger> weights,
            UniverseRelationalOperator wOperator, String wVariable, List<BigInteger> profits,
            UniverseRelationalOperator pOperator, String pVariable);

    /**
     * Adds a {@code knapsack} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param weights The weights of the elements to put in the knapsack.
     * @param wOperator The operator for comparing the weight of the knapsack.
     * @param wVariable The variable encoding the total weight of the knapsack.
     * @param profits The profits of the elements to put in the knapsack.
     * @param pOperator The operator for comparing the profit of the knapsack.
     * @param pMin The minimum profit of the knapsack.
     * @param pMax The maximum profit of the knapsack.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addKnapsack(List<String> variables, List<BigInteger> weights,
            UniverseRelationalOperator wOperator, String wVariable, List<BigInteger> profits,
            UniverseSetBelongingOperator pOperator, BigInteger pMin, BigInteger pMax);

    /**
     * Adds a {@code knapsack} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param weights The weights of the elements to put in the knapsack.
     * @param wOperator The operator for comparing the weight of the knapsack.
     * @param wVariable The variable encoding the total weight of the knapsack.
     * @param profits The profits of the elements to put in the knapsack.
     * @param pOperator The operator for comparing the profit of the knapsack.
     * @param pSet The allowed total profits of the knapsack.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addKnapsack(List<String> variables, List<BigInteger> weights,
            UniverseRelationalOperator wOperator, String wVariable, List<BigInteger> profits,
            UniverseSetBelongingOperator pOperator, List<BigInteger> pSet);

    /**
     * Adds a {@code knapsack} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param weights The weights of the elements to put in the knapsack.
     * @param wOperator The operator for comparing the weight of the knapsack.
     * @param wMin The minimum weight of the knapsack.
     * @param wMax The maximum weight of the knapsack.
     * @param profits The profits of the elements to put in the knapsack.
     * @param pOperator The operator for comparing the profit of the knapsack.
     * @param pValue The total profit of the knapsack.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addKnapsack(List<String> variables, List<BigInteger> weights,
            UniverseSetBelongingOperator wOperator, BigInteger wMin, BigInteger wMax,
            List<BigInteger> profits, UniverseRelationalOperator pOperator, BigInteger pValue);

    /**
     * Adds a {@code knapsack} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param weights The weights of the elements to put in the knapsack.
     * @param wOperator The operator for comparing the weight of the knapsack.
     * @param wMin The minimum weight of the knapsack.
     * @param wMax The maximum weight of the knapsack.
     * @param profits The profits of the elements to put in the knapsack.
     * @param pOperator The operator for comparing the profit of the knapsack.
     * @param pVariable The variable encoding the total profit of the knapsack.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addKnapsack(List<String> variables, List<BigInteger> weights,
            UniverseSetBelongingOperator wOperator, BigInteger wMin, BigInteger wMax,
            List<BigInteger> profits, UniverseRelationalOperator pOperator, String pVariable);

    /**
     * Adds a {@code knapsack} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param weights The weights of the elements to put in the knapsack.
     * @param wOperator The operator for comparing the weight of the knapsack.
     * @param wMin The minimum weight of the knapsack.
     * @param wMax The maximum weight of the knapsack.
     * @param profits The profits of the elements to put in the knapsack.
     * @param pOperator The operator for comparing the profit of the knapsack.
     * @param pMin The minimum profit of the knapsack.
     * @param pMax The maximum profit of the knapsack.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addKnapsack(List<String> variables, List<BigInteger> weights,
            UniverseSetBelongingOperator wOperator, BigInteger wMin, BigInteger wMax,
            List<BigInteger> profits, UniverseSetBelongingOperator pOperator, BigInteger pMin,
            BigInteger pMax);

    /**
     * Adds a {@code knapsack} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param weights The weights of the elements to put in the knapsack.
     * @param wOperator The operator for comparing the weight of the knapsack.
     * @param wMin The minimum weight of the knapsack.
     * @param wMax The maximum weight of the knapsack.
     * @param profits The profits of the elements to put in the knapsack.
     * @param pOperator The operator for comparing the profit of the knapsack.
     * @param pSet The allowed total profits of the knapsack.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addKnapsack(List<String> variables, List<BigInteger> weights,
            UniverseSetBelongingOperator wOperator, BigInteger wMin, BigInteger wMax,
            List<BigInteger> profits, UniverseSetBelongingOperator pOperator,
            List<BigInteger> pSet);

    /**
     * Adds a {@code knapsack} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param weights The weights of the elements to put in the knapsack.
     * @param wOperator The operator for comparing the weight of the knapsack.
     * @param wSet The allowed total weights of the knapsack.
     * @param profits The profits of the elements to put in the knapsack.
     * @param pOperator The operator for comparing the profit of the knapsack.
     * @param pValue The variable encoding the total profit of the knapsack.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addKnapsack(List<String> variables, List<BigInteger> weights,
            UniverseSetBelongingOperator wOperator, List<BigInteger> wSet, List<BigInteger> profits,
            UniverseRelationalOperator pOperator, BigInteger pValue);

    /**
     * Adds a {@code knapsack} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param weights The weights of the elements to put in the knapsack.
     * @param wOperator The operator for comparing the weight of the knapsack.
     * @param wSet The allowed total weights of the knapsack.
     * @param profits The profits of the elements to put in the knapsack.
     * @param pOperator The operator for comparing the profit of the knapsack.
     * @param pVariable The variable encoding the total profit of the knapsack.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addKnapsack(List<String> variables, List<BigInteger> weights,
            UniverseSetBelongingOperator wOperator, List<BigInteger> wSet, List<BigInteger> profits,
            UniverseRelationalOperator pOperator, String pVariable);

    /**
     * Adds a {@code knapsack} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param weights The weights of the elements to put in the knapsack.
     * @param wOperator The operator for comparing the weight of the knapsack.
     * @param wSet The allowed total weights of the knapsack.
     * @param profits The profits of the elements to put in the knapsack.
     * @param pOperator The operator for comparing the profit of the knapsack.
     * @param pMin The minimum profit of the knapsack.
     * @param pMax The maximum profit of the knapsack.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addKnapsack(List<String> variables, List<BigInteger> weights,
            UniverseSetBelongingOperator wOperator, List<BigInteger> wSet, List<BigInteger> profits,
            UniverseSetBelongingOperator pOperator, BigInteger pMin, BigInteger pMax);

    /**
     * Adds a {@code knapsack} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param weights The weights of the elements to put in the knapsack.
     * @param wOperator The operator for comparing the weight of the knapsack.
     * @param wSet The allowed total weights of the knapsack.
     * @param profits The profits of the elements to put in the knapsack.
     * @param pOperator The operator for comparing the profit of the knapsack.
     * @param pSet The allowed total profits of the knapsack.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addKnapsack(List<String> variables, List<BigInteger> weights,
            UniverseSetBelongingOperator wOperator, List<BigInteger> wSet, List<BigInteger> profits,
            UniverseSetBelongingOperator pOperator, List<BigInteger> pSet);

    /**
     * Adds a {@code stretch} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param values The values to assign to the variables.
     * @param widthsMin The minimum widths of the sequences to build.
     * @param widthsMax The maximum widths of the sequences to build.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addStretch(List<String> variables, List<BigInteger> values, List<BigInteger> widthsMin,
            List<BigInteger> widthsMax);

    /**
     * Adds a {@code stretch} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param values The values to assign to the variables.
     * @param widthsMin The minimum widths of the sequences to build.
     * @param widthsMax The maximum widths of the sequences to build.
     * @param patterns The possible successive values between stretches.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addStretch(List<String> variables, List<BigInteger> values, List<BigInteger> widthsMin,
            List<BigInteger> widthsMax, List<List<BigInteger>> patterns);

    /**
     * Adds an {@code element} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param operator The relational operator used to compare the value with those
     *        assigned to the variables.
     * @param value The value to look for among the variables.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addElement(List<String> variables, UniverseRelationalOperator operator, BigInteger value);

    /**
     * Adds an {@code element} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param operator The relational operator used to compare the value with those
     *        assigned to the variables.
     * @param value The variable encoding the value to look for among the variables.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addElement(List<String> variables, UniverseRelationalOperator operator, String value);

    /**
     * Adds an {@code element} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param operator The operator used to check whether a variable is assigned in the
     *        range.
     * @param min The minimum value of the range.
     * @param max The maximum value of the range.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addElement(List<String> variables, UniverseSetBelongingOperator operator, BigInteger min,
            BigInteger max);

    /**
     * Adds an {@code element} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param operator The operator used to check whether a variable is assigned in the
     *        set.
     * @param set The set of values to look for.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addElement(List<String> variables, UniverseSetBelongingOperator operator,
            List<BigInteger> set);

    /**
     * Adds an {@code element} constraint to this solver.
     *
     * @param values The values among which to look for the variable.
     * @param startIndex The index at which to start looking for the variable.
     * @param index The index at which the variable appears in the values.
     * @param operator The relational operator used to compare the value with those
     *        assigned to the variables.
     * @param value The value to look for.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addElementConstantValues(List<BigInteger> values, int startIndex, String index,
            UniverseRelationalOperator operator, BigInteger value);

    /**
     * Adds an {@code element} constraint to this solver.
     *
     * @param values The values among which to look for the variable.
     * @param startIndex The index at which to start looking for the variable.
     * @param index The index at which the variable appears in the values.
     * @param operator The relational operator used to compare the value with those
     *        assigned to the variables.
     * @param variable The variable whose value is to be looked for.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addElementConstantValues(List<BigInteger> values, int startIndex, String index,
            UniverseRelationalOperator operator, String variable);

    /**
     * Adds an {@code element} constraint to this solver.
     *
     * @param values The values among which to look for the variable.
     * @param startIndex The index at which to start looking for the variable.
     * @param index The index at which the variable appears in the values.
     * @param operator The operator used to check whether a variable is assigned in the
     *        range.
     * @param min The minimum value of the range.
     * @param max The maximum value of the range.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addElementConstantValues(List<BigInteger> values, int startIndex, String index,
            UniverseSetBelongingOperator operator, BigInteger min, BigInteger max);

    /**
     * Adds an {@code element} constraint to this solver.
     *
     * @param values The values among which to look for the variable.
     * @param startIndex The index at which to start looking for the variable.
     * @param index The index at which the variable appears in the values.
     * @param operator The operator used to check whether a variable is assigned in the
     *        set.
     * @param set The set of values to look for.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addElementConstantValues(List<BigInteger> values, int startIndex, String index,
            UniverseSetBelongingOperator operator, List<BigInteger> set);

    /**
     * Adds an {@code element} constraint to this solver.
     *
     * @param variables The variables among which to look for the value.
     * @param startIndex The index at which to start looking for the value.
     * @param index The index at which the value appears in the variables.
     * @param operator The relational operator used to compare the value with those
     *        assigned to the variables.
     * @param value The value to look for.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addElement(List<String> variables, int startIndex, String index,
            UniverseRelationalOperator operator, BigInteger value);

    /**
     * Adds an {@code element} constraint to this solver.
     *
     * @param variables The variables among which to look for the value.
     * @param startIndex The index at which to start looking for the variable.
     * @param index The index at which the variable appears in the values.
     * @param operator The relational operator used to compare the value with those
     *        assigned to the variables.
     * @param variable The variable whose value is to be looked for.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addElement(List<String> variables, int startIndex, String index,
            UniverseRelationalOperator operator, String variable);

    /**
     * Adds an {@code element} constraint to this solver.
     *
     * @param variables The variables among which to look for the value.
     * @param startIndex The index at which to start looking for the variable.
     * @param index The index at which the variable appears in the values.
     * @param operator The operator used to check whether a variable is assigned in the
     *        range.
     * @param min The minimum value of the range.
     * @param max The maximum value of the range.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addElement(List<String> variables, int startIndex, String index,
            UniverseSetBelongingOperator operator, BigInteger min, BigInteger max);

    /**
     * Adds an {@code element} constraint to this solver.
     *
     * @param variables The variables among which to look for the value.
     * @param startIndex The index at which to start looking for the variable.
     * @param index The index at which the variable appears in the values.
     * @param operator The operator used to check whether a variable is assigned in the
     *        set.
     * @param set The set of values to look for.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addElement(List<String> variables, int startIndex, String index,
            UniverseSetBelongingOperator operator, List<BigInteger> set);

    /**
     * Adds an {@code element} constraint to this solver.
     *
     * @param matrix The matrix of values among which the value must appear.
     * @param startRowIndex The index of the row starting from which the value must
     *        appear.
     * @param rowIndex The variable encoding the index of the row at which the
     *        value appears.
     * @param startColIndex The index of the column starting from which the value
     *        must appear.
     * @param colIndex The variable encoding the index of the column at which
     *        the value appears.
     * @param operator The relational operator used to compare the value with those
     *        assigned to the variables.
     * @param value The value to look for inside the matrix.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addElementConstantMatrix(List<List<BigInteger>> matrix, int startRowIndex, String rowIndex,
            int startColIndex, String colIndex, UniverseRelationalOperator operator,
            BigInteger value);

    /**
     * Adds an {@code element} constraint to this solver.
     *
     * @param matrix The matrix of values among which the value must appear.
     * @param startRowIndex The index of the row starting from which the value must
     *        appear.
     * @param rowIndex The variable encoding the index of the row at which the
     *        value appears.
     * @param startColIndex The index of the column starting from which the value
     *        must appear.
     * @param colIndex The variable encoding the index of the column at which
     *        the value appears.
     * @param operator The relational operator used to compare the value with those
     *        assigned to the variables.
     * @param value The variable whose value is to be looked for inside the matrix.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addElementConstantMatrix(List<List<BigInteger>> matrix, int startRowIndex, String rowIndex,
            int startColIndex, String colIndex, UniverseRelationalOperator operator, String value);

    /**
     * Adds an {@code element} constraint to this solver.
     *
     * @param matrix The matrix of values among which the value must appear.
     * @param startRowIndex The index of the row starting from which the value must
     *        appear.
     * @param rowIndex The variable encoding the index of the row at which the
     *        value appears.
     * @param startColIndex The index of the column starting from which the value
     *        must appear.
     * @param colIndex The variable encoding the index of the column at which
     *        the value appears.
     * @param operator The operator used to check whether a variable is assigned in the
     *        range.
     * @param min The minimum value of the range.
     * @param max The maximum value of the range.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addElementConstantMatrix(List<List<BigInteger>> matrix, int startRowIndex, String rowIndex,
            int startColIndex, String colIndex, UniverseSetBelongingOperator operator,
            BigInteger min, BigInteger max);

    /**
     * Adds an {@code element} constraint to this solver.
     *
     * @param matrix The matrix of values among which the value must appear.
     * @param startRowIndex The index of the row starting from which the value must
     *        appear.
     * @param rowIndex The variable encoding the index of the row at which the
     *        value appears.
     * @param startColIndex The index of the column starting from which the value
     *        must appear.
     * @param colIndex The variable encoding the index of the column at which
     *        the value appears.
     * @param operator The operator used to check whether a variable is assigned in the
     *        set.
     * @param set The set of values to look for.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addElementConstantMatrix(List<List<BigInteger>> matrix, int startRowIndex, String rowIndex,
            int startColIndex, String colIndex, UniverseSetBelongingOperator operator,
            List<BigInteger> set);

    /**
     * Adds an {@code element} constraint to this solver.
     *
     * @param matrix The matrix of variables among which the value must be
     *        assigned.
     * @param startRowIndex The index of the row starting from which the value must
     *        appear.
     * @param rowIndex The variable encoding the index of the row at which the
     *        value appears.
     * @param startColIndex The index of the column starting from which the value
     *        must appear.
     * @param colIndex The variable encoding the index of the column at which
     *        the value appears.
     * @param operator The relational operator used to compare the value with those
     *        assigned to the variables.
     * @param value The variable whose value is to be looked for inside the matrix.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addElementMatrix(List<List<String>> matrix, int startRowIndex, String rowIndex,
            int startColIndex, String colIndex, UniverseRelationalOperator operator,
            BigInteger value);

    /**
     * Adds an {@code element} constraint to this solver.
     *
     * @param matrix The matrix of variables among which the value must be
     *        assigned.
     * @param startRowIndex The index of the row starting from which the value must
     *        appear.
     * @param rowIndex The variable encoding the index of the row at which the
     *        value appears.
     * @param startColIndex The index of the column starting from which the value
     *        must appear.
     * @param colIndex The variable encoding the index of the column at which
     *        the value appears.
     * @param operator The relational operator used to compare the value with those
     *        assigned to the variables.
     * @param value The variable whose value is to be looked for inside the matrix.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addElementMatrix(List<List<String>> matrix, int startRowIndex, String rowIndex,
            int startColIndex, String colIndex, UniverseRelationalOperator operator, String value);

    /**
     * Adds an {@code element} constraint to this solver.
     *
     * @param matrix The matrix of variables among which the value must be
     *        assigned.
     * @param startRowIndex The index of the row starting from which the value must
     *        appear.
     * @param rowIndex The variable encoding the index of the row at which the
     *        value appears.
     * @param startColIndex The index of the column starting from which the value
     *        must appear.
     * @param colIndex The variable encoding the index of the column at which
     *        the value appears.
     * @param operator The operator used to check whether a variable is assigned in the
     *        range.
     * @param min The minimum value of the range.
     * @param max The maximum value of the range.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addElementMatrix(List<List<String>> matrix, int startRowIndex, String rowIndex,
            int startColIndex, String colIndex, UniverseSetBelongingOperator operator,
            BigInteger min, BigInteger max);

    /**
     * Adds an {@code element} constraint to this solver.
     *
     * @param matrix The matrix of variables among which the value must be
     *        assigned.
     * @param startRowIndex The index of the row starting from which the value must
     *        appear.
     * @param rowIndex The variable encoding the index of the row at which the
     *        value appears.
     * @param startColIndex The index of the column starting from which the value
     *        must appear.
     * @param colIndex The variable encoding the index of the column at which
     *        the value appears.
     * @param operator The operator used to check whether a variable is assigned in the
     *        set.
     * @param set The set of values to look for.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addElementMatrix(List<List<String>> matrix, int startRowIndex, String rowIndex,
            int startColIndex, String colIndex, UniverseSetBelongingOperator operator,
            List<BigInteger> set);

    /**
     * Adds a {@code precedence} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     */
    void addPrecedence(List<String> variables);

    /**
     * Adds a {@code precedence} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param values The values on which the precedence constraint applies.
     * @param covered Whether each value of the specified list must be assigned by at
     *        least one variable in the scope of the constraint.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addPrecedence(List<String> variables, List<BigInteger> values, boolean covered);

    /**
     * Adds an {@code extension} constraint describing the support of a tuple of variables
     * to this solver.
     *
     * @param variable The variable for which the support is given.
     * @param allowedValues The values allowed for the variable.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addSupport(String variable, List<BigInteger> allowedValues);

    /**
     * Adds an {@code extension} constraint describing the support of a tuple of variables
     * to this solver.
     *
     * @param variable The variable for which the support is given.
     * @param allowedValues The values allowed for the variable.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addSupportSymbolic(String variable, List<String> allowedValues);

    /**
     * Adds an {@code extension} constraint describing the support of a tuple of variables
     * to this solver.
     *
     * @param variableTuple The tuple of variables for which the support is given.
     * @param allowedValues The values allowed for the tuple variables.
     *        Values equal to {@code null} are interpreted as "any value" (as in so-called
     *        "starred tuples").
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addSupport(List<String> variableTuple, List<List<BigInteger>> allowedValues);

    /**
     * Adds an {@code extension} constraint describing the support of a tuple of variables
     * to this solver.
     *
     * @param variableTuple The tuple of variables for which the support is given.
     * @param allowedValues The values allowed for the tuple variables.
     *        Values equal to {@code null} are interpreted as "any value" (as in so-called
     *        "starred tuples").
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addSupportSymbolic(List<String> variableTuple, List<List<String>> allowedValues);

    /**
     * Adds an {@code extension} constraint describing the conflicts of a tuple of
     * variables to this solver.
     *
     * @param variable The variable for which the conflicts are given.
     * @param forbiddenValues The values forbidden for the variable.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addConflicts(String variable, List<BigInteger> forbiddenValues);

    /**
     * Adds an {@code extension} constraint describing the conflicts of a tuple of
     * variables to this solver.
     *
     * @param variable The variable for which the conflicts are given.
     * @param forbiddenValues The values forbidden for the variable.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addConflictsSymbolic(String variable, List<String> forbiddenValues);

    /**
     * Adds an {@code extension} constraint describing the conflicts of a tuple of
     * variables to this solver.
     *
     * @param variableTuple The tuple of variables for which the conflicts are given.
     * @param forbiddenValues The values forbidden for the tuple variables.
     *        Values equal to {@code null} are interpreted as "any value" (as in so-called
     *        "starred tuples").
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addConflicts(List<String> variableTuple, List<List<BigInteger>> forbiddenValues);

    /**
     * Adds an {@code extension} constraint describing the conflicts of a tuple of
     * variables to this solver.
     *
     * @param variableTuple The tuple of variables for which the conflicts are
     *        given.
     * @param forbiddenValues The values forbidden for the tuple variables.
     *        Values equal to {@code null} are interpreted as "any value" (as in so-called
     *        "starred tuples").
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addConflictsSymbolic(List<String> variableTuple, List<List<String>> forbiddenValues);

    /**
     * Adds an {@code intension} constraint to this solver.
     *
     * @param constr The user-friendly representation of the constraint to add.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addIntension(IUniverseIntensionConstraint constr);

    /**
     * Adds a {@code primitive} constraint to this solver.
     *
     * @param variable The variable appearing in the constraint.
     * @param operator The operator used in the constraint.
     * @param value The value to compare the variable with.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addPrimitive(String variable, UniverseRelationalOperator operator, BigInteger value);

    /**
     * Adds a {@code primitive} constraint to this solver.
     *
     * @param variable The variable appearing in the constraint.
     * @param arithOp The arithmetic operator applied on the variable.
     * @param leftHandSide The value on the left-hand side of the constraint.
     * @param relOp The relational operator used to compare the right-hand
     *        side with the left-hand side.
     * @param rightHandSide The value on the right-hand side of the constraint.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addPrimitive(String variable, UniverseArithmeticOperator arithOp, BigInteger leftHandSide,
            UniverseRelationalOperator relOp, BigInteger rightHandSide);

    /**
     * Adds a {@code primitive} constraint to this solver.
     *
     * @param variable The variable appearing in the constraint.
     * @param arithOp The arithmetic operator applied on the variable.
     * @param leftHandSide The variable on the left-hand side of the constraint.
     * @param relOp The relational operator used to compare the right-hand
     *        side with the left-hand side.
     * @param rightHandSide The value on the right-hand side of the constraint.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addPrimitive(String variable, UniverseArithmeticOperator arithOp, String leftHandSide,
            UniverseRelationalOperator relOp, BigInteger rightHandSide);

    /**
     * Adds a {@code primitive} constraint to this solver.
     *
     * @param variable The variable appearing in the constraint.
     * @param arithOp The arithmetic operator applied on the variable.
     * @param leftHandSide The value on the left-hand side of the constraint.
     * @param relOp The relational operator used to compare the right-hand
     *        side with the left-hand side.
     * @param rightHandSide The variable on the right-hand side of the constraint.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addPrimitive(String variable, UniverseArithmeticOperator arithOp, BigInteger leftHandSide,
            UniverseRelationalOperator relOp, String rightHandSide);

    /**
     * Adds a {@code primitive} constraint to this solver.
     *
     * @param variable The variable appearing in the constraint.
     * @param arithOp The arithmetic operator applied on the variable.
     * @param leftHandSide The variable on the left-hand side of the constraint.
     * @param relOp The relational operator used to compare the right-hand
     *        side with the left-hand side.
     * @param rightHandSide The variable on the right-hand side of the constraint.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addPrimitive(String variable, UniverseArithmeticOperator arithOp, String leftHandSide,
            UniverseRelationalOperator relOp, String rightHandSide);

    /**
     * Adds a {@code primitive} constraint to this solver.
     *
     * @param arithOp The arithmetic operator applied on the variable.
     * @param variable The variable on which the operator is applied.
     * @param rightHandSide The variable on the right-hand side of the constraint.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addPrimitive(UniverseArithmeticOperator arithOp, String variable, String rightHandSide);

    /**
     * Adds a {@code primitive} constraint to this solver.
     *
     * @param variable The variable appearing in the constraint.
     * @param operator The operator defining whether the values are allowed or
     *        forbidden.
     * @param values The set of values on which the operator is applied.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addPrimitive(String variable, UniverseSetBelongingOperator operator,
            List<BigInteger> values);

    /**
     * Adds a {@code primitive} constraint to this solver.
     *
     * @param variable The variable appearing in the constraint.
     * @param operator The operator defining whether the values are allowed or
     *        forbidden.
     * @param min The minimum value of the range on which the operator is
     *        applied.
     * @param max The maximum value of the range on which the operator is
     *        applied.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addPrimitive(String variable, UniverseSetBelongingOperator operator, BigInteger min,
            BigInteger max);

    /**
     * Adds a {@code minimum} constraint to this solver.
     *
     * @param variables The variables to compute the minimum of.
     * @param operator The relational operator to use to compare the minimum.
     * @param value The value to compare the minimum with.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMinimum(List<String> variables, UniverseRelationalOperator operator, BigInteger value);

    /**
     * Adds a {@code minimum} constraint to this solver.
     *
     * @param variables The variables to compute the minimum of.
     * @param operator The relational operator to use to compare the minimum.
     * @param value The variable to compare the minimum with.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMinimum(List<String> variables, UniverseRelationalOperator operator, String value);

    /**
     * Adds a {@code minimum} constraint to this solver.
     *
     * @param variables The variables to compute the minimum of.
     * @param operator The operator checking whether the minimum is in the range.
     * @param min The minimum value for the minimum.
     * @param max The maximum value for the minimum.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMinimum(List<String> variables, UniverseSetBelongingOperator operator, BigInteger min,
            BigInteger max);

    /**
     * Adds a {@code minimum} constraint to this solver.
     *
     * @param variables The variables to compute the minimum of.
     * @param operator The operator checking whether the minimum is in the set.
     * @param set The allowed values for the minimum.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMinimum(List<String> variables, UniverseSetBelongingOperator operator,
            List<BigInteger> set);

    /**
     * Adds a {@code minimum} constraint to this solver.
     *
     * @param variables The variables to compute the minimum of.
     * @param startIndex The index at which to start looking for the minimum
     * @param index The variable encoding the index at which the minimum is.
     * @param operator The relational operator to use to compare the minimum.
     * @param value The value to compare the minimum with.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMinimumIndex(List<String> variables, int startIndex, String index,
            UniverseRelationalOperator operator, BigInteger value);

    /**
     * Adds a {@code minimum} constraint to this solver.
     *
     * @param variables The variables to compute the minimum of.
     * @param startIndex The index at which to start looking for the minimum
     * @param index The variable encoding the index at which the minimum is.
     * @param operator The relational operator to use to compare the minimum.
     * @param value The variable to compare the minimum with.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMinimumIndex(List<String> variables, int startIndex, String index,
            UniverseRelationalOperator operator, String value);

    /**
     * Adds a {@code minimum} constraint to this solver.
     *
     * @param variables The variables to compute the minimum of.
     * @param startIndex The index at which to start looking for the minimum
     * @param index The variable encoding the index at which the minimum is.
     * @param operator The operator checking whether the minimum is in the range.
     * @param min The minimum value for the minimum.
     * @param max The maximum value for the minimum.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMinimumIndex(List<String> variables, int startIndex, String index,
            UniverseSetBelongingOperator operator, BigInteger min, BigInteger max);

    /**
     * Adds a {@code minimum} constraint to this solver.
     *
     * @param variables The variables to compute the minimum of.
     * @param startIndex The index at which to start looking for the minimum
     * @param index The variable encoding the index at which the minimum is.
     * @param operator The operator checking whether the minimum is in the set.
     * @param set The allowed values for the minimum.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMinimumIndex(List<String> variables, int startIndex, String index,
            UniverseSetBelongingOperator operator, List<BigInteger> set);

    /**
     * Adds a {@code minimum} constraint to this solver.
     *
     * @param intensionConstraints The intension constraints to compute the minimum of.
     * @param operator The relational operator to use to compare the minimum.
     * @param value The value to compare the minimum with.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMinimumIntension(List<IUniverseIntensionConstraint> intensionConstraints,
            UniverseRelationalOperator operator, BigInteger value);

    /**
     * Adds a {@code minimum} constraint to this solver.
     *
     * @param intensionConstraints The intension constraints to compute the minimum of.
     * @param operator The relational operator to use to compare the minimum.
     * @param value The variable to compare the minimum with.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMinimumIntension(List<IUniverseIntensionConstraint> intensionConstraints,
            UniverseRelationalOperator operator, String value);

    /**
     * Adds a {@code minimum} constraint to this solver.
     *
     * @param intensionConstraints The intension constraints to compute the minimum of.
     * @param operator The operator checking whether the minimum is in the range.
     * @param min The minimum value for the minimum.
     * @param max The maximum value for the minimum.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMinimumIntension(List<IUniverseIntensionConstraint> intensionConstraints,
            UniverseSetBelongingOperator operator, BigInteger min, BigInteger max);

    /**
     * Adds a {@code minimum} constraint to this solver.
     *
     * @param intensionConstraints The intension constraints to compute the minimum of.
     * @param operator The operator checking whether the minimum is in the set.
     * @param set The allowed values for the minimum.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMinimumIntension(List<IUniverseIntensionConstraint> intensionConstraints,
            UniverseSetBelongingOperator operator, List<BigInteger> set);

    /**
     * Adds a {@code minimum-arg} constraint to this solver.
     *
     * @param variables The variables to compute the minimum of.
     * @param operator The relational operator to use to compare the minimum.
     * @param value The value to compare the minimum with.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMinimumArg(List<String> variables, UniverseRelationalOperator operator,
            BigInteger value);

    /**
     * Adds a {@code minimum-arg} constraint to this solver.
     *
     * @param variables The variables to compute the minimum of.
     * @param operator The relational operator to use to compare the minimum.
     * @param value The variable to compare the minimum with.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMinimumArg(List<String> variables, UniverseRelationalOperator operator, String value);

    /**
     * Adds a {@code minimum-arg} constraint to this solver.
     *
     * @param variables The variables to compute the minimum of.
     * @param operator The operator checking whether the minimum is in the range.
     * @param min The minimum value for the minimum.
     * @param max The maximum value for the minimum.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMinimumArg(List<String> variables, UniverseSetBelongingOperator operator,
            BigInteger min, BigInteger max);

    /**
     * Adds a {@code minimum-arg} constraint to this solver.
     *
     * @param variables The variables to compute the minimum of.
     * @param operator The operator checking whether the minimum is in the set.
     * @param set The allowed values for the minimum.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMinimumArg(List<String> variables, UniverseSetBelongingOperator operator,
            List<BigInteger> set);

    /**
     * Adds a {@code minimum-arg} constraint to this solver.
     *
     * @param intensionConstraints The intension constraints to compute the minimum of.
     * @param operator The relational operator to use to compare the minimum.
     * @param value The value to compare the minimum with.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMinimumArgIntension(List<IUniverseIntensionConstraint> intensionConstraints,
            UniverseRelationalOperator operator, BigInteger value);

    /**
     * Adds a {@code minimum-arg} constraint to this solver.
     *
     * @param intensionConstraints The intension constraints to compute the minimum of.
     * @param operator The relational operator to use to compare the minimum.
     * @param value The variable to compare the minimum with.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMinimumArgIntension(List<IUniverseIntensionConstraint> intensionConstraints,
            UniverseRelationalOperator operator, String value);

    /**
     * Adds a {@code minimum-arg} constraint to this solver.
     *
     * @param intensionConstraints The intension constraints to compute the minimum of.
     * @param operator The operator checking whether the minimum is in the range.
     * @param min The minimum value for the minimum.
     * @param max The maximum value for the minimum.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMinimumArgIntension(List<IUniverseIntensionConstraint> intensionConstraints,
            UniverseSetBelongingOperator operator, BigInteger min, BigInteger max);

    /**
     * Adds a {@code minimum-arg} constraint to this solver.
     *
     * @param intensionConstraints The intension constraints to compute the minimum of.
     * @param operator The operator checking whether the minimum is in the set.
     * @param set The allowed values for the minimum.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMinimumArgIntension(List<IUniverseIntensionConstraint> intensionConstraints,
            UniverseSetBelongingOperator operator, List<BigInteger> set);

    /**
     * Adds a {@code maximum} constraint to this solver.
     *
     * @param variables The variables to compute the maximum of.
     * @param operator The relational operator to use to compare the maximum.
     * @param value The value to compare the maximum with.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMaximum(List<String> variables, UniverseRelationalOperator operator, BigInteger value);

    /**
     * Adds a {@code maximum} constraint to this solver.
     *
     * @param variables The variables to compute the maximum of.
     * @param operator The relational operator to use to compare the maximum.
     * @param value The variable to compare the maximum with.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMaximum(List<String> variables, UniverseRelationalOperator operator, String value);

    /**
     * Adds a {@code maximum} constraint to this solver.
     *
     * @param variables The variables to compute the maximum of.
     * @param operator The operator checking whether the maximum is in the range.
     * @param min The minimum value for the maximum.
     * @param max The maximum value for the maximum.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMaximum(List<String> variables, UniverseSetBelongingOperator operator, BigInteger min,
            BigInteger max);

    /**
     * Adds a {@code maximum} constraint to this solver.
     *
     * @param variables The variables to compute the maximum of.
     * @param operator The operator checking whether the maximum is in the set.
     * @param set The allowed values for the maximum.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMaximum(List<String> variables, UniverseSetBelongingOperator operator,
            List<BigInteger> set);

    /**
     * Adds a {@code maximum} constraint to this solver.
     *
     * @param variables The variables to compute the maximum of.
     * @param startIndex The index at which to start looking for the maximum
     * @param index The variable encoding the index at which the maximum is.
     * @param operator The relational operator to use to compare the maximum.
     * @param value The value to compare the maximum with.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMaximumIndex(List<String> variables, int startIndex, String index,
            UniverseRelationalOperator operator, BigInteger value);

    /**
     * Adds a {@code maximum} constraint to this solver.
     *
     * @param variables The variables to compute the maximum of.
     * @param startIndex The index at which to start looking for the maximum
     * @param index The variable encoding the index at which the maximum is.
     * @param operator The relational operator to use to compare the maximum.
     * @param value The variable to compare the maximum with.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMaximumIndex(List<String> variables, int startIndex, String index,
            UniverseRelationalOperator operator, String value);

    /**
     * Adds a {@code maximum} constraint to this solver.
     *
     * @param variables The variables to compute the maximum of.
     * @param startIndex The index at which to start looking for the maximum
     * @param index The variable encoding the index at which the maximum is.
     * @param operator The operator checking whether the maximum is in the range.
     * @param min The minimum value for the maximum.
     * @param max The maximum value for the maximum.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMaximumIndex(List<String> variables, int startIndex, String index,
            UniverseSetBelongingOperator operator, BigInteger min, BigInteger max);

    /**
     * Adds a {@code maximum} constraint to this solver.
     *
     * @param variables The variables to compute the maximum of.
     * @param startIndex The index at which to start looking for the maximum
     * @param index The variable encoding the index at which the maximum is.
     * @param operator The operator checking whether the maximum is in the set.
     * @param set The allowed values for the maximum.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMaximumIndex(List<String> variables, int startIndex, String index,
            UniverseSetBelongingOperator operator, List<BigInteger> set);

    /**
     * Adds a {@code maximum} constraint to this solver.
     *
     * @param intensionConstraints The intension constraints to compute the maximum of.
     * @param operator The relational operator to use to compare the maximum.
     * @param value The value to compare the maximum with.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMaximumIntension(List<IUniverseIntensionConstraint> intensionConstraints,
            UniverseRelationalOperator operator, BigInteger value);

    /**
     * Adds a {@code maximum} constraint to this solver.
     *
     * @param intensionConstraints The intension constraints to compute the maximum of.
     * @param operator The relational operator to use to compare the maximum.
     * @param value The variable to compare the maximum with.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMaximumIntension(List<IUniverseIntensionConstraint> intensionConstraints,
            UniverseRelationalOperator operator, String value);

    /**
     * Adds a {@code maximum} constraint to this solver.
     *
     * @param intensionConstraints The intension constraints to compute the maximum of.
     * @param operator The operator checking whether the maximum is in the range.
     * @param min The minimum value for the maximum.
     * @param max The maximum value for the maximum.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMaximumIntension(List<IUniverseIntensionConstraint> intensionConstraints,
            UniverseSetBelongingOperator operator, BigInteger min, BigInteger max);

    /**
     * Adds a {@code maximum} constraint to this solver.
     *
     * @param intensionConstraints The intension constraints to compute the maximum of.
     * @param operator The operator checking whether the maximum is in the set.
     * @param set The allowed values for the maximum.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMaximumIntension(List<IUniverseIntensionConstraint> intensionConstraints,
            UniverseSetBelongingOperator operator, List<BigInteger> set);

    /**
     * Adds a {@code maximum-arg} constraint to this solver.
     *
     * @param variables The variables to compute the maximum of.
     * @param operator The relational operator to use to compare the maximum.
     * @param value The value to compare the maximum with.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMaximumArg(List<String> variables, UniverseRelationalOperator operator,
            BigInteger value);

    /**
     * Adds a {@code maximum-arg} constraint to this solver.
     *
     * @param variables The variables to compute the maximum of.
     * @param operator The relational operator to use to compare the maximum.
     * @param value The variable to compare the maximum with.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMaximumArg(List<String> variables, UniverseRelationalOperator operator, String value);

    /**
     * Adds a {@code maximum-arg} constraint to this solver.
     *
     * @param variables The variables to compute the maximum of.
     * @param operator The operator checking whether the maximum is in the range.
     * @param min The minimum value for the maximum.
     * @param max The maximum value for the maximum.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMaximumArg(List<String> variables, UniverseSetBelongingOperator operator,
            BigInteger min, BigInteger max);

    /**
     * Adds a {@code maximum-arg} constraint to this solver.
     *
     * @param variables The variables to compute the maximum of.
     * @param operator The operator checking whether the maximum is in the set.
     * @param set The allowed values for the maximum.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMaximumArg(List<String> variables, UniverseSetBelongingOperator operator,
            List<BigInteger> set);

    /**
     * Adds a {@code maximum-arg} constraint to this solver.
     *
     * @param intensionConstraints The intension constraints to compute the maximum of.
     * @param operator The relational operator to use to compare the maximum.
     * @param value The value to compare the maximum with.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMaximumArgIntension(List<IUniverseIntensionConstraint> intensionConstraints,
            UniverseRelationalOperator operator, BigInteger value);

    /**
     * Adds a {@code maximum-arg} constraint to this solver.
     *
     * @param intensionConstraints The intension constraints to compute the maximum of.
     * @param operator The relational operator to use to compare the maximum.
     * @param value The variable to compare the maximum with.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMaximumArgIntension(List<IUniverseIntensionConstraint> intensionConstraints,
            UniverseRelationalOperator operator, String value);

    /**
     * Adds a {@code maximum-arg} constraint to this solver.
     *
     * @param intensionConstraints The intension constraints to compute the maximum of.
     * @param operator The operator checking whether the maximum is in the range.
     * @param min The minimum value for the maximum.
     * @param max The maximum value for the maximum.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMaximumArgIntension(List<IUniverseIntensionConstraint> intensionConstraints,
            UniverseSetBelongingOperator operator, BigInteger min, BigInteger max);

    /**
     * Adds a {@code maximum-arg} constraint to this solver.
     *
     * @param intensionConstraints The intension constraints to compute the maximum of.
     * @param operator The operator checking whether the maximum is in the set.
     * @param set The allowed values for the maximum.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMaximumArgIntension(List<IUniverseIntensionConstraint> intensionConstraints,
            UniverseSetBelongingOperator operator, List<BigInteger> set);

    /**
     * Adds a {@code no-overlap} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param length The length associated to the variables.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addNoOverlap(List<String> variables, List<BigInteger> length);

    /**
     * Adds a {@code no-overlap} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param length The length associated to the variables.
     * @param zeroIgnored Whether {@code 0}-lengths should be ignored.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addNoOverlap(List<String> variables, List<BigInteger> length, boolean zeroIgnored);

    /**
     * Adds a {@code no-overlap} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param length The variable for the length of the other variables.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addNoOverlapVariableLength(List<String> variables, List<String> length);

    /**
     * Adds a {@code no-overlap} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param length The variable for the length of the other variables.
     * @param zeroIgnored Whether {@code 0}-lengths should be ignored.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addNoOverlapVariableLength(List<String> variables, List<String> length,
            boolean zeroIgnored);

    /**
     * Adds a {@code no-overlap} constraint to this solver.
     *
     * @param xVariables The variables appearing in the constraint on the x-axis.
     * @param yVariables The variables appearing in the constraint on the y-axis.
     * @param xLength The variables for the lengths associated to the variables on the
     *        x-axis.
     * @param yLength The lengths associated to the variables on the y-axis.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addBiDimensionalNoOverlap(List<String> xVariables, List<String> yVariables,
            List<String> xLength, List<BigInteger> yLength);

    /**
     * Adds a {@code no-overlap} constraint to this solver.
     *
     * @param xVariables The variables appearing in the constraint on the x-axis.
     * @param yVariables The variables appearing in the constraint on the y-axis.
     * @param xLength The variables for the lengths associated to the variables on the
     *        x-axis.
     * @param yLength The lengths associated to the variables on the y-axis.
     * @param zeroIgnored Whether {@code 0}-lengths should be ignored.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addBiDimensionalNoOverlap(List<String> xVariables, List<String> yVariables,
            List<String> xLength, List<BigInteger> yLength, boolean zeroIgnored);

    /**
     * Adds a {@code no-overlap} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param length The length associated to the variables.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMultiDimensionalNoOverlap(List<List<String>> variables, List<List<BigInteger>> length);

    /**
     * Adds a {@code no-overlap} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param length The length associated to the variables.
     * @param zeroIgnored Whether {@code 0}-lengths should be ignored.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMultiDimensionalNoOverlap(List<List<String>> variables, List<List<BigInteger>> length,
            boolean zeroIgnored);

    /**
     * Adds a {@code no-overlap} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param length The variable for the length of the other variables.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMultiDimensionalNoOverlapVariableLength(List<List<String>> variables,
            List<List<String>> length);

    /**
     * Adds a {@code no-overlap} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param length The variable for the length of the other variables.
     * @param zeroIgnored Whether {@code 0}-lengths should be ignored.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMultiDimensionalNoOverlapVariableLength(List<List<String>> variables,
            List<List<String>> length, boolean zeroIgnored);

    /**
     * Adds an {@code ordered} constraint to this solver.
     *
     * @param variables The variables that should be ordered.
     * @param operator The relational operator defining the order of the variables.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addOrdered(List<String> variables, UniverseRelationalOperator operator);

    /**
     * Adds an {@code ordered} constraint to this solver.
     *
     * @param variables The variables that should be ordered.
     * @param lengths The lengths that must exist between two consecutive variables.
     * @param operator The relational operator defining the order of the variables.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addOrderedWithConstantLength(List<String> variables, List<BigInteger> lengths,
            UniverseRelationalOperator operator);

    /**
     * Adds an {@code ordered} constraint to this solver.
     *
     * @param variables The variables that should be ordered.
     * @param lengths The variables encoding the lengths that must exist between two
     *        consecutive variables.
     * @param operator The relational operator defining the order of the variables.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addOrderedWithVariableLength(List<String> variables, List<String> lengths,
            UniverseRelationalOperator operator);

    /**
     * Adds an {@code all-equal} constraint to this solver.
     *
     * @param variables The variables that should all be equal.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addAllEqual(List<String> variables);

    /**
     * Adds an {@code all-equal} constraint to this solver.
     *
     * @param expressions The expressions that should all be equal.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addAllEqualIntension(List<IUniverseIntensionConstraint> expressions);

    /**
     * Adds a {@code not-all-equal} constraint to this solver.
     *
     * @param variables The variables that should not be all equal.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addNotAllEqual(List<String> variables);

    /**
     * Adds a {@code lex} constraint to this solver.
     *
     * @param tuples The tuple of variables that should be lexicographically ordered.
     * @param operator The relational operator defining the order of the tuples.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addLex(List<List<String>> tuples, UniverseRelationalOperator operator);

    /**
     * Adds a {@code lex} constraint to this solver.
     *
     * @param variables The variables that should be lexicographically ordered.
     * @param limit The limits of the constraint.
     * @param operator The relational operator defining the order of the tuples.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addLex(List<String> variables, List<BigInteger> limit,
            UniverseRelationalOperator operator);

    /**
     * Adds a {@code lex-matrix} constraint to this solver.
     *
     * @param matrix The matrix of variables that should be lexicographically ordered.
     * @param operator The relational operator defining the order in the matrix.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addLexMatrix(List<List<String>> matrix, UniverseRelationalOperator operator);

    /**
     * Adds a {@code sum} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param operator The relational operator used in the constraint.
     * @param value The value of the right-hand side of the constraint.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addSum(List<String> variables, UniverseRelationalOperator operator, BigInteger value);

    /**
     * Adds a {@code sum} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param operator The relational operator used in the constraint.
     * @param rightVariable The variable on the right-hand side of the constraint.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addSum(List<String> variables, UniverseRelationalOperator operator, String rightVariable);

    /**
     * Adds a {@code sum} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param operator The set operator used in the constraint.
     * @param min The minimum value for the sum.
     * @param max The maximum value for the sum.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addSum(List<String> variables, UniverseSetBelongingOperator operator, BigInteger min,
            BigInteger max);

    /**
     * Adds a {@code sum} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param operator The set operator used in the constraint.
     * @param values The set of allowed values for the sum.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addSum(List<String> variables, UniverseSetBelongingOperator operator,
            List<BigInteger> values);

    /**
     * Adds a {@code sum} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param coefficients The coefficients of the variables in the sum.
     * @param operator The relational operator used in the constraint.
     * @param value The value of the right-hand side of the constraint.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addSum(List<String> variables, List<BigInteger> coefficients,
            UniverseRelationalOperator operator, BigInteger value);

    /**
     * Adds a {@code sum} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param coefficients The coefficients of the variables in the sum.
     * @param operator The relational operator used in the constraint.
     * @param rightVariable The variable on the right-hand side of the constraint.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addSum(List<String> variables, List<BigInteger> coefficients,
            UniverseRelationalOperator operator, String rightVariable);

    /**
     * Adds a {@code sum} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param coefficients The coefficients of the variables in the sum.
     * @param operator The set operator used in the constraint.
     * @param min The minimum value for the sum.
     * @param max The maximum value for the sum.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addSum(List<String> variables, List<BigInteger> coefficients,
            UniverseSetBelongingOperator operator, BigInteger min, BigInteger max);

    /**
     * Adds a {@code sum} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param coefficients The coefficients of the variables in the sum.
     * @param operator The set operator used in the constraint.
     * @param values The set of allowed values for the sum.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addSum(List<String> variables, List<BigInteger> coefficients,
            UniverseSetBelongingOperator operator, List<BigInteger> values);

    /**
     * Adds a {@code sum} constraint to this solver.
     *
     * @param expressions The expressions appearing in the constraint.
     * @param operator The relational operator used in the constraint.
     * @param value The value of the right-hand side of the constraint.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addSumIntension(List<IUniverseIntensionConstraint> expressions,
            UniverseRelationalOperator operator, BigInteger value);

    /**
     * Adds a {@code sum} constraint to this solver.
     *
     * @param expressions The expressions appearing in the constraint.
     * @param operator The relational operator used in the constraint.
     * @param rightVariable The variable on the right-hand side of the constraint.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addSumIntension(List<IUniverseIntensionConstraint> expressions,
            UniverseRelationalOperator operator, String rightVariable);

    /**
     * Adds a {@code sum} constraint to this solver.
     *
     * @param expressions The expressions appearing in the constraint.
     * @param operator The set operator used in the constraint.
     * @param min The minimum value for the sum.
     * @param max The maximum value for the sum.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addSumIntension(List<IUniverseIntensionConstraint> expressions,
            UniverseSetBelongingOperator operator, BigInteger min, BigInteger max);

    /**
     * Adds a {@code sum} constraint to this solver.
     *
     * @param expressions The expressions appearing in the constraint.
     * @param operator The set operator used in the constraint.
     * @param values The set of allowed values for the sum.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addSumIntension(List<IUniverseIntensionConstraint> expressions,
            UniverseSetBelongingOperator operator, List<BigInteger> values);

    /**
     * Adds a {@code sum} constraint to this solver.
     *
     * @param expressions The expressions appearing in the constraint.
     * @param coefficients The coefficients of the variables in the sum.
     * @param operator The relational operator used in the constraint.
     * @param value The value of the right-hand side of the constraint.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addSumIntension(List<IUniverseIntensionConstraint> expressions,
            List<BigInteger> coefficients, UniverseRelationalOperator operator, BigInteger value);

    /**
     * Adds a {@code sum} constraint to this solver.
     *
     * @param expressions The expressions appearing in the constraint.
     * @param coefficients The coefficients of the variables in the sum.
     * @param operator The relational operator used in the constraint.
     * @param rightVariable The variable on the right-hand side of the constraint.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addSumIntension(List<IUniverseIntensionConstraint> expressions,
            List<BigInteger> coefficients, UniverseRelationalOperator operator,
            String rightVariable);

    /**
     * Adds a {@code sum} constraint to this solver.
     *
     * @param expressions The expressions appearing in the constraint.
     * @param coefficients The coefficients of the variables in the sum.
     * @param operator The set operator used in the constraint.
     * @param min The minimum value for the sum.
     * @param max The maximum value for the sum.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addSumIntension(List<IUniverseIntensionConstraint> expressions,
            List<BigInteger> coefficients, UniverseSetBelongingOperator operator, BigInteger min,
            BigInteger max);

    /**
     * Adds a {@code sum} constraint to this solver.
     *
     * @param expressions The expressions appearing in the constraint.
     * @param coefficients The coefficients of the variables in the sum.
     * @param operator The set operator used in the constraint.
     * @param values The set of allowed values for the sum.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addSumIntension(List<IUniverseIntensionConstraint> expressions,
            List<BigInteger> coefficients, UniverseSetBelongingOperator operator,
            List<BigInteger> values);

    /**
     * Adds a {@code sum} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param coefficients The coefficients of the variables in the sum.
     * @param operator The relational operator used in the constraint.
     * @param value The value of the right-hand side of the constraint.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addSumWithVariableCoefficients(List<String> variables, List<String> coefficients,
            UniverseRelationalOperator operator, BigInteger value);

    /**
     * Adds a {@code sum} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param coefficients The coefficients of the variables in the sum.
     * @param operator The relational operator used in the constraint.
     * @param rightVariable The variable on the right-hand side of the constraint.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addSumWithVariableCoefficients(List<String> variables, List<String> coefficients,
            UniverseRelationalOperator operator, String rightVariable);

    /**
     * Adds a {@code sum} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param coefficients The coefficients of the variables in the sum.
     * @param operator The set operator used in the constraint.
     * @param min The minimum value for the sum.
     * @param max The maximum value for the sum.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addSumWithVariableCoefficients(List<String> variables, List<String> coefficients,
            UniverseSetBelongingOperator operator, BigInteger min, BigInteger max);

    /**
     * Adds a {@code sum} constraint to this solver.
     *
     * @param variables The variables appearing in the constraint.
     * @param coefficients The coefficients of the variables in the sum.
     * @param operator The set operator used in the constraint.
     * @param values The set of allowed values for the sum.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addSumWithVariableCoefficients(List<String> variables, List<String> coefficients,
            UniverseSetBelongingOperator operator, List<BigInteger> values);

    /**
     * Adds a {@code sum} constraint to this solver.
     *
     * @param expressions The expressions appearing in the constraint.
     * @param operator The set operator used in the constraint.
     * @param values The set of allowed values for the sum.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addSumIntensionWithVariableCoefficients(List<IUniverseIntensionConstraint> expressions,
            UniverseSetBelongingOperator operator, List<BigInteger> values);

    /**
     * Adds a {@code sum} constraint to this solver.
     *
     * @param expressions The expressions appearing in the constraint.
     * @param coefficients The coefficients of the variables in the sum.
     * @param operator The relational operator used in the constraint.
     * @param value The value of the right-hand side of the constraint.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addSumIntensionWithVariableCoefficients(List<IUniverseIntensionConstraint> expressions,
            List<String> coefficients, UniverseRelationalOperator operator, BigInteger value);

    /**
     * Adds a {@code sum} constraint to this solver.
     *
     * @param expressions The expressions appearing in the constraint.
     * @param coefficients The coefficients of the variables in the sum.
     * @param operator The relational operator used in the constraint.
     * @param rightVariable The variable on the right-hand side of the constraint.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addSumIntensionWithVariableCoefficients(List<IUniverseIntensionConstraint> expressions,
            List<String> coefficients, UniverseRelationalOperator operator, String rightVariable);

    /**
     * Adds a {@code sum} constraint to this solver.
     *
     * @param expressions The expressions appearing in the constraint.
     * @param coefficients The coefficients of the variables in the sum.
     * @param operator The set operator used in the constraint.
     * @param min The minimum value for the sum.
     * @param max The maximum value for the sum.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addSumIntensionWithVariableCoefficients(List<IUniverseIntensionConstraint> expressions,
            List<String> coefficients, UniverseSetBelongingOperator operator, BigInteger min,
            BigInteger max);

    /**
     * Adds a {@code sum} constraint to this solver.
     *
     * @param expressions The expressions appearing in the constraint.
     * @param coefficients The coefficients of the variables in the sum.
     * @param operator The set operator used in the constraint.
     * @param values The set of allowed values for the sum.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addSumIntensionWithVariableCoefficients(List<IUniverseIntensionConstraint> expressions,
            List<String> coefficients, UniverseSetBelongingOperator operator,
            List<BigInteger> values);

    /**
     * Adds a {@code circuit} constraint to this solver.
     *
     * @param variables The variables representing the circuit.
     * @param startIndex The index of the variable at which the circuit starts.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCircuit(List<String> variables, int startIndex);

    /**
     * Adds a {@code circuit} constraint to this solver.
     *
     * @param variables The variables representing the circuit.
     * @param startIndex The index of the variable at which the circuit starts.
     * @param size The size of the expected circuit.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCircuit(List<String> variables, int startIndex, BigInteger size);

    /**
     * Adds a {@code circuit} constraint to this solver.
     *
     * @param variables The variables representing the circuit.
     * @param startIndex The index of the variable at which the circuit starts.
     * @param size The variable encoding the size of the expected circuit.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addCircuit(List<String> variables, int startIndex, String size);

    /**
     * Adds an {@code mdd} constraint to this solver.
     *
     * @param variables The variables encoding a path in the MDD.
     * @param transitions The transitions of the MDD.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addMDD(List<String> variables, List<UniverseTransition> transitions);

    /**
     * Adds a {@code regular} constraint to this solver.
     *
     * @param variables The variables encoding a path in the MDD.
     * @param transitions The transitions of the MDD.
     * @param startState The variable encoding the start state of the MDD.
     * @param finalStates The variables encoding the final states of the MDD.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addRegular(List<String> variables, List<UniverseTransition> transitions,
            String startState, List<String> finalStates);

    /**
     * Adds a {@code flow} constraint to this solver.
     *
     * @param variables The variable encoding the flow.
     * @param balance The balance in the network, i.e., the difference between input and
     *        output flows.
     * @param edges The edges in the network.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addFlow(List<String> variables, List<BigInteger> balance, List<List<BigInteger>> edges);

    /**
     * Adds a {@code flow} constraint to this solver.
     *
     * @param variables The variable encoding the flow.
     * @param balance The balance in the network, i.e., the difference between input and
     *        output flows.
     * @param edges The edges in the network.
     * @param weights The weights on the edges of the network.
     * @param operator The operator comparing the total cost.
     * @param totalCost The total cost of the flow.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addFlow(List<String> variables, List<BigInteger> balance, List<List<BigInteger>> edges,
            List<BigInteger> weights, UniverseRelationalOperator operator, BigInteger totalCost);

    /**
     * Adds a {@code flow} constraint to this solver.
     *
     * @param variables The variable encoding the flow.
     * @param balance The balance in the network, i.e., the difference between input and
     *        output flows.
     * @param edges The edges in the network.
     * @param weights The weights on the edges of the network.
     * @param operator The operator comparing the total cost.
     * @param totalCost The variable encoding the total cost of the flow.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addFlow(List<String> variables, List<BigInteger> balance, List<List<BigInteger>> edges,
            List<BigInteger> weights, UniverseRelationalOperator operator, String totalCost);

    /**
     * Adds a {@code flow} constraint to this solver.
     *
     * @param variables The variable encoding the flow.
     * @param balance The balance in the network, i.e., the difference between input and
     *        output flows.
     * @param edges The edges in the network.
     * @param weights The weights on the edges of the network.
     * @param operator The operator comparing the total cost.
     * @param min The minimum total cost of the flow.
     * @param max The maximum total cost of the flow.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addFlow(List<String> variables, List<BigInteger> balance, List<List<BigInteger>> edges,
            List<BigInteger> weights, UniverseSetBelongingOperator operator, BigInteger min,
            BigInteger max);

    /**
     * Adds a {@code flow} constraint to this solver.
     *
     * @param variables The variable encoding the flow.
     * @param balance The balance in the network, i.e., the difference between input and
     *        output flows.
     * @param edges The edges in the network.
     * @param weights The weights on the edges of the network.
     * @param operator The operator comparing the total cost.
     * @param set The possible values for the total cost.
     *
     * @throws UniverseContradictionException If adding the constraint results in a
     *         trivial inconsistency.
     */
    void addFlow(List<String> variables, List<BigInteger> balance, List<List<BigInteger>> edges,
            List<BigInteger> weights, UniverseSetBelongingOperator operator, List<BigInteger> set);

    /**
     * Adds an objective function to this solver to minimize the value assigned to a
     * variable.
     *
     * @param variable The variable to minimize the value of.
     */
    void minimizeVariable(String variable);

    /**
     * Adds an objective function to this solver to maximize the value assigned to a
     * variable.
     *
     * @param variable The variable to maximize the value of.
     */
    void maximizeVariable(String variable);

    /**
     * Adds an objective function to this solver to minimize the value of an expression.
     *
     * @param expression The expression to minimize the value of.
     */
    void minimizeExpression(IUniverseIntensionConstraint expression);

    /**
     * Adds an objective function to this solver to maximize the value of an expression.
     *
     * @param expression The expression to maximize the value of.
     */
    void maximizeExpression(IUniverseIntensionConstraint expression);

    /**
     * Adds an objective function to this solver to minimize a sum of variables.
     *
     * @param variables The variables to minimize the sum of.
     */
    void minimizeSum(List<String> variables);

    /**
     * Adds an objective function to this solver to minimize a sum of variables.
     *
     * @param variables The variables to minimize the sum of.
     * @param coefficients The coefficients of the variables in the sum.
     */
    void minimizeSum(List<String> variables, List<BigInteger> coefficients);

    /**
     * Adds an objective function to this solver to minimize a sum of expressions.
     *
     * @param expressions The expressions to minimize the sum of.
     */
    void minimizeExpressionSum(List<IUniverseIntensionConstraint> expressions);

    /**
     * Adds an objective function to this solver to minimize a sum of expressions.
     *
     * @param expressions The expressions to minimize the sum of.
     * @param coefficients The coefficients of the expressions in the sum.
     */
    void minimizeExpressionSum(List<IUniverseIntensionConstraint> expressions,
            List<BigInteger> coefficients);

    /**
     * Adds an objective function to this solver to maximize a sum of variables.
     *
     * @param variables The variables to maximize the sum of.
     */
    void maximizeSum(List<String> variables);

    /**
     * Adds an objective function to this solver to maximize a sum of variables.
     *
     * @param variables The variables to maximize the sum of.
     * @param coefficients The coefficients of the variables in the sum.
     */
    void maximizeSum(List<String> variables, List<BigInteger> coefficients);

    /**
     * Adds an objective function to this solver to maximize a sum of expressions.
     *
     * @param expressions The expressions to maximize the sum of.
     */
    void maximizeExpressionSum(List<IUniverseIntensionConstraint> expressions);

    /**
     * Adds an objective function to this solver to maximize a sum of expressions.
     *
     * @param expressions The expressions to maximize the sum of.
     * @param coefficients The coefficients of the expressions in the sum.
     */
    void maximizeExpressionSum(List<IUniverseIntensionConstraint> expressions,
            List<BigInteger> coefficients);

    /**
     * Adds an objective function to this solver to minimize a product of variables.
     *
     * @param variables The variables to minimize the product of.
     */
    void minimizeProduct(List<String> variables);

    /**
     * Adds an objective function to this solver to minimize a product of variables.
     *
     * @param variables The variables to minimize the product of.
     * @param coefficients The coefficients of the variables in the product.
     */
    void minimizeProduct(List<String> variables, List<BigInteger> coefficients);

    /**
     * Adds an objective function to this solver to minimize a product of expressions.
     *
     * @param expressions The expressions to minimize the product of.
     */
    void minimizeExpressionProduct(List<IUniverseIntensionConstraint> expressions);

    /**
     * Adds an objective function to this solver to minimize a product of expressions.
     *
     * @param expressions The expressions to minimize the product of.
     * @param coefficients The coefficients of the expressions in the product.
     */
    void minimizeExpressionProduct(List<IUniverseIntensionConstraint> expressions,
            List<BigInteger> coefficients);

    /**
     * Adds an objective function to this solver to maximize a product of variables.
     *
     * @param variables The variables to maximize the product of.
     */
    void maximizeProduct(List<String> variables);

    /**
     * Adds an objective function to this solver to maximize a product of variables.
     *
     * @param variables The variables to maximize the product of.
     * @param coefficients The coefficients of the variables in the product.
     */
    void maximizeProduct(List<String> variables, List<BigInteger> coefficients);

    /**
     * Adds an objective function to this solver to maximize a product of expressions.
     *
     * @param expressions The expressions to maximize the product of.
     */
    void maximizeExpressionProduct(List<IUniverseIntensionConstraint> expressions);

    /**
     * Adds an objective function to this solver to maximize a product of expressions.
     *
     * @param expressions The expressions to maximize the product of.
     * @param coefficients The coefficients of the expressions in the product.
     */
    void maximizeExpressionProduct(List<IUniverseIntensionConstraint> expressions,
            List<BigInteger> coefficients);

    /**
     * Adds an objective function to this solver to minimize the minimum of variables.
     *
     * @param variables The variables to minimize the minimum of.
     */
    void minimizeMinimum(List<String> variables);

    /**
     * Adds an objective function to this solver to minimize the minimum of variables.
     *
     * @param variables The variables to minimize the minimum of.
     * @param coefficients The coefficients of the variables in the minimum.
     */
    void minimizeMinimum(List<String> variables, List<BigInteger> coefficients);

    /**
     * Adds an objective function to this solver to minimize the minimum of expressions.
     *
     * @param expressions The expressions to minimize the minimum of.
     */
    void minimizeExpressionMinimum(List<IUniverseIntensionConstraint> expressions);

    /**
     * Adds an objective function to this solver to minimize the minimum of expressions.
     *
     * @param expressions The expressions to minimize the minimum of.
     * @param coefficients The coefficients of the expressions in the minimum.
     */
    void minimizeExpressionMinimum(List<IUniverseIntensionConstraint> expressions,
            List<BigInteger> coefficients);

    /**
     * Adds an objective function to this solver to maximize the minimum of variables.
     *
     * @param variables The variables to maximize the minimum of.
     */
    void maximizeMinimum(List<String> variables);

    /**
     * Adds an objective function to this solver to maximize the minimum of variables.
     *
     * @param variables The variables to maximize the minimum of.
     * @param coefficients The coefficients of the variables in the minimum.
     */
    void maximizeMinimum(List<String> variables, List<BigInteger> coefficients);

    /**
     * Adds an objective function to this solver to maximize the minimum of expressions.
     *
     * @param expressions The expressions to maximize the minimum of.
     */
    void maximizeExpressionMinimum(List<IUniverseIntensionConstraint> expressions);

    /**
     * Adds an objective function to this solver to maximize the minimum of expressions.
     *
     * @param expressions The expressions to maximize the minimum of.
     * @param coefficients The coefficients of the expressions in the minimum.
     */
    void maximizeExpressionMinimum(List<IUniverseIntensionConstraint> expressions,
            List<BigInteger> coefficients);

    /**
     * Adds an objective function to this solver to minimize the maximum of variables.
     *
     * @param variables The variables to minimize the maximum of.
     */
    void minimizeMaximum(List<String> variables);

    /**
     * Adds an objective function to this solver to minimize the maximum of variables.
     *
     * @param variables The variables to minimize the maximum of.
     * @param coefficients The coefficients of the variables in the maximum.
     */
    void minimizeMaximum(List<String> variables, List<BigInteger> coefficients);

    /**
     * Adds an objective function to this solver to minimize the maximum of expressions.
     *
     * @param expressions The expressions to minimize the maximum of.
     */
    void minimizeExpressionMaximum(List<IUniverseIntensionConstraint> expressions);

    /**
     * Adds an objective function to this solver to minimize the maximum of expressions.
     *
     * @param expressions The expressions to minimize the maximum of.
     * @param coefficients The coefficients of the expressions in the maximum.
     */
    void minimizeExpressionMaximum(List<IUniverseIntensionConstraint> expressions,
            List<BigInteger> coefficients);

    /**
     * Adds an objective function to this solver to maximize the maximum of variables.
     *
     * @param variables The variables to maximize the maximum of.
     */
    void maximizeMaximum(List<String> variables);

    /**
     * Adds an objective function to this solver to maximize the maximum of variables.
     *
     * @param variables The variables to maximize the maximum of.
     * @param coefficients The coefficients of the variables in the maximum.
     */
    void maximizeMaximum(List<String> variables, List<BigInteger> coefficients);

    /**
     * Adds an objective function to this solver to maximize the maximum of expressions.
     *
     * @param expressions The expressions to maximize the maximum of.
     */
    void maximizeExpressionMaximum(List<IUniverseIntensionConstraint> expressions);

    /**
     * Adds an objective function to this solver to maximize the maximum of expressions.
     *
     * @param expressions The expressions to maximize the maximum of.
     * @param coefficients The coefficients of the expressions in the maximum.
     */
    void maximizeExpressionMaximum(List<IUniverseIntensionConstraint> expressions,
            List<BigInteger> coefficients);

    /**
     * Adds an objective function to this solver to minimize the number of values assigned
     * to variables.
     *
     * @param variables The variables to minimize the number of values of.
     */
    void minimizeNValues(List<String> variables);

    /**
     * Adds an objective function to this solver to minimize the number of values assigned
     * to variables.
     *
     * @param variables The variables to minimize the number of values of.
     * @param coefficients The coefficients of the variables.
     */
    void minimizeNValues(List<String> variables, List<BigInteger> coefficients);

    /**
     * Adds an objective function to this solver to minimize the number of values assigned
     * to variables.
     *
     * @param expressions The expressions to minimize the number of values of.
     */
    void minimizeExpressionNValues(List<IUniverseIntensionConstraint> expressions);

    /**
     * Adds an objective function to this solver to minimize the number of values assigned
     * to variables.
     *
     * @param expressions The expressions to minimize the number of values of.
     * @param coefficients The coefficients of the expressions.
     */
    void minimizeExpressionNValues(List<IUniverseIntensionConstraint> expressions,
            List<BigInteger> coefficients);

    /**
     * Adds an objective function to this solver to maximize the number of values assigned
     * to variables.
     *
     * @param variables The variables to maximize the number of values of.
     */
    void maximizeNValues(List<String> variables);

    /**
     * Adds an objective function to this solver to maximize the number of values assigned
     * to variables.
     *
     * @param variables The variables to maximize the number of values of.
     * @param coefficients The coefficients of the variables.
     */
    void maximizeNValues(List<String> variables, List<BigInteger> coefficients);

    /**
     * Adds an objective function to this solver to maximize the number of values assigned
     * to variables.
     *
     * @param expressions The expressions to maximize the number of values of.
     */
    void maximizeExpressionNValues(List<IUniverseIntensionConstraint> expressions);

    /**
     * Adds an objective function to this solver to maximize the number of values assigned
     * to variables.
     *
     * @param expressions The expressions to maximize the number of values of.
     * @param coefficients The coefficients of the expressions.
     */
    void maximizeExpressionNValues(List<IUniverseIntensionConstraint> expressions,
            List<BigInteger> coefficients);

}
