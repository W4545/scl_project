package dev.jacaro.school.cs4308.commands

import dev.jacaro.school.cs4308.expressions.Expression
import dev.jacaro.school.cs4308.structure.Action
import dev.jacaro.school.cs4308.structure.State

data class GoToCommand(val expression: Expression<Int>) : Action {
    override fun action(state: State) {
        state.setNextLine(int = expression.raw)
    }
}