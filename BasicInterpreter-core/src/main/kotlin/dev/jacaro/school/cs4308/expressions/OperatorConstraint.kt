package dev.jacaro.school.cs4308.expressions

import dev.jacaro.school.cs4308.errors.constraints.NumericConstraintError
import dev.jacaro.school.cs4308.values.*

interface OperatorConstraint<T, R> {

    fun validate(operator: OperatorImpl<T, R>)
}


class BasicOperatorConstraint<T, R>(val name: String = "BasicConstraint", private val validator: OperatorImpl<T, R>.() -> Unit) : OperatorConstraint<T, R> {
    override fun validate(operator: OperatorImpl<T, R>) {
        operator.validator()
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BasicOperatorConstraint<*, *>

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

val NumberOperatorConstraint = BasicOperatorConstraint<Double, Double>("NumberConstraint") {
    fun validateField(value: Value<*>) {
        if (value is ID) {
            value.addConstraint(NumericConstraint)
        } else if (value !is Integer && value !is Real) {
            throw NumericConstraintError("Value $value in operator $this failed to be numeric")
        }
    }

    validateField(left)
    right?.let { value -> validateField(value) }
}