package dev.jacaro.school.cs4308.kotlin.commands

import dev.jacaro.school.cs4308.kotlin.constants.IDList
import dev.jacaro.school.cs4308.kotlin.structure.Action
import dev.jacaro.school.cs4308.kotlin.structure.State
import dev.jacaro.school.cs4308.kotlin.values.RawType
import dev.jacaro.school.cs4308.kotlin.values.ID

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