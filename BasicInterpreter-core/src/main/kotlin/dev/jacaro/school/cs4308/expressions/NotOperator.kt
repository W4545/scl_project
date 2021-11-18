package dev.jacaro.school.cs4308.expressions

import dev.jacaro.school.cs4308.values.CBoolean
import dev.jacaro.school.cs4308.values.Value
import java.lang.RuntimeException

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