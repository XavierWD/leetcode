package tencent;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //排序
        for (int i = 0; i < candidates.length; i++) {
            for (int j = i + 1; j < candidates.length; j++) {
                if (candidates[i] > candidates[j]) {
                    int temp = candidates[i];
                    candidates[i] = candidates[j];
                    candidates[j] = temp;
                }
            }
        }
        root = new Node(null);
        Node last = root;
        for (int i = 0; i < candidates.length; i++) {
            last.next = new Node(candidates[i]);
        }
        return new ArrayList<>();
    }

    Node root = null;

    public Node findNext(int[] nums, Node pre, Node left, Node prePop, int nowTotal, int target) {
        if (left == null && pre == null) {
            return root.next;
        }
        if (pre == null) {
            return left;
        }
        if (prePop == null) {
            return pre;
        }
        if (prePop == pre) {
            if (nowTotal + pre.next.val <= target) {
                return pre.next;
            }
        }

        return null;
    }

    class Node {
        Integer val;
        Node next;

        public Node(Integer val) {
            this.val = val;
        }
    }
}
