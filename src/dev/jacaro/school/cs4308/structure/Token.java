
package dev.jacaro.school.cs4308.structure;

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
    STRING("^\"[\\w\\d\\s]+\""),
    ID("^[\\w]+[$%]?"),
    REAL("^[\\d].[\\d]+"),
    INTEGER("^[\\d]+"),
    OP;

    private final Matcher matcher;

    Token(String match) {
        matcher = new RegexMatcher(this, match);
    }

    Token() {
        matcher = new RegexMatcher(this, String.format("^%s", this.name()));
    }

    public Matcher getMatcher() {
        return matcher;
    }
}
