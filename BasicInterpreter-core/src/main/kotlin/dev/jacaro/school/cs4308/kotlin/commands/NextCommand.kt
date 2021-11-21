package dev.jacaro.school.cs4308.kotlin.commands

import dev.jacaro.school.cs4308.kotlin.structure.Action
import dev.jacaro.school.cs4308.kotlin.structure.State
import dev.jacaro.school.cs4308.kotlin.values.ID
import dev.jacaro.school.cs4308.kotlin.structure.ForLoopControl
import dev.jacaro.school.cs4308.kotlin.structure.ForLoop

/**
 * The NEXT command looks up the corresponding [ForLoopControl] for the currently looping [ForLoop]. This will throw an
 * error if the current [ForLoopControl] does not match the [ID] provided in the NEXT command. If the IDs match,
 * execution is returned to the for loop for iteration and loop control.
 * @see ForLoopControl
 * @see ForLoop
 */
data class NextCommand(val id: ID) : Action {
    override fun action(state: State) {
        val first = state.forLoopControls.first

        if (first.cause.letCommand.id != id)
            throw RuntimeException("Mismatched for loops. " +
                    "Expected ID ${state.forLoopControls.first.cause.letCommand.id}.")

        if (first.nextCommandLine == null)
            first.nextCommandLine = state.currentLine

        state.setNextLine(line = state.forLoopControls.first.startingLine)
    }
}