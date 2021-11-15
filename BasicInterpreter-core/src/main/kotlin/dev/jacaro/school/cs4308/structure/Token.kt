package dev.jacaro.school.cs4308.structure

import dev.jacaro.school.cs4308.expressions.Priority

enum class Token {
    REM,
    CLOSE,
    DATA,
    DIM,
    END,
    FOR,
    TO,
    STEP,
    GOTO,
    GOSUB,
    IF,
    THEN,
    INPUT,
    LET,
    NEXT,
    OPEN,
    AS,
    POKE,
    PRINT,
    READ,
    RETURN,
    RESTORE,
    RUN,
    STOP,
    SYS,
    WAIT,
    OUTPUT,
    OR,
    AND,
    NOT,
    OP_COLON("(:)", Type.OPERATOR),
    OP_POUND("(#)", Type.OPERATOR),
    OP_OPEN_PARENTHESIS("([(])", Type.OPERATOR, Priority.ONE),
    OP_CLOSE_PARENTHESIS("([)])", Type.OPERATOR, Priority.ONE),
    OP_EQUALS("(=)", Type.OPERATOR, Priority.SEVEN),
    OP_COMMA("(,)", Type.OPERATOR),
    OP_NOT_EQUAL("(<>|><)", Type.OPERATOR, Priority.SEVEN),
    OP_GREATER_THAN("(>)", Type.OPERATOR, Priority.SIX),
    OP_GREATER_OR_EQUAL_TO("(>=)", Type.OPERATOR, Priority.SIX),
    OP_LESS_THAN("(<)", Type.OPERATOR, Priority.SIX),
    OP_LESS_THAN_OR_EQUAL_TO("(<=)", Type.OPERATOR, Priority.SIX),
    OP_PLUS("(\\+)", Type.OPERATOR, Priority.FOUR),
    OP_MINUS("(-)", Type.OPERATOR, Priority.FOUR),
    OP_MULTIPLY("([*])", Type.OPERATOR, Priority.THREE),
    OP_DIVIDE("(/)", Type.OPERATOR, Priority.THREE),
    OP_POWER("(\\^)", Type.OPERATOR, Priority.TWO),
    OP_SEMICOLON("(;)", Type.OPERATOR),
    OP_NEWLINE("(\n)", Type.NEW_LINE),
    STRING("\"([^\"]*)\"", Type.STRING),
    REAL("([\\d]+\\.[\\d]+)", Type.REAL),
    INTEGER("([\\d]+)", Type.INTEGER),
    ID("([\\w]+[$%]?)", Type.ID);

    val matcher: Matcher
    val type: Type
    val priority: Priority?

    constructor(match: String, type: Type, priority: Priority? = null) {
        this.priority = priority
        matcher = RegexMatcher(this, String.format("^\\s*%s", match))
        this.type = type
    }

    constructor() {
        this.priority = null
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