package dev.jacaro.school.cs4308.parser.structure

import dev.jacaro.school.cs4308.parser.Head
import dev.jacaro.school.cs4308.parser.Parser
import dev.jacaro.school.cs4308.scanner.structure.Token
import kotlin.properties.Delegates

class Line {
    var lineNumber by Delegates.notNull<Int>()
        internal set
    lateinit var statements: Statements
        internal set

    fun accept(head: Head) : Boolean {
        when (lexeme.token) {
            Token.INTEGER -> {
                Parser.head.inc()
                statements = expectStatements()
            }

        }
    }
}

fun line(head: Head) {

}

