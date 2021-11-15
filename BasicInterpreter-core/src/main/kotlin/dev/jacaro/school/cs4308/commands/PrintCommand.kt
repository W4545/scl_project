package dev.jacaro.school.cs4308.commands

import dev.jacaro.school.cs4308.constants.PrintList
import dev.jacaro.school.cs4308.structure.Action
import dev.jacaro.school.cs4308.values.Integer

data class PrintCommand(val integer: Integer?, val printList: PrintList) : Action