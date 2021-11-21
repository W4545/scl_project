package dev.jacaro.school.cs4308.kotlin.structure

import dev.jacaro.school.cs4308.kotlin.ids.IDManager
import dev.jacaro.school.cs4308.kotlin.values.Integer
import dev.jacaro.school.cs4308.kotlin.values.Value
import dev.jacaro.school.cs4308.kotlin.commands.DataCommand
import dev.jacaro.school.cs4308.kotlin.commands.ReadCommand
import java.lang.RuntimeException
import java.util.*

/**
 * Holds the current state of execution
 * @param idManager the active [IDManager]
 */
class State(val idManager: IDManager, val lines: Array<Line>) {

    /**
     * A map of line numbers associated to lines
     */
    val lineMap = lines.associateBy { it.lineNumber }

    /**
     * A stack of [ForLoopControls][ForLoopControl]
     */
    val forLoopControls: Deque<ForLoopControl> = ArrayDeque()

    /**
     * A stack of [SubRoutineControls][SubRoutineControl]
     */
    val goSubControls: Deque<SubRoutineControl> = ArrayDeque()

    /**
     * A queue of data. Data is provided by [DATA commands][DataCommand] and used by [READ commands][ReadCommand].
     */
    val dataQueue: Deque<Value<*>> = ArrayDeque()

    var stopExecution = false

    /**
     * Tells the execution engine to not increment the line. Used by control structures, subroutines, goto commands.
     */
    var doNotIncrementLine: Boolean = false

    private var currentLineArrayPosition = 0

    var currentLineNumber: Integer = lines.first().lineNumber
    private set(value) {
        currentLine = lineMap[value] ?: throw RuntimeException("Illegal line number $value. No line exists with provided line number.")
        currentLineArrayPosition = lines.indexOf(currentLine)
        field = value
    }

    var currentLine: Line = lines.first()
    private set

    /**
     * Changes the current executing line to the provided [Integer], [Int], or [Line].
     */
    fun setNextLine(integer: Integer? = null, int: Int? = null, line: Line? = null) : Boolean {
        integer?.let {
            if(lineMap.keys.contains(it)) {
                currentLineNumber = it
                doNotIncrementLine = true
                return true
            }
        }

        int?.let {
            val temp = Integer(it)
            if (lineMap.keys.contains(temp)) {
                currentLineNumber = temp
                doNotIncrementLine = true
                return true
            }
        }

        line?.let {
            currentLineNumber = line.lineNumber
            doNotIncrementLine = true
            return true
        }

        return false
    }

    /**
     * Returns the next line to be executed.
     */
    fun nextLine(): Line {
        return lines[currentLineArrayPosition + 1]
    }

    override fun toString(): String {
        return "State(idManager=$idManager, lines=${lines.contentToString()}, lineMap=$lineMap, forLoopControls=$forLoopControls, goSubControls=$goSubControls, currentLineArrayPosition=$currentLineArrayPosition, currentLineNumber=$currentLineNumber, currentLine=$currentLine)"
    }
}