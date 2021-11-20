package dev.jacaro.school.cs4308.structure;

/**
 * Base interface of matcher paradigm used during scanning.
 */
public interface Matcher {
    Lexeme match(String file, int startRegion);
}
