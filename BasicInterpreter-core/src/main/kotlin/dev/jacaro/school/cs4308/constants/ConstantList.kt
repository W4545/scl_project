package dev.jacaro.school.cs4308.constants

import dev.jacaro.school.cs4308.values.Value

/**
 * Wrapper type for an array of Values.
 * @see Value
 */
data class ConstantList(val constants: Array<Value<*>>) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ConstantList

        if (!constants.contentEquals(other.constants)) return false

        return true
    }

    override fun hashCode(): Int {
        return constants.contentHashCode()
    }
}