package dev.jacaro.school.cs4308.kotlin.constants

import dev.jacaro.school.cs4308.kotlin.values.Integer
import dev.jacaro.school.cs4308.kotlin.values.Value

/**
 * Wrapper type for an array of integer values.
 * @see Value
 */
data class IntegerList(val integers: Array<Integer>) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as IntegerList

        if (!integers.contentEquals(other.integers)) return false

        return true
    }

    override fun hashCode(): Int {
        return integers.contentHashCode()
    }
}