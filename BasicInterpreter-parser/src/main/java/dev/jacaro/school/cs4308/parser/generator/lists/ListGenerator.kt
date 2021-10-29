package dev.jacaro.school.cs4308.parser.generator.lists

import dev.jacaro.school.cs4308.parser.Head
import dev.jacaro.school.cs4308.parser.constants.Constant
import dev.jacaro.school.cs4308.parser.constants.ConstantList
import dev.jacaro.school.cs4308.parser.generator.expectToken
import dev.jacaro.school.cs4308.parser.structure.Generator
import dev.jacaro.school.cs4308.scanner.structure.Lexeme
import dev.jacaro.school.cs4308.scanner.structure.Token

open class ListGenerator<T>(private val tokens: Array<Token>, private val refBuild: (lexemes: Array<Lexeme>) -> T)  : Generator<T> {
    override fun generate(head: Head): T? {

        if (tokens.any { head.current().token == it }) {
            val unprocessedLexemes = emptyList<Lexeme>().toMutableList()

            while(tokens.any { head.current().token == it }) {
                unprocessedLexemes.add(head.current())
                head.inc()
                expectToken(head, Token.OP_COMMA)
            }

            return refBuild(unprocessedLexemes.toTypedArray())
        }

        return null
    }
}

val ConstantListGenerator = ListGenerator(arrayOf(Token.INTEGER, Token.STRING, Token.REAL)) { lexemes ->
    ConstantList(lexemes.map { Constant(it) }.toTypedArray())
}