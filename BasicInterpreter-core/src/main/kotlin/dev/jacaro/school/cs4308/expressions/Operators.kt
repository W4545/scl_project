package dev.jacaro.school.cs4308.expressions

import dev.jacaro.school.cs4308.structure.Token

enum class Operators(val token: Token, val priority: Priority, val leftAssociative: Boolean = true, val unary: Boolean = false) {
    NOT_EQUAL(Token.OP_NOT_EQUAL, Priority.SEVEN),
    EQUAL(Token.OP_EQUALS, Priority.SEVEN),
    GREATER_THAN(Token.OP_GREATER_THAN, Priority.SIX),
    GREATER_OR_EQUAL_TO(Token.OP_GREATER_OR_EQUAL_TO, Priority.SIX),
    LESS_THAN(Token.OP_LESS_THAN, Priority.SIX),
    LESS_THAN_OR_EQUAL_TO(Token.OP_LESS_THAN_OR_EQUAL_TO, Priority.SIX),
    PLUS(Token.OP_PLUS, Priority.FOUR),
    MINUS(Token.OP_MINUS, Priority.FOUR),
    MULTIPLY(Token.OP_MULTIPLY, Priority.THREE),
    DIVIDE(Token.OP_DIVIDE, Priority.THREE),
    POWER(Token.OP_POWER, Priority.POWER, leftAssociative = false),
    AND(Token.AND, Priority.EIGHT),
    OR(Token.OR, Priority.TWELVE),
    OPEN_PARENTHESIS(Token.OP_OPEN_PARENTHESIS, Priority.ONE),
    CLOSE_PARENTHESIS(Token.OP_CLOSE_PARENTHESIS, Priority.ONE),
    UNARY_PLUS(Token.OP_UNARY_PLUS, Priority.TWO, leftAssociative = false, unary = true),
    UNARY_MINUS(Token.OP_UNARY_MINUS, Priority.TWO, leftAssociative = false, unary = true),
    NOT(Token.NOT, Priority.TWO, leftAssociative = false, unary = true)

}