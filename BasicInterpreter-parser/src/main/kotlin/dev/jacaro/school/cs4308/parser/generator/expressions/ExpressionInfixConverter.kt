package dev.jacaro.school.cs4308.parser.generator.expressions

import dev.jacaro.school.cs4308.errors.ExpressionGenerationError
import dev.jacaro.school.cs4308.expressions.Operators
import dev.jacaro.school.cs4308.values.*
import java.lang.RuntimeException
import java.util.*

object ExpressionInfixConverter {

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

    @Suppress("UNCHECKED_CAST")
    fun infixToPostfix(infix: Array<ExpressionWrap<*>>): Array<ExpressionWrap<*>> {
        val processed = unaryPreProcessing(infix)

        val output = emptyList<ExpressionWrap<*>>().toMutableList()
        val deque = ArrayDeque<ExpressionWrap<Operators>>()


        for (current in processed) {
            when (current.value) {
                is Real, is Integer, is CBoolean, is CString, is ID -> output.add(current)

                Operators.OPEN_PARENTHESIS ->  deque.push(current as ExpressionWrap<Operators>)
                Operators.CLOSE_PARENTHESIS -> {
                    while (deque.peek().value != Operators.OPEN_PARENTHESIS) {
                        if (deque.isEmpty())
                            throw ExpressionGenerationError("Mismatching parentheses")
                        output.add(deque.pop())
                    }
                    deque.pop()
                }
                in Operators.values() -> {
                    current as ExpressionWrap<Operators>
                    while (deque.isNotEmpty() && deque.peek().value != Operators.OPEN_PARENTHESIS &&
                        (deque.peek().value.priority < current.value.priority ||
                                (deque.peek().value.priority == current.value.priority && current.value.leftAssociative))) {
                        output.add(deque.pop())
                    }
                    deque.push(current)
                }


            }
        }

        while (deque.peek() != null)
            output.add(deque.pop())

        return output.toTypedArray()
    }
}