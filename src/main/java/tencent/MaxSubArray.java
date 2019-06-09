package tencent;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int preMax = Integer.MIN_VALUE;
        if (nums.length > 0) {
            preMax = nums[0];
            max = preMax;
        }
        for (int i = 1; i < nums.length; i++) {
            preMax = (preMax + nums[i]) > nums[i] ? preMax + nums[i] : nums[i];
            if (preMax > max) {
                max = preMax;
            }
        }
        return max;
    }
}
