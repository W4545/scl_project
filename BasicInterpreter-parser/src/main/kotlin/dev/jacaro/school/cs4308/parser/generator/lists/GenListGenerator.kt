package dev.jacaro.school.cs4308.parser.generator.lists

import dev.jacaro.school.cs4308.constants.ConstantList
import dev.jacaro.school.cs4308.parser.Head
import dev.jacaro.school.cs4308.constants.PrintList
import dev.jacaro.school.cs4308.constants.ValueList
import dev.jacaro.school.cs4308.expressions.ExpressionList
import dev.jacaro.school.cs4308.parser.generator.expressions.ExpressionGenerator
import dev.jacaro.school.cs4308.parser.generator.ValueGenerator
import dev.jacaro.school.cs4308.parser.generator.ValueGeneratorNoIDs
import dev.jacaro.school.cs4308.parser.generator.structures.StatementGenerator
import dev.jacaro.school.cs4308.parser.structure.Generator
import dev.jacaro.school.cs4308.structure.Token

class GenListGenerator<T, E> internal constructor(
    private val generator: Generator<T>,
    private val delimiter: Token = Token.OP_COMMA,
    private val refBuild : (List<T>) -> E)
    : Generator<E> {

    override fun generate(head: Head): E? {
        val obj = generator.generate(head) ?: return null
        val expressionList = mutableListOf<T>()
        expressionList.add(obj)
        if (!head.isToken(delimiter))
            return refBuild(expressionList.toList())
        head.inc()
        var temp = generator.generate(head)
        while (temp != null) {
            expressionList.add(temp)
            if (head.isToken(delimiter))
                head.inc()
            else
                break
            temp = generator.generate(head)
        }

        return refBuild(expressionList.toList())
    }

    override val result: String
        get() = "List of ${generator.result}"
}

val ExpressionListGenerator = GenListGenerator(ExpressionGenerator) {
    ExpressionList(it.toTypedArray())
}

val ValueListGenerator = GenListGenerator(ValueGenerator) {
    ValueList(it.toTypedArray())
}

val PrintListGenerator = GenListGenerator(ExpressionGenerator, Token.OP_SEMICOLON) {
    PrintList(it.toTypedArray())
}

val StatementsGenerator = GenListGenerator(StatementGenerator, Token.OP_COLON) {
    it.toTypedArray()
}

val ConstantListGenerator = GenListGenerator(ValueGeneratorNoIDs) {
    ConstantList(it.toTypedArray())
}