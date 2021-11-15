package dev.jacaro.school.cs4308.structure

import dev.jacaro.school.cs4308.commands.LetCommand
import dev.jacaro.school.cs4308.expressions.Expression
import dev.jacaro.school.cs4308.structure.Action
import dev.jacaro.school.cs4308.values.Integer

data class ForLoop(val letCommand: LetCommand, val postExpression: Expression, val step: Integer? = null) : Action