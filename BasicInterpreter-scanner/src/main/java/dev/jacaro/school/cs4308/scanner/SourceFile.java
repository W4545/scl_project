package dev.jacaro.school.cs4308.scanner;

import dev.jacaro.school.cs4308.java.structure.Lexeme;

/**
 * Data class for sourcefiles. Holds the fileName and lexical format of file.
 */
public record SourceFile(String fileName, String file, Lexeme[] lexemes) {
}
