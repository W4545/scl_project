package dev.jacaro.school.cs4308.parser.generator.expressions.builderextensions

import dev.jacaro.school.cs4308.expressions.EqualToOperator
import dev.jacaro.school.cs4308.expressions.Operators
import dev.jacaro.school.cs4308.parser.generator.expressions.ExpressionWrap
import dev.jacaro.school.cs4308.values.Value
import java.util.*

object EqualBuildExtension : BuilderExtension {
    override fun action(expressionWrap: ExpressionWrap<*>, stack: Deque<Value<*>>) {
        val right = stack.pop()
        val left = stack.pop()

        stack.push(EqualToOperator(left, right))
    }

    override fun accept(expressionWrap: ExpressionWrap<*>): Boolean = basicAccept(expressionWrap, Operators.EQUAL)
}