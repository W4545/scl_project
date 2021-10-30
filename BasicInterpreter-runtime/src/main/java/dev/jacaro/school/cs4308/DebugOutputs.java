package dev.jacaro.school.cs4308;

import dev.jacaro.school.cs4308.parser.structure.Line;
import dev.jacaro.school.cs4308.scanner.SourceFile;
import dev.jacaro.school.cs4308.scanner.Utils;
import dev.jacaro.school.cs4308.scanner.structure.Lexeme;
import dev.jacaro.school.cs4308.structure.Type;

public class DebugOutputs {

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
        System.out.println();
    }

    private static void printArr(String name, Lexeme[] array) {
        System.out.printf("%s: [%n", name);
        for (int i = 0; i < array.length; i++) {
            if (i + 1 != array.length)
                System.out.printf("\t%s%n", array[i]);
            else
                System.out.printf("\t%s%n]%n", array[i]);
        }
    }

    public static void debugScanner(SourceFile sourceFile) {
        printFile(sourceFile.lexemes());

        var keywords = Utils.removeDuplicateTokens(Utils.filterOnType(sourceFile.lexemes(), Type.KEYWORD));
        var IDs = Utils.removeDuplicateIDs(Utils.filterOnType(sourceFile.lexemes(), Type.ID));
        var operators = Utils.removeDuplicateTokens(Utils.filterOnType(sourceFile.lexemes(), Type.OPERATOR));
        var values = Utils.filterOnType(sourceFile.lexemes(), Type.REAL, Type.INTEGER, Type.STRING);

        printArr("Keywords", keywords);
        printArr("IDs", IDs);
        printArr("Operators", operators);
        printArr("Constants", values);
    }

    public static void debugParser(Line[] lines) {
        for (var line : lines) {
            System.out.println(line);
        }
    }
}
