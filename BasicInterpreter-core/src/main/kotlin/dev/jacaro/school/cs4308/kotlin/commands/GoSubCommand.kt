package dev.jacaro.school.cs4308.kotlin.commands

import dev.jacaro.school.cs4308.kotlin.expressions.Expression
import dev.jacaro.school.cs4308.kotlin.structure.Action
import dev.jacaro.school.cs4308.kotlin.structure.State
import dev.jacaro.school.cs4308.kotlin.structure.SubRoutineControl

/**
 * Adds a [SubRoutineControl] to the sub routine stack and changes the current execution line to the one specified
 * in the expression.
 * @see SubRoutineControl
 * @see ReturnCommand
 */
data class GoSubCommand(val expression: Expression<Int>) : Action {
    override fun action(state: State) {
        state.goSubControls.push(SubRoutineControl(state.currentLine, state.nextLine()))
        state.setNextLine(int = expression.expression.raw)
    }
}