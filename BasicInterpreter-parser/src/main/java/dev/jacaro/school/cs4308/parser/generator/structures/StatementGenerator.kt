package dev.jacaro.school.cs4308.parser.generator.structures

import dev.jacaro.school.cs4308.parser.Head
import dev.jacaro.school.cs4308.parser.generator.commands.allGenerators
import dev.jacaro.school.cs4308.parser.structure.Generator
import dev.jacaro.school.cs4308.parser.structures.Statement

object StatementGenerator : Generator<Statement> {
    override fun generate(head: Head): Statement? {
        for (generator in allGenerators) {
            val value = generator.generate(head)
            if (value != null)
                return Statement(value)
        }

        return null
    }

    override val result: String
        get() = "Statement"
}