package dev.jacaro.school.cs4308.parser.generator

import dev.jacaro.school.cs4308.structure.Token

object RealGenerator : TokenGenerator<Double>(Token.REAL, { value.toDouble() })