package dev.jacaro.school.cs4308.parser.generator.commands

import dev.jacaro.school.cs4308.parser.Head
import dev.jacaro.school.cs4308.commands.DataCommand
import dev.jacaro.school.cs4308.parser.generator.genOrThrow
import dev.jacaro.school.cs4308.parser.generator.lists.ConstantListGenerator
import dev.jacaro.school.cs4308.parser.structure.Generator
import dev.jacaro.school.cs4308.structure.Token

/**
 * Generates [DataCommands][DataCommand]
 * @see Generator
 */
object DataCommandGenerator : Generator<DataCommand> {
    override fun generate(head: Head): DataCommand? {
        return if (head.isToken(Token.DATA)) {

            head.inc()
            val constantList = genOrThrow(head, ConstantListGenerator)

            DataCommand(constantList)
        } else null
    }

    override val result: String
        get() = "DataCommand"

}