package dev.jacaro.school.cs4308.executor

import dev.jacaro.school.cs4308.kotlin.commands.DataCommand
import dev.jacaro.school.cs4308.kotlin.errors.Basic64RuntimeException
import dev.jacaro.school.cs4308.kotlin.ids.IDManager
import dev.jacaro.school.cs4308.kotlin.structure.Line
import dev.jacaro.school.cs4308.kotlin.structure.State

/**
 * Main execution control logic.
 */
object Executor {

    fun execute(lines: Array<Line>) {
        val state = State(IDManager, lines) // Creates state for execution.

        // Pre-executes all data commands to preload data queue.
        for (line in state.lines) {
            for (statement in line.statements) {
                if (statement is DataCommand)
                    statement.action(state)
            }
        }


        outer@ while (!state.stopExecution) {
            inner@ for (statement in state.currentLine.statements) {
                try {
                    statement.action(state) // Execute statements on line.
                } catch (ex: RuntimeException) {
                    throw Basic64RuntimeException(state.currentLine, statement, ex)
                }

                if (state.doNotIncrementLine)
                    break@inner // Stop executing current line. Jumping to execute another line.

                if (state.stopExecution)
                    break@outer // Execution ordered to stop.
            }
            if (!state.doNotIncrementLine) {
                state.setNextLine(line = state.nextLine())
                state.doNotIncrementLine = false
            } else {
                state.doNotIncrementLine = false // Reset state after not incrementing.
            }
        }

        println("Execution Complete")
    }
}