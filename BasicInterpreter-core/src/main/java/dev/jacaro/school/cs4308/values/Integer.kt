package dev.jacaro.school.cs4308.values

class Integer(private val integer: Int) : Value<Int>() {
    override val value: Double
        get() = integer.toDouble()
    override val raw: Int
        get() = integer

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Integer

        if (integer != other.integer) return false

        return true
    }

    override fun hashCode(): Int {
        return integer
    }

    override fun toString(): String {
        return "Integer(value=$integer)"
    }
}