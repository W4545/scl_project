package dev.jacaro.school.cs4308.kotlin.commands

import dev.jacaro.school.cs4308.kotlin.structure.Action
import dev.jacaro.school.cs4308.kotlin.structure.State

/**
 * Functionally the same as the return command.
 * @see ReturnCommand
 */
class EndCommand : Action {
    override fun action(state: State) {
        state.stopExecution = true
    }

    override fun toString(): String {
        return "EndCommand"
    }
}