package dev.jacaro.school.cs4308.commands

import dev.jacaro.school.cs4308.constants.ConstantList
import dev.jacaro.school.cs4308.structure.Action
import dev.jacaro.school.cs4308.structure.State

/**
 * The data command adds values to a buffer that can later be read using the [ReadCommand].
 * @see ReadCommand
 */
data class DataCommand(val constantList: ConstantList) : Action {

    var executed = false
    private set

    override fun action(state: State) {
        if (!executed) {
            for (constant in constantList.constants)
                state.dataQueue.addLast(constant)
            executed = true
        }
    }
}