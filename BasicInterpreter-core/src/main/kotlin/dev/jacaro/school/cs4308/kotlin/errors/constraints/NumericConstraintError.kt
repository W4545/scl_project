package dev.jacaro.school.cs4308.kotlin.errors.constraints

import dev.jacaro.school.cs4308.kotlin.expressions.NumberOperatorConstraint
import dev.jacaro.school.cs4308.kotlin.values.NumericConstraint

/**
 * An error produced by [NumberOperatorConstraint] or [NumericConstraint]
 */
class NumericConstraintError(message: String) : RuntimeException(message)