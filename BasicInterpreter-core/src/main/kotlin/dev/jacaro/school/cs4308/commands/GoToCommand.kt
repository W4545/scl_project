package dev.jacaro.school.cs4308.commands

import dev.jacaro.school.cs4308.expressions.Expression
import dev.jacaro.school.cs4308.structure.Action

data class GoToCommand(val expression: Expression<Int>) : Action