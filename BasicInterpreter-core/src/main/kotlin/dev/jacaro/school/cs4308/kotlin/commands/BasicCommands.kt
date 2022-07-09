package dev.jacaro.school.cs4308.kotlin.commands

import dev.jacaro.school.cs4308.kotlin.errors.actions.ReturnCommandActionError
import dev.jacaro.school.cs4308.kotlin.structure.Action
import dev.jacaro.school.cs4308.kotlin.structure.State
import dev.jacaro.school.cs4308.kotlin.structure.SubRoutineControl

/**
 * Exits a subroutine by returning to the line after the subroutine call. Also removes the
 * [SubRoutineControl] from the subroutine stack.
 * @see GoSubCommand
 * @see SubRoutineControl
 */
class ReturnCommand : Action {
    override fun action(state: State) {
        if (state.goSubControls.size > 0) {
            val subRoutineControl = state.goSubControls.pop()
            state.setNextLine(line = subRoutineControl.returningLine)
        } else {
            throw ReturnCommandActionError()
        }
    }

    override fun toString(): String {
        return "ReturnCommand"
    }
}

/**
 * Immediately stops execution of the inputted file
 */
class StopCommand : Action {
    override fun action(state: State) {
        state.stopExecution = true
    }

    override fun toString(): String {
        return "StopCommand"
    }
}

/**
 * Simply a placeholder. REM commands are ignored during execution.
 */
class RemarkCommand(private val remark: String? = null) : Action {
    override fun action(state: State) {
        // Do Nothing. This is a comment
    }

    override fun toString(): String = if (remark != null)
        "RemarkCommand($remark)"
    else
        "RemarkCommand"
}
