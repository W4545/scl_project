package dev.jacaro.school.cs4308.structure

/**
 * A wrapper class that takes an [Action].
 */
data class Statement(val action: Action) : Action {
    override fun action(state: State) {
        action.action(state)
    }
}