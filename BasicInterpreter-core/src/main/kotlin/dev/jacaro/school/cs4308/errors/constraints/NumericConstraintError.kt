package dev.jacaro.school.cs4308.errors.constraints

import dev.jacaro.school.cs4308.expressions.NumberOperatorConstraint
import dev.jacaro.school.cs4308.values.NumericConstraint

/**
 * An error produced by [NumberOperatorConstraint] or [NumericConstraint]
 */
class NumericConstraintError(message: String) : RuntimeException(message)