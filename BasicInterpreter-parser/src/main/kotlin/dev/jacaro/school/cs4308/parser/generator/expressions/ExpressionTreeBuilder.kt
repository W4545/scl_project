package dev.jacaro.school.cs4308.parser.generator.expressions

import dev.jacaro.school.cs4308.parser.generator.expressions.builderextensions.*
import dev.jacaro.school.cs4308.values.Value
import java.util.ArrayDeque

object ExpressionTreeBuilder {
    private val builderExtensions = arrayOf(
        StandardNumberOperationBuilderExtension,
        ComparisonOperatorBuilderExtension,
        AndOrBuilderExtension,
        UnaryNumberBuilderExtension,
        NotBuilderExtension,
        NotEqualBuilderExtension,
        EqualBuildExtension,
        StandardNumberBuilderExtension
    )

    fun buildTree(postFix: Array<ExpressionWrap<*>>) : Value<*> {

        if (postFix.size == 1)
            return postFix.first().value as Value<*>

        val deque = ArrayDeque<Value<*>>()

        for (current in postFix) {
            for (extension in builderExtensions) {
                if (extension.accept(current)) {
                    extension.action(current, deque)
                    break
                }
            }
        }

        assert(deque.size == 1)

        return deque.pop()
    }

}