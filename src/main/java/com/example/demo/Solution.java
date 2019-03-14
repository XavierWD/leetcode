package com.example.demo;

import java.util.*;

/**
 * Created by weixiaolong on 2019/1/1.
 */
public class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> roots = new ArrayList<>();
        if (root != null) {
            roots.add(root);
            List<Integer> vals = new ArrayList<>();
            vals.add(root.val);
            result.add(vals);
        }
        while (roots.size() > 0) {
            List<TreeNode> tmpRoots = level(roots);
            if (tmpRoots.size() > 0) {
                List<Integer> vals = new ArrayList<>();
                for (TreeNode treeNode : tmpRoots) {
                    vals.add(treeNode.val);
                }
                result.add(0, vals);
            } else {
                break;
            }
            roots = tmpRoots;
        }
        return result;
    }

    public List<TreeNode> level(List<TreeNode> roots) {
        List<TreeNode> treeNodes = new ArrayList<>();
        for (TreeNode treeNode : roots) {
            if (treeNode.left != null) {
                treeNodes.add(treeNode.left);
            }
            if (treeNode.right != null) {
                treeNodes.add(treeNode.right);
            }
        }
        return treeNodes;
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> roots = new ArrayList<>();
        if (root != null) {
            roots.add(root);
            List<Integer> vals = new ArrayList<>();
            vals.add(root.val);
            result.add(vals);
        }
        int depth = 1;
        while (roots.size() > 0) {
            List<TreeNode> tmpRoots = level(roots);
            if (tmpRoots.size() > 0) {
                List<Integer> vals = new ArrayList<>();
                for (TreeNode treeNode : tmpRoots) {
                    if (depth % 2 == 0) {
                        vals.add(treeNode.val);
                    } else {
                        vals.add(0, treeNode.val);
                    }
                }
                result.add(vals);
            } else {
                break;
            }
            depth++;
            roots = tmpRoots;
        }
        return result;
    }


    public List<TreeNode> level(List<TreeNode> roots, int flag) {
        List<TreeNode> treeNodes = new ArrayList<>();
        for (TreeNode treeNode : roots) {
            if (treeNode.left != null) {
                if (flag == 0) {
                    treeNodes.add(treeNode.left);
                } else {
                    treeNodes.add(0, treeNode.left);
                }
            }
            if (treeNode.right != null) {
                if (flag == 0) {
                    treeNodes.add(treeNode.right);
                } else {
                    treeNodes.add(0, treeNode.right);
                }
            }
        }
        return treeNodes;
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        List<TreeNode> roots = new ArrayList<>();
        if (root != null) {
            roots.add(root);
            result.add(root.val);
        }
        while (roots.size() > 0) {
            List<TreeNode> tmpRoots = level(roots);
            if (tmpRoots.size() > 0) {
                result.add(tmpRoots.get(tmpRoots.size() - 1).val);
            } else {
                break;
            }
            roots = tmpRoots;
        }
        return result;
    }

    public void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val);
        inorder(root.right);
    }

    public void posOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        posOrder(root.left);
        posOrder(root.right);
        System.out.print(root.val);
    }


    public static void main(String... args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        Solution solution = new Solution();
        System.out.println(solution.tree2str(root));
    }

    public int findBottomLeftValue(TreeNode root) {
        List<TreeNode> roots = new ArrayList<>();
        if (root != null) {
            roots.add(root);
        }
        while (roots.size() > 0) {
            List<TreeNode> tmpRoots = level(roots);
            if (tmpRoots.size() > 0) {
            } else {
                break;
            }
            roots = tmpRoots;
        }
        return roots.get(0).val;
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        List<TreeNode> roots = new ArrayList<>();
        if (d == 1) {
            TreeNode r = new TreeNode(v);
            r.left = root;
            r.right = null;
        }
        if (root != null) {
            roots.add(root);
        }
        int depth = 2;
        while (true) {
            if (depth > d + 1) {
                break;
            }
            if (roots.size() > 0) {
                if (depth == d && roots.size() > 0) {
                    for (TreeNode treeNode : roots) {
                        if (treeNode.left != null) {
                            TreeNode leftTemp = treeNode.left;
                            treeNode.left = new TreeNode(v);
                            treeNode.left.left = leftTemp;
                        }
                        if (treeNode.right != null) {
                            TreeNode rightTemp = treeNode.right;
                            treeNode.right = new TreeNode(v);
                            treeNode.right.right = rightTemp;
                        }
                    }
                    break;
                }
                List<TreeNode> tempRoots = level(roots);
                roots = tempRoots;
            } else {
                break;
            }
            depth++;
        }
        return root;
    }

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        List<TreeLinkNode> links = new ArrayList<>();
        links.add(root);
        while (links.size() > 0) {
            if (links.size() > 1) {
                for (int i = 0; i < links.size() - 2; i++) {
                    TreeLinkNode temp = links.get(i);
                    temp.next = links.get(i + 1);
                }
            }
            List<TreeLinkNode> linkNodes = linksLevel(links);
            links = linkNodes;
        }
    }

    public List<TreeLinkNode> linksLevel(List<TreeLinkNode> roots) {
        List<TreeLinkNode> treeNodes = new ArrayList<>();
        for (TreeLinkNode treeNode : roots) {
            if (treeNode.left != null) {
                treeNodes.add(treeNode.left);
            }
            if (treeNode.right != null) {
                treeNodes.add(treeNode.right);
            }
        }
        return treeNodes;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode leftRoot = lowestCommonAncestor(root.left, p, q);
        TreeNode rightRoot = lowestCommonAncestor(root.right, p, q);
        if (leftRoot != null && rightRoot != null) {
            return root;
        } else {
            return leftRoot == null ? rightRoot : leftRoot;
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        int result = 0;
        if (root == null) {
            return result;
        }
        List<TreeNode> roots = new LinkedList<>();
        roots.add(root);
        while (roots.size() > 0) {
            TreeNode cur = roots.remove(0);
            if (cur.left != null && cur.left.left == null && cur.left.right == null) {
                result = result + cur.left.val;
            }
            if (cur.left != null) {
                roots.add(cur.left);
            }
            if (cur.right != null) {
                roots.add(cur.right);
            }

        }
        return result;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return maxBT(nums, 0, nums.length - 1);
    }

    public TreeNode maxBT(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int index = indexMax(nums, start, end);
        TreeNode max = new TreeNode(nums[index]);
        max.left = maxBT(nums, start, index - 1);
        max.right = maxBT(nums, index + 1, end);
        return max;
    }

    public int indexMax(int[] nums, int start, int end) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }

    int sum = 0;

    public int findTilt(TreeNode root) {
        rootTile(root);
        return sum;
    }

    public int rootTile(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int leftSum = rootTile(root.left);
        int rightSum = rootTile(root.right);
        sum = sum + Math.abs(leftSum - rightSum);
        return leftSum + rightSum + root.val;
    }

    Map<Integer, Integer> countMap = new HashMap<>();
    int maxCount = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        int rootSum = sum(root);
        int count = 1;
        if (!countMap.containsKey(rootSum)) {
            countMap.put(rootSum, count);
        } else {
            int leftCount = countMap.get(rootSum);
            count = leftCount + 1;
            countMap.put(rootSum, count);
        }
        if (count > maxCount) {
            maxCount = count;
        }
        List<Integer> resultList = new ArrayList<>();
        for (Integer key : countMap.keySet()) {
            if (countMap.get(key) == maxCount) {
                resultList.add(key);
            }
        }
        int[] resultInt = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultInt[i] = resultList.get(i);
        }
        return resultInt;
    }

    public Integer sum(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        Integer leftSum = sum(root.left);
        Integer rightSum = sum(root.right);
        if (leftSum != null) {
            int count = 1;
            if (!countMap.containsKey(leftSum)) {
                countMap.put(leftSum, count);
            } else {
                int leftCount = countMap.get(leftSum);
                count = leftCount + 1;
                countMap.put(leftSum, count);
            }
            if (count > maxCount) {
                maxCount = count;
            }
        }
        if (rightSum != null) {
            int count = 1;
            if (!countMap.containsKey(rightSum)) {
                countMap.put(rightSum, count);
            } else {
                int rightCount = countMap.get(rightSum);
                count = rightCount + 1;
                countMap.put(rightSum, count);
            }
            if (count > maxCount) {
                maxCount = count;
            }
        }
        return (leftSum == null ? 0 : leftSum) + (rightSum == null ? 0 : rightSum) + root.val;
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        find(0, sum, root, new ArrayList<>(), result);
        return result;
    }

    public void find(int sum, int target, TreeNode root, List<Integer> list, List<List<Integer>> result) {
        list.add(root.val);
        if (root.left == null && root.right == null && root.val + sum == target) {
            result.add(new ArrayList<>(list));
        } else {
            if (root.left != null) {
                find(sum + root.val, target, root.left, list, result);
            }
            if (root.right != null) {
                find(sum + root.val, target, root.right, list, result);
            }
        }
        list.remove(list.size() - 1);
    }

    public int pathSum2(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return subSumCount(root, sum);
    }

    public int subSumCount(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return subSumCount(root.left, sum) + subSumCount(root.right, sum) + subCount(0, root, sum);
    }

    public int subCount(int sum, TreeNode root, int target) {
        int count = 0;
        if (root == null) {
            return 0;
        }
        if (sum + root.val == target) {
            count = count + 1;
        }
        count = count + subCount(sum + root.val, root.left, target);
        count = count + subCount(sum + root.val, root.right, target);
        return count;
    }

    int maxDepth = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        diameterOfBinaryTree1(root);
        return maxDepth;
    }

    public int diameterOfBinaryTree1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = 0;
        int rightMax = 0;
        if (root.left != null) {
            leftMax = diameterOfBinaryTree1(root.left) + 1;
        }
        if (root.right != null) {
            rightMax = diameterOfBinaryTree1(root.right) + 1;
        }
        maxDepth = Math.max(leftMax + rightMax, maxDepth);
        return Math.max(leftMax, rightMax);
    }

    int maxUniDepth = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        subOperate(root);
        return maxUniDepth;
    }

    public void subOperate(TreeNode root) {
        if (root == null) {
            return;
        }
        maxUnival(root);
        subOperate(root.left);
        subOperate(root.right);
    }

    public int maxUnival(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = 0;
        int rightMax = 0;
        if (root.left != null && root.left.val == root.val) {
            leftMax = maxUnival(root.left) + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            rightMax = maxUnival(root.right) + 1;
        }
        maxUniDepth = Math.max(leftMax + rightMax, maxUniDepth);
        return Math.max(leftMax, rightMax);
    }

    public void subOp(TreeNode root) {
        if (root == null) {
            return;
        }
        int sum = subSum(root);

        subOp(root.left);
        subOp(root.right);
    }

    public int subSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int left = subSum(root.left);
        int right = subSum(root.right);
        return left + right + root.val;
    }

    int TREE_MAX_PATH_SUM = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        treeSum(root);
        return TREE_MAX_PATH_SUM;
    }


    public int treeSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = treeSum(root.left);
        int rightSum = treeSum(root.right);
        int rootSum = Math.max(0, leftSum) + Math.max(0, rightSum) + root.val;
        TREE_MAX_PATH_SUM = Math.max(rootSum, TREE_MAX_PATH_SUM);
        return Math.max(Math.max(0, leftSum), Math.max(0, rightSum)) + root.val;
    }

    public TreeNode buildPreOrderTree(int[] preorder, int[] inorder) {
        return helpBuildTree(preorder, inorder, 0, inorder.length - 1, 0);
    }

    public TreeNode helpBuildTree(int[] preorder, int[] inorder, int inOrderStart, int inOrderEnd, int preStart) {
        if (inOrderStart > inOrderEnd) {
            return null;
        }
        if (preStart >= preorder.length) {
            return null;
        }
        int first = preorder[preStart];
        int index = findIndex(inorder, first, inOrderStart, inOrderEnd);
        TreeNode root = new TreeNode(inorder[index]);
        root.left = helpBuildTree(preorder, inorder, inOrderStart, index - 1, preStart + 1);
        root.right = helpBuildTree(preorder, inorder, index + 1, inOrderEnd, preStart + (index - inOrderStart) + 1);
        return root;
    }

    public int findIndex(int[] order, int val, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (order[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helpBuildPosTree(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode helpBuildPosTree(int[] inorder, int[] postorder, int postLastIndex, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        if (postLastIndex < 0) {
            return null;
        }
        int first = postorder[postLastIndex];
        int index = findIndex(inorder, first, inStart, inEnd);
        TreeNode root = new TreeNode(first);
        root.left = helpBuildPosTree(inorder, postorder, postLastIndex - (inEnd - index) - 1, inStart, index - 1);
        root.right = helpBuildPosTree(inorder, postorder, postLastIndex - 1, index + 1, inEnd);
        return root;
    }

    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder("");
        if(t == null){
            return sb.toString();
        }
        append(t, sb);
        return sb.subSequence(1, sb.length() - 1).toString();
    }

    public void append(TreeNode t, StringBuilder sb) {
        if (t == null) {
            return;
        }
        sb.append("(");
        sb.append(t.val);
        if (t.left == null && t.right != null) {
            sb.append("()");
        }
        append(t.left, sb);
        append(t.right, sb);
        sb.append(")");
    }
}

class TreeNode {
    int val;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int x) {
        val = x;
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}
