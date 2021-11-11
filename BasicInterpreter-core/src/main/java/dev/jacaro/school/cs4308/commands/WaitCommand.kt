package dev.jacaro.school.cs4308.commands

import dev.jacaro.school.cs4308.constants.ValueList
import dev.jacaro.school.cs4308.structure.Action

data class WaitCommand(val valueList: ValueList) : Action