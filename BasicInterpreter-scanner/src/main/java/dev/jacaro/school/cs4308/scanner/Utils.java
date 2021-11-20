package dev.jacaro.school.cs4308.scanner;

import dev.jacaro.school.cs4308.structure.Lexeme;
import dev.jacaro.school.cs4308.structure.Type;

import java.util.ArrayList;

/**
 * Utility class for filtering.
 */
public class Utils {

    private Utils() {}


    public static Lexeme[] filterOnType(Lexeme[] lexemes, Type ... types) {
        var filteredLexemes = new ArrayList<Lexeme>();

        for (var lexeme : lexemes) {
            for (var type : types) {
                if (lexeme.token().getType() == type) {
                    filteredLexemes.add(lexeme);
                    break;
                }
            }
        }

        return filteredLexemes.toArray(new Lexeme[0]);
    }

    public static Lexeme[] removeDuplicateTokens(Lexeme[] lexemes) {
        var filteredLexemes = new ArrayList<Lexeme>();
        filteredLexemes.add(lexemes[0]);
        for (int i = 1, lexemesLength = lexemes.length; i < lexemesLength; i++) {
            Lexeme lexeme = lexemes[i];
            var token = lexeme.token();
            boolean toAdd = true;
            for (var filteredLexeme : filteredLexemes) {
                if (filteredLexeme.token() == token) {
                    toAdd = false;
                    break;
                }
            }
            if (toAdd)
                filteredLexemes.add(lexeme);
        }

        return filteredLexemes.toArray(new Lexeme[0]);
    }

    public static Lexeme[] removeDuplicateIDs(Lexeme[] lexemes) {
        var filteredLexemes = new ArrayList<Lexeme>();
        filteredLexemes.add(lexemes[0]);
        for (int i = 1, lexemesLength = lexemes.length; i < lexemesLength; i++) {
            Lexeme lexeme = lexemes[i];
            var id = lexeme.value();
            boolean toAdd = true;
            for (var filteredLexeme : filteredLexemes) {
                if (filteredLexeme.value().equals(id)) {
                    toAdd = false;
                    break;
                }
            }
            if (toAdd)
                filteredLexemes.add(lexeme);
        }

        return filteredLexemes.toArray(new Lexeme[0]);
    }
}
