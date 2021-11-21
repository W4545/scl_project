package dev.jacaro.school.cs4308.parser.generator.commands

import dev.jacaro.school.cs4308.kotlin.commands.*
import dev.jacaro.school.cs4308.parser.generator.TokenGenerator
import dev.jacaro.school.cs4308.parser.structure.Generator
import dev.jacaro.school.cs4308.kotlin.structure.Token

/**
 * Generates [ReturnCommands][ReturnCommand]
 * @see Generator
 * @see TokenGenerator
 */
val ReturnCommandGenerator = TokenGenerator(Token.RETURN) {
    ReturnCommand()
}

/**
 * Generates [StopCommands][StopCommand]
 * @see Generator
 * @see TokenGenerator
 */
val StopCommandGenerator = TokenGenerator(Token.STOP) {
    StopCommand()

}

/**
 * Generates [RemarkCommands][RemarkCommand]
 * @see Generator
 * @see TokenGenerator
 */
val RemarkCommandGenerator = TokenGenerator(Token.REM) {
    RemarkCommand()
}