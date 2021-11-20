package dev.jacaro.school.cs4308.errors

import dev.jacaro.school.cs4308.values.ID

/**
 * An error that is thrown while initializing an [ID]
 */
class VariableInitializationError(message: String) : RuntimeException(message)