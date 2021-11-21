package dev.jacaro.school.cs4308.java.structure;

/**
 * Base interface of matcher paradigm used during scanning.
 */
public interface Matcher {
    Lexeme match(String file, int startRegion);
}
