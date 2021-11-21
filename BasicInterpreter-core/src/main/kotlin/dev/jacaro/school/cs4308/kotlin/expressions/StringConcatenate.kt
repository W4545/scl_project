package dev.jacaro.school.cs4308.kotlin.expressions

import dev.jacaro.school.cs4308.kotlin.values.CString
import dev.jacaro.school.cs4308.kotlin.values.Value
import java.lang.RuntimeException

/**
 * Implements a string concatenate operator
 */
class StringConcatenate(left: Value<String>, right: Value<String>) : OperatorImpl<String, String>(left, right) {

    override val value: Double
        get() = throw RuntimeException("Illegal Operation")
    override val raw: String
        get() = operation().raw

    override fun operation(): Value<String> = CString(left.raw + right!!.raw)

    override fun toString(): String {
        return "StringConcatOperator(left=$left, right=$right)"
    }
}