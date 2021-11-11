package dev.jacaro.school.cs4308.values

class Real(private val double: Double) : Value<Double>() {
    override val value: Double
        get() = double
    override val raw: Double
        get() = double

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