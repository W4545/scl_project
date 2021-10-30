package dev.jacaro.school.cs4308.parser.generator

import dev.jacaro.school.cs4308.parser.expressions.Expression
import dev.jacaro.school.cs4308.parser.expressions.Operators
import dev.jacaro.school.cs4308.parser.generator.lists.ListGenerator
import dev.jacaro.school.cs4308.scanner.structure.Token


private val expectedTokens = Operators.values().map { it.token }
    .plus(arrayOf(
        Token.ID,
        Token.OP_EQUALS,
        Token.STRING,
        Token.INTEGER,
        Token.REAL,
        Token.OP_COMMA,
        Token.AND,
        Token.OR,
        Token.OP_OPEN_PARENTHESIS,
        Token.OP_CLOSE_PARENTHESIS)).toTypedArray()


object ExpressionGenerator : ListGenerator<Expression>(expectedTokens, { Expression(it) }) {

    override val result: String
        get() = "Expression"

}