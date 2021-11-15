package dev.jacaro.school.cs4308.expressions

import dev.jacaro.school.cs4308.values.Value

abstract class Operator<T>(val left: Value<*>, val right: Value<*>?) {

    abstract fun operation() : Value<T>

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Operator<*>) return false

        if (left != other.left) return false
        if (right != other.right) return false

        return true
    }

    override fun hashCode(): Int {
        var result = left.hashCode()
        result = 31 * result + (right?.hashCode() ?: 0)
        return result
    }
}

