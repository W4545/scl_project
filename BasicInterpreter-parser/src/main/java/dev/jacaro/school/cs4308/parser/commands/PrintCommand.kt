package dev.jacaro.school.cs4308.parser.commands

import dev.jacaro.school.cs4308.parser.constants.PrintList
import dev.jacaro.school.cs4308.parser.structure.Action

data class PrintCommand(val integer: Int?, val printList: PrintList) : Action