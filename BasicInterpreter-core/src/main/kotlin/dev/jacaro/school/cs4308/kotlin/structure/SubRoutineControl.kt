package dev.jacaro.school.cs4308.kotlin.structure

/**
 * Data class that tracts the line calling the subroutine and the returning line after the subroutine is done.
 * @see Line
 */
data class SubRoutineControl(val currentLine: Line, val returningLine: Line)