package dev.jacaro.school.cs4308.java.structure;

import dev.jacaro.school.cs4308.kotlin.structure.Token;

/**
 * A data class storing data related to lexical tokens in a file.
 */
public record Lexeme(Token token, int code, String value, int startMatch, int endMatch) {

}
