package dev.jacaro.school.cs4308.executor

import dev.jacaro.school.cs4308.commands.DataCommand
import dev.jacaro.school.cs4308.ids.IDManager
import dev.jacaro.school.cs4308.structure.Line
import dev.jacaro.school.cs4308.structure.State

object Executor {

    fun execute(lines: Array<Line>) {
        val state = State(IDManager, lines)

        for (line in state.lines) {
            for (statement in line.statements) {
                if (statement.action is DataCommand)
                    statement.action.action(state)
            }
        }


        outer@ while (!state.stopExecution) {
            inner@ for (statement in state.currentLine.statements) {
                statement.action(state)

                if (state.doNotIncrementLine)
                    break@inner

                if (state.stopExecution)
                    break@outer
            }
            if (!state.doNotIncrementLine) {
                state.setNextLine(line = state.nextLine())
                state.doNotIncrementLine = false
            } else {
                state.doNotIncrementLine = false
            }
        }

        println("Execution Complete")
    }
}