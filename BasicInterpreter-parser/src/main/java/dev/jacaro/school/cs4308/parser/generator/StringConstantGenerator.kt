package dev.jacaro.school.cs4308.parser.generator

import dev.jacaro.school.cs4308.scanner.structure.Token

object StringConstantGenerator: TokenGenerator<String>(Token.STRING, { value })