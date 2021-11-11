package dev.jacaro.school.cs4308.commands

import dev.jacaro.school.cs4308.structure.Action
import dev.jacaro.school.cs4308.values.Integer

data class CloseCommand(val int: Integer) : Action