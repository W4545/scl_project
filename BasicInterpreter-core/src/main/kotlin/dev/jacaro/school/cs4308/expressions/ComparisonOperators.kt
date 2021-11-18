package dev.jacaro.school.cs4308.expressions

import dev.jacaro.school.cs4308.values.CBoolean
import dev.jacaro.school.cs4308.values.Value
import java.lang.RuntimeException

abstract class ComparisonOperator(left: Value<Double>, right: Value<Double>) : OperatorImpl<Double, Boolean>(left, right)

open class BasicComparisonOperator(left: Value<Double>, right: Value<Double>, private val operationFun: () -> Boolean)
    : ComparisonOperator(left, right) {

    override val value: Double
        get() = throw RuntimeException("Illegal Operation")
    override val raw: Boolean
        get() = operation().raw

    override fun operation(): Value<Boolean> = CBoolean(operationFun())


    override fun toString(): String = "${javaClass.name}(left=$left, right=$right)"
}


class GreaterThanOperator(left: Value<Double>, right: Value<Double>)
    : BasicComparisonOperator(left, right, { left.value > right.value })

class LessThanOperator(left: Value<Double>, right: Value<Double>)
    : BasicComparisonOperator(left, right, { left.value < right.value })

class GreaterThanOrEqualToOperator(left: Value<Double>, right: Value<Double>)
    : BasicComparisonOperator(left, right, { left.value >= right.value })

class LessThanOrEqualToOperator(left: Value<Double>, right: Value<Double>)
    : BasicComparisonOperator(left, right, { left.value <= right.value })

abstract class BasicBooleanOperator(left: Value<Boolean>, right: Value<Boolean>, private val operationFun: () -> Boolean) : OperatorImpl<Boolean, Boolean>(left, right) {
    override val value: Double
        get() = throw RuntimeException("Illegal Operation")
    override val raw: Boolean
        get() = operation().raw

    override fun operation(): Value<Boolean> = CBoolean(operationFun())

    override fun toString(): String = "${javaClass.name}(left=$left, right=$right)"
}

class AndOperator(left: Value<Boolean>, right: Value<Boolean>): BasicBooleanOperator(left, right, {
    left.raw && right.raw
})

class OrOperator(left: Value<Boolean>, right: Value<Boolean>): BasicBooleanOperator(left, right, {
    left.raw || right.raw
})

abstract class AnyComparisonOperator(left: Value<*>, right: Value<*>, private val operationFun: () -> Boolean) : OperatorImpl<Any, Boolean>(AnyWrap(left), AnyWrap(right)) {

    override val value: Double
        get() = throw RuntimeException("Illegal Operation")
    override val raw: Boolean
        get() = operation().raw

    override fun operation(): Value<Boolean> = CBoolean(operationFun())

    override fun toString(): String = "${javaClass.name}(left=$left, right=$right)"
}

class EqualToOperator(left: Value<*>, right: Value<*>)
    : AnyComparisonOperator(left, right, { left.raw == right.raw })

class NotEqualToOperator(left: Value<*>, right: Value<*>)
    : AnyComparisonOperator(left, right, { left.raw != right.raw })