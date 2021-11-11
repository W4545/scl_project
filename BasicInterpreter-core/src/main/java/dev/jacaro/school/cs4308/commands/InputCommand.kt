package dev.jacaro.school.cs4308.commands

import dev.jacaro.school.cs4308.constants.IDList
import dev.jacaro.school.cs4308.structure.Action
import dev.jacaro.school.cs4308.values.Integer

//TODO Investigate integer option in this command
data class InputCommand(val idList: IDList, val integer: Integer? = null) : Action