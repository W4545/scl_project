package dev.jacaro.school.cs4308.parser.structure


import dev.jacaro.school.cs4308.parser.structures.Statement

data class Line(val lineNumber: Int, val statements: Array<Statement>)

