package tencent;

/**
 * 二分搜索
 */
public class BinarySearch {


    public static void main(String... args) {
        int[] source = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        BinarySearch binarySearch = new BinarySearch();
        int index = binarySearch.search(source, 7, 0, source.length - 1);
        System.out.println(index);
    }

    public int search(int[] source, int target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (source[mid] == target) {
                return mid;
            } else if (source[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

}
