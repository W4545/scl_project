package dev.jacaro.school.cs4308.parser.generator.expressions

/**
 * Expression wrapper class. Used when building expressions.
 */
data class ExpressionWrap<T>(val value: T) {

    override fun toString(): String {
        return "ExpressionWrap(value=$value)"
    }
}