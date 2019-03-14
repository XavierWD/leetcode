package test;

import java.util.*;

/**
 * Created by weixiaolong on 2019/1/16.
 */
public class TS {

    public static void main(String... args) {

        List<String> s = new ArrayList<>();
        s.add("A");
        s.add("B");
        s.add("C");
        s.add("D");
        in(new ArrayList<>(), s);
//        for (String ss : allString) {
//            System.out.println(ss);
//        }
    }

    private static Set<String> allString = new HashSet<>();

    public static void in(List<String> s, List<String> y) {
        if (y.size() == 0) {
            allString.add(String.join("", s));
            System.out.println(String.join("", s));
            return;
        }
        for (int i = 0; i < y.size(); i++) {
            String first = y.remove(0);
            s.add(first);
            in(s, y);
            String last = s.remove(s.size() - 1);
            y.add(last);
        }
    }

    public static void iter(List<String> source) {
        Stack<String> stack = new Stack<>();
        List<String> result = new ArrayList<>();
        List<String> target = new ArrayList<>();
//        for (int i = 0; i < source.size(); i++) {
//            source.
//        }
        int length = source.size();
        List<String> cur = new ArrayList<>(source);
        while (target.size() != length) {
            String now = cur.remove(0);
            target.add(now);
        }
    }
}
