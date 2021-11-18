package dev.jacaro.school.cs4308.expressions

import dev.jacaro.school.cs4308.values.ID
import dev.jacaro.school.cs4308.values.Value
import kotlin.jvm.internal.Reflection
import kotlin.reflect.full.functions
import kotlin.reflect.typeOf

data class Expression<T>(val expression: Value<T>) : Operator<T> {

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

    override fun operation(): Value<T> = expression

    companion object {
        @OptIn(ExperimentalStdlibApi::class)
        inline fun<reified T> validate(expression: Expression<*>) : Boolean {
            println()
            return expression.expression is ID || expression.expression::class.members.find { it.name == "raw" }?.returnType == typeOf<T>()
        }
    }
}