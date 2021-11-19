package dev.jacaro.school.cs4308.structure

data class ForLoopControl(val startingLine: Line, val cause: ForLoop, var nextCommandLine: Line? = null)