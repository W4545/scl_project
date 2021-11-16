package dev.jacaro.school.cs4308.parser.generator.expressions

import dev.jacaro.school.cs4308.errors.ExpressionGenerationError
import dev.jacaro.school.cs4308.expressions.Expression
import dev.jacaro.school.cs4308.expressions.Operators
import dev.jacaro.school.cs4308.ids.IDManager
import dev.jacaro.school.cs4308.parser.generator.lists.ListGenerator
import dev.jacaro.school.cs4308.structure.Token
import dev.jacaro.school.cs4308.values.CString
import dev.jacaro.school.cs4308.values.ID
import dev.jacaro.school.cs4308.values.Integer
import dev.jacaro.school.cs4308.values.Real


private val expectedTokens = Operators.values().map { it.token }
    .plus(arrayOf(
        Token.ID,
        Token.STRING,
        Token.INTEGER,
        Token.REAL)).toTypedArray()


object ExpressionGenerator : ListGenerator<Expression>(expectedTokens, { lexemes ->
    val expressionWrapped: Array<ExpressionWrap<*>> = lexemes.map { lexeme ->
        when(lexeme.token) {
            in Operators.values().map { it.token } ->
                ExpressionWrap(Operators.values().find { it.token == lexeme.token }!!)
            Token.ID -> ExpressionWrap(IDManager.ids.getOrPut(lexeme.value) {
                ID(lexeme.value)
            })
            Token.STRING -> ExpressionWrap(CString(lexeme.value))
            Token.INTEGER -> ExpressionWrap(Integer(lexeme.value.toInt()))
            Token.REAL -> ExpressionWrap(Real(lexeme.value.toDouble()))
            else -> throw ExpressionGenerationError("")
        }
    }.toTypedArray()

    val postFix = ExpressionConverter.infixToPostfix(expressionWrapped)
    Expression(Integer(0))
}) {

    override val result: String
        get() = "Expression"

}