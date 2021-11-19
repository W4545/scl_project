package dev.jacaro.school.cs4308.structure

import dev.jacaro.school.cs4308.commands.LetCommand
import dev.jacaro.school.cs4308.expressions.Expression
import dev.jacaro.school.cs4308.values.ID
import dev.jacaro.school.cs4308.values.Integer
import dev.jacaro.school.cs4308.values.Real
import dev.jacaro.school.cs4308.values.Value
import java.lang.RuntimeException
import kotlin.properties.Delegates

inline fun <reified T> ID.validateOrThrow() : T {
    if (backerProperty?.raw is T)
        return backerProperty?.raw as T
    else
        throw RuntimeException("Failed to cast ID $id to expected type.")
}

data class ForLoop(val letCommand: LetCommand, val postExpression: Expression<Double>, val step: Real? = null) : Action {

    var firstRun = false
    private set

    private var initial by Delegates.notNull<Double>()

    override fun action(state: State) {

        if (!firstRun) {
            firstRun = true

            letCommand.action(state)

            initial = letCommand.id.validateOrThrow()

            // Verify within bounds
            if (letCommand.id.validateOrThrow<Double>() <= postExpression.expression.value) {
                state.forLoopControls.push(ForLoopControl(state.currentLine, this))
            }
        } else {
            if (step == null) {
                letCommand.id.backerProperty = Real(letCommand.id.backerProperty!!.value + initial)
            } else {
                letCommand.id.backerProperty = Real(letCommand.id.backerProperty!!.value + step.value)
            }
            if (letCommand.id.value > postExpression.value) {
                val temp = state.forLoopControls.pop()
                state.setNextLine(line = temp.nextCommandLine)
                state.setNextLine(line = state.nextLine())
                firstRun = false
            }
        }

    }
}