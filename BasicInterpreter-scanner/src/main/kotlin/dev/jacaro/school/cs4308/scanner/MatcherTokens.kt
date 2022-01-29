package dev.jacaro.school.cs4308.scanner

import dev.jacaro.school.cs4308.kotlin.structure.Token
import dev.jacaro.school.cs4308.scanner.matcher.Matcher
import dev.jacaro.school.cs4308.scanner.matcher.RegexMatcher

/**
 * Enum class that tracts all the tokens that are allowed inside source files.
 */
enum class MatcherTokens {
    REM,
    DATA,
    END,
    FOR,
    TO,
    STEP,
    GOTO,
    GOSUB,
    IF,
    THEN,
    LET,
    NEXT,
    PRINT,
    READ,
    RETURN,
    STOP,
    OR,
    AND,
    NOT,
    OP_COLON("(:)"),
    OP_OPEN_PARENTHESIS("([(])"),
    OP_CLOSE_PARENTHESIS("([)])"),
    OP_EQUALS("(=)"),
    OP_COMMA("(,)"),
    OP_NOT_EQUAL("(<>|><)"),
    OP_GREATER_THAN("(>)"),
    OP_GREATER_OR_EQUAL_TO("(>=)"),
    OP_LESS_THAN("(<)"),
    OP_LESS_THAN_OR_EQUAL_TO("(<=)"),
    OP_PLUS("(\\+)"),
    OP_MINUS("(-)"),
    OP_MULTIPLY("([*])"),
    OP_DIVIDE("(/)"),
    OP_POWER("(\\^)"),
    OP_SEMICOLON("(;)"),
    OP_NEWLINE("(\n)"),
    OP_UNARY_PLUS,
    OP_UNARY_MINUS,
    STRING("\"([^\"]*)\""),
    REAL("([\\d]+\\.[\\d]+)"),
    INTEGER("([\\d]+)"),
    ID("([\\w]+[$%]?)");

    val matcher: Matcher
    val token: Token

    constructor(match: String) {
        matcher = RegexMatcher(
            this,
            String.format("^\\s*%s", match)
        )
        token = Token.valueOf(this.name)
    }

    constructor() {
        val regex = String.format("^\\s*(%s)", name)
        matcher = RegexMatcher(this, regex)
        token = Token.valueOf(this.name)
    }

    companion object {
        @JvmStatic
        val allMatchers: Array<Matcher?>
            get() {
                val tokens = values()
                val matchers = arrayOfNulls<Matcher>(tokens.size)
                for (i in tokens.indices) matchers[i] = tokens[i].matcher
                return matchers
            }
    }
}