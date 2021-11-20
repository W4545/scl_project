package dev.jacaro.school.cs4308.parser.generator.expressions.builderextensions

import dev.jacaro.school.cs4308.expressions.*

/**
 * Generates standard math operators except for addition.
 */
val StandardNumberOperationBuilderExtension = standardBuilderExtensionGenerator<Double>(
    Operators.MINUS,
    Operators.MULTIPLY,
    Operators.DIVIDE,
    Operators.POWER) { expressionWrap, left, right ->

    when (expressionWrap.value) {
        Operators.MINUS -> Subtraction(left, right!!)
        Operators.MULTIPLY -> Multiplication(left, right!!)
        Operators.DIVIDE -> Division(left, right!!)
        Operators.POWER -> Power(left, right!!)
        else -> throw RuntimeException("Unreachable")
    }
}