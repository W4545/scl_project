package dev.jacaro.school.cs4308.parser.generator.commands

import dev.jacaro.school.cs4308.parser.Head
import dev.jacaro.school.cs4308.commands.DimCommand
import dev.jacaro.school.cs4308.parser.generator.IDGenerator
import dev.jacaro.school.cs4308.parser.generator.expectToken
import dev.jacaro.school.cs4308.parser.generator.genOrThrow
import dev.jacaro.school.cs4308.parser.generator.lists.IntegerListGenerator
import dev.jacaro.school.cs4308.parser.structure.Generator
import dev.jacaro.school.cs4308.structure.Token

object DimCommandGenerator : Generator<DimCommand> {
    override fun generate(head: Head): DimCommand? {
        return if (head.isToken(Token.DIM)) {
            head.inc()
            val id = genOrThrow(head, IDGenerator)
            expectToken(head, Token.OP_OPEN_PARENTHESIS)
            head.inc()
            val integerList = genOrThrow(head, IntegerListGenerator)
            expectToken(head, Token.OP_CLOSE_PARENTHESIS)
            head.inc()
            DimCommand(id, integerList)
        } else null
    }

    override val result: String
        get() = "DataCommand"
}