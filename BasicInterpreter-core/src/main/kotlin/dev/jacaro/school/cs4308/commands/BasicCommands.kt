package dev.jacaro.school.cs4308.commands

import dev.jacaro.school.cs4308.structure.Action
import dev.jacaro.school.cs4308.structure.State
import dev.jacaro.school.cs4308.structure.SubRoutineControl

/**
 * Exits a subroutine by returning to the line after the subroutine call. Also removes the
 * [SubRoutineControl] from the subroutine stack.
 * @see GoSubCommand
 * @see SubRoutineControl
 */
class ReturnCommand : Action {
    override fun action(state: State) {
        val subRoutineControl = state.goSubControls.pop()
        state.setNextLine(line = subRoutineControl.returningLine)
    }
}

/**
 * Immediately stops execution of the inputted file
 */
class StopCommand : Action {
    override fun action(state: State) {
        state.stopExecution = true
    }
}

/**
 * Simply a placeholder. REM commands are ignored during execution.
 */
class RemarkCommand : Action {
    override fun action(state: State) {
        // Do Nothing. This is a comment
    }
}
