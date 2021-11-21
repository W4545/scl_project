package dev.jacaro.school.cs4308.parser.generator.expressions.builderextensions

import dev.jacaro.school.cs4308.kotlin.expressions.*
import dev.jacaro.school.cs4308.parser.generator.expressions.ExpressionWrap
import dev.jacaro.school.cs4308.kotlin.values.Value
import java.util.*

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

/**
 * Generates addition operators. Handles both double values and strings.
 */
object PlusBuilderExtension : BuilderExtension {
    @Suppress("UNCHECKED_CAST") override fun action(expressionWrap: ExpressionWrap<*>, stack: Deque<Value<*>>) {
        val right = stack.pop()
        val left = stack.pop()

        if (left.raw is String && right.raw is String)
            stack.push(StringConcatenate(left as Value<String>, right as Value<String>))
        else
            stack.push(Addition(left as Value<Double>, right as Value<Double>))
    }

    override fun accept(expressionWrap: ExpressionWrap<*>): Boolean = expressionWrap.value == Operators.PLUS
}