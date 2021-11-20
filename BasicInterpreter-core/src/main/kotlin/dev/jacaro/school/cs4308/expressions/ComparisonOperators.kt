package dev.jacaro.school.cs4308.expressions

import dev.jacaro.school.cs4308.values.CBoolean
import dev.jacaro.school.cs4308.values.Value
import java.lang.RuntimeException

/**
 * Middleware that implements some specifics for basic numeric comparison operators.
 */
open class BasicComparisonOperator(left: Value<Double>, right: Value<Double>, private val operationFun: () -> Boolean)
    : OperatorImpl<Double, Boolean>(left, right) {

    override val value: Double
        get() = throw RuntimeException("Illegal Operation")
    override val raw: Boolean
        get() = operation().raw

    override fun operation(): Value<Boolean> = CBoolean(operationFun())


    override fun toString(): String = "${javaClass.name}(left=$left, right=$right)"
}

/**
 * Implements the greater than operator
 */
class GreaterThanOperator(left: Value<Double>, right: Value<Double>)
    : BasicComparisonOperator(left, right, { left.value > right.value })

/**
 * Implements the less than operator
 */
class LessThanOperator(left: Value<Double>, right: Value<Double>)
    : BasicComparisonOperator(left, right, { left.value < right.value })

/**
 * Implements the greater than or equal to operator
 */
class GreaterThanOrEqualToOperator(left: Value<Double>, right: Value<Double>)
    : BasicComparisonOperator(left, right, { left.value >= right.value })

/**
 * Implements the less than or equal to operator
 */
class LessThanOrEqualToOperator(left: Value<Double>, right: Value<Double>)
    : BasicComparisonOperator(left, right, { left.value <= right.value })

/**
 * Middleware that implements some specifics for operators that manipulate booleans.
 */
abstract class BasicBooleanOperator(left: Value<Boolean>, right: Value<Boolean>, private val operationFun: () -> Boolean) : OperatorImpl<Boolean, Boolean>(left, right) {
    override val value: Double
        get() = throw RuntimeException("Illegal Operation")
    override val raw: Boolean
        get() = operation().raw

    override fun operation(): Value<Boolean> = CBoolean(operationFun())

    override fun toString(): String = "${javaClass.name}(left=$left, right=$right)"
}

/**
 * Implements the boolean AND operator.
 */
class AndOperator(left: Value<Boolean>, right: Value<Boolean>): BasicBooleanOperator(left, right, {
    left.raw && right.raw
})

/**
 * Implements the boolean OR operator.
 */
class OrOperator(left: Value<Boolean>, right: Value<Boolean>): BasicBooleanOperator(left, right, {
    left.raw || right.raw
})

/**
 * Middleware for comparison operators that take any value and compares them.
 * @see AnyWrap
 */
abstract class AnyComparisonOperator(left: Value<*>, right: Value<*>, private val operationFun: () -> Boolean) : OperatorImpl<Any, Boolean>(AnyWrap(left), AnyWrap(right)) {

    override val value: Double
        get() = throw RuntimeException("Illegal Operation")
    override val raw: Boolean
        get() = operation().raw

    override fun operation(): Value<Boolean> = CBoolean(operationFun())

    override fun toString(): String = "${javaClass.name}(left=$left, right=$right)"
}

/**
 * Implements the equal to operator
 */
class EqualToOperator(left: Value<*>, right: Value<*>)
    : AnyComparisonOperator(left, right, { left.raw == right.raw })

/**
 * Implements the not equal to operator.
 */
class NotEqualToOperator(left: Value<*>, right: Value<*>)
    : AnyComparisonOperator(left, right, { left.raw != right.raw })