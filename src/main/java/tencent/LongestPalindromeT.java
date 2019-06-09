package tencent;

public class LongestPalindromeT {

    public static void main(String...args){
        LongestPalindromeT t = new LongestPalindromeT();
        String tst = t.longestPalindrome("ab");
        System.out.print(tst);
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }
        int max = 1;

        String maxString = Character.toString(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            //奇数
            int oddRight = i + 1;
            int j = i - 1;
            boolean flag = true;
            while (true) {
                if (isPalindrome(s, j, oddRight)) {
                    oddRight++;
                    j--;
                } else {
                    flag = false;
                    break;
                }
            }
            if(!flag){
                oddRight--;
                j++;
            }
            if (oddRight - j + 1 > max) {
                max = oddRight - j + 1;
                maxString = s.substring(j, oddRight + 1);
            }

            j = i - 1;
            int right = i;
            flag = true;
            while (true) {
                if (isPalindrome(s, j, right)) {
                    right++;
                    j--;
                } else {
                    flag = false;
                    break;
                }
            }
            if(!flag){
                right--;
                j++;
            }
            if (right - j + 1 > max) {
                max = right - j + 1;
                maxString = s.substring(j, right + 1);
            }

            //偶数
        }
        return maxString;
    }


    private boolean isPalindrome(String s, int start, int end) {
        if (start < 0 || end >= s.length()) {
            return false;
        }
        return s.charAt(start) == s.charAt(end);
    }
}
