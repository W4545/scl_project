
package dev.jacaro.school.cs4308.structure;

import java.util.Arrays;

public enum Token {
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
    OP_COLON("(:)"),
    OP_POUND("(#)"),
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

    STRING("\"([^\"]*)\""),
    REAL("([\\d]+\\.[\\d]+)"),
    INTEGER("([\\d]+)"),
    ID("([\\w]+[$%]?)");

    private final Matcher matcher;

    Token(String match) {
        matcher = new RegexMatcher(this, String.format("^\\s*%s", match));
    }

    Token() {
        String regex = String.format("^\\s*(%s)", this.name());
        matcher = new RegexMatcher(this, regex);
    }

    public Matcher getMatcher() {
        return matcher;
    }

    public static Matcher[] getAllMatchers() {
        var tokens = values();
        Matcher[] matchers = new Matcher[tokens.length];

        for (int i = 0; i < tokens.length; i++)
            matchers[i] = tokens[i].getMatcher();

        return matchers;
    }
}
