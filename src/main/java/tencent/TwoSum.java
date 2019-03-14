package tencent;

import java.util.List;

/**
 * Created by weixiaolong on 2019/3/10.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 0 || nums.length == 1) {
            return null;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{nums[i], nums[j]};
                }
            }
        }
        return null;
    }


}
