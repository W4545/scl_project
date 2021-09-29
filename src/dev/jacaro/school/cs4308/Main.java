package dev.jacaro.school.cs4308;

import dev.jacaro.school.cs4308.errors.FileReadError;
import dev.jacaro.school.cs4308.scanner.SourceFile;
import dev.jacaro.school.cs4308.structure.Token;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class Main {

    private static String[] loadFile(File file) throws FileReadError {

        try {
            return Files.readAllLines(file.toPath()).toArray(new String[0]);
        } catch (IOException e) {
            throw new FileReadError(file.getAbsolutePath(), e);
        }
    }

    public static void main(String[] args) {

        var sourceFiles = new ArrayList<SourceFile>();
        for (var arg : args) {
            System.out.println(arg);
            var file = new File(arg);
            if (file.exists()) {
                try {
                    sourceFiles.add(new SourceFile(file.getName(), loadFile(file)));
                } catch (FileReadError fileReadError) {
                    System.err.println(fileReadError.getMessage());
                    return;
                }
            } else {
                System.err.printf("Cannot find the file \"%s\"%n", arg);
                return;
            }
        }

        System.out.println(sourceFiles);

        System.out.println(Token.IDENTIFIER.name());
    }
}
