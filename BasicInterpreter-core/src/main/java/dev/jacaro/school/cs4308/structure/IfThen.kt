package dev.jacaro.school.cs4308.structure

import dev.jacaro.school.cs4308.expressions.Expression

data class IfThen(val expression: Expression, val statement: Statement) : Action