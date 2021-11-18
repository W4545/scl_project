package dev.jacaro.school.cs4308.commands

import dev.jacaro.school.cs4308.values.ID
import dev.jacaro.school.cs4308.expressions.Expression
import dev.jacaro.school.cs4308.structure.Action

data class LetCommand(val id: ID, val expression: Expression<*>) : Action