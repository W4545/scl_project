package dev.jacaro.school.cs4308.ids

import dev.jacaro.school.cs4308.values.ID

/**
 * Creates an ID manager to make sure that all reverences to an [ID] refer to the same ID.
 */
object IDManager {
    val ids = emptyMap<String, ID>().toMutableMap()
}