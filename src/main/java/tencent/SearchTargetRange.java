package tencent;

import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 */
public class SearchTargetRange {


    public static void main(String... args) {
        SearchTargetRange searchTargetRange = new SearchTargetRange();
        int[] result = searchTargetRange.searchRange(new int[]{8, 10}, 8);
        Arrays.stream(result).forEach(r -> System.out.print(r + " "));
    }

    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        int result = -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                result = mid;
                break;
            }
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (result == -1) {
            return new int[]{-1, -1};
        }
        start = result;
        end = result;
        while (start > -1 && nums[start] == target) {
            if (nums[start] == target) {
                start--;
            }

        }
        while (end < nums.length && nums[end] == target) {
            if (nums[end] == target) {
                end++;
            }
        }
        return new int[]{start + 1, end - 1};
    }
}
