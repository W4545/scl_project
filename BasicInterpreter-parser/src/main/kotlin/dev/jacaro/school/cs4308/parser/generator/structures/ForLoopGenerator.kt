package dev.jacaro.school.cs4308.parser.generator.structures

import dev.jacaro.school.cs4308.commands.LetCommand
import dev.jacaro.school.cs4308.parser.Head
import dev.jacaro.school.cs4308.parser.generator.*
import dev.jacaro.school.cs4308.parser.structure.Generator
import dev.jacaro.school.cs4308.structure.ForLoop
import dev.jacaro.school.cs4308.structure.Token

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
        val postExpression = genOrThrow(head, ExpressionGenerator)

        val step = if (head.isToken(Token.STEP)) {
            head.inc()
            genOrThrow(head, IntConstantGenerator)
        } else null

        ForLoop(letCommand, postExpression, step)
    } else null

    override val result: String
        get() = TODO("Not yet implemented")

}