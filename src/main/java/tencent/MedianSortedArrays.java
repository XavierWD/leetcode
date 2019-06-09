package tencent;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 */
public class MedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length;
        int numsL2ength = nums2.length;
        int MedianSize = (nums1Length + numsL2ength) % 2 == 0 ? 2 : 1;
        int medianIndex = (nums1Length + numsL2ength) / 2;
        int allMin = 0;

        int oneStart = 0;
        int oneEnd = nums1Length - 1;

        int twoStart = 0;
        int twoEnd = numsL2ength - 1;

        while (allMin != medianIndex) {
            int index1 = findMid(oneStart, oneEnd);
            int index2 = findMid(twoStart, twoEnd);
            int leftCount = 0;
            int rightCount = 0;
            if (nums1[index1] < nums2[index2]) {
                leftCount = index1;
                rightCount = numsL2ength - 1 - index2;
            } else {
                leftCount = index2;
                rightCount = nums1Length - 1 - index1;
            }
        }
        return 1;
    }

    public int findMid(int start, int end) {
        return (start + end) / 2;
    }
}
