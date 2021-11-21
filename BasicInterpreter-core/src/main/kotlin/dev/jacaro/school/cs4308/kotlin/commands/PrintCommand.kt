package dev.jacaro.school.cs4308.kotlin.commands

import dev.jacaro.school.cs4308.kotlin.constants.PrintList
import dev.jacaro.school.cs4308.kotlin.structure.Action
import dev.jacaro.school.cs4308.kotlin.structure.State
import dev.jacaro.school.cs4308.kotlin.expressions.Expression

/**
 * The PRINT command prints out the provided list of expressions. All expressions are printed on the same line.
 * Expressions are separated by semi-colons. A new line is printed if a trailing comma is not present.
 * @see Expression
 * @see PrintList
 */
data class PrintCommand(val printList: PrintList?, val newLine: Boolean) : Action {
    override fun action(state: State) {
        if (printList != null) {
            for (expression in printList.expressionList)
                print("${expression.raw}")
        }

        if (newLine)
            println()
        else
            print("\t")
    }
}