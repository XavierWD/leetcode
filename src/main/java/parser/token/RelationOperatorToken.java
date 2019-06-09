package parser.token;


public class RelationOperatorToken extends Token {
    protected TokenType tokenType;

    public RelationOperatorToken(TokenType tokenType, String token) {
        super(token);
        this.tokenType = tokenType;
    }

    @Override
    public TokenType getTokenType() {
        return tokenType;
    }
}
