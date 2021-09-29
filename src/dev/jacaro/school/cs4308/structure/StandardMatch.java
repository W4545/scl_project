package dev.jacaro.school.cs4308.structure;

public class StandardMatch implements Matcher {

    private String[] matches;
    private Token token;


    public StandardMatch(Token token, String ... matches) {
        this.matches = matches;
        this.token = token;
    }

    @Override
    public Lexeme match(String possibleToken) {
        for (var match : matches) {
            if (match.equals(possibleToken))
                return new Lexeme(token, possibleToken);
        }
        return null;
    }
}
