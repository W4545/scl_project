package dev.jacaro.school.cs4308.parser.commands

import dev.jacaro.school.cs4308.parser.constants.ConstantList
import dev.jacaro.school.cs4308.parser.constants.ID
import dev.jacaro.school.cs4308.parser.structure.Action

data class DataCommand(val constantList: ConstantList) : Action