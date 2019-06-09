package parser;

public class ParseTest {

    public static void main(String... args) {

        ExpressionParser parser = new ExpressionParser();
        String query = "Name eq 'Tom Jo&da' and Age eq 9";
        parser.parse(query);

    }
}
