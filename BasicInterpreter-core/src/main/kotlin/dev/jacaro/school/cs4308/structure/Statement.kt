package dev.jacaro.school.cs4308.structure

data class Statement(val action: Action) : Action {
    override fun action(state: State) {
        action.action(state)
    }
}