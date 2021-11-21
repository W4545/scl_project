package dev.jacaro.school.cs4308.parser.generator

import dev.jacaro.school.cs4308.java.errors.ParsingError
import dev.jacaro.school.cs4308.parser.Head
import dev.jacaro.school.cs4308.parser.generator.lists.StatementsGenerator
import dev.jacaro.school.cs4308.parser.structure.Generator
import dev.jacaro.school.cs4308.kotlin.structure.Line
import dev.jacaro.school.cs4308.kotlin.structure.Token

/**
 * Generates [Line] objects
 * @see Generator
 * @see Line
 */
object LineGenerator : Generator<Line> {
    override fun generate(head: Head): Line? {
        if (head.currentHead >= head.lexemes.size)
            return null
        val int = IntConstantGenerator.generate(head) ?: return null

        val statements = genOrThrow(head, StatementsGenerator)

        if (!head.isToken(Token.OP_NEWLINE)) {
            if (head.currentHead < head.lexemes.size)
                throw ParsingError("Expected New Line")
        } else
            head.inc()

        return Line(int, statements)
    }

    override val result: String
        get() = "Line"
}