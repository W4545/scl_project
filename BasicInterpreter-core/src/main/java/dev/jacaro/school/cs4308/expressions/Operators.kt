package dev.jacaro.school.cs4308.expressions

import dev.jacaro.school.cs4308.structure.Token

enum class Operators(val token: Token) {
    NOT_EQUAL(Token.OP_NOT_EQUAL),
    GREATER_THAN(Token.OP_GREATER_THAN),
    GREATER_OR_EQUAL_TO(Token.OP_GREATER_OR_EQUAL_TO),
    LESS_THAN(Token.OP_LESS_THAN),
    LESS_THAN_OR_EQUAL_TO(Token.OP_LESS_THAN_OR_EQUAL_TO),
    PLUS(Token.OP_PLUS),
    MINUS(Token.OP_MINUS),
    MULTIPLY(Token.OP_MULTIPLY),
    DIVIDE(Token.OP_DIVIDE),
    POWER(Token.OP_POWER)
}
