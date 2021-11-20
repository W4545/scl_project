package dev.jacaro.school.cs4308.constants

import dev.jacaro.school.cs4308.values.ID
import dev.jacaro.school.cs4308.values.Value

/**
 * Wrapper type for an array of Values.
 * @see Value
 */
data class IDList(val idList: Array<ID>) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as IDList

        if (!idList.contentEquals(other.idList)) return false

        return true
    }

    override fun hashCode(): Int {
        return idList.contentHashCode()
    }
}