package dev.jacaro.school.cs4308.parser.generator.commands

import dev.jacaro.school.cs4308.parser.Head
import dev.jacaro.school.cs4308.kotlin.commands.LetCommand
import dev.jacaro.school.cs4308.parser.generator.*
import dev.jacaro.school.cs4308.parser.generator.expressions.ExpressionGenerator
import dev.jacaro.school.cs4308.parser.structure.Generator
import dev.jacaro.school.cs4308.kotlin.structure.Token

/**
 * Generates [LetCommands][LetCommand]
 * @see Generator
 * @see isHeadOrNull
 */
object LetCommandGenerator : Generator<LetCommand> {
    override fun generate(head: Head): LetCommand? = isHeadOrNull(head, Token.LET) {
        val id = genOrThrow(head, IDGenerator)
        expectToken(head, Token.OP_EQUALS)
        head.inc()
        val expression = genOrThrow(head, ExpressionGenerator)
        LetCommand(id, expression)
    }

    override val result: String
        get() = TODO("Not yet implemented")
}