package dev.jacaro.school.cs4308.parser.generator.expressions.builderextensions

import dev.jacaro.school.cs4308.kotlin.expressions.Operators
import dev.jacaro.school.cs4308.parser.generator.expressions.ExpressionWrap
import dev.jacaro.school.cs4308.kotlin.values.Value
import java.util.*

/**
 * An interface for building a tree using a stack.
 */
interface BuilderExtension {

    fun action(expressionWrap: ExpressionWrap<*>, stack: Deque<Value<*>>)

    fun accept(expressionWrap: ExpressionWrap<*>) : Boolean

}

/**
 * Returns true if the wrapper [ExpressionWrap] holds one of the provided [operators][Operators]
 */
fun basicAccept(expressionWrap: ExpressionWrap<*>, vararg operators: Operators) : Boolean {
    if (expressionWrap.value !is Operators)
        return false
    for (operator in operators) {
        if (expressionWrap.value == operator)
            return true
    }

    return false
}

/**
 * Builder function. Creates anonymous builder extensions for the provided operators. Uses lambdas to build the tree.
 */
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

/**
 * BuilderExtension that adds numeric values onto the stack
 */
object StandardNumberBuilderExtension : BuilderExtension {
    override fun action(expressionWrap: ExpressionWrap<*>, stack: Deque<Value<*>>) {
        stack.push(expressionWrap.value as Value<*>)
    }

    override fun accept(expressionWrap: ExpressionWrap<*>): Boolean = expressionWrap.value is Value<*>

}