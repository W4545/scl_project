package dev.jacaro.school.cs4308.parser.generator

import dev.jacaro.school.cs4308.structure.Token
import dev.jacaro.school.cs4308.values.Real

object RealGenerator : TokenGenerator<Real>(Token.REAL, { Real(value.toDouble()) })