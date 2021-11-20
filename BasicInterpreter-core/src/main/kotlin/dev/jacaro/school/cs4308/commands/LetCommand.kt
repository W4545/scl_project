package dev.jacaro.school.cs4308.commands

import dev.jacaro.school.cs4308.expressions.Expression
import dev.jacaro.school.cs4308.structure.Action
import dev.jacaro.school.cs4308.structure.State
import dev.jacaro.school.cs4308.values.*

/**
 * Assigns the value of the provided [Expression] to the given [ID].
 * @see Expression
 * @see ID
 */
data class LetCommand(val id: ID, val expression: Expression<*>) : Action {
    override fun action(state: State) {
        val value = expression.expression.raw

        id.backerProperty = when (value) {
            is Double -> Real(value)
            is Int -> Integer(value)
            is String -> CString(value)
            is Boolean -> CBoolean(value)
            else -> throw RuntimeException("Illegal expression type attempted to be assigned to ID \"$id\"." +
                    "Let command was provided value $value.")
        }
    }
}