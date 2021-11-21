package dev.jacaro.school.cs4308.parser.generator.commands

import dev.jacaro.school.cs4308.kotlin.commands.EndCommand
import dev.jacaro.school.cs4308.parser.generator.TokenGenerator
import dev.jacaro.school.cs4308.parser.structure.Generator
import dev.jacaro.school.cs4308.kotlin.structure.Token

/**
 * Generates [EndCommands][EndCommand]
 * @see Generator
 * @see TokenGenerator
 */
object EndCommandGenerator : TokenGenerator<EndCommand>(Token.END, { EndCommand() })