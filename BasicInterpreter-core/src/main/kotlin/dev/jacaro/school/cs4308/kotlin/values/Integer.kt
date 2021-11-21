package dev.jacaro.school.cs4308.kotlin.values

/**
 * [RawType] for integers
 */
class Integer(private val integer: Int) : RawType<Int> {
    override val value: Double
        get() = integer.toDouble()
    override val raw: Int
        get() = integer

    operator fun plus(integer: Integer) = Integer(this.integer + integer.integer)

    operator fun plus(type: Value<*>) = Real(this.integer + type.value)

    operator fun minus(integer: Integer) = Integer(this.integer - integer.integer)

    operator fun minus(type: Value<*>) = Real(this.integer - type.value)

    operator fun times(integer: Integer) = Integer(this.integer * integer.integer)

    operator fun times(type: Value<*>) = Real(this.integer * type.value)

    operator fun div(integer: Integer) = Integer(this.integer / integer.integer)

    operator fun div(type: Value<*>) = Real(this.integer / type.value)

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