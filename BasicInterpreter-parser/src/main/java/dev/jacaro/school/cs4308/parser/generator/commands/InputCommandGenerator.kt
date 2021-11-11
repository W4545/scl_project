package dev.jacaro.school.cs4308.parser.generator.commands

import dev.jacaro.school.cs4308.parser.Head
import dev.jacaro.school.cs4308.commands.InputCommand
import dev.jacaro.school.cs4308.parser.generator.IntConstantGenerator
import dev.jacaro.school.cs4308.parser.generator.expectToken
import dev.jacaro.school.cs4308.parser.generator.genOrThrow
import dev.jacaro.school.cs4308.parser.generator.lists.IDListGenerator
import dev.jacaro.school.cs4308.parser.structure.Generator
import dev.jacaro.school.cs4308.structure.Token
import dev.jacaro.school.cs4308.values.Integer

object InputCommandGenerator : Generator<InputCommand> {
    override fun generate(head: Head): InputCommand? = if (head.isToken(Token.INPUT)) {
        head.inc()
        val integer = if (head.isToken(Token.OP_POUND)) {
            head.inc()
            val temp = genOrThrow(head, IntConstantGenerator)
            expectToken(head, Token.OP_COMMA)
            head.inc()
            temp
        } else null
        val idList = genOrThrow(head, IDListGenerator)
        InputCommand(idList, integer)
    } else null

    override val result: String
        get() = TODO("Not yet implemented")

}