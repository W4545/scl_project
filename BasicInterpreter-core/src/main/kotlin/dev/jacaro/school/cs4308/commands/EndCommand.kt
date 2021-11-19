package dev.jacaro.school.cs4308.commands

import dev.jacaro.school.cs4308.structure.Action
import dev.jacaro.school.cs4308.structure.State

class EndCommand : Action {
    override fun action(state: State) {
        state.stopExecution = true
    }
}