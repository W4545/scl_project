package dev.jacaro.school.cs4308.kotlin.errors

import dev.jacaro.school.cs4308.kotlin.expressions.Expression

/**
 * An error produced while generating an [Expression]
 * @see Expression
 */
class ExpressionGenerationError(message: String): RuntimeException(message)