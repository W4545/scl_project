package dev.jacaro.school.cs4308.expressions

import dev.jacaro.school.cs4308.values.CBoolean
import dev.jacaro.school.cs4308.values.Value

abstract class ComparisonOperator(left: Value<*>, right: Value<*>) : Operator<Boolean>(left, right)

open class BasicComparisonOperator(left: Value<*>, right: Value<*>, private val operationFun: () -> Boolean)
    : ComparisonOperator(left, right) {

    override fun operation(): Value<Boolean> = CBoolean(operationFun())


    override fun toString(): String = "${javaClass.name}(left=$left, right=$right)"
}


class GreaterThanOperator(left: Value<*>, right: Value<*>)
    : BasicComparisonOperator(left, right, { left.value > right.value })

class LessThanOperator(left: Value<*>, right: Value<*>)
    : BasicComparisonOperator(left, right, { left.value < right.value })

class GreaterThanOrEqualToOperator(left: Value<*>, right: Value<*>)
    : BasicComparisonOperator(left, right, { left.value >= right.value })

class LessThanOrEqualToOperator(left: Value<*>, right: Value<*>)
    : BasicComparisonOperator(left, right, { left.value <= right.value })

class EqualToOperator(left: Value<*>, right: Value<*>)
    : BasicComparisonOperator(left, right, { left.value == right.value })

class NotEqualToOperator(left: Value<*>, right: Value<*>)
    : BasicComparisonOperator(left, right, { left.value != right.value })