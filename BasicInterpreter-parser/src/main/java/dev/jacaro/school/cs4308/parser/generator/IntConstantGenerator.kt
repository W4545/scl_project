package dev.jacaro.school.cs4308.parser.generator

import dev.jacaro.school.cs4308.scanner.structure.Token

object IntConstantGenerator: TokenGenerator<Int>(Token.INTEGER, { value.toInt() })