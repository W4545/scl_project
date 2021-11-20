package dev.jacaro.school.cs4308.expressions

import dev.jacaro.school.cs4308.values.Value

/**
 * Middleware class that implements equals and hashcode methods.
 */
abstract class OperatorImpl<T, R>(val left: Value<T>, val right: Value<T>?) : Operator<R> {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is OperatorImpl<*, *>) return false

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

