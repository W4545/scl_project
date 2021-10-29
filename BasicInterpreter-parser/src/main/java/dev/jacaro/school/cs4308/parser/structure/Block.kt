package dev.jacaro.school.cs4308.parser.structure

import dev.jacaro.school.cs4308.scanner.structure.Lexeme
import dev.jacaro.school.cs4308.scanner.structure.Token

class Block<T>(val sourceStructure: T) {

    fun<E> accept(lexeme: Lexeme, block: Block<E>.() -> Unit) {

    }
}