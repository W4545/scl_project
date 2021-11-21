package dev.jacaro.school.cs4308.parser.generator.structures

import dev.jacaro.school.cs4308.kotlin.commands.LetCommand
import dev.jacaro.school.cs4308.parser.Head
import dev.jacaro.school.cs4308.parser.generator.*
import dev.jacaro.school.cs4308.parser.generator.expressions.ExpressionGenerator
import dev.jacaro.school.cs4308.parser.structure.Generator
import dev.jacaro.school.cs4308.kotlin.structure.ForLoop
import dev.jacaro.school.cs4308.kotlin.structure.Token

/**
 * Generates for loops
 * @see Generator
 * @see ForLoop
 */
object ForLoopGenerator : Generator<ForLoop> {
    override fun generate(head: Head): ForLoop? = if (head.isToken(Token.FOR)) {
        head.inc()
        val id = genOrThrow(head, IDGenerator)
        expectToken(head, Token.OP_EQUALS)
        head.inc()
        val expression = genOrThrow(head, ExpressionGenerator)
        val letCommand = LetCommand(id, expression)
        expectToken(head, Token.TO)
        head.inc()
        val postExpression = genExpressionOrThrow<Double>(head)

        val step = if (head.isToken(Token.STEP)) {
            head.inc()
            genOrThrow(head, RealGenerator)
        } else null

        ForLoop(letCommand, postExpression, step)
    } else null

    override val result: String
        get() = TODO("Not yet implemented")

}