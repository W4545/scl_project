package dev.jacaro.school.cs4308.kotlin.expressions

import dev.jacaro.school.cs4308.kotlin.values.Value

/**
 * Base type for the operator type.
 * @see Value
 */
interface Operator<T> : Value<T> {
    fun operation(): Value<T>
}