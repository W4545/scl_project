package dev.jacaro.school.cs4308.kotlin.commands

import dev.jacaro.school.cs4308.kotlin.expressions.Expression
import dev.jacaro.school.cs4308.kotlin.structure.Action
import dev.jacaro.school.cs4308.kotlin.structure.State

/**
 * Immediately shifts execution to the provided line.
 * @see State
 */
data class GoToCommand(val expression: Expression<Int>) : Action {
    override fun action(state: State) {
        state.setNextLine(int = expression.raw)
    }
}