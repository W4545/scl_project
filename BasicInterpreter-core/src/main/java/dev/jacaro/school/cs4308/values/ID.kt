package dev.jacaro.school.cs4308.values


class ID(val id: String, var backerProperty: Value<Any>? = null) : Value<Any>() {

    override val value: Double
        get() = backerProperty?.value ?: throw RuntimeException()

    override val raw: Any
        get() = backerProperty?.raw ?: throw RuntimeException()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ID

        if (id != other.id) return false
        if (backerProperty != other.backerProperty) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + (backerProperty?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "ID(id='$id', currentValue=$backerProperty)"
    }


}