package dev.jacaro.school.cs4308.parser.generator

import dev.jacaro.school.cs4308.errors.ExpressionGenerationError
import dev.jacaro.school.cs4308.errors.ParsingError
import dev.jacaro.school.cs4308.expressions.DoubleToInt
import dev.jacaro.school.cs4308.expressions.Expression
import dev.jacaro.school.cs4308.parser.Head
import dev.jacaro.school.cs4308.parser.generator.expressions.ExpressionGenerator
import dev.jacaro.school.cs4308.parser.structure.Generator
import dev.jacaro.school.cs4308.structure.Lexeme
import dev.jacaro.school.cs4308.structure.Token
import dev.jacaro.school.cs4308.values.Value
import kotlin.reflect.KType
import kotlin.reflect.jvm.jvmErasure
import kotlin.reflect.typeOf

open class TokenGenerator<T>(private val token: Token, private val refBuild: Lexeme.() -> T): Generator<T> {
    override fun generate(head: Head): T? {
        val lexeme: Lexeme = head.current()
        return if (lexeme.token == token) {
            head.inc()
            lexeme.refBuild()
        } else
            null
    }

    override val result: String
        get() = token.name

}

fun expectToken(head: Head, token: Token) {
    if (!head.isToken(token))
        throw ParsingError(String.format("Failed to parse file, expected %s", token))
}

fun<T> genOrThrow(head: Head, generator: Generator<T>) : T =
    generator.generate(head) ?: throw ParsingError(String.format("Parsing Error, Expected token %s", generator.result))

@OptIn(ExperimentalStdlibApi::class)
@Suppress("UNCHECKED_CAST")
inline fun<reified T> genExpressionOrThrow(head: Head) : Expression<T> {
    val expression = ExpressionGenerator.generate(head) ?: throw ParsingError(String.format("Parsing Error."))
    println(typeOf<T>().classifier)
    if (typeOf<T>().classifier?.toString() == "class kotlin.Int") {
        if (!Expression.validate<Double>(expression))
            throw ExpressionGenerationError("Expected type ${T::class.simpleName} but received ${expression.expression::class.simpleName}")
        return Expression(DoubleToInt(expression.expression as Value<Double>)) as Expression<T>
    }
    if (!Expression.validate<T>(expression))
        throw ExpressionGenerationError("Expected type ${T::class.simpleName} but received ${expression.expression::class.simpleName}")
    return expression as Expression<T>
}

fun <T> isHeadOrNull(head: Head, token: Token, block: () -> T) : T? =
    if (head.isToken(token))  {
        head.inc()
        block()
    } else null