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

package fr.univartois.cril.juniverse.csp;

import java.math.BigInteger;
import java.util.List;

import fr.univartois.cril.juniverse.core.UniverseContradictionException;
import fr.univartois.cril.juniverse.csp.intension.IIntensionConstraint;
import fr.univartois.cril.juniverse.csp.operator.UniverseArithmeticOperator;
import fr.univartois.cril.juniverse.csp.operator.UniverseBooleanOperator;
import fr.univartois.cril.juniverse.csp.operator.UniverseRelationalOperator;
import fr.univartois.cril.juniverse.csp.operator.UniverseSetBelongingOperator;
import fr.univartois.cril.juniverse.pb.IUniversePseudoBooleanSolver;

/**
 * The IUniverseCSPSolver
 *
 * @author Thibault Falque
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public interface IUniverseCSPSolver extends IUniversePseudoBooleanSolver {
	/**
	 * Notifies this listener that a new variable is to be created.
	 *
	 * @param id  The identifier of the variable to create.
	 * @param min The minimum value of the domain of the variable.
	 * @param max The maximum value of the domain of the variable.
	 */
	void newVariable(String id, int min, int max);

	/**
	 * Notifies this listener that a new variable is to be created.
	 *
	 * @param id  The identifier of the variable to create.
	 * @param min The minimum value of the domain of the variable.
	 * @param max The maximum value of the domain of the variable.
	 */
	void newVariable(String id, BigInteger min, BigInteger max);

	/**
	 * Notifies this listener that a new variable is to be created.
	 *
	 * @param id     The identifier of the variable to create.
	 * @param values The values of the domain of the variable.
	 */
	void newVariable(String id, List<? extends Number> values);

	/**
	 * Notifies this listener that an {@code instantiation} constraint is to be
	 * added.
	 *
	 * @param variable The variable to assign.
	 * @param value    The value to assign to the variable.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addInstantiation(String variable, int value);

	/**
	 * Notifies this listener that an {@code instantiation} constraint is to be
	 * added.
	 *
	 * @param variable The variable to assign.
	 * @param value    The value to assign to the variable.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addInstantiation(String variable, BigInteger value);

	/**
	 * Notifies this listener that an {@code instantiation} constraint is to be
	 * added.
	 *
	 * @param variables The variables to assign.
	 * @param values    The values to assign to the variables.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addInstantiation(List<String> variables, List<? extends Number> values);

	/**
	 * Notifies this listener that a {@code clause} constraint is to be added.
	 *
	 * @param positive The (Boolean) variables appearing positively in the clause.
	 * @param negative The (Boolean) variables appearing negatively in the clause.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addClause(List<String> positive, List<String> negative);

	/**
	 * Notifies this listener that a {@code logical} constraint is to be added.
	 *
	 * @param operator  The Boolean operator to apply on the variables.
	 * @param variables The (Boolean) variables on which the operator is applied.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addLogical(UniverseBooleanOperator operator, List<String> variables);

	/**
	 * Notifies this listener that a {@code logical} constraint is to be added.
	 *
	 * @param variable  The (Boolean) variable whose assignment depends on the truth
	 *                  value of the logical operations.
	 * @param equiv     Whether {@code variable} must be equivalent to the truth
	 *                  value of the logical operations.
	 * @param operator  The Boolean operator to apply on the variables.
	 * @param variables The (Boolean) variables on which the operator is applied.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addLogical(String variable, boolean equiv, UniverseBooleanOperator operator, List<String> variables);

	/**
	 * Notifies this listener that a {@code logical} constraint is to be added.
	 *
	 * @param variable The (Boolean) variable whose assignment depends on the truth
	 *                 value of the comparison between {@code left} and
	 *                 {@code right}.
	 * @param left     The variable on the left-hand side of the comparison.
	 * @param operator The relational operator used to compare {@code left} and
	 *                 {@code right}.
	 * @param right    The value on the right-hand side of the comparison.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addLogical(String variable, String left, UniverseRelationalOperator operator, BigInteger right);

	/**
	 * Notifies this listener that a {@code logical} constraint is to be added.
	 *
	 * @param variable The (Boolean) variable whose assignment depends on the truth
	 *                 value of the comparison between {@code left} and
	 *                 {@code right}.
	 * @param left     The variable on the left-hand side of the comparison.
	 * @param operator The relational operator used to compare {@code left} and
	 *                 {@code right}.
	 * @param right    The variable on the right-hand side of the comparison.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addLogical(String variable, String left, UniverseRelationalOperator operator, String right);

	/**
	 * Notifies this listener that an {@code all-different} constraint is to be
	 * added.
	 *
	 * @param variables The variables that should all be different.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addAllDifferent(List<String> variables);

	/**
	 * Notifies this listener that an {@code all-different} constraint is to be
	 * added.
	 *
	 * @param variables The variables that should all be different.
	 * @param except    The values not to consider in the constraint.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addAllDifferent(List<String> variables, List<BigInteger> except);

	/**
	 * Notifies this listener that an {@code all-different} constraint is to be
	 * added.
	 *
	 * @param variableMatrix The matrix of variables that should all be different.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addAllDifferentMatrix(List<List<String>> variableMatrix);

	/**
	 * Notifies this listener that an {@code all-different} constraint is to be
	 * added.
	 *
	 * @param variableMatrix The matrix of variables that should all be different.
	 * @param except         The values not to consider in the constraint.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addAllDifferentMatrix(List<List<String>> variableMatrix, List<BigInteger> except);

	/**
	 * Notifies this listener that an {@code all-different} constraint is to be
	 * added.
	 *
	 * @param variableLists The lists of variables that should all be different.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addAllDifferentList(List<List<String>> variableLists);

	/**
	 * Notifies this listener that an {@code all-different} constraint is to be
	 * added.
	 *
	 * @param intensionConstraints The intension constraints that should all be
	 *                             different.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addAllDifferentIntension(List<IIntensionConstraint> intensionConstraints);

	/**
	 * Notifies this listener that a {@code cardinality} constraint is to be added.
	 *
	 * @param variables The variables to count the assignments of.
	 * @param values    The assignable values to count.
	 * @param occurs    The number of times each value can be assigned.
	 * @param closed    Whether only the values in {@code value} can be assigned to
	 *                  the variables.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addCardinalityWithConstantValuesAndConstantCounts(List<String> variables, List<BigInteger> values,
			List<BigInteger> occurs, boolean closed);

	/**
	 * Notifies this listener that a {@code cardinality} constraint is to be added.
	 *
	 * @param variables The variables to count the assignments of.
	 * @param values    The assignable values to count.
	 * @param occursMin The minimum number of times each value can be assigned.
	 * @param occursMax The maximum number of times each value can be assigned.
	 * @param closed    Whether only the values in {@code value} can be assigned to
	 *                  the variables.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addCardinalityWithConstantValuesAndConstantIntervalCounts(List<String> variables, List<BigInteger> values,
			List<BigInteger> occursMin, List<BigInteger> occursMax, boolean closed);

	/**
	 * Notifies this listener that a {@code cardinality} constraint is to be added.
	 *
	 * @param variables The variables to count the assignments of.
	 * @param values    The assignable values to count.
	 * @param occurs    The variables encoding the number of times each value can be
	 *                  assigned.
	 * @param closed    Whether only the values in {@code value} can be assigned to
	 *                  the variables.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addCardinalityWithConstantValuesAndVariableCounts(List<String> variables, List<BigInteger> values,
			List<String> occurs, boolean closed);

	/**
	 * Notifies this listener that a {@code cardinality} constraint is to be added.
	 *
	 * @param variables The variables to count the assignments of.
	 * @param values    The variables encoding the assignable values to count.
	 * @param occurs    The number of times each value can be assigned.
	 * @param closed    Whether only the values in {@code value} can be assigned to
	 *                  the variables.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addCardinalityWithVariableValuesAndConstantCounts(List<String> variables, List<String> values,
			List<BigInteger> occurs, boolean closed);

	/**
	 * Notifies this listener that a {@code cardinality} constraint is to be added.
	 *
	 * @param variables The variables to count the assignments of.
	 * @param values    The variables encoding the assignable values to count.
	 * @param occursMin The minimum number of times each value can be assigned.
	 * @param occursMax The maximum number of times each value can be assigned.
	 * @param closed    Whether only the values in {@code value} can be assigned to
	 *                  the variables.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addCardinalityWithVariableValuesAndConstantIntervalCounts(List<String> variables, List<String> values,
			List<BigInteger> occursMin, List<BigInteger> occursMax, boolean closed);

	/**
	 * Notifies this listener that a {@code cardinality} constraint is to be added.
	 *
	 * @param variables The variables to count the assignments of.
	 * @param values    The variables encoding the assignable values to count.
	 * @param occurs    The variables encoding the number of times each value can be
	 *                  assigned.
	 * @param closed    Whether only the values in {@code value} can be assigned to
	 *                  the variables.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addCardinalityWithVariableValuesAndVariableCounts(List<String> variables, List<String> values,
			List<String> occurs, boolean closed);

	/**
	 * Notifies this listener that a {@code channel} constraint is to be added.
	 *
	 * @param variables  The variables appearing in the constraint.
	 * @param startIndex The index at which the constraint starts.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addChannel(List<String> variables, int startIndex);

	/**
	 * Notifies this listener that a {@code channel} constraint is to be added.
	 *
	 * @param variables  The variables among which exactly one should be satisfied
	 *                   starting from the given index.
	 * @param startIndex The index at which the constraint starts.
	 * @param value      The variable containing the index of the satisfied
	 *                   variable.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addChannel(List<String> variables, int startIndex, String value);

	/**
	 * Notifies this listener that a {@code channel} constraint is to be added.
	 *
	 * @param variables       The variables appearing in the constraint.
	 * @param startIndex      The index at which the constraint starts on the first
	 *                        vector of variables.
	 * @param otherVariables  The variables with which to channel the variables of
	 *                        the first vector.
	 * @param otherStartIndex The index at which the constraint starts on the second
	 *                        vector of variables.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addChannel(List<String> variables, int startIndex, List<String> otherVariables, int otherStartIndex);

	/**
	 * Notifies this listener that an {@code at-least} constraint is to be added.
	 *
	 * @param variables The variables to count the assignments of.
	 * @param value     The value to count the assignments of.
	 * @param count     The minimum number of times the value can be assigned among
	 *                  the variables.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addAtLeast(List<String> variables, BigInteger value, BigInteger count);

	/**
	 * Notifies this listener that an {@code exactly} constraint is to be added.
	 *
	 * @param variables The variables to count the assignments of.
	 * @param value     The value to count the assignments of.
	 * @param count     The number of times the value can be assigned among the
	 *                  variables.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addExactly(List<String> variables, BigInteger value, BigInteger count);

	/**
	 * Notifies this listener that an {@code exactly} constraint is to be added.
	 *
	 * @param variables The variables to count the assignments of.
	 * @param value     The value to count the assignments of.
	 * @param count     The variable encoding the number of times the value can be
	 *                  assigned among the variables.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addExactly(List<String> variables, BigInteger value, String count);

	/**
	 * Notifies this listener that an {@code among} constraint is to be added.
	 *
	 * @param variables The variables to count the assignments of.
	 * @param values    The values to count the assignments of.
	 * @param count     The number of times the value can be assigned among the
	 *                  variables.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addAmong(List<String> variables, List<BigInteger> values, BigInteger count);

	/**
	 * Notifies this listener that an {@code among} constraint is to be added.
	 *
	 * @param variables The variables to count the assignments of.
	 * @param values    The values to count the assignments of.
	 * @param count     The variable encoding the number of times the values can be
	 *                  assigned among the variables.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addAmong(List<String> variables, List<BigInteger> values, String count);

	/**
	 * Notifies this listener that an {@code at-most} constraint is to be added.
	 *
	 * @param variables The variables to count the assignments of.
	 * @param value     The value to count the assignments of.
	 * @param count     The maximum number of times the value can be assigned among
	 *                  the variables.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addAtMost(List<String> variables, BigInteger value, BigInteger count);

	/**
	 * Notifies this listener that a {@code count} constraint is to be added.
	 *
	 * @param variables The variables to count the assignments of.
	 * @param values    The values to count the assignments of.
	 * @param operator  The operator to use to compare the number of assignments to
	 *                  their expected count.
	 * @param count     The number of times the values can be assigned among the
	 *                  variables.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addCountWithConstantValues(List<String> variables, List<BigInteger> values,
			UniverseRelationalOperator operator, BigInteger count);

	/**
	 * Notifies this listener that a {@code count} constraint is to be added.
	 *
	 * @param variables The variables to count the assignments of.
	 * @param values    The values to count the assignments of.
	 * @param operator  The operator to use to compare the number of assignments to
	 *                  their expected count.
	 * @param count     The variable encoding the number of times the values can be
	 *                  assigned among the variables.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addCountWithConstantValues(List<String> variables, List<BigInteger> values,
			UniverseRelationalOperator operator, String count);

	/**
	 * Notifies this listener that a {@code count} constraint is to be added.
	 *
	 * @param variables The variables to count the assignments of.
	 * @param values    The variables encoding the values to count the assignments
	 *                  of.
	 * @param operator  The operator to use to compare the number of assignments to
	 *                  their expected count.
	 * @param count     The number of times the values can be assigned among the
	 *                  variables.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addCountWithVariableValues(List<String> variables, List<String> values, UniverseRelationalOperator operator,
			BigInteger count);

	/**
	 * Notifies this listener that a {@code count} constraint is to be added.
	 *
	 * @param variables The variables to count the assignments of.
	 * @param values    The variables encoding the values to count the assignments
	 *                  of.
	 * @param operator  The operator to use to compare the number of assignments to
	 *                  their expected count.
	 * @param count     The variable encoding the number of times the values can be
	 *                  assigned among the variables.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addCountWithVariableValues(List<String> variables, List<String> values, UniverseRelationalOperator operator,
			String count);

	/**
	 * Notifies this listener that a {@code count} constraint is to be added.
	 *
	 * @param expressions The expressions to count the assignments of.
	 * @param values      The values to count the assignments of.
	 * @param operator    The operator to use to compare the number of assignments
	 *                    to their expected count.
	 * @param count       The variable encoding the number of times the values can
	 *                    be assigned among the variables.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addCountIntensionWithConstantValues(List<IIntensionConstraint> expressions, List<BigInteger> values,
			UniverseRelationalOperator operator, BigInteger count);

	/**
	 * Notifies this listener that a {@code count} constraint is to be added.
	 *
	 * @param expressions The expressions to count the assignments of.
	 * @param values      The values to count the assignments of.
	 * @param operator    The operator to use to compare the number of assignments
	 *                    to their expected count.
	 * @param count       The variable encoding the number of times the values can
	 *                    be assigned among the variables.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addCountIntensionWithConstantValues(List<IIntensionConstraint> expressions, List<BigInteger> values,
			UniverseRelationalOperator operator, String count);

	/**
	 * Notifies this listener that a {@code cumulative} constraint is to be added.
	 *
	 * @param origins  The variables encoding the origins of the resources.
	 * @param lengths  The lengths of the tasks to assign.
	 * @param heights  The heights of the tasks to assign.
	 * @param operator The operator to compare the cumulative use with.
	 * @param value    The value for the cumulative use.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addCumulativeConstantLengthsConstantHeights(List<String> origins, List<BigInteger> lengths,
			List<BigInteger> heights, UniverseRelationalOperator operator, BigInteger value);

	/**
	 * Notifies this listener that a {@code cumulative} constraint is to be added.
	 *
	 * @param origins  The variables encoding the origins of the resources.
	 * @param lengths  The lengths of the tasks to assign.
	 * @param ends     The variables encoding the ends of the resources.
	 * @param heights  The heights of the tasks to assign.
	 * @param operator The operator to compare the cumulative use with.
	 * @param value    The value for the cumulative use.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addCumulativeConstantLengthsConstantHeights(List<String> origins, List<BigInteger> lengths, List<String> ends,
			List<BigInteger> heights, UniverseRelationalOperator operator, BigInteger value);

	/**
	 * Notifies this listener that a {@code cumulative} constraint is to be added.
	 *
	 * @param origins  The variables encoding the origins of the resources.
	 * @param lengths  The lengths of the tasks to assign.
	 * @param heights  The heights of the tasks to assign.
	 * @param operator The operator to compare the cumulative use with.
	 * @param value    The variable encoding the value for the cumulative use.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addCumulativeConstantLengthsConstantHeights(List<String> origins, List<BigInteger> lengths,
			List<BigInteger> heights, UniverseRelationalOperator operator, String value);

	/**
	 * Notifies this listener that a {@code cumulative} constraint is to be added.
	 *
	 * @param origins  The variables encoding the origins of the resources.
	 * @param lengths  The lengths of the tasks to assign.
	 * @param ends     The variables encoding the ends of the resources.
	 * @param heights  The heights of the tasks to assign.
	 * @param operator The operator to compare the cumulative use with.
	 * @param value    The variable encoding the value for the cumulative use.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addCumulativeConstantLengthsConstantHeights(List<String> origins, List<BigInteger> lengths, List<String> ends,
			List<BigInteger> heights, UniverseRelationalOperator operator, String value);

	/**
	 * Notifies this listener that a {@code cumulative} constraint is to be added.
	 *
	 * @param origins  The variables encoding the origins of the resources.
	 * @param lengths  The lengths of the tasks to assign.
	 * @param heights  The variable encoding the heights of the tasks to assign.
	 * @param operator The operator to compare the cumulative use with.
	 * @param value    The value for the cumulative use.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addCumulativeConstantLengthsVariableHeights(List<String> origins, List<BigInteger> lengths,
			List<String> heights, UniverseRelationalOperator operator, BigInteger value);

	/**
	 * Notifies this listener that a {@code cumulative} constraint is to be added.
	 *
	 * @param origins  The variables encoding the origins of the resources.
	 * @param lengths  The lengths of the tasks to assign.
	 * @param ends     The variables encoding the ends of the resources.
	 * @param heights  The variable encoding the heights of the tasks to assign.
	 * @param operator The operator to compare the cumulative use with.
	 * @param value    The value for the cumulative use.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addCumulativeConstantLengthsVariableHeights(List<String> origins, List<BigInteger> lengths, List<String> ends,
			List<String> heights, UniverseRelationalOperator operator, BigInteger value);

	/**
	 * Notifies this listener that a {@code cumulative} constraint is to be added.
	 *
	 * @param origins  The variables encoding the origins of the resources.
	 * @param lengths  The lengths of the tasks to assign.
	 * @param heights  The variable encoding the heights of the tasks to assign.
	 * @param operator The operator to compare the cumulative use with.
	 * @param value    The variable encoding the value for the cumulative use.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addCumulativeConstantLengthsVariableHeights(List<String> origins, List<BigInteger> lengths,
			List<String> heights, UniverseRelationalOperator operator, String value);

	/**
	 * Notifies this listener that a {@code cumulative} constraint is to be added.
	 *
	 * @param origins  The variables encoding the origins of the resources.
	 * @param lengths  The lengths of the tasks to assign.
	 * @param ends     The variables encoding the ends of the resources.
	 * @param heights  The variable encoding the heights of the tasks to assign.
	 * @param operator The operator to compare the cumulative use with.
	 * @param value    The variable encoding the value for the cumulative use.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addCumulativeConstantLengthsVariableHeights(List<String> origins, List<BigInteger> lengths, List<String> ends,
			List<String> heights, UniverseRelationalOperator operator, String value);

	/**
	 * Notifies this listener that a {@code cumulative} constraint is to be added.
	 *
	 * @param origins  The variables encoding the origins of the resources.
	 * @param lengths  The variables encoding the lengths of the tasks to assign.
	 * @param heights  The heights of the tasks to assign.
	 * @param operator The operator to compare the cumulative use with.
	 * @param value    The value for the cumulative use.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addCumulativeVariableLengthsConstantHeights(List<String> origins, List<String> lengths,
			List<BigInteger> heights, UniverseRelationalOperator operator, BigInteger value);

	/**
	 * Notifies this listener that a {@code cumulative} constraint is to be added.
	 *
	 * @param origins  The variables encoding the origins of the resources.
	 * @param lengths  The variables encoding the lengths of the tasks to assign.
	 * @param ends     The variables encoding the ends of the resources.
	 * @param heights  The heights of the tasks to assign.
	 * @param operator The operator to compare the cumulative use with.
	 * @param value    The value for the cumulative use.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addCumulativeVariableLengthsConstantHeights(List<String> origins, List<String> lengths, List<String> ends,
			List<BigInteger> heights, UniverseRelationalOperator operator, BigInteger value);

	/**
	 * Notifies this listener that a {@code cumulative} constraint is to be added.
	 *
	 * @param origins  The variables encoding the origins of the resources.
	 * @param lengths  The variables encoding the lengths of the tasks to assign.
	 * @param heights  The heights of the tasks to assign.
	 * @param operator The operator to compare the cumulative use with.
	 * @param value    The variable encoding the value for the cumulative use.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addCumulativeVariableLengthsConstantHeights(List<String> origins, List<String> lengths,
			List<BigInteger> heights, UniverseRelationalOperator operator, String value);

	/**
	 * Notifies this listener that a {@code cumulative} constraint is to be added.
	 *
	 * @param origins  The variables encoding the origins of the resources.
	 * @param lengths  The variables encoding the lengths of the tasks to assign.
	 * @param ends     The variables encoding the ends of the resources.
	 * @param heights  The heights of the tasks to assign.
	 * @param operator The operator to compare the cumulative use with.
	 * @param value    The variable encoding the value for the cumulative use.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addCumulativeVariableLengthsConstantHeights(List<String> origins, List<String> lengths, List<String> ends,
			List<BigInteger> heights, UniverseRelationalOperator operator, String value);

	/**
	 * Notifies this listener that a {@code cumulative} constraint is to be added.
	 *
	 * @param origins  The variables encoding the origins of the resources.
	 * @param lengths  The variables encoding the lengths of the tasks to assign.
	 * @param heights  The variables encoding the heights of the tasks to assign.
	 * @param operator The operator to compare the cumulative use with.
	 * @param value    The value for the cumulative use.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addCumulativeVariableLengthsVariableHeights(List<String> origins, List<String> lengths, List<String> heights,
			UniverseRelationalOperator operator, BigInteger value);

	/**
	 * Notifies this listener that a {@code cumulative} constraint is to be added.
	 *
	 * @param origins  The variables encoding the origins of the resources.
	 * @param lengths  The variables encoding the lengths of the tasks to assign.
	 * @param ends     The variables encoding the ends of the resources.
	 * @param heights  The variables encoding the heights of the tasks to assign.
	 * @param operator The operator to compare the cumulative use with.
	 * @param value    The value for the cumulative use.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addCumulativeVariableLengthsVariableHeights(List<String> origins, List<String> lengths, List<String> ends,
			List<String> heights, UniverseRelationalOperator operator, BigInteger value);

	/**
	 * Notifies this listener that a {@code cumulative} constraint is to be added.
	 *
	 * @param origins  The variables encoding the origins of the resources.
	 * @param lengths  The variables encoding the lengths of the tasks to assign.
	 * @param heights  The variables encoding the heights of the tasks to assign.
	 * @param operator The operator to compare the cumulative use with.
	 * @param value    The variable encoding the value for the cumulative use.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addCumulativeVariableLengthsVariableHeights(List<String> origins, List<String> lengths, List<String> heights,
			UniverseRelationalOperator operator, String value);

	/**
	 * Notifies this listener that a {@code cumulative} constraint is to be added.
	 *
	 * @param origins  The variables encoding the origins of the resources.
	 * @param lengths  The variables encoding the lengths of the tasks to assign.
	 * @param ends     The variables encoding the ends of the resources.
	 * @param heights  The variables encoding the heights of the tasks to assign.
	 * @param operator The operator to compare the cumulative use with.
	 * @param value    The variable encoding the value for the cumulative use.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addCumulativeVariableLengthsVariableHeights(List<String> origins, List<String> lengths, List<String> ends,
			List<String> heights, UniverseRelationalOperator operator, String value);

	/**
	 * Notifies this listener that an {@code element} constraint is to be added.
	 *
	 * @param variables The variables appearing in the constraint.
	 * @param value     The value that must appear among the variables.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addElement(List<String> variables, BigInteger value);

	/**
	 * Notifies this listener that an {@code element} constraint is to be added.
	 *
	 * @param variables The variables appearing in the constraint.
	 * @param value     The variable encoding the value that must appear among the
	 *                  variables.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addElement(List<String> variables, String value);

	/**
	 * Notifies this listener that an {@code element} constraint is to be added.
	 *
	 * @param values     The values among which to look for the variable.
	 * @param startIndex The index at which to start looking for the variable.
	 * @param index      The index at which the variable appears in the values.
	 * @param value      The value to look for.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addElementConstantValues(List<BigInteger> values, int startIndex, String index, BigInteger value);

	/**
	 * Notifies this listener that an {@code element} constraint is to be added.
	 *
	 * @param values     The values among which to look for the variable.
	 * @param startIndex The index at which to start looking for the variable.
	 * @param index      The index at which the variable appears in the values.
	 * @param variable   The variable whose value is to be looked for.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addElementConstantValues(List<BigInteger> values, int startIndex, String index, String variable);

	/**
	 * Notifies this listener that an {@code element} constraint is to be added.
	 *
	 * @param variables  The variables among which to look for the value.
	 * @param startIndex The index at which to start looking for the value.
	 * @param index      The index at which the value appears in the variables.
	 * @param value      The value to look for.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addElement(List<String> variables, int startIndex, String index, BigInteger value);

	/**
	 * Notifies this listener that an {@code element} constraint is to be added.
	 *
	 * @param values     The variables representing the values among which to look
	 *                   for the variable.
	 * @param startIndex The index at which to start looking for the variable.
	 * @param index      The index at which the variable appears in the values.
	 * @param variable   The variable whose value is to be looked for.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addElement(List<String> values, int startIndex, String index, String variable);

	/**
	 * Notifies this listener that an {@code element} constraint is to be added.
	 *
	 * @param matrix        The matrix of values among which the value must appear.
	 * @param startRowIndex The index of the row starting from which the value must
	 *                      appear.
	 * @param rowIndex      The variable encoding the index of the row at which the
	 *                      value appears.
	 * @param startColIndex The index of the column starting from which the value
	 *                      must appear.
	 * @param colIndex      The variable encoding the index of the column at which
	 *                      the value appears.
	 * @param value         The value to look for inside the matrix.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addElementConstantMatrix(List<List<BigInteger>> matrix, int startRowIndex, String rowIndex, int startColIndex,
			String colIndex, BigInteger value);

	/**
	 * Notifies this listener that an {@code element} constraint is to be added.
	 *
	 * @param matrix        The matrix of values among which the value must appear.
	 * @param startRowIndex The index of the row starting from which the value must
	 *                      appear.
	 * @param rowIndex      The variable encoding the index of the row at which the
	 *                      value appears.
	 * @param startColIndex The index of the column starting from which the value
	 *                      must appear.
	 * @param colIndex      The variable encoding the index of the column at which
	 *                      the value appears.
	 * @param value         The variable encoding the value to look for inside the
	 *                      matrix.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addElementConstantMatrix(List<List<BigInteger>> matrix, int startRowIndex, String rowIndex, int startColIndex,
			String colIndex, String value);

	/**
	 * Notifies this listener that an {@code element} constraint is to be added.
	 *
	 * @param matrix        The matrix of variables among which the value must be
	 *                      assigned.
	 * @param startRowIndex The index of the row starting from which the value must
	 *                      appear.
	 * @param rowIndex      The variable encoding the index of the row at which the
	 *                      value appears.
	 * @param startColIndex The index of the column starting from which the value
	 *                      must appear.
	 * @param colIndex      The variable encoding the index of the column at which
	 *                      the value appears.
	 * @param value         The variable encoding the value to look for inside the
	 *                      matrix.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addElementMatrix(List<List<String>> matrix, int startRowIndex, String rowIndex, int startColIndex,
			String colIndex, BigInteger value);

	/**
	 * Notifies this listener that an {@code element} constraint is to be added.
	 *
	 * @param matrix        The matrix of variables among which the value must be
	 *                      assigned.
	 * @param startRowIndex The index of the row starting from which the value must
	 *                      appear.
	 * @param rowIndex      The variable encoding the index of the row at which the
	 *                      value appears.
	 * @param startColIndex The index of the column starting from which the value
	 *                      must appear.
	 * @param colIndex      The variable encoding the index of the column at which
	 *                      the value appears.
	 * @param value         The variable encoding the value to look for inside the
	 *                      matrix.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addElementMatrix(List<List<String>> matrix, int startRowIndex, String rowIndex, int startColIndex,
			String colIndex, String value);

	/**
	 * Notifies this listener that an {@code extension} constraint describing the
	 * support of a tuple of variables is to be added.
	 *
	 * @param variable      The variable for which the support is given.
	 * @param allowedValues The values allowed for the variable.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addSupport(String variable, List<BigInteger> allowedValues);

	/**
	 * Notifies this listener that an {@code extension} constraint describing the
	 * support of a tuple of variables is to be added.
	 *
	 * @param variableTuple The tuple of variables for which the support is given.
	 * @param allowedValues The values allowed for the tuple variables. Values equal
	 *                      to {@code null} are interpreted as "any value" (as in
	 *                      so-called "starred tuples").
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addSupport(List<String> variableTuple, List<List<BigInteger>> allowedValues);

	/**
	 * Notifies this listener that an {@code extension} constraint describing the
	 * conflicts of a tuple of variables is to be added.
	 *
	 * @param variable        The variable for which the conflicts are given.
	 * @param forbiddenValues The values forbidden for the variable.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addConflicts(String variable, List<BigInteger> forbiddenValues);

	/**
	 * Notifies this listener that an {@code extension} constraint describing the
	 * conflicts of a tuple of variables is to be added.
	 *
	 * @param variableTuple   The tuple of variables for which the conflicts are
	 *                        given.
	 * @param forbiddenValues The values forbidden for the tuple variables. Values
	 *                        equal to {@code null} are interpreted as "any value"
	 *                        (as in so-called "starred tuples").
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addConflicts(List<String> variableTuple, List<List<BigInteger>> forbiddenValues);

	/**
	 * Notifies this listener that an {@code intension} constraint is to be added.
	 *
	 * @param constr The user-friendly representation of the constraint to add.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addIntension(IIntensionConstraint constr);

	/**
	 * Notifies this listener that a {@code primitive} constraint is to be added.
	 *
	 * @param variable The variable appearing in the constraint.
	 * @param operator The operator used in the constraint.
	 * @param value    The value to compare the variable with.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addPrimitive(String variable, UniverseRelationalOperator operator, BigInteger value);

	/**
	 * Notifies this listener that a {@code primitive} constraint is to be added.
	 *
	 * @param variable      The variable appearing in the constraint.
	 * @param arithOp       The arithmetic operator applied on the variable.
	 * @param leftHandSide  The value on the left-hand side of the constraint.
	 * @param relOp         The relational operator used to compare the right-hand
	 *                      side with the left-hand side.
	 * @param rightHandSide The value on the right-hand side of the constraint.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addPrimitive(String variable, UniverseArithmeticOperator arithOp, BigInteger leftHandSide,
			UniverseRelationalOperator relOp, BigInteger rightHandSide);

	/**
	 * Notifies this listener that a {@code primitive} constraint is to be added.
	 *
	 * @param variable      The variable appearing in the constraint.
	 * @param arithOp       The arithmetic operator applied on the variable.
	 * @param leftHandSide  The variable on the left-hand side of the constraint.
	 * @param relOp         The relational operator used to compare the right-hand
	 *                      side with the left-hand side.
	 * @param rightHandSide The value on the right-hand side of the constraint.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addPrimitive(String variable, UniverseArithmeticOperator arithOp, String leftHandSide,
			UniverseRelationalOperator relOp, BigInteger rightHandSide);

	/**
	 * Notifies this listener that a {@code primitive} constraint is to be added.
	 *
	 * @param variable      The variable appearing in the constraint.
	 * @param arithOp       The arithmetic operator applied on the variable.
	 * @param leftHandSide  The value on the left-hand side of the constraint.
	 * @param relOp         The relational operator used to compare the right-hand
	 *                      side with the left-hand side.
	 * @param rightHandSide The variable on the right-hand side of the constraint.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addPrimitive(String variable, UniverseArithmeticOperator arithOp, BigInteger leftHandSide,
			UniverseRelationalOperator relOp, String rightHandSide);

	/**
	 * Notifies this listener that a {@code primitive} constraint is to be added.
	 *
	 * @param variable      The variable appearing in the constraint.
	 * @param arithOp       The arithmetic operator applied on the variable.
	 * @param leftHandSide  The variable on the left-hand side of the constraint.
	 * @param relOp         The relational operator used to compare the right-hand
	 *                      side with the left-hand side.
	 * @param rightHandSide The variable on the right-hand side of the constraint.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addPrimitive(String variable, UniverseArithmeticOperator arithOp, String leftHandSide,
			UniverseRelationalOperator relOp, String rightHandSide);

	/**
	 * Notifies this listener that a {@code primitive} constraint is to be added.
	 *
	 * @param arithOp       The arithmetic operator applied on the variable.
	 * @param variable      The variable on which the operator is applied.
	 * @param rightHandSide The variable on the right-hand side of the constraint.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addPrimitive(UniverseArithmeticOperator arithOp, String variable, String rightHandSide);

	/**
	 * Notifies this listener that a {@code primitive} constraint is to be added.
	 *
	 * @param variable The variable appearing in the constraint.
	 * @param operator The operator defining whether the values are allowed or
	 *                 forbidden.
	 * @param values   The set of values on which the operator is applied.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addPrimitive(String variable, UniverseSetBelongingOperator operator, List<BigInteger> values);

	/**
	 * Notifies this listener that a {@code primitive} constraint is to be added.
	 *
	 * @param variable The variable appearing in the constraint.
	 * @param operator The operator defining whether the values are allowed or
	 *                 forbidden.
	 * @param min      The minimum value of the range on which the operator is
	 *                 applied.
	 * @param max      The maximum value of the range on which the operator is
	 *                 applied.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addPrimitive(String variable, UniverseSetBelongingOperator operator, BigInteger min, BigInteger max);

	/**
	 * Notifies this listener that a {@code minimum} constraint is to be added.
	 *
	 * @param variables The variables to compute the minimum of.
	 * @param operator  The relational operator to use to compare the minimum.
	 * @param value     The value to compare the minimum with.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addMinimum(List<String> variables, UniverseRelationalOperator operator, BigInteger value);

	/**
	 * Notifies this listener that a {@code minimum} constraint is to be added.
	 *
	 * @param variables The variables to compute the minimum of.
	 * @param operator  The relational operator to use to compare the minimum.
	 * @param value     The variable encoding the value to compare the minimum with.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addMinimum(List<String> variables, UniverseRelationalOperator operator, String value);

	/**
	 * Notifies this listener that a {@code minimum} constraint is to be added.
	 *
	 * @param intensionConstraints The intension constraints to compute the minimum
	 *                             of.
	 * @param operator             The relational operator to use to compare the
	 *                             minimum.
	 * @param value                The value to compare the minimum with.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addMinimumIntension(List<IIntensionConstraint> intensionConstraints, UniverseRelationalOperator operator,
			BigInteger value);

	/**
	 * Notifies this listener that a {@code minimum} constraint is to be added.
	 *
	 * @param intensionConstraints The intension constraints to compute the minimum
	 *                             of.
	 * @param operator             The relational operator to use to compare the
	 *                             minimum.
	 * @param value                The variable encoding the value to compare the
	 *                             minimum with.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addMinimumIntension(List<IIntensionConstraint> intensionConstraints, UniverseRelationalOperator operator,
			String value);

	/**
	 * Notifies this listener that a {@code maximum} constraint is to be added.
	 *
	 * @param variables The variables to compute the maximum of.
	 * @param operator  The relational operator to use to compare the maximum.
	 * @param value     The value to compare the maximum with.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addMaximum(List<String> variables, UniverseRelationalOperator operator, BigInteger value);

	/**
	 * Notifies this listener that a {@code maximum} constraint is to be added.
	 *
	 * @param variables The variables to compute the maximum of.
	 * @param operator  The relational operator to use to compare the maximum.
	 * @param value     The variable encoding the value to compare the maximum with.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addMaximum(List<String> variables, UniverseRelationalOperator operator, String value);

	/**
	 * Notifies this listener that a {@code maximum} constraint is to be added.
	 *
	 * @param intensionConstraints The intension constraints to compute the maximum
	 *                             of.
	 * @param operator             The relational operator to use to compare the
	 *                             maximum.
	 * @param value                The value to compare the maximum with.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addMaximumIntension(List<IIntensionConstraint> intensionConstraints, UniverseRelationalOperator operator,
			BigInteger value);

	/**
	 * Notifies this listener that a {@code maximum} constraint is to be added.
	 *
	 * @param intensionConstraints The intension constraints to compute the maximum
	 *                             of.
	 * @param operator             The relational operator to use to compare the
	 *                             maximum.
	 * @param value                The variable encoding the value to compare the
	 *                             maximum with.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addMaximumIntension(List<IIntensionConstraint> intensionConstraints, UniverseRelationalOperator operator,
			String value);

	/**
	 * Notifies this listener that a {@code no-overlap} constraint is to be added.
	 *
	 * @param variables The variables appearing in the constraint.
	 * @param length    The length associated to the variables.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addNoOverlap(List<String> variables, List<BigInteger> length);

	/**
	 * Notifies this listener that a {@code no-overlap} constraint is to be added.
	 *
	 * @param variables   The variables appearing in the constraint.
	 * @param length      The length associated to the variables.
	 * @param zeroIgnored Whether {@code 0}-lengths should be ignored.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addNoOverlap(List<String> variables, List<BigInteger> length, boolean zeroIgnored);

	/**
	 * Notifies this listener that a {@code no-overlap} constraint is to be added.
	 *
	 * @param variables The variables appearing in the constraint.
	 * @param length    The variable for the length of the other variables.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addNoOverlapVariableLength(List<String> variables, List<String> length);

	/**
	 * Notifies this listener that a {@code no-overlap} constraint is to be added.
	 *
	 * @param variables   The variables appearing in the constraint.
	 * @param length      The variable for the length of the other variables.
	 * @param zeroIgnored Whether {@code 0}-lengths should be ignored.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addNoOverlapVariableLength(List<String> variables, List<String> length, boolean zeroIgnored);

	/**
	 * Notifies this listener that a {@code no-overlap} constraint is to be added.
	 *
	 * @param variables The variables appearing in the constraint.
	 * @param length    The length associated to the variables.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addMultiDimensionalNoOverlap(List<List<String>> variables, List<List<BigInteger>> length);

	/**
	 * Notifies this listener that a {@code no-overlap} constraint is to be added.
	 *
	 * @param variables   The variables appearing in the constraint.
	 * @param length      The length associated to the variables.
	 * @param zeroIgnored Whether {@code 0}-lengths should be ignored.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addMultiDimensionalNoOverlap(List<List<String>> variables, List<List<BigInteger>> length, boolean zeroIgnored);

	/**
	 * Notifies this listener that a {@code no-overlap} constraint is to be added.
	 *
	 * @param variables The variables appearing in the constraint.
	 * @param length    The variable for the length of the other variables.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addMultiDimensionalNoOverlapVariableLength(List<List<String>> variables, List<List<String>> length);

	/**
	 * Notifies this listener that a {@code no-overlap} constraint is to be added.
	 *
	 * @param variables   The variables appearing in the constraint.
	 * @param length      The variable for the length of the other variables.
	 * @param zeroIgnored Whether {@code 0}-lengths should be ignored.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addMultiDimensionalNoOverlapVariableLength(List<List<String>> variables, List<List<String>> length,
			boolean zeroIgnored);

	/**
	 * Notifies this listener that an {@code n-values} constraint is to be added.
	 *
	 * @param variables The variables appearing in the constraint.
	 * @param operator  The relational operator used in the constraint.
	 * @param nb        The number of distinct values to count.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addNValues(List<String> variables, UniverseRelationalOperator operator, BigInteger nb);

	/**
	 * Notifies this listener that an {@code n-values} constraint is to be added.
	 *
	 * @param variables The variables appearing in the constraint.
	 * @param operator  The relational operator used in the constraint.
	 * @param nb        The number of distinct values to count.
	 * @param except    The values that should not be counted.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addNValuesExcept(List<String> variables, UniverseRelationalOperator operator, BigInteger nb,
			List<BigInteger> except);

	/**
	 * Notifies this listener that an {@code n-values} constraint is to be added.
	 *
	 * @param variables The variables appearing in the constraint.
	 * @param operator  The relational operator used in the constraint.
	 * @param nb        The variable counting the number of distinct values.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addNValues(List<String> variables, UniverseRelationalOperator operator, String nb);

	/**
	 * Notifies this listener that an {@code n-values} constraint is to be added.
	 *
	 * @param variables The variables appearing in the constraint.
	 * @param operator  The relational operator used in the constraint.
	 * @param nb        The variable counting the number of distinct values.
	 * @param except    The values that should not be counted.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addNValuesExcept(List<String> variables, UniverseRelationalOperator operator, String nb,
			List<BigInteger> except);

	/**
	 * Notifies this listener that an {@code n-values} constraint is to be added.
	 *
	 * @param expressions The expressions appearing in the constraint.
	 * @param operator    The relational operator used in the constraint.
	 * @param nb          The number of distinct values to count.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addNValuesIntension(List<IIntensionConstraint> expressions, UniverseRelationalOperator operator,
			BigInteger nb);

	/**
	 * Notifies this listener that an {@code n-values} constraint is to be added.
	 *
	 * @param expressions The expressions appearing in the constraint.
	 * @param operator    The relational operator used in the constraint.
	 * @param nb          The variable counting the number of distinct values.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addNValuesIntension(List<IIntensionConstraint> expressions, UniverseRelationalOperator operator, String nb);

	/**
	 * Notifies this listener that an {@code ordered} constraint is to be added.
	 *
	 * @param variables The variables that should be ordered.
	 * @param operator  The relational operator defining the order of the variables.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addOrdered(List<String> variables, UniverseRelationalOperator operator);

	/**
	 * Notifies this listener that an {@code ordered} constraint is to be added.
	 *
	 * @param variables The variables that should be ordered.
	 * @param lengths   The lengths that must exist between two consecutive
	 *                  variables.
	 * @param operator  The relational operator defining the order of the variables.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addOrderedWithConstantLength(List<String> variables, List<BigInteger> lengths,
			UniverseRelationalOperator operator);

	/**
	 * Notifies this listener that an {@code ordered} constraint is to be added.
	 *
	 * @param variables The variables that should be ordered.
	 * @param lengths   The variables encoding the lengths that must exist between
	 *                  two consecutive variables.
	 * @param operator  The relational operator defining the order of the variables.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addOrderedWithVariableLength(List<String> variables, List<String> lengths,
			UniverseRelationalOperator operator);

	/**
	 * Notifies this listener that an {@code all-equal} constraint is to be added.
	 *
	 * @param variables The variables that should all be equal.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addAllEqual(List<String> variables);

	/**
	 * Notifies this listener that an {@code all-equal} constraint is to be added.
	 *
	 * @param expressions The expressions that should all be equal.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addAllEqualIntension(List<IIntensionConstraint> expressions);

	/**
	 * Notifies this listener that a {@code not-all-equal} constraint is to be
	 * added.
	 *
	 * @param variables The variables that should not be all equal.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addNotAllEqual(List<String> variables);

	/**
	 * Notifies this listener that an {@code lex} constraint is to be added.
	 *
	 * @param tuples   The tuple of variables that should be lexicographically
	 *                 ordered.
	 * @param operator The relational operator defining the order of the tuples.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addLex(List<List<String>> tuples, UniverseRelationalOperator operator);

	/**
	 * Notifies this listener that an {@code lex-matrix} constraint is to be added.
	 *
	 * @param matrix   The matrix of variables that should be lexicographically
	 *                 ordered.
	 * @param operator The relational operator defining the order in the matrix.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addLexMatrix(List<List<String>> matrix, UniverseRelationalOperator operator);

	/**
	 * Notifies this listener that a {@code sum} constraint is to be added.
	 *
	 * @param variables The variables appearing in the constraint.
	 * @param operator  The relational operator used in the constraint.
	 * @param min       The minimum value of the range.
	 * @param max       The maximum value of the range.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addSum(List<String> variables, UniverseSetBelongingOperator operator, BigInteger min, BigInteger max);

	/**
	 * Notifies this listener that a {@code sum} constraint is to be added.
	 *
	 * @param variables    The variables appearing in the constraint.
	 * @param coefficients The coefficients of the variables appearing in the
	 *                     constraint.
	 * @param operator     The relational operator used in the constraint.
	 * @param min          The minimum value of the range.
	 * @param max          The maximum value of the range..
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addSum(List<String> variables, List<BigInteger> coefficients, UniverseSetBelongingOperator operator,
			BigInteger min, BigInteger max);

	/**
	 * Notifies this listener that a {@code sum} constraint is to be added.
	 *
	 * @param variables The variables appearing in the constraint.
	 * @param operator  The relational operator used in the constraint.
	 * @param values    The set of values.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addSum(List<String> variables, UniverseSetBelongingOperator operator, List<BigInteger> values);

	/**
	 * Notifies this listener that a {@code sum} constraint is to be added.
	 *
	 * @param variables    The variables appearing in the constraint.
	 * @param coefficients The coefficients of the variables appearing in the
	 *                     constraint.
	 * @param operator     The relational operator used in the constraint.
	 * @param values       The set of values.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addSum(List<String> variables, List<BigInteger> coefficients, UniverseSetBelongingOperator operator,
			List<BigInteger> values);

	/**
	 * Notifies this listener that a {@code sum} constraint is to be added.
	 *
	 * @param intensionConstraints The intension constraints to compute the sum of.
	 * @param operator             The relational operator used in the constraint.
	 * @param min                  The minimum value of the range.
	 * @param max                  The maximum value of the range.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addSumIntension(List<IIntensionConstraint> intensionConstraints, UniverseSetBelongingOperator operator,
			BigInteger min, BigInteger max);

	/**
	 * Notifies this listener that a {@code sum} constraint is to be added.
	 *
	 * @param intensionConstraints The intension constraints to compute the sum of.
	 * @param coefficients         The coefficients of the variables appearing in
	 *                             the constraint.
	 * @param operator             The relational operator used in the constraint.
	 * @param min                  The minimum value of the range.
	 * @param max                  The maximum value of the range.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addSumIntension(List<IIntensionConstraint> intensionConstraints, List<BigInteger> coefficients,
			UniverseSetBelongingOperator operator, BigInteger min, BigInteger max);

	/**
	 * Notifies this listener that a {@code sum} constraint is to be added.
	 *
	 * @param intensionConstraints The intension constraints to compute the sum of.
	 * @param operator             The relational operator used in the constraint.
	 * @param values               The set of values
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addSumIntension(List<IIntensionConstraint> intensionConstraints, UniverseSetBelongingOperator operator,
			List<BigInteger> values);

	/**
	 * Notifies this listener that a {@code sum} constraint is to be added.
	 *
	 * @param intensionConstraints The intension constraints to compute the sum of.
	 * @param coefficients         The coefficients of the variables appearing in
	 *                             the constraint.
	 * @param operator             The relational operator used in the constraint.
	 * @param values               The set of values.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addSumIntension(List<IIntensionConstraint> intensionConstraints, List<BigInteger> coefficients,
			UniverseSetBelongingOperator operator, List<BigInteger> values);

	/**
	 * Notifies this listener that a {@code sum} constraint is to be added.
	 *
	 * @param variables    The variables appearing in the constraint.
	 * @param coefficients The variables representing the coefficients of the
	 *                     variables appearing in the constraint.
	 * @param operator     The relational operator used in the constraint.
	 * @param min          The minimum value of the range.
	 * @param max          The maximum value of the range.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addSumWithVariableCoefficients(List<String> variables, List<String> coefficients,
			UniverseSetBelongingOperator operator, BigInteger min, BigInteger max);

	/**
	 * Notifies this listener that a {@code sum} constraint is to be added.
	 *
	 * @param variables    The variables appearing in the constraint.
	 * @param coefficients The variables representing the coefficients of the
	 *                     variables appearing in the constraint.
	 * @param operator     The relational operator used in the constraint.
	 * @param values       The set of values.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addSumWithVariableCoefficients(List<String> variables, List<String> coefficients,
			UniverseSetBelongingOperator operator, List<BigInteger> values);

	/**
	 * Notifies this listener that a {@code sum} constraint is to be added.
	 *
	 * @param intensionConstraints The intension constraints to compute the sum of.
	 * @param coefficients         The variables representing the coefficients of
	 *                             the variables appearing in the constraint.
	 * @param operator             The relational operator used in the constraint.
	 * @param min                  The minimum value of the range.
	 * @param max                  The maximum value of the range.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addSumIntensionWithVariableCoefficients(List<IIntensionConstraint> intensionConstraints,
			List<String> coefficients, UniverseSetBelongingOperator operator, BigInteger min, BigInteger max);

	/**
	 * Notifies this listener that a {@code sum} constraint is to be added.
	 *
	 * @param intensionConstraints The intension constraints to compute the sum of.
	 * @param coefficients         The variables representing the coefficients of
	 *                             the variables appearing in the constraint.
	 * @param operator             The relational operator used in the constraint.
	 * @param values               The set of values
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addSumIntensionWithVariableCoefficients(List<IIntensionConstraint> intensionConstraints,
			List<String> coefficients, UniverseSetBelongingOperator operator, List<BigInteger> values);

	/**
	 * Notifies this listener that a {@code sum} constraint is to be added.
	 *
	 * @param variables The variables appearing in the constraint.
	 * @param operator  The relational operator used in the constraint.
	 * @param value     The value of the right-hand side of the constraint.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addSum(List<String> variables, UniverseRelationalOperator operator, BigInteger value);

	/**
	 * Notifies this listener that a {@code sum} constraint is to be added.
	 *
	 * @param variables    The variables appearing in the constraint.
	 * @param coefficients The coefficients of the variables appearing in the
	 *                     constraint.
	 * @param operator     The relational operator used in the constraint.
	 * @param value        The value of the right-hand side of the constraint.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addSum(List<String> variables, List<BigInteger> coefficients, UniverseRelationalOperator operator,
			BigInteger value);

	/**
	 * Notifies this listener that a {@code sum} constraint is to be added.
	 *
	 * @param variables     The variables appearing in the constraint.
	 * @param operator      The relational operator used in the constraint.
	 * @param rightVariable The variable on the right-hand side of the constraint.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addSum(List<String> variables, UniverseRelationalOperator operator, String rightVariable);

	/**
	 * Notifies this listener that a {@code sum} constraint is to be added.
	 *
	 * @param variables     The variables appearing in the constraint.
	 * @param coefficients  The coefficients of the variables appearing in the
	 *                      constraint.
	 * @param operator      The relational operator used in the constraint.
	 * @param rightVariable The variable on the right-hand side of the constraint.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addSum(List<String> variables, List<BigInteger> coefficients, UniverseRelationalOperator operator,
			String rightVariable);

	/**
	 * Notifies this listener that a {@code sum} constraint is to be added.
	 *
	 * @param intensionConstraints The intension constraints to compute the sum of.
	 * @param operator             The relational operator used in the constraint.
	 * @param value                The value of the right-hand side of the
	 *                             constraint.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addSumIntension(List<IIntensionConstraint> intensionConstraints, UniverseRelationalOperator operator,
			BigInteger value);

	/**
	 * Notifies this listener that a {@code sum} constraint is to be added.
	 *
	 * @param intensionConstraints The intension constraints to compute the sum of.
	 * @param coefficients         The coefficients of the variables appearing in
	 *                             the constraint.
	 * @param operator             The relational operator used in the constraint.
	 * @param value                The value of the right-hand side of the
	 *                             constraint.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addSumIntension(List<IIntensionConstraint> intensionConstraints, List<BigInteger> coefficients,
			UniverseRelationalOperator operator, BigInteger value);

	/**
	 * Notifies this listener that a {@code sum} constraint is to be added.
	 *
	 * @param intensionConstraints The intension constraints to compute the sum of.
	 * @param operator             The relational operator used in the constraint.
	 * @param rightVariable        The variable on the right-hand side of the
	 *                             constraint.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addSumIntension(List<IIntensionConstraint> intensionConstraints, UniverseRelationalOperator operator,
			String rightVariable);

	/**
	 * Notifies this listener that a {@code sum} constraint is to be added.
	 *
	 * @param intensionConstraints The intension constraints to compute the sum of.
	 * @param coefficients         The coefficients of the variables appearing in
	 *                             the constraint.
	 * @param operator             The relational operator used in the constraint.
	 * @param rightVariable        The variable on the right-hand side of the
	 *                             constraint.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addSumIntension(List<IIntensionConstraint> intensionConstraints, List<BigInteger> coefficients,
			UniverseRelationalOperator operator, String rightVariable);

	/**
	 * Notifies this listener that a {@code sum} constraint is to be added.
	 *
	 * @param variables    The variables appearing in the constraint.
	 * @param coefficients The variables representing the coefficients of the
	 *                     variables appearing in the constraint.
	 * @param operator     The relational operator used in the constraint.
	 * @param value        The value of the right-hand side of the constraint.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addSumWithVariableCoefficients(List<String> variables, List<String> coefficients,
			UniverseRelationalOperator operator, BigInteger value);

	/**
	 * Notifies this listener that a {@code sum} constraint is to be added.
	 *
	 * @param variables     The variables appearing in the constraint.
	 * @param coefficients  The variables representing the coefficients of the
	 *                      variables appearing in the constraint.
	 * @param operator      The relational operator used in the constraint.
	 * @param rightVariable The variable on the right-hand side of the constraint.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addSumWithVariableCoefficients(List<String> variables, List<String> coefficients,
			UniverseRelationalOperator operator, String rightVariable);

	/**
	 * Notifies this listener that a {@code sum} constraint is to be added.
	 *
	 * @param intensionConstraints The intension constraints to compute the sum of.
	 * @param coefficients         The variables representing the coefficients of
	 *                             the variables appearing in the constraint.
	 * @param operator             The relational operator used in the constraint.
	 * @param value                The value of the right-hand side of the
	 *                             constraint.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addSumIntensionWithVariableCoefficients(List<IIntensionConstraint> intensionConstraints,
			List<String> coefficients, UniverseRelationalOperator operator, BigInteger value);

	/**
	 * Notifies this listener that a {@code sum} constraint is to be added.
	 *
	 * @param intensionConstraints The intension constraints to compute the sum of.
	 * @param coefficients         The variables representing the coefficients of
	 *                             the variables appearing in the constraint.
	 * @param operator             The relational operator used in the constraint.
	 * @param rightVariable        The variable on the right-hand side of the
	 *                             constraint.
	 *
	 * @throws UniverseContradictionException If adding the constraint results in a
	 *                                        trivial inconsistency.
	 */
	void addSumIntensionWithVariableCoefficients(List<IIntensionConstraint> intensionConstraints,
			List<String> coefficients, UniverseRelationalOperator operator, String rightVariable);

	/**
	 * Notifies this listener that an objective function is to be added to minimize
	 * the value assigned to a variable.
	 *
	 * @param variable The variable to minimize the value of.
	 */
	void minimizeVariable(String variable);

	/**
	 * Notifies this listener that an objective function is to be added to maximize
	 * the value assigned to a variable.
	 *
	 * @param variable The variable to maximize the value of.
	 */
	void maximizeVariable(String variable);

	/**
	 * Notifies this listener that an objective function is to be added to minimize
	 * the value of an expression.
	 *
	 * @param expression The expression to minimize the value of.
	 */
	void minimizeExpression(IIntensionConstraint expression);

	/**
	 * Notifies this listener that an objective function is to be added to maximize
	 * the value of an expression.
	 *
	 * @param expression The expression to maximize the value of.
	 */
	void maximizeExpression(IIntensionConstraint expression);

	/**
	 * Notifies this listener that an objective function is to be added to minimize
	 * a sum of variables.
	 *
	 * @param variables The variables to minimize the sum of.
	 */
	void minimizeSum(List<String> variables);

	/**
	 * Notifies this listener that an objective function is to be added to minimize
	 * a sum of variables.
	 *
	 * @param variables    The variables to minimize the sum of.
	 * @param coefficients The coefficients of the variables in the sum.
	 */
	void minimizeSum(List<String> variables, List<BigInteger> coefficients);

	/**
	 * Notifies this listener that an objective function is to be added to minimize
	 * a sum of expressions.
	 *
	 * @param expressions The expressions to minimize the sum of.
	 */
	void minimizeExpressionSum(List<IIntensionConstraint> expressions);

	/**
	 * Notifies this listener that an objective function is to be added to minimize
	 * a sum of expressions.
	 *
	 * @param expressions  The expressions to minimize the sum of.
	 * @param coefficients The coefficients of the expressions in the sum.
	 */
	void minimizeExpressionSum(List<IIntensionConstraint> expressions, List<BigInteger> coefficients);

	/**
	 * Notifies this listener that an objective function is to be added to maximize
	 * a sum of variables.
	 *
	 * @param variables The variables to maximize the sum of.
	 */
	void maximizeSum(List<String> variables);

	/**
	 * Notifies this listener that an objective function is to be added to maximize
	 * a sum of variables.
	 *
	 * @param variables    The variables to maximize the sum of.
	 * @param coefficients The coefficients of the variables in the sum.
	 */
	void maximizeSum(List<String> variables, List<BigInteger> coefficients);

	/**
	 * Notifies this listener that an objective function is to be added to maximize
	 * a sum of expressions.
	 *
	 * @param expressions The expressions to maximize the sum of.
	 */
	void maximizeExpressionSum(List<IIntensionConstraint> expressions);

	/**
	 * Notifies this listener that an objective function is to be added to maximize
	 * a sum of expressions.
	 *
	 * @param expressions  The expressions to maximize the sum of.
	 * @param coefficients The coefficients of the expressions in the sum.
	 */
	void maximizeExpressionSum(List<IIntensionConstraint> expressions, List<BigInteger> coefficients);

	/**
	 * Notifies this listener that an objective function is to be added to minimize
	 * a product of variables.
	 *
	 * @param variables The variables to minimize the product of.
	 */
	void minimizeProduct(List<String> variables);

	/**
	 * Notifies this listener that an objective function is to be added to minimize
	 * a product of variables.
	 *
	 * @param variables    The variables to minimize the product of.
	 * @param coefficients The coefficients of the variables in the product.
	 */
	void minimizeProduct(List<String> variables, List<BigInteger> coefficients);

	/**
	 * Notifies this listener that an objective function is to be added to minimize
	 * a product of expressions.
	 *
	 * @param expressions The expressions to minimize the product of.
	 */
	void minimizeExpressionProduct(List<IIntensionConstraint> expressions);

	/**
	 * Notifies this listener that an objective function is to be added to minimize
	 * a product of expressions.
	 *
	 * @param expressions  The expressions to minimize the product of.
	 * @param coefficients The coefficients of the expressions in the product.
	 */
	void minimizeExpressionProduct(List<IIntensionConstraint> expressions, List<BigInteger> coefficients);

	/**
	 * Notifies this listener that an objective function is to be added to maximize
	 * a product of variables.
	 *
	 * @param variables The variables to maximize the product of.
	 */
	void maximizeProduct(List<String> variables);

	/**
	 * Notifies this listener that an objective function is to be added to maximize
	 * a product of variables.
	 *
	 * @param variables    The variables to maximize the product of.
	 * @param coefficients The coefficients of the variables in the product.
	 */
	void maximizeProduct(List<String> variables, List<BigInteger> coefficients);

	/**
	 * Notifies this listener that an objective function is to be added to maximize
	 * a product of expressions.
	 *
	 * @param expressions The expressions to maximize the product of.
	 */
	void maximizeExpressionProduct(List<IIntensionConstraint> expressions);

	/**
	 * Notifies this listener that an objective function is to be added to maximize
	 * a product of expressions.
	 *
	 * @param expressions  The expressions to maximize the product of.
	 * @param coefficients The coefficients of the expressions in the product.
	 */
	void maximizeExpressionProduct(List<IIntensionConstraint> expressions, List<BigInteger> coefficients);

	/**
	 * Notifies this listener that an objective function is to be added to minimize
	 * the minimum of variables.
	 *
	 * @param variables The variables to minimize the minimum of.
	 */
	void minimizeMinimum(List<String> variables);

	/**
	 * Notifies this listener that an objective function is to be added to minimize
	 * the minimum of variables.
	 *
	 * @param variables    The variables to minimize the minimum of.
	 * @param coefficients The coefficients of the variables in the minimum.
	 */
	void minimizeMinimum(List<String> variables, List<BigInteger> coefficients);

	/**
	 * Notifies this listener that an objective function is to be added to minimize
	 * the minimum of expressions.
	 *
	 * @param expressions The expressions to minimize the minimum of.
	 */
	void minimizeExpressionMinimum(List<IIntensionConstraint> expressions);

	/**
	 * Notifies this listener that an objective function is to be added to minimize
	 * the minimum of expressions.
	 *
	 * @param expressions  The expressions to minimize the minimum of.
	 * @param coefficients The coefficients of the expressions in the minimum.
	 */
	void minimizeExpressionMinimum(List<IIntensionConstraint> expressions, List<BigInteger> coefficients);

	/**
	 * Notifies this listener that an objective function is to be added to maximize
	 * the minimum of variables.
	 *
	 * @param variables The variables to maximize the minimum of.
	 */
	void maximizeMinimum(List<String> variables);

	/**
	 * Notifies this listener that an objective function is to be added to maximize
	 * the minimum of variables.
	 *
	 * @param variables    The variables to maximize the minimum of.
	 * @param coefficients The coefficients of the variables in the minimum.
	 */
	void maximizeMinimum(List<String> variables, List<BigInteger> coefficients);

	/**
	 * Notifies this listener that an objective function is to be added to maximize
	 * the minimum of expressions.
	 *
	 * @param expressions The expressions to maximize the minimum of.
	 */
	void maximizeExpressionMinimum(List<IIntensionConstraint> expressions);

	/**
	 * Notifies this listener that an objective function is to be added to maximize
	 * the minimum of expressions.
	 *
	 * @param expressions  The expressions to maximize the minimum of.
	 * @param coefficients The coefficients of the expressions in the minimum.
	 */
	void maximizeExpressionMinimum(List<IIntensionConstraint> expressions, List<BigInteger> coefficients);

	/**
	 * Notifies this listener that an objective function is to be added to minimize
	 * the maximum of variables.
	 *
	 * @param variables The variables to minimize the maximum of.
	 */
	void minimizeMaximum(List<String> variables);

	/**
	 * Notifies this listener that an objective function is to be added to minimize
	 * the maximum of variables.
	 *
	 * @param variables    The variables to minimize the maximum of.
	 * @param coefficients The coefficients of the variables in the maximum.
	 */
	void minimizeMaximum(List<String> variables, List<BigInteger> coefficients);

	/**
	 * Notifies this listener that an objective function is to be added to minimize
	 * the maximum of expressions.
	 *
	 * @param expressions The expressions to minimize the maximum of.
	 */
	void minimizeExpressionMaximum(List<IIntensionConstraint> expressions);

	/**
	 * Notifies this listener that an objective function is to be added to minimize
	 * the maximum of expressions.
	 *
	 * @param expressions  The expressions to minimize the maximum of.
	 * @param coefficients The coefficients of the expressions in the maximum.
	 */
	void minimizeExpressionMaximum(List<IIntensionConstraint> expressions, List<BigInteger> coefficients);

	/**
	 * Notifies this listener that an objective function is to be added to maximize
	 * the maximum of variables.
	 *
	 * @param variables The variables to maximize the maximum of.
	 */
	void maximizeMaximum(List<String> variables);

	/**
	 * Notifies this listener that an objective function is to be added to maximize
	 * the maximum of variables.
	 *
	 * @param variables    The variables to maximize the maximum of.
	 * @param coefficients The coefficients of the variables in the maximum.
	 */
	void maximizeMaximum(List<String> variables, List<BigInteger> coefficients);

	/**
	 * Notifies this listener that an objective function is to be added to maximize
	 * the maximum of expressions.
	 *
	 * @param expressions The expressions to maximize the maximum of.
	 */
	void maximizeExpressionMaximum(List<IIntensionConstraint> expressions);

	/**
	 * Notifies this listener that an objective function is to be added to maximize
	 * the maximum of expressions.
	 *
	 * @param expressions  The expressions to maximize the maximum of.
	 * @param coefficients The coefficients of the expressions in the maximum.
	 */
	void maximizeExpressionMaximum(List<IIntensionConstraint> expressions, List<BigInteger> coefficients);

	/**
	 * Notifies this listener that an objective function is to be added to minimize
	 * the number of values assigned to variables.
	 *
	 * @param variables The variables to minimize the number of values of.
	 */
	void minimizeNValues(List<String> variables);

	/**
	 * Notifies this listener that an objective function is to be added to minimize
	 * the number of values assigned to variables.
	 *
	 * @param variables    The variables to minimize the number of values of.
	 * @param coefficients The coefficients of the variables.
	 */
	void minimizeNValues(List<String> variables, List<BigInteger> coefficients);

	/**
	 * Notifies this listener that an objective function is to be added to minimize
	 * the number of values assigned to variables.
	 *
	 * @param expressions The expressions to minimize the number of values of.
	 */
	void minimizeExpressionNValues(List<IIntensionConstraint> expressions);

	/**
	 * Notifies this listener that an objective function is to be added to minimize
	 * the number of values assigned to variables.
	 *
	 * @param expressions  The expressions to minimize the number of values of.
	 * @param coefficients The coefficients of the expressions.
	 */
	void minimizeExpressionNValues(List<IIntensionConstraint> expressions, List<BigInteger> coefficients);

	/**
	 * Notifies this listener that an objective function is to be added to maximize
	 * the number of values assigned to variables.
	 *
	 * @param variables The variables to maximize the number of values of.
	 */
	void maximizeNValues(List<String> variables);

	/**
	 * Notifies this listener that an objective function is to be added to maximize
	 * the number of values assigned to variables.
	 *
	 * @param variables    The variables to maximize the number of values of.
	 * @param coefficients The coefficients of the variables.
	 */
	void maximizeNValues(List<String> variables, List<BigInteger> coefficients);

	/**
	 * Notifies this listener that an objective function is to be added to maximize
	 * the number of values assigned to variables.
	 *
	 * @param expressions The expressions to maximize the number of values of.
	 */
	void maximizeExpressionNValues(List<IIntensionConstraint> expressions);

	/**
	 * Notifies this listener that an objective function is to be added to maximize
	 * the number of values assigned to variables.
	 *
	 * @param expressions  The expressions to maximize the number of values of.
	 * @param coefficients The coefficients of the expressions.
	 */
	void maximizeExpressionNValues(List<IIntensionConstraint> expressions, List<BigInteger> coefficients);

	void decisionVariables(List<String> variables);
}
