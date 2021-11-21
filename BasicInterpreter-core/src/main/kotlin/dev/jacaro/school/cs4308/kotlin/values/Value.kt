package dev.jacaro.school.cs4308.kotlin.values

/**
 * Base Type for all language values.
 */
interface Value<T> {
    val value : Double

    val raw : T
}