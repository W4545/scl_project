package dev.jacaro.school.cs4308.kotlin.structure

import dev.jacaro.school.cs4308.java.structure.Matcher
import dev.jacaro.school.cs4308.java.structure.RegexMatcher
import dev.jacaro.school.cs4308.java.structure.Type

/**
 * Enum class that tracts all the tokens that are allowed inside source files.
 */
enum class Token {
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
    OP_COLON("(:)", Type.OPERATOR),
    OP_OPEN_PARENTHESIS("([(])", Type.OPERATOR),
    OP_CLOSE_PARENTHESIS("([)])", Type.OPERATOR),
    OP_EQUALS("(=)", Type.OPERATOR),
    OP_COMMA("(,)", Type.OPERATOR),
    OP_NOT_EQUAL("(<>|><)", Type.OPERATOR),
    OP_GREATER_THAN("(>)", Type.OPERATOR),
    OP_GREATER_OR_EQUAL_TO("(>=)", Type.OPERATOR),
    OP_LESS_THAN("(<)", Type.OPERATOR),
    OP_LESS_THAN_OR_EQUAL_TO("(<=)", Type.OPERATOR),
    OP_PLUS("(\\+)", Type.OPERATOR),
    OP_MINUS("(-)", Type.OPERATOR),
    OP_MULTIPLY("([*])", Type.OPERATOR),
    OP_DIVIDE("(/)", Type.OPERATOR),
    OP_POWER("(\\^)", Type.OPERATOR),
    OP_SEMICOLON("(;)", Type.OPERATOR),
    OP_NEWLINE("(\n)", Type.NEW_LINE),
    OP_UNARY_PLUS,
    OP_UNARY_MINUS,
    STRING("\"([^\"]*)\"", Type.STRING),
    REAL("([\\d]+\\.[\\d]+)", Type.REAL),
    INTEGER("([\\d]+)", Type.INTEGER),
    ID("([\\w]+[$%]?)", Type.ID);

    val matcher: Matcher
    val type: Type

    constructor(match: String, type: Type) {
        matcher = RegexMatcher(
            this,
            String.format("^\\s*%s", match)
        )
        this.type = type
    }

    constructor() {
        val regex = String.format("^\\s*(%s)", name)
        matcher = RegexMatcher(this, regex)
        type = Type.KEYWORD
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