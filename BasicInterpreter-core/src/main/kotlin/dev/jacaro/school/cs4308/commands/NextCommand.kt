package dev.jacaro.school.cs4308.commands

import dev.jacaro.school.cs4308.structure.Action
import dev.jacaro.school.cs4308.structure.State
import dev.jacaro.school.cs4308.values.ID

data class NextCommand(val id: ID) : Action {
    override fun action(state: State) {
        val first = state.forLoopControls.first

        if (first.cause.letCommand.id != id)
            throw RuntimeException("Mismatched for loops. Expected ID ${state.forLoopControls.first.cause.letCommand.id}.")

        if (first.nextCommandLine == null)
            first.nextCommandLine = state.currentLine

        state.setNextLine(line = state.forLoopControls.first.startingLine)
    }
}