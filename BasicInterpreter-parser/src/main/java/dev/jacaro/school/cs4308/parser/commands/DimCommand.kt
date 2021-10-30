package dev.jacaro.school.cs4308.parser.commands

import dev.jacaro.school.cs4308.parser.constants.IntegerList
import dev.jacaro.school.cs4308.parser.constants.ID
import dev.jacaro.school.cs4308.parser.structure.Action

data class DimCommand(val id: ID, val integerList: IntegerList) : Action