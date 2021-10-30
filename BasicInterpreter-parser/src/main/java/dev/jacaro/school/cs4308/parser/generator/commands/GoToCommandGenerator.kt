package dev.jacaro.school.cs4308.parser.generator.commands

import dev.jacaro.school.cs4308.parser.Head
import dev.jacaro.school.cs4308.parser.commands.GoToCommand
import dev.jacaro.school.cs4308.parser.generator.ExpressionGenerator
import dev.jacaro.school.cs4308.parser.generator.genOrThrow
import dev.jacaro.school.cs4308.parser.structure.Generator
import dev.jacaro.school.cs4308.scanner.structure.Token

object GoToCommandGenerator : Generator<GoToCommand> {
    override fun generate(head: Head): GoToCommand? = if (head.isToken(Token.GOTO)) {
        head.inc()
        val expression = genOrThrow(head, ExpressionGenerator)
        GoToCommand(expression)
    } else null

    override val result: String
        get() = TODO("Not yet implemented")
}