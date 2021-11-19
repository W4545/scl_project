package dev.jacaro.school.cs4308.commands

import dev.jacaro.school.cs4308.structure.Action
import dev.jacaro.school.cs4308.structure.State


class ReturnCommand : Action {
    override fun action(state: State) {
        val subRoutineControl = state.goSubControls.pop()
        state.setNextLine(line = subRoutineControl.returningLine)
    }
}

class StopCommand : Action {
    override fun action(state: State) {
        state.stopExecution = true
    }
}

class RemarkCommand : Action {
    override fun action(state: State) {
        // Do Nothing. This is a comment
    }
}
