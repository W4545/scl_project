package dev.jacaro.school.cs4308.parser.generator.commands

import dev.jacaro.school.cs4308.parser.Head
import dev.jacaro.school.cs4308.commands.PrintCommand
import dev.jacaro.school.cs4308.parser.generator.IntConstantGenerator
import dev.jacaro.school.cs4308.parser.generator.expectToken
import dev.jacaro.school.cs4308.parser.generator.genOrThrow
import dev.jacaro.school.cs4308.parser.generator.isHeadOrNull
import dev.jacaro.school.cs4308.parser.generator.lists.PrintListGenerator
import dev.jacaro.school.cs4308.parser.structure.Generator
import dev.jacaro.school.cs4308.structure.Token

object PrintCommandGenerator : Generator<PrintCommand> {
    override fun generate(head: Head): PrintCommand? = isHeadOrNull(head, Token.PRINT) {
        val integer = if (head.isToken(Token.OP_POUND)) {
            head.inc()
            val temp = genOrThrow(head, IntConstantGenerator)
            expectToken(head, Token.OP_COMMA)
            head.inc()
            temp
        } else null
        val printList = genOrThrow(head, PrintListGenerator)
        PrintCommand(integer, printList)
    }

    override val result: String
        get() = TODO("Not yet implemented")

}