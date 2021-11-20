package dev.jacaro.school.cs4308.values

/**
 * [RawType] for booleans
 */
class CBoolean(val boolean: Boolean) : RawType<Boolean> {
    override val value: Double
        get() = if (boolean) 1.0 else 0.0
    override val raw: Boolean
        get() = boolean

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is CBoolean) return false

        if (boolean != other.boolean) return false

        return true
    }

    override fun hashCode(): Int {
        return boolean.hashCode()
    }

    override fun toString(): String {
        return "CBoolean(boolean=$boolean)"
    }
}