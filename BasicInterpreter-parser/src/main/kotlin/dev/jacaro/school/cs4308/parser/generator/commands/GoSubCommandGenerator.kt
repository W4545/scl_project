package dev.jacaro.school.cs4308.parser.generator.commands

import dev.jacaro.school.cs4308.parser.Head
import dev.jacaro.school.cs4308.kotlin.commands.GoSubCommand
import dev.jacaro.school.cs4308.parser.generator.genExpressionOrThrow
import dev.jacaro.school.cs4308.parser.structure.Generator
import dev.jacaro.school.cs4308.kotlin.structure.Token

/**
 * Generates [GoSubCommands][GoSubCommand]
 * @see Generator
 */
object GoSubCommandGenerator : Generator<GoSubCommand> {
    override fun generate(head: Head): GoSubCommand? = if (head.isToken(Token.GOSUB)) {
        head.inc()
        val expression = genExpressionOrThrow<Int>(head)

        GoSubCommand(expression)
    } else null

    override val result: String
        get() = TODO("Not yet implemented")

}