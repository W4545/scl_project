package dev.jacaro.school.cs4308.parser.commands

import dev.jacaro.school.cs4308.parser.constants.ValueList
import dev.jacaro.school.cs4308.parser.structure.Action

data class PokeCommand(val valueList: ValueList) : Action