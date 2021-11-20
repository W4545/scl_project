package dev.jacaro.school.cs4308.errors

import dev.jacaro.school.cs4308.expressions.Expression

/**
 * An error produced while generating an [Expression]
 * @see Expression
 */
class ExpressionGenerationError(message: String): RuntimeException(message)