package dev.jacaro.school.cs4308.structure;

/**
 * A data class storing data related to lexical tokens in a file.
 */
public record Lexeme(Token token, int code, String value, int startMatch, int endMatch) {

}
