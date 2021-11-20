package dev.jacaro.school.cs4308.structure

/**
 * Data class that holds references to the starting and ending lines of a for loop, and the ForLoop object.
 * This object is used for tracking the currently executing for loop.
 * @see ForLoop
 */
data class ForLoopControl(val startingLine: Line, val cause: ForLoop, var nextCommandLine: Line? = null)