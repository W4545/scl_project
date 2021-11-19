package dev.jacaro.school.cs4308.structure

import dev.jacaro.school.cs4308.ids.IDManager
import dev.jacaro.school.cs4308.values.Integer
import dev.jacaro.school.cs4308.values.Value
import java.lang.RuntimeException
import java.util.*

class State(val idManager: IDManager, val lines: Array<Line>) {

    val lineMap = lines.associateBy { it.lineNumber }

    val forLoopControls: Deque<ForLoopControl> = ArrayDeque()

    val goSubControls: Deque<SubRoutineControl> = ArrayDeque()

    val dataQueue: Deque<Value<*>> = ArrayDeque()

    var stopExecution = false

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

    fun nextLine(): Line {
        return lines[currentLineArrayPosition + 1]
    }

    override fun toString(): String {
        return "State(idManager=$idManager, lines=${lines.contentToString()}, lineMap=$lineMap, forLoopControls=$forLoopControls, goSubControls=$goSubControls, currentLineArrayPosition=$currentLineArrayPosition, currentLineNumber=$currentLineNumber, currentLine=$currentLine)"
    }
}