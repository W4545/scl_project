package dev.jacaro.school.cs4308.parser.generator.lists

import dev.jacaro.school.cs4308.constants.IDList
import dev.jacaro.school.cs4308.constants.IntegerList
import dev.jacaro.school.cs4308.parser.Head
import dev.jacaro.school.cs4308.parser.structure.Generator
import dev.jacaro.school.cs4308.structure.Lexeme
import dev.jacaro.school.cs4308.structure.Token
import dev.jacaro.school.cs4308.values.ID
import dev.jacaro.school.cs4308.values.Integer

open class ListGenerator<T>(private val tokens: Array<Token>, private val refBuild: (lexemes: Array<Lexeme>) -> T)  : Generator<T> {
    override fun generate(head: Head): T? {

        if (tokens.any { head.current().token == it }) {
            val unprocessedLexemes = emptyList<Lexeme>().toMutableList()

            while(tokens.any { head.current().token == it } || head.isToken(Token.OP_COMMA)) {
                if (!head.isToken(Token.OP_COMMA))
                    unprocessedLexemes.add(head.current())
                head.inc()
            }

            return refBuild(unprocessedLexemes.toTypedArray())
        }

        return null
    }

    override val result: String
        get() = tokens.toString()
}

val IntegerListGenerator = ListGenerator(arrayOf(Token.INTEGER)) { lexemes ->
    IntegerList(lexemes.map { Integer(it.value.toInt()) }.toTypedArray())
}

val IDListGenerator = ListGenerator(arrayOf(Token.ID)) { lexemes ->
    IDList(lexemes.map { ID(it.value) }.toTypedArray())
}
