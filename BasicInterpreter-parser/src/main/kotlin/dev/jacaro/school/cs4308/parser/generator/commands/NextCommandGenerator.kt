package dev.jacaro.school.cs4308.parser.generator.commands

import dev.jacaro.school.cs4308.parser.Head
import dev.jacaro.school.cs4308.commands.NextCommand
import dev.jacaro.school.cs4308.parser.generator.genOrThrow
import dev.jacaro.school.cs4308.parser.generator.isHeadOrNull
import dev.jacaro.school.cs4308.parser.generator.lists.IDListGenerator
import dev.jacaro.school.cs4308.parser.structure.Generator
import dev.jacaro.school.cs4308.structure.Token

object NextCommandGenerator : Generator<NextCommand> {
    override fun generate(head: Head): NextCommand? = isHeadOrNull(head, Token.NEXT) {
        val idList = genOrThrow(head, IDListGenerator)
        NextCommand(idList)
    }

    override val result: String
        get() = TODO("Not yet implemented")

}