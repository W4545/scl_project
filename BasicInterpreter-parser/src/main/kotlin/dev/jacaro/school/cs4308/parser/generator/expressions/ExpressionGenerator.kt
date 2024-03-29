package dev.jacaro.school.cs4308.parser.generator.expressions

import dev.jacaro.school.cs4308.kotlin.errors.ExpressionGenerationError
import dev.jacaro.school.cs4308.kotlin.expressions.Expression
import dev.jacaro.school.cs4308.kotlin.expressions.Operators
import dev.jacaro.school.cs4308.kotlin.ids.IDManager
import dev.jacaro.school.cs4308.parser.generator.lists.ListGenerator
import dev.jacaro.school.cs4308.kotlin.structure.Token
import dev.jacaro.school.cs4308.kotlin.values.CString
import dev.jacaro.school.cs4308.kotlin.values.ID
import dev.jacaro.school.cs4308.kotlin.values.Real


private val expectedTokens = Operators.values().map { it.token }
    .plus(arrayOf(
        Token.ID,
        Token.STRING,
        Token.INTEGER,
        Token.REAL)).toTypedArray()

/**
 * Generates an expression. This could be any type of expression. Expression return type is enforced later.
 * @see ListGenerator
 */
object ExpressionGenerator : ListGenerator<Expression<*>>(expectedTokens, { lexemes ->
    val expressionWrapped: Array<ExpressionWrap<*>> = lexemes.map { lexeme ->
        when(lexeme.token) {
            in Operators.values().map { it.token } ->
                ExpressionWrap(Operators.values().find { it.token == lexeme.token }!!)
            Token.ID -> ExpressionWrap(IDManager.ids.getOrPut(lexeme.value) {
                ID(lexeme.value)
            })
            Token.STRING -> ExpressionWrap(CString(lexeme.value))
            Token.REAL, Token.INTEGER -> ExpressionWrap(Real(lexeme.value.toDouble()))
            else -> throw ExpressionGenerationError("")
        }
    }.toTypedArray()

    val postFix = ExpressionInfixConverter.infixToPostfix(expressionWrapped)
    Expression(ExpressionTreeBuilder.buildTree(postFix))
}) {

    override val result: String
        get() = "Expression"

}