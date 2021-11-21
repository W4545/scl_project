package dev.jacaro.school.cs4308.parser.generator

import dev.jacaro.school.cs4308.kotlin.ids.IDManager
import dev.jacaro.school.cs4308.kotlin.values.ID
import dev.jacaro.school.cs4308.kotlin.structure.Token

/**
 * Generates IDs
 * @see TokenGenerator
 * @see ID
 */
object IDGenerator : TokenGenerator<ID>(Token.ID, {
    IDManager.ids.getOrPut(value) {
        ID(value)
    }
})