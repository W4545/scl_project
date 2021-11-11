package dev.jacaro.school.cs4308.commands

import dev.jacaro.school.cs4308.constants.Access
import dev.jacaro.school.cs4308.values.Value
import dev.jacaro.school.cs4308.structure.Action
import dev.jacaro.school.cs4308.values.Integer

data class OpenCommand(val value: Value<*>, val access: Access, val integer: Integer) : Action