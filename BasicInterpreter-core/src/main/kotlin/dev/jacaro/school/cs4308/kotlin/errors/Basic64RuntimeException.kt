package dev.jacaro.school.cs4308.kotlin.errors

import dev.jacaro.school.cs4308.kotlin.structure.Action
import dev.jacaro.school.cs4308.kotlin.structure.Line

class Basic64RuntimeException(val line: Line, val command: Action, cause: Throwable?)
    : RuntimeException("An error occurred on line ${line.lineNumber.raw} with command ${command}.", cause) {
}