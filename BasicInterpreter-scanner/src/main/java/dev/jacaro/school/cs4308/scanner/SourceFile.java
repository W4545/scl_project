package dev.jacaro.school.cs4308.scanner;

import dev.jacaro.school.cs4308.scanner.structure.Lexeme;

public record SourceFile(String fileName, String file, Lexeme[] lexemes) {
}
