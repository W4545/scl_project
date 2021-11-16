package dev.jacaro.school.cs4308.expressions

import dev.jacaro.school.cs4308.values.CBoolean
import dev.jacaro.school.cs4308.values.Value

class NotOperator(value: Value<Boolean>) : Operator<Boolean>(value, null) {
    override fun operation(): Value<Boolean> = CBoolean(!(left.raw as Boolean))

    override fun toString(): String {
        return "NotOperator(value=$left)"
    }
}