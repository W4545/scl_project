package dev.jacaro.school.cs4308.expressions

import dev.jacaro.school.cs4308.errors.constraints.NumericConstraintError
import dev.jacaro.school.cs4308.values.*

interface OperatorConstraint<T> {

    fun validate(operator: Operator<T>)
}


class BasicOperatorConstraint<T>(val name: String = "BasicConstraint", private val validator: (Operator<T>) -> Unit) : OperatorConstraint<T> {
    override fun validate(operator: Operator<T>) = validator(operator)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BasicOperatorConstraint<*>

        if (validator != other.validator) return false

        return true
    }

    override fun hashCode(): Int {
        return validator.hashCode()
    }

    override fun toString(): String {
        return name
    }
}

val NumberOperatorConstraint = BasicOperatorConstraint<Double>("NumberConstraint") {
    fun validateField(value: Value<*>) {
        if (value.raw is ID) {
            val temp = value.raw as ID
            temp.addConstraint(NumericConstraint)
        } else if (value.raw !is Integer && value.raw !is Real) {
            throw NumericConstraintError("Value $value in operator $it failed to be numeric")
        }
    }

    validateField(it.left)
    it.right?.let { value -> validateField(value) }
}