package dev.jacaro.school.cs4308.parser.generator.commands

import dev.jacaro.school.cs4308.errors.ParsingError
import dev.jacaro.school.cs4308.parser.Head
import dev.jacaro.school.cs4308.commands.CloseCommand
import dev.jacaro.school.cs4308.parser.generator.IntConstantGenerator
import dev.jacaro.school.cs4308.parser.generator.expectToken
import dev.jacaro.school.cs4308.parser.structure.Generator
import dev.jacaro.school.cs4308.structure.Token
import dev.jacaro.school.cs4308.values.Integer

object CloseCommandGenerator: Generator<CloseCommand> {
    override fun generate(head: Head): CloseCommand? {
        return if (head.isToken(Token.CLOSE)) {
            head.inc()
            expectToken(head, Token.OP_POUND)
            head.inc()
            val int = IntConstantGenerator.generate(head) ?: throw ParsingError("")
            CloseCommand(int)
        } else null
    }

    override val result: String
        get() = "CLOSE"
}