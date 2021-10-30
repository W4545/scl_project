package dev.jacaro.school.cs4308.parser.structure

import dev.jacaro.school.cs4308.parser.Head

interface Generator<out T> {

    fun generate(head: Head): T?

    val result: String
}