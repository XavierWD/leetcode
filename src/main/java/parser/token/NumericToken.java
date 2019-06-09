package parser.token;


public class NumericToken extends LeafToken<Float> {
    public NumericToken(String token) {
        super(token);
    }

    @Override
    public Float getValue() {
        return Float.valueOf(token);
    }

    @Override
    public TokenType getTokenType() {
        return TokenType.Numeric;
    }
}
