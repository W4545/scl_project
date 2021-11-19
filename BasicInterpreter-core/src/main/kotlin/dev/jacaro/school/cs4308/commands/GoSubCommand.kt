package dev.jacaro.school.cs4308.commands

import dev.jacaro.school.cs4308.expressions.Expression
import dev.jacaro.school.cs4308.structure.Action
import dev.jacaro.school.cs4308.structure.State
import dev.jacaro.school.cs4308.structure.SubRoutineControl

data class GoSubCommand(val expression: Expression<Int>) : Action {
    override fun action(state: State) {
        state.goSubControls.push(SubRoutineControl(state.currentLine, state.nextLine()))
        state.setNextLine(int = expression.expression.raw)
    }
}