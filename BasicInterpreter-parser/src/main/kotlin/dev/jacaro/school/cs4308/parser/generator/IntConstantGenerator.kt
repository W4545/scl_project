package dev.jacaro.school.cs4308.parser.generator

import dev.jacaro.school.cs4308.parser.Head
import dev.jacaro.school.cs4308.parser.structure.Generator
import dev.jacaro.school.cs4308.structure.Token
import dev.jacaro.school.cs4308.values.Integer

/**
 * Generates integer constants
 * @see Generator
 * @see Integer
 */
object IntConstantGenerator: Generator<Integer> {
    override fun generate(head: Head): Integer? {
        return when (head.current.token) {
            Token.INTEGER -> {
                val temp = Integer(head.current.value.toInt())
                head.inc()
                temp
            }
            Token.OP_MINUS -> {
                head.inc()
                expectToken(head, Token.INTEGER)
                val temp = Integer(-head.current.value.toInt())
                head.inc()
                temp
            }
            Token.OP_PLUS -> {
                head.inc()
                expectToken(head, Token.INTEGER)
                val temp = Integer(+head.current.value.toInt())
                head.inc()
                temp
            }
            else -> null
        }
    }

    override val result: String
        get() = "Integer"

}