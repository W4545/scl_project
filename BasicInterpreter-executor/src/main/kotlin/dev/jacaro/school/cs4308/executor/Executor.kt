package dev.jacaro.school.cs4308.executor

import dev.jacaro.school.cs4308.commands.DataCommand
import dev.jacaro.school.cs4308.ids.IDManager
import dev.jacaro.school.cs4308.structure.Line
import dev.jacaro.school.cs4308.structure.State

/**
 * Main execution control logic.
 */
object Executor {

    fun execute(lines: Array<Line>) {
        val state = State(IDManager, lines) // Creates state for execution.

        // Pre-executes all data commands to preload data queue.
        for (line in state.lines) {
            for (statement in line.statements) {
                if (statement.action is DataCommand)
                    statement.action.action(state)
            }
        }


        outer@ while (!state.stopExecution) {
            inner@ for (statement in state.currentLine.statements) {
                statement.action(state) // Execute statements on line.

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