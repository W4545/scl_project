package dev.jacaro.school.cs4308.parser.generator.structures

import dev.jacaro.school.cs4308.kotlin.structure.Action
import dev.jacaro.school.cs4308.parser.Head
import dev.jacaro.school.cs4308.parser.generator.commands.allGenerators
import dev.jacaro.school.cs4308.parser.structure.Generator

/**
 * Generates statements
 * @see Action
 */
object ActionGenerator : Generator<Action> {
    override fun generate(head: Head): Action? {
        for (generator in allGenerators) {
            val value = generator.generate(head)
            if (value != null)
                return value
        }

        return null
    }

    override val result: String
        get() = "Statement"
}