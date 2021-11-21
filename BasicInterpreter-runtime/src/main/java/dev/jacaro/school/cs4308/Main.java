package dev.jacaro.school.cs4308;

import dev.jacaro.school.cs4308.java.errors.FileReadError;
import dev.jacaro.school.cs4308.parser.Parser;
import dev.jacaro.school.cs4308.kotlin.structure.Line;
import dev.jacaro.school.cs4308.scanner.SourceFile;
import dev.jacaro.school.cs4308.scanner.SourceScanner;
import dev.jacaro.school.cs4308.kotlin.structure.Token;
import dev.jacaro.school.cs4308.executor.Executor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main entry point for program.
 */
public class Main {

    private static String loadFile(File file) throws FileReadError {

        try {
            return new Scanner(file).useDelimiter("\\Z").next();
        } catch (IOException e) {
            throw new FileReadError(file.getAbsolutePath(), e);
        }
    }

    public static void main(String[] args) {

        boolean debugScanner = false, debugParser = false, debugExecutor = false;

        var names = new ArrayList<String>();
        var data = new ArrayList<String>();


        for (var arg : args) {
            switch (arg) {
                case "--debug-scanner" -> {
                    debugScanner = true;
                    continue;
                }
                case "--debug-parser" -> {
                    debugParser = true;
                    continue;
                }
                case "--debug-executor" -> {
                    debugExecutor = true;
                    continue;
                }
            }
            // Load files
            var file = new File(arg);
            if (file.exists()) {
                try {
                    names.add(file.getName());
                    data.add(loadFile(file));
                } catch (FileReadError fileReadError) {
                    System.err.println(fileReadError.getMessage());
                    return;
                }
            } else {
                System.err.printf("Cannot find the file \"%s\"%n", arg);
                return;
            }
        }

        if (names.size() == 0) {
            System.err.println("Error, please provide a source file.");
            return;
        }

        // Run Scanner
        var sourceFiles = new ArrayList<SourceFile>();

        for (int i = 0; i < names.size(); i++) {
            var lexemes = SourceScanner.scan(data.get(i), Token.getAllMatchers());
            sourceFiles.add(new SourceFile(names.get(i), data.get(i), lexemes));
        }

        if (debugScanner) {
            for (var sourceFile : sourceFiles) {
                DebugOutputs.debugScanner(sourceFile);
            }
        }

        // Run Parser

        var parserOutputs = new ArrayList<Line[]>();

        for (var sourceFile : sourceFiles) {
            parserOutputs.add(Parser.INSTANCE.parse(sourceFile.lexemes()));
        }

        if (debugParser) {
            for (var parserOutput : parserOutputs) {
                DebugOutputs.debugParser(parserOutput);
            }
        }

        for (var lines : parserOutputs) {
            Executor.INSTANCE.execute(lines);
        }
    }
}
