package dev.jacaro.school.cs4308.structure

import dev.jacaro.school.cs4308.commands.LetCommand
import dev.jacaro.school.cs4308.expressions.Expression
import dev.jacaro.school.cs4308.values.ID
import dev.jacaro.school.cs4308.values.Real
import java.lang.RuntimeException
import kotlin.properties.Delegates

/**
 * Checks if the provided ID has the type T or throws an exception.
 * @receiver type of ID
 * @throws RuntimeException
 */
inline fun <reified T> ID.validateOrThrow() : T {
    if (backerProperty?.raw is T)
        return backerProperty?.raw as T
    else
        throw RuntimeException("Failed to cast ID $id to expected type.")
}

/**
 * For loop structure. Controls the initialization of and stepping of the loop variable. Also responsible for
 * exiting the loop.
 */
data class ForLoop(val letCommand: LetCommand, val postExpression: Expression<Double>, val step: Real? = null) : Action {

    var firstRun = false
    private set

    private var initial by Delegates.notNull<Double>()

    override fun action(state: State) {

        if (!firstRun) {
            firstRun = true // Only run initialization once.

            letCommand.action(state)

            initial = letCommand.id.validateOrThrow()

            // Verify within bounds of loop
            if (letCommand.id.validateOrThrow<Double>() <= postExpression.expression.value) {
                state.forLoopControls.push(ForLoopControl(state.currentLine, this))
            }
        } else {
            if (step == null) {
                letCommand.id.backerProperty = Real(letCommand.id.backerProperty!!.value + initial)
            } else {
                letCommand.id.backerProperty = Real(letCommand.id.backerProperty!!.value + step.value)
            }
            // Verify within bounds of loop
            if (letCommand.id.value > postExpression.value) {
                val temp = state.forLoopControls.pop()
                state.setNextLine(line = temp.nextCommandLine)
                state.setNextLine(line = state.nextLine()) // Set next line to next line outside for loop
                firstRun = false
            }
        }

    }
}