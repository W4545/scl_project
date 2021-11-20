package dev.jacaro.school.cs4308.parser

import dev.jacaro.school.cs4308.structure.Lexeme
import dev.jacaro.school.cs4308.structure.Token

/**
 * Tracks the current position of the parser
 * @see Lexeme
 */
class Head(val lexemes: Array<Lexeme>, current: Int = 0) {

    var currentHead = current
    private set

    val current: Lexeme
    get() = lexemes[currentHead]

    val previous: Lexeme
    get() = lexemes[currentHead - 1]


    operator fun inc() : Head {
        currentHead += 1
        return this
    }

    operator fun dec() : Head {
        currentHead -= 1
        return this
    }

    operator fun invoke(): Lexeme {
        return lexemes[currentHead]
    }

    fun duplicate(): Head {
        return Head(lexemes, currentHead)
    }

    fun current(): Lexeme {
        return lexemes[currentHead]
    }

    fun isToken(token: Token) : Boolean = currentHead < lexemes.size && lexemes[currentHead].token == token
}