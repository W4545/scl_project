package dev.jacaro.school.cs4308.parser.structures

import dev.jacaro.school.cs4308.parser.expressions.Expression
import dev.jacaro.school.cs4308.parser.structure.Action

data class IfThen(val expression: Expression, val statement: Statement) : Action