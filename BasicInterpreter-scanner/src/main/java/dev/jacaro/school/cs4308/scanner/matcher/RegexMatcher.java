package dev.jacaro.school.cs4308.scanner.matcher;

import dev.jacaro.school.cs4308.java.structure.Lexeme;
import dev.jacaro.school.cs4308.scanner.MatcherTokens;

import java.util.regex.Pattern;

/**
 * A matcher that uses Regular expressions to generate Lexemes.
 */
public class RegexMatcher implements Matcher {

    private final Pattern pattern;
    private final MatcherTokens matcherToken;
    private final String regexExpression;

    public RegexMatcher(MatcherTokens matcherToken, String regex) {
        this.matcherToken = matcherToken;
        this.regexExpression = regex;
        pattern = Pattern.compile(regex);
    }

    @Override
    public Lexeme match(String file, int startOffset) {
        var matcher = pattern.matcher(file).region(startOffset, file.length());

        if (matcher.find()) {
            var value = matcher.group(1);
            return new Lexeme(
                    matcherToken.getToken(),
                    matcherToken.ordinal(),
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
