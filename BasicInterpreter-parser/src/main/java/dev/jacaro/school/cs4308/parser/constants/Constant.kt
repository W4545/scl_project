package dev.jacaro.school.cs4308.parser.constants

import dev.jacaro.school.cs4308.scanner.structure.Lexeme
import dev.jacaro.school.cs4308.scanner.structure.Token
import dev.jacaro.school.cs4308.structure.Type

class Constant(lexeme: Lexeme) {

    val value: String = lexeme.value

    val type: Type = when(lexeme.token) {
        Token.INTEGER -> Type.INTEGER
        Token.REAL -> Type.REAL
        Token.STRING -> Type.STRING
        else -> throw RuntimeException("hmm, what happened")
    }

}