package dev.jacaro.school.cs4308.parser

import dev.jacaro.school.cs4308.scanner.structure.Lexeme

object Parser {
    lateinit var head: Head
    private set

    fun parse(lexemes: Array<Lexeme>) {
        head = Head(lexemes)


    }
}