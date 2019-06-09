package parser;

import org.apache.commons.lang3.StringUtils;
import parser.token.Token;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.Collectors;

/**
 * Created by 王亚运 on 2018/5/5.
 * 表达式解析器
 */
public class ExpressionParser {
    private static TokenParserChain parserChain;
    private static final String SPACE_REPLACE = "|||";
    private static final Character QUTATION = '\'';

    static {
        LeafTokenParser leafTokenParser = new LeafTokenParser(parserChain);
        RelationTokenParser relationTokenParser = new RelationTokenParser(leafTokenParser);
        parserChain = relationTokenParser;
    }

    public List<Token> parse(String expression) {
        List<Token> tokens = new ArrayList<>();
        List<String> subStrings = split(expression);
        Token token = null;
        for (String subString : subStrings) {
            token = parserChain.parse(subString);
            tokens.add(token);
        }
        return tokens;
    }

    private List<String> split(String expression) {
        List<String> result = new ArrayList<>();
        if (StringUtils.isBlank(expression)) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        int position = 0;
        boolean inQuota = false;
        while (position < expression.length()) {
            if (expression.charAt(position) == QUTATION && !inQuota) {
                int end = expression.indexOf(QUTATION, position + 1);
                String subString = expression.substring(position, end + 1);
                subString = subString.replace(" ", SPACE_REPLACE);
                sb.append(subString);
                position = end;
            } else {
                sb.append(expression.charAt(position));
            }
            position++;
        }
        result.addAll(Arrays.stream(sb.toString().split(StringUtils.SPACE)).collect(Collectors.toList()));
        return result;
    }

    /**
     * 转波兰式
     *
     * @param tokens
     * @return
     */
    public List<Token> convertToPolishNotation(List<Token> tokens) {
        Queue<Token> tokenQueue = new LinkedBlockingDeque<>();
        Iterator<Token> iterator = tokens.iterator();
        Stack<Token> operators = new Stack<>();
        while (iterator.hasNext()) {
            Token token = iterator.next();
            switch (token.getTokenType()) {
                case Numeric:
                case String:
                    tokenQueue.offer(token);
                    break;
                default:
                    break;
            }
        }
        while (!operators.empty())
            tokenQueue.offer(operators.pop());
        List<Token> polishNotation = new ArrayList<>(tokenQueue);
        return polishNotation;
    }


    /**
     * 替换操作符
     *
     * @param expression
     * @return
     */
    private String replateOperators(String expression) {
        expression = expression.replaceAll("&&", "&");
        expression = expression.replaceAll(">=", " ge ");
        expression = expression.replaceAll("<=", "le");
        expression = expression.replaceAll("==", "eq");
        expression = expression.replaceAll("\\|\\|", "|");
        return expression;
    }
}
