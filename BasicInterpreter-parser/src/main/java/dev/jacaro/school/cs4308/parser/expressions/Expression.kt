package dev.jacaro.school.cs4308.parser.expressions

import dev.jacaro.school.cs4308.scanner.structure.Lexeme

data class Expression(val expression: Array<Lexeme>) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Expression

        if (!expression.contentEquals(other.expression)) return false

        return true
    }

    override fun hashCode(): Int {
        return expression.contentHashCode()
    }
}