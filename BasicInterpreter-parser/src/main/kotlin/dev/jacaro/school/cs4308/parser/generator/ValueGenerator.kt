package dev.jacaro.school.cs4308.parser.generator

import dev.jacaro.school.cs4308.ids.IDManager
import dev.jacaro.school.cs4308.parser.Head
import dev.jacaro.school.cs4308.parser.structure.Generator
import dev.jacaro.school.cs4308.structure.Lexeme
import dev.jacaro.school.cs4308.structure.Token
import dev.jacaro.school.cs4308.values.*

/**
 * Generates values. Allows for control over whether IDs are allowed to be generated
 * @see Generator
 * @see Value
 * @see ID
 */
private class ValueGeneratorImpl(val allowIDs: Boolean) : Generator<Value<*>> {

    override fun generate(head: Head): Value<*>? {
        fun getAndInc(): Lexeme {
            val temp = head.current()
            head.inc()

            return temp
        }
        return when(head.current().token) {
            Token.STRING -> CString(getAndInc().value)
            Token.ID -> {
                if (allowIDs) {
                    val temp = getAndInc().value
                    IDManager.ids.getOrPut(temp) {
                        ID(temp)
                    }
                } else null
            }
            else -> {
                val int = IntConstantGenerator.generate(head)
                if (int == null) {
                    val real = RealGenerator.generate(head)
                    real
                } else
                    int
            }
        }
    }

    override val result: String
        get() = TODO("Not yet implemented")

}

/**
 * Generates values, including IDs.
 * @see ValueGeneratorImpl
 * @see Value
 * @see ID
 */
val ValueGenerator : Generator<Value<*>> = ValueGeneratorImpl(true)

/**
 * Generates RawType values
 * @see ValueGeneratorImpl
 * @see RawType
 * @see Value
 */
@Suppress("UNCHECKED_CAST") val ValueGeneratorNoIDs : Generator<RawType<*>> = ValueGeneratorImpl(false) as Generator<RawType<*>>