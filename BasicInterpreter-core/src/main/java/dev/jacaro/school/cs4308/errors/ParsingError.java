package dev.jacaro.school.cs4308.errors;

/**
 * An error generated while parsing.
 */
public class ParsingError extends RuntimeException {
    public ParsingError(String message, Throwable cause) {
        super(String.format("An error occurred while loading the file %s", message), cause);
    }

    public ParsingError(String message) {
        super(String.format("An error occurred while loading the file %s", message));
    }
}
