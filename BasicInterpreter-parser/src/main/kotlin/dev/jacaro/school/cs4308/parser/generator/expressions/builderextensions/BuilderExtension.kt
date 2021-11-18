package dev.jacaro.school.cs4308.parser.generator.expressions.builderextensions

import dev.jacaro.school.cs4308.expressions.Operators
import dev.jacaro.school.cs4308.parser.generator.expressions.ExpressionWrap
import dev.jacaro.school.cs4308.values.ID
import dev.jacaro.school.cs4308.values.Value
import java.lang.RuntimeException
import java.util.*
import kotlin.reflect.typeOf

interface BuilderExtension {

    fun action(expressionWrap: ExpressionWrap<*>, stack: Deque<Value<*>>)

    fun accept(expressionWrap: ExpressionWrap<*>) : Boolean

}

fun basicAccept(expressionWrap: ExpressionWrap<*>, vararg operators: Operators) : Boolean {
    if (expressionWrap.value !is Operators)
        return false
    for (operator in operators) {
        if (expressionWrap.value == operator)
            return true
    }

    return false
}

@Suppress("UNCHECKED_CAST") inline fun <reified T> standardBuilderExtensionGenerator(vararg operators: Operators, unary: Boolean = false, crossinline generator: (ExpressionWrap<*>, Value<T>, Value<T>?) -> Value<*>) : BuilderExtension {

    return object : BuilderExtension {
        override fun action(expressionWrap: ExpressionWrap<*>, stack: Deque<Value<*>>) {

            val right = if (unary)
                null
            else
                stack.pop()
            val left = stack.pop()

            left as Value<T>
            right as Value<T>?

            stack.push(generator(expressionWrap, left, right))
        }

        override fun accept(expressionWrap: ExpressionWrap<*>): Boolean = basicAccept(expressionWrap, *operators)

    }
}

object StandardNumberBuilderExtension : BuilderExtension {
    override fun action(expressionWrap: ExpressionWrap<*>, stack: Deque<Value<*>>) {
        stack.push(expressionWrap.value as Value<*>)
    }

    override fun accept(expressionWrap: ExpressionWrap<*>): Boolean = expressionWrap.value is Value<*>

}