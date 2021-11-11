package dev.jacaro.school.cs4308.parser.generator.commands

import dev.jacaro.school.cs4308.parser.Head
import dev.jacaro.school.cs4308.commands.PokeCommand
import dev.jacaro.school.cs4308.parser.generator.genOrThrow
import dev.jacaro.school.cs4308.parser.generator.isHeadOrNull
import dev.jacaro.school.cs4308.parser.generator.lists.ValueListGenerator
import dev.jacaro.school.cs4308.parser.structure.Generator
import dev.jacaro.school.cs4308.structure.Token

object PokeCommandGenerator : Generator<PokeCommand> {
    override fun generate(head: Head): PokeCommand? = isHeadOrNull(head, Token.POKE) {
        val valueList = genOrThrow(head, ValueListGenerator)
        PokeCommand(valueList)
    }

    override val result: String
        get() = TODO("Not yet implemented")

}