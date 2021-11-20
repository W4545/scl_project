package dev.jacaro.school.cs4308.expressions

/**
 * A class that holds an array of [Expressions][Expression].
 */
data class ExpressionList(val expressionList: Array<Expression<*>>) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ExpressionList

        if (!expressionList.contentEquals(other.expressionList)) return false

        return true
    }

    override fun hashCode(): Int {
        return expressionList.contentHashCode()
    }
}