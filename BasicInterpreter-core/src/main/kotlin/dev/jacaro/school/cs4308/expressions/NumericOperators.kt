package dev.jacaro.school.cs4308.expressions

import dev.jacaro.school.cs4308.values.Real
import dev.jacaro.school.cs4308.values.Value
import kotlin.math.pow

/**
 * A necessary wrapper to allow any value type to be based to certain operators.
 * @param backerValue a value to be passed through the AnyWrap
 */
class AnyWrap(val backerValue: Value<*>) : Value<Any> {
    override val value: Double
        get() = backerValue.value
    override val raw: Any
        get() = backerValue.raw!!

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is AnyWrap) return false

        if (backerValue != other.backerValue) return false

        return true
    }

    override fun hashCode(): Int {
        return backerValue.hashCode()
    }

    override fun toString(): String = backerValue.toString()
}

/**
 * Middleware for the numeric operators. Implements some necessary fields from the implementing [Value].
 */
abstract class NumericOperator internal constructor(left: Value<Double>, right: Value<Double>) : OperatorImpl<Double, Double>(left, right) {
    override val value: Double
        get() = operation().value
    override val raw: Double
        get() = operation().value

}

/**
 * Add two double values together
 */
class Addition(left: Value<Double>, right: Value<Double>) : NumericOperator(left, right) {
    override fun operation(): Value<Double> {
        return Real(left.value + right!!.value)
    }

    override fun toString(): String {
        return "Addition(left=$left, right=$right)"
    }
}

/**
 * Subtract two double values
 */
class Subtraction(left: Value<Double>, right: Value<Double>) : NumericOperator(left, right) {
    override fun operation(): Value<Double> {
        return Real(left.value - right!!.value)
    }

    override fun toString(): String {
        return "Subtraction(left=$left, right=$right)"
    }
}
/**
 * Multiply two double values
 */
class Multiplication(left: Value<Double>, right: Value<Double>) : NumericOperator(left, right) {
    override fun operation(): Value<Double> {
        return Real(left.value * right!!.value)
    }

    override fun toString(): String {
        return "Multiplication(left=$left, right=$right)"
    }
}

/**
 * Divide two double values
 */
class Division(left: Value<Double>, right: Value<Double>) : NumericOperator(left, right) {
    override fun operation(): Value<Double> {
        return Real(left.value / right!!.value)
    }

    override fun toString(): String {
        return "Division(left=$left, right=$right)"
    }
}

/**
 * Raise a double value to the value of another double value
 */
class Power(left: Value<Double>, right: Value<Double>) : NumericOperator(left, right) {
    override fun operation(): Value<Double> {
        return Real(left.value.pow(right!!.value))
    }

    override fun toString(): String {
        return "Power(left=$left, right=$right"
    }
}

/**
 * Makes a double value positive
 */
class UnaryPlus(value: Value<Double>) : OperatorImpl<Double, Double>(value, null) {

    override val value: Double
        get() = operation().value
    override val raw: Double
        get() = operation().value

    override fun operation(): Value<Double> {
        return Real(+left.value)
    }
}

/**
 * Makes a double value negative
 */
class UnaryMinus(value: Value<Double>) : OperatorImpl<Double, Double>(value, null) {

    override val value: Double
        get() = operation().value
    override val raw: Double
        get() = operation().value

    override fun operation(): Value<Double> {
        return Real(-left.value)
    }
}