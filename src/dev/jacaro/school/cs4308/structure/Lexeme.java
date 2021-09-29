package dev.jacaro.school.cs4308.structure;

import java.util.Objects;

public record Lexeme(Token token, int code, String value, int startMatch, int endMatch) {

}
