package dev.jacaro.school.cs4308.values

/**
 * [RawType] for strings
 */
class CString(private val string: String) : RawType<String> {
    override val value: Double
        get() = string.hashCode().toDouble()
    override val raw: String
        get() = string

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CString

        if (string != other.string) return false

        return true
    }

    override fun hashCode(): Int {
        return string.hashCode()
    }

    override fun toString(): String {
        return "CString(value='$string')"
    }
}