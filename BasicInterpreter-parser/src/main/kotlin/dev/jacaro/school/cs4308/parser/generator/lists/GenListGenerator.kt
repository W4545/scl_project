package dev.jacaro.school.cs4308.parser.generator.lists

import dev.jacaro.school.cs4308.kotlin.constants.ConstantList
import dev.jacaro.school.cs4308.kotlin.constants.IDList
import dev.jacaro.school.cs4308.parser.Head
import dev.jacaro.school.cs4308.kotlin.constants.PrintList
import dev.jacaro.school.cs4308.kotlin.constants.ValueList
import dev.jacaro.school.cs4308.kotlin.expressions.ExpressionList
import dev.jacaro.school.cs4308.parser.generator.IDGenerator
import dev.jacaro.school.cs4308.parser.generator.expressions.ExpressionGenerator
import dev.jacaro.school.cs4308.parser.generator.ValueGenerator
import dev.jacaro.school.cs4308.parser.generator.ValueGeneratorNoIDs
import dev.jacaro.school.cs4308.parser.generator.structures.ActionGenerator
import dev.jacaro.school.cs4308.parser.structure.Generator
import dev.jacaro.school.cs4308.kotlin.structure.Token

/**
 * Generates a List using the provided generator and list delimiter. Uses the anonymous function [refBuild] to build
 * individual types.
 */
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

        if (head.previous.token == Token.OP_COMMA)
            head.dec()

        return refBuild(expressionList.toList())
    }

    override val result: String
        get() = "List of ${generator.result}"
}

/**
 * Generates a list of Expressions
 * @see GenListGenerator
 * @see ExpressionGenerator
 */
val ExpressionListGenerator = GenListGenerator(ExpressionGenerator) {
    ExpressionList(it.toTypedArray())
}

/**
 * Generates a list of values
 * @see GenListGenerator
 * @see ValueGenerator
 */
val ValueListGenerator = GenListGenerator(ValueGenerator) {
    ValueList(it.toTypedArray())
}

/**
 * Generates a list of printable values
 * @see GenListGenerator
 * @see ExpressionGenerator
 */
val PrintListGenerator = GenListGenerator(ExpressionGenerator, Token.OP_SEMICOLON) {
    PrintList(it.toTypedArray())
}

/**
 * Generates a list of statements
 * @see GenListGenerator
 * @see ActionsGenerator
 */
val ActionsGenerator = GenListGenerator(ActionGenerator, Token.OP_COLON) {
    it.toTypedArray()
}

/**
 * Generates a list of constants
 * @see GenListGenerator
 * @see ValueGeneratorNoIDs
 */
val ConstantListGenerator = GenListGenerator(ValueGeneratorNoIDs) {
    ConstantList(it.toTypedArray())
}

/**
 * Generates a list of IDs
 * @see GenListGenerator
 * @see IDGenerator
 */
val IDListGenerator = GenListGenerator(IDGenerator) {
    IDList(it.toTypedArray())
}