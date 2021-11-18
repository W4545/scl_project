package dev.jacaro.school.cs4308.expressions

import dev.jacaro.school.cs4308.values.Value

class DoubleToInt(val backerProperty: Value<Double>) : Value<Int> {
    override val value: Double
        get() = backerProperty.value
    override val raw: Int
        get() = backerProperty.raw.toInt()
}