package dev.jacaro.school.cs4308.parser.generator.expressions.builderextensions

import dev.jacaro.school.cs4308.expressions.*

val ComparisonOperatorBuilderExtension = standardBuilderExtensionGenerator<Double>(
    Operators.GREATER_THAN,
    Operators.GREATER_OR_EQUAL_TO,
    Operators.LESS_THAN,
    Operators.LESS_THAN_OR_EQUAL_TO) { expressionWrap, left, right ->

    when (expressionWrap.value) {
        Operators.GREATER_THAN -> GreaterThanOperator(left, right!!)
        Operators.GREATER_OR_EQUAL_TO -> GreaterThanOrEqualToOperator(left, right!!)
        Operators.LESS_THAN -> LessThanOperator(left, right!!)
        Operators.LESS_THAN_OR_EQUAL_TO -> LessThanOrEqualToOperator(left, right!!)
        else -> throw RuntimeException("Unreachable")
    }
}

val AndOrBuilderExtension = standardBuilderExtensionGenerator<Boolean>(
    Operators.AND,
    Operators.OR) { expressionWrap, left, right ->

    when (expressionWrap.value) {
        Operators.AND -> AndOperator(left, right!!)
        Operators.OR -> OrOperator(left, right!!)
        else -> throw RuntimeException("Unreachable")
    }
}

val UnaryNumberBuilderExtension = standardBuilderExtensionGenerator<Double>(
    Operators.UNARY_PLUS,
    Operators.UNARY_MINUS,
    unary = true) { expressionWrap, left, _ ->

    when (expressionWrap.value) {
        Operators.UNARY_PLUS -> UnaryPlus(left)
        Operators.UNARY_MINUS -> UnaryMinus(left)
        else -> throw RuntimeException("Unreachable")
    }
}

val NotBuilderExtension = standardBuilderExtensionGenerator<Boolean>(
    Operators.NOT,
    unary = true) { _, left, _ ->

    NotOperator(left)
}