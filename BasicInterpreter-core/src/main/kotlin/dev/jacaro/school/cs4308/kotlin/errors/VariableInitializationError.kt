package dev.jacaro.school.cs4308.kotlin.errors

import dev.jacaro.school.cs4308.kotlin.values.ID

/**
 * An error that is thrown while initializing an [ID]
 */
class VariableInitializationError(message: String) : RuntimeException(message)