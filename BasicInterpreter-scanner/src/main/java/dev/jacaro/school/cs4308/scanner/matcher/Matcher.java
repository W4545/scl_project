package dev.jacaro.school.cs4308.scanner.matcher;

import dev.jacaro.school.cs4308.java.structure.Lexeme;

/**
 * Base interface of matcher paradigm used during scanning.
 */
public interface Matcher {
    Lexeme match(String file, int startRegion);
}
