package dev.jacaro.school.cs4308.parser.generator

import dev.jacaro.school.cs4308.errors.ParsingError
import dev.jacaro.school.cs4308.parser.Head
import dev.jacaro.school.cs4308.parser.structure.Generator
import dev.jacaro.school.cs4308.scanner.structure.Lexeme
import dev.jacaro.school.cs4308.scanner.structure.Token

open class TokenGenerator<T>(private val token: Token, private val refBuild: Lexeme.() -> T): Generator<T> {
    override fun generate(head: Head): T? {
        val lexeme: Lexeme = head.current()
        return if (lexeme.token == token) {
            head.inc()
            lexeme.refBuild()
        } else
            null
    }

    override val result: String
        get() = token.name

}

fun expectToken(head: Head, token: Token) {
    if (!head.isToken(token))
        throw ParsingError(String.format("Failed to parse file, expected %s", token))
}

fun<T> genOrThrow(head: Head, generator: Generator<T>) : T =
    generator.generate(head) ?: throw ParsingError(String.format("Parsing Error, Expected token %s", generator.result))

fun <T> isHeadOrNull(head: Head, token: Token, block: () -> T) : T? =
    if (head.isToken(token))  {
        head.inc()
        block()
    } else null