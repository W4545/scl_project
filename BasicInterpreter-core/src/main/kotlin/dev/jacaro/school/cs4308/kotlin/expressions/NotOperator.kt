package dev.jacaro.school.cs4308.kotlin.expressions

import dev.jacaro.school.cs4308.kotlin.values.CBoolean
import dev.jacaro.school.cs4308.kotlin.values.Value
import java.lang.RuntimeException

/**
 * Implements the unary boolean not operator.
 */
class NotOperator(value: Value<Boolean>) : OperatorImpl<Boolean, Boolean>(value, null) {

    override val value: Double
        get() = throw RuntimeException("Illegal Operation")
    override val raw: Boolean
        get() = operation().raw

    override fun operation(): Value<Boolean> = CBoolean(!(left.raw))

    override fun toString(): String {
        return "NotOperator(value=$left)"
    }
}