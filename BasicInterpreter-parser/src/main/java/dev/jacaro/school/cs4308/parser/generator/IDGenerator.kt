package dev.jacaro.school.cs4308.parser.generator

import dev.jacaro.school.cs4308.values.ID
import dev.jacaro.school.cs4308.structure.Token

object IDGenerator : TokenGenerator<ID>(Token.ID, {
    ID(value)
})