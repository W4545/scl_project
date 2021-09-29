package dev.jacaro.school.cs4308.structure;

import java.util.Objects;

public final class Lexeme {

    private final Token token;
    private final int code;
    private final String value;

    public Lexeme(Token token, String value) {
        this.token = token;
        this.value = value;
        this.code = token.ordinal();
    }

    public Lexeme(Token token, String value, int code) {
        this.token = token;
        this.value = value;
        this.code = code;
    }

    public Token getToken() {
        return token;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lexeme lexeme = (Lexeme) o;
        return code == lexeme.code && token == lexeme.token && value.equals(lexeme.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, code, value);
    }

    @Override
    public String toString() {
        return "Lexeme{" +
                "token=" + token +
                ", code=" + code +
                ", value='" + value + '\'' +
                '}';
    }
}
