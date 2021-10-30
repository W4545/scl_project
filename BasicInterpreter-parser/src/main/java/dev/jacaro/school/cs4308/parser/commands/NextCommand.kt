package dev.jacaro.school.cs4308.parser.commands

import dev.jacaro.school.cs4308.parser.constants.IDList
import dev.jacaro.school.cs4308.parser.structure.Action

data class NextCommand(val idList: IDList) : Action