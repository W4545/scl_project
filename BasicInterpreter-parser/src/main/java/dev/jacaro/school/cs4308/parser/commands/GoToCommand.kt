package dev.jacaro.school.cs4308.parser.commands

import dev.jacaro.school.cs4308.parser.expressions.Expression
import dev.jacaro.school.cs4308.parser.structure.Action

data class GoToCommand(val expression: Expression) : Action