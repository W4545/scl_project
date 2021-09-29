package dev.jacaro.school.cs4308;

import dev.jacaro.school.cs4308.errors.FileReadError;
import dev.jacaro.school.cs4308.scanner.SourceFile;
import dev.jacaro.school.cs4308.scanner.SourceScanner;
import dev.jacaro.school.cs4308.structure.Lexeme;
import dev.jacaro.school.cs4308.structure.Token;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static String loadFile(File file) throws FileReadError {

        try {
            return new Scanner(file).useDelimiter("\\Z").next();
        } catch (IOException e) {
            throw new FileReadError(file.getAbsolutePath(), e);
        }
    }

    public static void printFile(Lexeme[] array) {
        for (Lexeme value : array) {

            switch (value.token()) {
                case OP_NEWLINE -> System.out.println();
                case INTEGER -> System.out.printf("INTEGER=%s ", value.value());
                case REAL -> System.out.printf("REAL=%s ", value.value());
                case STRING -> System.out.printf("STR=\"%s\" ", value.value());
                case ID -> System.out.printf("ID=%s ", value.value());
                default -> System.out.printf("%s ", value.token().name());
            }
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

        var lexemes = SourceScanner.scan(sourceFiles.get(0).file(), Token.getAllMatchers());

        printFile(lexemes);
    }
}
