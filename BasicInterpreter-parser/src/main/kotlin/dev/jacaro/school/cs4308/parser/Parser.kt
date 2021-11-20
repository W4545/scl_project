package dev.jacaro.school.cs4308.parser

import dev.jacaro.school.cs4308.errors.ParsingError
import dev.jacaro.school.cs4308.parser.generator.LineGenerator
import dev.jacaro.school.cs4308.structure.Line
import dev.jacaro.school.cs4308.structure.Lexeme

/**
 * Parses [lexemes][Lexeme] into a series of line objects.
 */
object Parser {

    fun parse(lexemes: Array<Lexeme>) : Array<Line> {
        val head = Head(lexemes)

        val lines = mutableListOf<Line>()

        var line : Line? = LineGenerator.generate(head) ?: throw ParsingError("Empty or invalid file")


        while (line != null) {
            lines.add(line)
            line = LineGenerator.generate(head)
        }

        return lines.toTypedArray()
    }
}