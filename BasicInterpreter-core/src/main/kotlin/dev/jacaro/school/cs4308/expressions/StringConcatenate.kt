package dev.jacaro.school.cs4308.expressions

import dev.jacaro.school.cs4308.values.CString
import dev.jacaro.school.cs4308.values.Value

class StringConcatenate(left: Value<String>, right: Value<String>) : Operator<String>(left, right) {
    override fun operation(): Value<String> = CString((left.raw as String) + (right!!.raw as String))

    override fun toString(): String {
        return "StringConcatOperator(left=$left, right=$right)"
    }
}