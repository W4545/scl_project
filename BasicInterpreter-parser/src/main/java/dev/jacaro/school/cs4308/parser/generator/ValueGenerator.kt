package dev.jacaro.school.cs4308.parser.generator

import dev.jacaro.school.cs4308.parser.Head
import dev.jacaro.school.cs4308.parser.constants.Constant
import dev.jacaro.school.cs4308.parser.constants.ID
import dev.jacaro.school.cs4308.parser.constants.Value
import dev.jacaro.school.cs4308.parser.structure.Generator
import dev.jacaro.school.cs4308.scanner.structure.Token

object ValueGenerator : Generator<Value> {
    private val options = arrayOf(Token.INTEGER, Token.REAL, Token.STRING)

    override fun generate(head: Head): Value? {
        return if (options.any { head.current().token == it })
        {
            val temp = head.current()
            head.inc()
            Value(constant = Constant(temp))
        } else if (head.current().token == Token.ID) {
            val temp = head.current()
            head.inc()
            Value(id = ID(temp.value))
        } else null
    }

    override val result: String
        get() = TODO("Not yet implemented")

}