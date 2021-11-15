package dev.jacaro.school.cs4308.expressions

import dev.jacaro.school.cs4308.values.Value

data class Expression(val expression: Value<*>) : Value<Expression> {
    override val value: Double
        get() = expression.value
    override val raw: Expression
        get() = this

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Expression) return false

        if (expression != other.expression) return false

        return true
    }

    override fun hashCode(): Int {
        return expression.hashCode()
    }

    override fun toString(): String {
        return "Expression(expression=$expression)"
    }
}