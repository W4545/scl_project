package dev.jacaro.school.cs4308.parser.generator.commands

import dev.jacaro.school.cs4308.parser.Head
import dev.jacaro.school.cs4308.kotlin.commands.GoToCommand
import dev.jacaro.school.cs4308.parser.generator.genExpressionOrThrow
import dev.jacaro.school.cs4308.parser.structure.Generator
import dev.jacaro.school.cs4308.kotlin.structure.Token

/**
 * Generates [GoToCommands][GoToCommand]
 * @see Generator
 */
object GoToCommandGenerator : Generator<GoToCommand> {
    override fun generate(head: Head): GoToCommand? = if (head.isToken(Token.GOTO)) {
        head.inc()
        val expression = genExpressionOrThrow<Int>(head)
        GoToCommand(expression)
    } else null

    override val result: String
        get() = TODO("Not yet implemented")
}