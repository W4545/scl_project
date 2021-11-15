package dev.jacaro.school.cs4308.expressions

import dev.jacaro.school.cs4308.values.Real
import dev.jacaro.school.cs4308.values.Value

abstract class NumericOperator internal constructor(left: Value<*>, right: Value<*>) : Operator<Double>(left, right) {
    init {
        NumberOperatorConstraint.validate(this)
    }
}

class Addition(left: Value<*>, right: Value<*>) : NumericOperator(left, right) {
    override fun operation(): Value<Double> {
        return Real(left.value + right!!.value)
    }

    override fun toString(): String {
        return "Addition(left=$left, right=$right)"
    }
}

class Subtraction(left: Value<*>, right: Value<*>) : NumericOperator(left, right) {
    override fun operation(): Value<Double> {
        return Real(left.value - right!!.value)
    }

    override fun toString(): String {
        return "Subtraction(left=$left, right=$right)"
    }
}

class Multiplication(left: Value<*>, right: Value<*>) : NumericOperator(left, right) {
    override fun operation(): Value<Double> {
        return Real(left.value * right!!.value)
    }

    override fun toString(): String {
        return "Multiplication(left=$left, right=$right)"
    }
}

class Division(left: Value<*>, right: Value<*>) : NumericOperator(left, right) {
    override fun operation(): Value<Double> {
        return Real(left.value / right!!.value)
    }

    override fun toString(): String {
        return "Division(left=$left, right=$right)"
    }
}

class UnaryPlus(value: Value<*>) : Operator<Double>(value, null) {
    override fun operation(): Value<Double> {
        return Real(+left.value)
    }
}

class UnaryMinus(value: Value<*>) : Operator<Double>(value, null) {
    override fun operation(): Value<Double> {
        return Real(-left.value)
    }
}