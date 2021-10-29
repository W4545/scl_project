package dev.jacaro.school.cs4308.parser.generator

import dev.jacaro.school.cs4308.errors.ParsingError
import dev.jacaro.school.cs4308.parser.Head
import dev.jacaro.school.cs4308.parser.structure.Generator
import dev.jacaro.school.cs4308.scanner.structure.Lexeme
import dev.jacaro.school.cs4308.scanner.structure.Token

open class TokenGenerator<T>(private val token: Token, private val refBuild: Lexeme.() -> T): Generator<T> {
    override fun generate(head: Head): T? {
        val lexeme: Lexeme = head.current()
        return if (lexeme.token == token)
            lexeme.refBuild()
        else
            null
    }

}

fun expectToken(head: Head, token: Token) {
    if (!head.isToken(token))
        throw ParsingError(String.format("Failed to parse file, expected %s", token))
}