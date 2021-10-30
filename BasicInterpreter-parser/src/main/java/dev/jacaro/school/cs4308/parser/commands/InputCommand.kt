package dev.jacaro.school.cs4308.parser.commands

import dev.jacaro.school.cs4308.parser.constants.IDList
import dev.jacaro.school.cs4308.parser.structure.Action

//TODO Investigate integer option in this command
data class InputCommand(val idList: IDList, val integer: Int? = null) : Action