package dev.jacaro.school.cs4308.parser.generator.commands

import dev.jacaro.school.cs4308.parser.Head
import dev.jacaro.school.cs4308.kotlin.commands.PrintCommand
import dev.jacaro.school.cs4308.parser.generator.isHeadOrNull
import dev.jacaro.school.cs4308.parser.generator.lists.PrintListGenerator
import dev.jacaro.school.cs4308.parser.structure.Generator
import dev.jacaro.school.cs4308.kotlin.structure.Token

/**
 * Generates [PrintCommands][PrintCommand]
 * @see Generator
 * @see isHeadOrNull
 */
object PrintCommandGenerator : Generator<PrintCommand> {
    override fun generate(head: Head): PrintCommand? = isHeadOrNull(head, Token.PRINT) {
        val printList = PrintListGenerator.generate(head)
        val newLine = if (printList != null && head.isToken(Token.OP_COMMA)) {
            head.inc()
            false
        } else
            true
        PrintCommand(printList, newLine)
    }

    override val result: String
        get() = TODO("Not yet implemented")

}