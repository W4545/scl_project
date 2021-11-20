package dev.jacaro.school.cs4308.parser.generator.commands

import dev.jacaro.school.cs4308.parser.Head
import dev.jacaro.school.cs4308.commands.NextCommand
import dev.jacaro.school.cs4308.parser.generator.IDGenerator
import dev.jacaro.school.cs4308.parser.generator.genOrThrow
import dev.jacaro.school.cs4308.parser.generator.isHeadOrNull
import dev.jacaro.school.cs4308.parser.structure.Generator
import dev.jacaro.school.cs4308.structure.Token

/**
 * Generates [NextCommands][NextCommand]
 * @see Generator
 * @see isHeadOrNull
 */
object NextCommandGenerator : Generator<NextCommand> {
    override fun generate(head: Head): NextCommand? = isHeadOrNull(head, Token.NEXT) {
        val id = genOrThrow(head, IDGenerator)
        NextCommand(id)
    }

    override val result: String
        get() = TODO("Not yet implemented")

}