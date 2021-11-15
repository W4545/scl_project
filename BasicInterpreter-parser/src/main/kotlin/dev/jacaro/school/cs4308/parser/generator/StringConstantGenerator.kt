package dev.jacaro.school.cs4308.parser.generator

import dev.jacaro.school.cs4308.structure.Token
import dev.jacaro.school.cs4308.values.CString

object StringConstantGenerator: TokenGenerator<CString>(Token.STRING, { CString(value) })