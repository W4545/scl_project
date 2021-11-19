package dev.jacaro.school.cs4308.values

import dev.jacaro.school.cs4308.errors.VariableInitializationError
import dev.jacaro.school.cs4308.errors.constraints.NumericConstraintError


class ID(val id: String, backerProperty: RawType<*>? = null) : Value<Any> {

    private val constraints = emptySet<IDConstraint>().toMutableSet()

    var backerProperty = backerProperty
    set(value) {
        if (value == null)
            throw VariableInitializationError("A variable may not be assigned a null value")
        constraints.forEach { it.validate(this, value) }
        field = value
    }

    fun addConstraint(idConstraint: IDConstraint) : Boolean = constraints.add(idConstraint)

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

interface IDConstraint {
    fun validate(id: ID, value: RawType<*>)
}

class BasicIDConstraint(val name: String = "BasicConstraint", private val validator: (ID, RawType<*>) -> Unit) : IDConstraint {
    override fun validate(id: ID, value: RawType<*>) = validator(id, value)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BasicIDConstraint

        if (name != other.name) return false
        if (validator != other.validator) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + validator.hashCode()
        return result
    }

    override fun toString(): String {
        return name
    }

}

val NumericConstraint = BasicIDConstraint("NumericConstraint") { id, value ->
    if (value.raw !is Real && value.raw !is Integer)
        throw NumericConstraintError("ID $id failed numeric constraint. Expected a numeric value, found: $value")
}