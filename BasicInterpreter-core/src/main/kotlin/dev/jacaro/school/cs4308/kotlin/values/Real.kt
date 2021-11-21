package dev.jacaro.school.cs4308.kotlin.values

/**
 * [RawType] for doubles
 */
class Real(private val double: Double) : RawType<Double> {
    override val value: Double
        get() = double
    override val raw: Double
        get() = double

    operator fun plus(type: Value<*>) = Real(double + type.value)

    operator fun minus(type: Value<*>) = Real(double - type.value)

    operator fun times(type: Value<*>) = Real(double * type.value)

    operator fun div(type: Value<*>) = Real(double / type.value)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Real

        if (double != other.double) return false

        return true
    }

    override fun hashCode(): Int {
        return double.hashCode()
    }

    override fun toString(): String {
        return "Real(value=$double)"
    }
}