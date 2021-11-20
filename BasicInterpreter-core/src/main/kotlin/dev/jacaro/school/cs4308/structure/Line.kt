package dev.jacaro.school.cs4308.structure

import dev.jacaro.school.cs4308.values.Integer

/**
 * Class that holds all the [statements][Statement] on a given line as well as its line number
 * @see Statement
 */
data class Line(val lineNumber: Integer, val statements: Array<Statement>) {
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
}

