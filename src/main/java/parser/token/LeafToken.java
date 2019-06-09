package parser.token;

public abstract class LeafToken<T> extends Token {
    public LeafToken(String token) {
        super(token);
    }

    public abstract T getValue();
}
