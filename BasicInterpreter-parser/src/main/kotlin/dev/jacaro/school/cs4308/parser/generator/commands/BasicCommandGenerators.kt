package dev.jacaro.school.cs4308.parser.generator.commands

import dev.jacaro.school.cs4308.commands.*
import dev.jacaro.school.cs4308.parser.generator.TokenGenerator
import dev.jacaro.school.cs4308.structure.Token

val ReturnCommandGenerator = TokenGenerator(Token.RETURN) {
    ReturnCommand()
}

val StopCommandGenerator = TokenGenerator(Token.STOP) {
    StopCommand()

}

val RemarkCommandGenerator = TokenGenerator(Token.REM) {
    RemarkCommand()
}