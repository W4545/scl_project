package dev.jacaro.school.cs4308.parser.generator.commands

import dev.jacaro.school.cs4308.parser.Head
import dev.jacaro.school.cs4308.commands.ReadCommand
import dev.jacaro.school.cs4308.parser.generator.genOrThrow
import dev.jacaro.school.cs4308.parser.generator.isHeadOrNull
import dev.jacaro.school.cs4308.parser.generator.lists.IDListGenerator
import dev.jacaro.school.cs4308.parser.structure.Generator
import dev.jacaro.school.cs4308.structure.Token

object ReadCommandGenerator : Generator<ReadCommand> {
    override fun generate(head: Head): ReadCommand? = isHeadOrNull(head, Token.READ) {
        val idList = genOrThrow(head, IDListGenerator)
        ReadCommand(idList)
    }

    override val result: String
        get() = TODO("Not yet implemented")

}