package dev.jacaro.school.cs4308.structure

import dev.jacaro.school.cs4308.commands.GoToCommand
import dev.jacaro.school.cs4308.expressions.Expression

/**
 * Control structure that changes execution to a line given the provided [Expression] evaluates to true
 */
data class IfThen(val expression: Expression<Boolean>, val goToCommand: GoToCommand) : Action {
    override fun action(state: State) {
        if (expression.expression.raw) {
            goToCommand.action(state)
        }
    }
}