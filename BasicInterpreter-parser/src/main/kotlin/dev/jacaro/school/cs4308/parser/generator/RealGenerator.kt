package dev.jacaro.school.cs4308.parser.generator

import dev.jacaro.school.cs4308.errors.ParsingError
import dev.jacaro.school.cs4308.parser.Head
import dev.jacaro.school.cs4308.parser.generator.lists.ListGenerator
import dev.jacaro.school.cs4308.parser.structure.Generator
import dev.jacaro.school.cs4308.structure.Token
import dev.jacaro.school.cs4308.values.Integer
import dev.jacaro.school.cs4308.values.Real

object RealGenerator : Generator<Real> {
    override fun generate(head: Head): Real? {
        return when (head.current.token) {
            Token.INTEGER -> {
                val temp = Real(head.current.value.toDouble())
                head.inc()
                temp
            }
            Token.REAL -> {
                val temp = Real(head.current.value.toDouble())
                head.inc()
                temp
            }
            Token.OP_MINUS -> {
                head.inc()
                expectToken(head, Token.REAL)
                val temp = Real(-head.current.value.toDouble())
                head.inc()
                temp
            }
            Token.OP_PLUS -> {
                head.inc()
                expectToken(head, Token.REAL)
                val temp = Real(+head.current.value.toDouble())
                head.inc()
                temp
            }
            else -> null
        }
    }

    override val result: String
        get() = "Real"

}