package parser;


import parser.token.RelationOperatorToken;
import parser.token.Token;
import parser.token.TokenType;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;


public class RelationTokenParser extends TokenParserChain {
    private static final TokenType[] operators = {TokenType.Equal, TokenType.NotEqual, TokenType.GT, TokenType.LT, TokenType.GTOrEqual, TokenType.LTOrEqual};

    private TokenType tokenType;

    public RelationTokenParser(TokenParserChain parserChain) {
        super(parserChain);
    }

    @Override
    protected boolean isToken(String tokenStr) {
        Optional<TokenType> any = Stream.of(operators)
                .filter(type -> Arrays.asList(type.getTokens()).contains(tokenStr.toLowerCase()))
                .findAny();
        tokenType = any.orElse(null);
        return any.isPresent();
    }

    @Override
    protected Token createToken(String tokenStr) {
        return new RelationOperatorToken(tokenType, tokenStr);
    }
}
