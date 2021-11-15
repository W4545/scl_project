package dev.jacaro.school.cs4308.parser.generator.commands

import dev.jacaro.school.cs4308.parser.Head
import dev.jacaro.school.cs4308.commands.WaitCommand
import dev.jacaro.school.cs4308.parser.generator.genOrThrow
import dev.jacaro.school.cs4308.parser.generator.isHeadOrNull
import dev.jacaro.school.cs4308.parser.generator.lists.ValueListGenerator
import dev.jacaro.school.cs4308.parser.structure.Generator
import dev.jacaro.school.cs4308.structure.Token

object WaitCommand : Generator<WaitCommand> {
    override fun generate(head: Head): WaitCommand? = isHeadOrNull(head, Token.WAIT) {
        val valueList = genOrThrow(head, ValueListGenerator)

        WaitCommand(valueList)
    }

    override val result: String
        get() = TODO("Not yet implemented")

}