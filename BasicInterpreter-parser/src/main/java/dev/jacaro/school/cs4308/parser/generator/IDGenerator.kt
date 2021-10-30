package dev.jacaro.school.cs4308.parser.generator

import dev.jacaro.school.cs4308.parser.constants.ID
import dev.jacaro.school.cs4308.scanner.structure.Token

object IDGenerator : TokenGenerator<ID>(Token.ID, {
    ID(value)
})