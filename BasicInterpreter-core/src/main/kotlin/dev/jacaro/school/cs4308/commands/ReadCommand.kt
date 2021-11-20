package dev.jacaro.school.cs4308.commands

import dev.jacaro.school.cs4308.constants.IDList
import dev.jacaro.school.cs4308.structure.Action
import dev.jacaro.school.cs4308.structure.State
import dev.jacaro.school.cs4308.values.RawType
import dev.jacaro.school.cs4308.values.ID

/**
 * The READ command loads data from the data queue into the provided list of IDs. By default, execution is halted if
 * the data queue is empty.
 * @param idList list of [IDs][ID]
 */
data class ReadCommand(val idList: IDList) : Action {
    override fun action(state: State) {
        try {
            for (id in idList.idList)
                id.backerProperty = state.dataQueue.pop() as RawType<*>
        } catch (ex: NoSuchElementException) {
            state.stopExecution = true
        }

    }
}