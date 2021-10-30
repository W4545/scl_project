package dev.jacaro.school.cs4308.parser.constants

data class IDList(val idList: Array<ID>) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as IDList

        if (!idList.contentEquals(other.idList)) return false

        return true
    }

    override fun hashCode(): Int {
        return idList.contentHashCode()
    }
}