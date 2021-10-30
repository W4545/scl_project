package dev.jacaro.school.cs4308.parser.generator.commands

import dev.jacaro.school.cs4308.errors.ParsingError
import dev.jacaro.school.cs4308.parser.Head
import dev.jacaro.school.cs4308.parser.commands.OpenCommand
import dev.jacaro.school.cs4308.parser.constants.Access
import dev.jacaro.school.cs4308.parser.generator.*
import dev.jacaro.school.cs4308.parser.structure.Generator
import dev.jacaro.school.cs4308.scanner.structure.Token

object OpenCommandGenerator : Generator<OpenCommand> {
    override fun generate(head: Head): OpenCommand? = isHeadOrNull(head, Token.OPEN) {
        val value = genOrThrow(head, ValueGenerator)
        expectToken(head, Token.FOR)
        head.inc()
        val access = if (head.isToken(Token.INPUT))
            Access.INPUT
        else if (head.isToken(Token.OUTPUT))
            Access.OUTPUT
        else
            throw ParsingError("")
        head.inc()
        expectToken(head, Token.AS)
        head.inc()
        expectToken(head, Token.OP_POUND)
        head.inc()
        val integer = genOrThrow(head, IntConstantGenerator)

        OpenCommand(value, access, integer)
    }

    override val result: String
        get() = TODO("Not yet implemented")

}