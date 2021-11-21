package dev.jacaro.school.cs4308.parser.generator.structures

import dev.jacaro.school.cs4308.kotlin.commands.GoToCommand
import dev.jacaro.school.cs4308.kotlin.expressions.Expression
import dev.jacaro.school.cs4308.parser.Head
import dev.jacaro.school.cs4308.parser.generator.IntConstantGenerator
import dev.jacaro.school.cs4308.parser.generator.expectToken
import dev.jacaro.school.cs4308.parser.generator.genExpressionOrThrow
import dev.jacaro.school.cs4308.parser.generator.genOrThrow
import dev.jacaro.school.cs4308.parser.structure.Generator
import dev.jacaro.school.cs4308.kotlin.structure.IfThen
import dev.jacaro.school.cs4308.kotlin.structure.Token

/**
 * Generates [IfThen] statements
 * @see Generator
 * @see IfThen
 */
object IfThenGenerator : Generator<IfThen> {
    override fun generate(head: Head): IfThen? = if (head.isToken(Token.IF)) {
        head.inc()
        val expression = genExpressionOrThrow<Boolean>(head)
        expectToken(head, Token.THEN)
        head.inc()
        val lineNumber = genOrThrow(head, IntConstantGenerator)

        IfThen(expression, GoToCommand(Expression(lineNumber)))
    } else null

    override val result: String
        get() = TODO("Not yet implemented")

}