package dev.jacaro.school.cs4308.structure;

import java.util.regex.Pattern;

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
    public Lexeme match(String possibleMatch) {
        var matcher = pattern.matcher(possibleMatch);
        if (matcher.matches())
            return new Lexeme(token, possibleMatch);
        else
            return null;
    }

    public String getRegexExpression() {
        return regexExpression;
    }
}
