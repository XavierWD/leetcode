package tencent;

public class ReverseTest {


    public static void main(String...args){
        System.out.println(Integer.MAX_VALUE);
    }

    public int reverse(int x) {
        String xs = String.valueOf(Math.abs(x));
        int result = 0;
        for (int i = xs.length() - 1; i >= 0; i--) {
            if (result > ((Integer.MAX_VALUE - (xs.charAt(i) - '0')) / 10)) {
                return 0;
            }
            result = result * 10 + (xs.charAt(i) - '0');
        }
        if (x > 0) {
            return result;
        } else {
            return -result;
        }
    }
}
