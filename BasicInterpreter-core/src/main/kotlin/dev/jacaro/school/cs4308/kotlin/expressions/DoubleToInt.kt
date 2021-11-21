package dev.jacaro.school.cs4308.kotlin.expressions

import dev.jacaro.school.cs4308.kotlin.values.Value

/**
 * A wrapper to wrap doubles into integers.
 */
class DoubleToInt(private val backerProperty: Value<Double>) : Value<Int> {
    override val value: Double
        get() = backerProperty.value
    override val raw: Int
        get() = backerProperty.raw.toInt()
}