package dev.jacaro.school.cs4308.parser.structures

import dev.jacaro.school.cs4308.parser.commands.LetCommand
import dev.jacaro.school.cs4308.parser.constants.ID
import dev.jacaro.school.cs4308.parser.expressions.Expression
import dev.jacaro.school.cs4308.parser.structure.Action

data class ForLoop(val letCommand: LetCommand, val postExpression: Expression, val step: Int? = null) : Action