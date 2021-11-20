package dev.jacaro.school.cs4308.expressions

import dev.jacaro.school.cs4308.values.ID
import dev.jacaro.school.cs4308.values.Value
import kotlin.reflect.typeOf

/**
 * The base expression type. Holds the root of an expression tree that evaluates to some value T.
 * @param expression Root of a tree structure.
 * @see Value
 */
data class Expression<T>(val expression: Value<T>) : Value<T> {

    override val value: Double
        get() = expression.value
    override val raw: T
        get() = expression.raw

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Expression<*>) return false

        if (expression != other.expression) return false

        return true
    }

    override fun hashCode(): Int {
        return expression.hashCode()
    }

    override fun toString(): String {
        return "Expression(expression=$expression)"
    }

    companion object {
        inline fun<reified T> validate(expression: Expression<*>) : Boolean {
            println()
            return expression.expression is ID || expression.expression::class.members.find { it.name == "raw" }?.returnType == typeOf<T>()
        }
    }
}