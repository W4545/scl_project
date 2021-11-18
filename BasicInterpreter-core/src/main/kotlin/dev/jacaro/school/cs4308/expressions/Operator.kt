package dev.jacaro.school.cs4308.expressions

import dev.jacaro.school.cs4308.values.Value

interface Operator<T> : Value<T> {
    fun operation(): Value<T>
}