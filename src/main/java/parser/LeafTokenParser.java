package parser;


import org.apache.commons.lang3.StringUtils;
import parser.token.NumericToken;
import parser.token.StringToken;
import parser.token.Token;

public class LeafTokenParser extends TokenParserChain {

    public LeafTokenParser(TokenParserChain parserChain) {
        super(parserChain);
    }

    @Override
    protected boolean isToken(String tokenStr) {
        return true;
    }

    @Override
    protected Token createToken(String tokenStr) {
        if (StringUtils.isNumeric(tokenStr)) {
            return new NumericToken(tokenStr);
        }
        return new StringToken(tokenStr);
    }
}
