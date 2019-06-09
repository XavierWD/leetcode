package tencent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 */
public class Permute {

    public static void main(String... args) {
        Permute permute = new Permute();
        permute.permute(new int[]{});
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> source = new ArrayList<>();
        for (Integer i : nums) {
            source.add(i);
        }
        in(new ArrayList<>(), source, result);
        return result;
    }

    public void in(List<Integer> source, List<Integer> datas, List<List<Integer>> result) {
        if (datas.size() == 0) {
            source.stream().forEach(s -> System.out.print(s + ","));
            System.out.println();
            result.add(new ArrayList<>(source));
            return;
        }
        for (int i = 0; i < datas.size(); i++) {
            Integer popData = datas.remove(0);
            source.add(popData);
            in(source, datas, result);
            source.remove(source.size() - 1);
            datas.add(popData);
        }
    }

}
