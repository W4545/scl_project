package dev.jacaro.school.cs4308.parser.structure

import dev.jacaro.school.cs4308.parser.Head

interface Generator<T> {

    abstract fun generate(head: Head): T?
}