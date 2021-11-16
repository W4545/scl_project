package dev.jacaro.school.cs4308.parser.generator.expressions

import dev.jacaro.school.cs4308.expressions.Operators
import java.lang.RuntimeException

object ExpressionConverter {

    private fun unaryPreProcessing(infix: Array<ExpressionWrap<*>>): Array<ExpressionWrap<*>> {
        val processableOperators = arrayOf(Operators.PLUS, Operators.MINUS)

        val validPrevious = Operators.values().filterNot { it == Operators.CLOSE_PARENTHESIS }

        var previous: ExpressionWrap<*>? = null
        return infix.map { current : ExpressionWrap<*> ->
            if (current.value in processableOperators) {
                if (previous == null || previous!!.value in validPrevious) {
                    previous = current
                    when(current.value) {
                        Operators.PLUS -> ExpressionWrap(Operators.UNARY_PLUS)
                        Operators.MINUS -> ExpressionWrap(Operators.UNARY_MINUS)
                        else -> throw RuntimeException()
                    }
                } else {
                    previous = current
                    current
                }
            } else {
                previous = current
                current
            }
        }.toTypedArray()
    }

    fun infixToPostfix(infix: Array<ExpressionWrap<*>>): Array<ExpressionWrap<*>> {
        val processed = unaryPreProcessing(infix)

        println(processed.contentToString())

        return processed
    }
}