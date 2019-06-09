package tencent;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class MaxLength {


    public static void main(String... args) {
        MaxLength m = new MaxLength();
        int length = m.lengthOfLongestSubstring("ancdhef");
        System.out.println(length);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        int maxLength = 0;
        int start = 0;
        for (int i = 1; i < s.length(); i++) {
            for (int j = i - 1; j >= start; j--) {
                if (s.charAt(j) == s.charAt(i)) {
                    int length = i - j;
                    if (length > maxLength) {
                        maxLength = length;
//                        System.out.println(s.substring(j, i + 1));
                    }
                    start = j + 1;
                    break;
                } else if (j == start) {
                    int length = i - j + 1;
                    if (length > maxLength) {
                        maxLength = length;
//                        System.out.println(s.substring(j, i + 1));
                    }
                    start = j;
                }
            }
        }
        return maxLength;
    }
}
