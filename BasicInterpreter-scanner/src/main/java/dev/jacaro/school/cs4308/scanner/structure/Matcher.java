package dev.jacaro.school.cs4308.scanner.structure;

public interface Matcher {
    Lexeme match(String file, int startRegion);
}
