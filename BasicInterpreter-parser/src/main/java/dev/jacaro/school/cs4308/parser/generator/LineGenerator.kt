package dev.jacaro.school.cs4308.parser.generator

import dev.jacaro.school.cs4308.parser.Head
import dev.jacaro.school.cs4308.parser.structure.Generator
import dev.jacaro.school.cs4308.parser.structure.Line
import dev.jacaro.school.cs4308.scanner.structure.Token

object LineGenerator : Generator<Line> {
    override fun generate(head: Head): Line? {
        val int = IntConstantGenerator.generate(head) ?: return null
        head.inc()
        head.isToken(Token.OP_POUND)
    }


}