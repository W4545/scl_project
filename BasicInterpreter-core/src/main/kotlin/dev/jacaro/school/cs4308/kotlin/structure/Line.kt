package dev.jacaro.school.cs4308.kotlin.structure

import dev.jacaro.school.cs4308.kotlin.values.Integer

/**
 * Class that holds all the [statements][Action] on a given line as well as its line number
 * @see Action
 */
data class Line(val lineNumber: Integer, val statements: Array<Action>) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Line) return false

        if (lineNumber != other.lineNumber) return false
        if (!statements.contentEquals(other.statements)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = lineNumber.hashCode()
        result = 31 * result + statements.contentHashCode()
        return result
    }

    override fun toString(): String {
        return "Line(${statements.joinToString(", ")})"
    }
}

