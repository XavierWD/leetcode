package parser.token;

public class StringToken extends LeafToken<String> {
    public StringToken(String token) {
        super(token);
    }

    @Override
    public String getValue() {
        return token;
    }

    @Override
    public TokenType getTokenType() {
        return TokenType.String;
    }
}
