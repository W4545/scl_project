package dev.jacaro.school.cs4308.commands

import dev.jacaro.school.cs4308.values.Value
import dev.jacaro.school.cs4308.structure.Action

data class SysCommand(val value : Value<*>) : Action