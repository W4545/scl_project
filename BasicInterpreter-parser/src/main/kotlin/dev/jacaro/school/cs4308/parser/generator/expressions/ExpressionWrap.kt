package dev.jacaro.school.cs4308.parser.generator.expressions

data class ExpressionWrap<T>(val value: T) {

    override fun toString(): String {
        return "ExpressionWrap(value=$value)"
    }
}