package dev.jacaro.school.cs4308.parser.structure

import dev.jacaro.school.cs4308.parser.Head

interface Rule {

    fun accept(head: Head): Boolean
}