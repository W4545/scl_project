package dev.jacaro.school.cs4308.kotlin.structure

/**
 * A base interface for all commands to implement.
 * @see State
 */
interface Action {
    fun action(state: State)
}