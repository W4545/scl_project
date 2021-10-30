package dev.jacaro.school.cs4308.parser.commands

import dev.jacaro.school.cs4308.parser.constants.Access
import dev.jacaro.school.cs4308.parser.constants.Value
import dev.jacaro.school.cs4308.parser.structure.Action

data class OpenCommand(val value: Value, val access: Access, val integer: Int) : Action