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
    OP_COLON("(:)", Type.OPERATOR),
    OP_POUND("(#)", Type.OPERATOR),
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

    STRING("\"([^\"]*)\"", Type.STRING),
    REAL("([\\d]+\\.[\\d]+)", Type.REAL),
    INTEGER("([\\d]+)", Type.INTEGER),
    ID("([\\w]+[$%]?)", Type.ID);

    private final Matcher matcher;
    private final Type type;

    Token(String match, Type type) {
        matcher = new RegexMatcher(this, String.format("^\\s*%s", match));
        this.type = type;
    }

    Token() {
        String regex = String.format("^\\s*(%s)", this.name());
        matcher = new RegexMatcher(this, regex);
        type = Type.KEYWORD;
    }

    public Matcher getMatcher() {
        return matcher;
    }

    public Type getType() {
        return type;
    }

    public static Matcher[] getAllMatchers() {
        var tokens = values();
        Matcher[] matchers = new Matcher[tokens.length];

        for (int i = 0; i < tokens.length; i++)
            matchers[i] = tokens[i].getMatcher();

        return matchers;
    }
}
