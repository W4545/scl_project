package dev.jacaro.school.cs4308.parser.generator

import dev.jacaro.school.cs4308.structure.Token
import dev.jacaro.school.cs4308.values.Integer

object IntConstantGenerator: TokenGenerator<Integer>(Token.INTEGER, { Integer(value.toInt()) })