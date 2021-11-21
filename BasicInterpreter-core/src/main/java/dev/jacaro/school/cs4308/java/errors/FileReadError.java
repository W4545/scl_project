package dev.jacaro.school.cs4308.java.errors;

/**
 * An error produced while reading a file.
 */
public class FileReadError extends Exception {
    public FileReadError(String file, Throwable cause) {
        super(String.format("An error occurred while loading the file %s", file), cause);
    }
}
