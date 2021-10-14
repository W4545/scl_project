package dev.jacaro.school.cs4308.errors;

public class FileReadError extends Exception {
    public FileReadError(String file, Throwable cause) {
        super(String.format("An error occured while loading the file %s", file), cause);
    }
}
