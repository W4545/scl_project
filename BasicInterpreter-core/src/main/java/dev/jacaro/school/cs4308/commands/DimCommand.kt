package dev.jacaro.school.cs4308.commands

import dev.jacaro.school.cs4308.constants.IntegerList
import dev.jacaro.school.cs4308.values.ID
import dev.jacaro.school.cs4308.structure.Action

data class DimCommand(val id: ID, val integerList: IntegerList) : Action