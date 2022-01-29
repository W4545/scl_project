package dev.jacaro.school.cs4308.scanner;

import dev.jacaro.school.cs4308.java.structure.Lexeme;

import java.util.ArrayList;
import java.util.List;

/**
 * Generates Lexemes using the defined matchers.
 */
public class SourceScanner {

    private SourceScanner() {

    }

    public static Lexeme[] scan(String file) {

        List<Lexeme> lexemes = new ArrayList<>();
        boolean success = true;
        int startOffset = 0;

        outerWhile:
        while(success && startOffset < file.length()) {
            for (var matcher : MatcherTokens.getAllMatchers()) {
                Lexeme lexeme = matcher.match(file, startOffset);
                if (lexeme != null) {
                    lexemes.add(lexeme);
                    success = true;
                    startOffset = lexeme.endMatch() + 1;
                    continue outerWhile;
                } else
                    success = false;
            }
        }

        return lexemes.toArray(new Lexeme[0]);
    }
}
