package parser.token;


public enum TokenType {
    GT(5, ">", "gt"), /// > (大于)
    LT(5, "<", "lt"), /// < (小于)
    GTOrEqual(5, ">=", "ge"),/// >= (大于等于)
    LTOrEqual(5, "<=", "le"), /// <= (小于等于)
    Equal(4, "==", "eq"),// == (相等)
    NotEqual(4, "!=", "ne"),/// != 或 <> (不等于)
    And(3, "&&", "&", "and"),// && (逻辑与)
    Or(2, "|", "||", "or"), /// || (逻辑或)

    Numeric(1, null), /// 数值,
    String(1, null);

    private String[] tokens;
    private int level;

    TokenType(int level, String... tokens) {
        this.tokens = tokens;
        this.level = level;
    }

    public java.lang.String[] getTokens() {
        return tokens;
    }

    public int getLevel() {
        return level;
    }
}
