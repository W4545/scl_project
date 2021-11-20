package dev.jacaro.school.cs4308.constants

import dev.jacaro.school.cs4308.values.Value

/**
 * Wrapper type for an array of integer values.
 * @see Value
 */
data class ValueList(val valueList: Array<Value<*>>) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ValueList

        if (!valueList.contentEquals(other.valueList)) return false

        return true
    }

    override fun hashCode(): Int {
        return valueList.contentHashCode()
    }
}