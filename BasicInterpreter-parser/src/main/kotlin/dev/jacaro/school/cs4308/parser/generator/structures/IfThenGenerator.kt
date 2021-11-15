package dev.jacaro.school.cs4308.parser.generator.structures

import dev.jacaro.school.cs4308.parser.Head
import dev.jacaro.school.cs4308.parser.generator.ExpressionGenerator
import dev.jacaro.school.cs4308.parser.generator.expectToken
import dev.jacaro.school.cs4308.parser.generator.genOrThrow
import dev.jacaro.school.cs4308.parser.structure.Generator
import dev.jacaro.school.cs4308.structure.IfThen
import dev.jacaro.school.cs4308.structure.Token

object IfThenGenerator : Generator<IfThen> {
    override fun generate(head: Head): IfThen? = if (head.isToken(Token.IF)) {
        head.inc()
        val expression = genOrThrow(head, ExpressionGenerator)
        expectToken(head, Token.THEN)
        head.inc()
        val statement = genOrThrow(head, StatementGenerator)

        IfThen(expression, statement)
    } else null

    override val result: String
        get() = TODO("Not yet implemented")

}