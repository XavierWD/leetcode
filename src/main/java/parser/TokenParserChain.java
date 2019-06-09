package parser;

import parser.token.Token;

public abstract class TokenParserChain {
    protected TokenParserChain parserChain;

    public TokenParserChain(TokenParserChain parserChain) {
        this.parserChain = parserChain;
    }

    public Token parse(String tokenStr) {
        if (isToken(tokenStr)) {
            return createToken(tokenStr);
        } else {
            return parserChain.parse(tokenStr);
        }
//        Token token = parserChain.parse(tokenStr);
//        if (token == null) {
//            return this.parserChain.parse(tokenStr);
//        }
//        return token;
    }

    protected abstract boolean isToken(String tokenStr);

    protected abstract Token createToken(String tokenStr);
}
