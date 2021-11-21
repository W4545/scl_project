package dev.jacaro.school.cs4308.parser.generator

import dev.jacaro.school.cs4308.kotlin.structure.Token
import dev.jacaro.school.cs4308.kotlin.values.CString

/**
 * Generates a string constant
 * @see TokenGenerator
 * @see CString
 */
object StringConstantGenerator: TokenGenerator<CString>(Token.STRING, { CString(value) })