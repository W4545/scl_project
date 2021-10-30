package dev.jacaro.school.cs4308.parser.generator.commands

import dev.jacaro.school.cs4308.parser.commands.EndCommand
import dev.jacaro.school.cs4308.parser.generator.TokenGenerator
import dev.jacaro.school.cs4308.scanner.structure.Token

object EndCommandGenerator : TokenGenerator<EndCommand>(Token.END, { EndCommand() })