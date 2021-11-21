package dev.jacaro.school.cs4308.java.structure;

import dev.jacaro.school.cs4308.kotlin.structure.Token;

import java.util.regex.Pattern;

/**
 * A matcher that uses Regular expressions to generate Lexemes.
 */
public class RegexMatcher implements Matcher {

    private final Pattern pattern;
    private final Token token;
    private final String regexExpression;

    public RegexMatcher(Token token, String regex) {
        this.token = token;
        this.regexExpression = regex;
        pattern = Pattern.compile(regex);
    }

    @Override
    public Lexeme match(String file, int startOffset) {
        var matcher = pattern.matcher(file).region(startOffset, file.length());

        if (matcher.find()) {
            var value = matcher.group(1);
            return new Lexeme(
                    token,
                    token.ordinal(),
                    value, startOffset,
                    matcher.end() - 1);
        }
        else
            return null;
    }

    public String getRegexExpression() {
        return regexExpression;
    }
}
