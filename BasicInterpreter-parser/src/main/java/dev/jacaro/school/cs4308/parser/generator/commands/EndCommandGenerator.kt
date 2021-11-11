package dev.jacaro.school.cs4308.parser.generator.commands

import dev.jacaro.school.cs4308.commands.EndCommand
import dev.jacaro.school.cs4308.parser.generator.TokenGenerator
import dev.jacaro.school.cs4308.structure.Token

object EndCommandGenerator : TokenGenerator<EndCommand>(Token.END, { EndCommand() })