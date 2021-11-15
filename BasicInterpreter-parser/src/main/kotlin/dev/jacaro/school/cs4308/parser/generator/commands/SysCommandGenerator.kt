package dev.jacaro.school.cs4308.parser.generator.commands

import dev.jacaro.school.cs4308.parser.Head
import dev.jacaro.school.cs4308.commands.SysCommand
import dev.jacaro.school.cs4308.parser.generator.ValueGenerator
import dev.jacaro.school.cs4308.parser.generator.genOrThrow
import dev.jacaro.school.cs4308.parser.generator.isHeadOrNull
import dev.jacaro.school.cs4308.parser.structure.Generator
import dev.jacaro.school.cs4308.structure.Token

object SysCommandGenerator : Generator<SysCommand> {
    override fun generate(head: Head): SysCommand? = isHeadOrNull(head, Token.SYS) {
        val value = genOrThrow(head, ValueGenerator)

        SysCommand(value)
    }

    override val result: String
        get() = TODO("Not yet implemented")

}