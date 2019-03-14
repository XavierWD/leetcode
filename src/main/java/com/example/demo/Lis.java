package com.example.demo;

/**
 * Created by weixiaolong on 2019/1/13.
 */
public class Lis {

    public static void main(String... args) {
        Lis l  = new Lis();
        l.lengthOfLIS1(new int[]{1,5,19,5,3,7,10,6});
    }

    ///10,9,2,5,3,7,101,18
    ///1   1 1 1 1  1   1
    ///1  1 1 2 2
    public int lengthOfLIS(int[] nums) {
        //每一行为0 1 ，是否取值
        int result[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = 1;
        }
        int c = 0;
        for (int i = 1; i < nums.length; i++) {
            //求i - 1对最长子序列的最大
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (result[j] + 1 > result[i]) {
                        result[i] = result[j] + 1;
                        if (result[i] > c) {
                            c = result[i];
                        }
                    }
                }
            }
        }
        return c;
    }

    public int lengthOfLIS1(int[] nums) {
        //每一行为0 1 ，是否取值
        int result[][] = new int[nums.length][nums.length];
        int rows[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i][i] = 1;
            rows[i] = 1;
        }

        int c = 0;
        for (int i = 1; i < nums.length; i++) {
            //求i - 1对最长子序列的最大
            int rowMax = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (rows[j] + 1 > rows[i]) {
                        rows[i] = rows[j] + 1;
                        clear(result[i]);
                        for (int k = 0; k < i; k++) {
                            result[i][k] = result[j][k];
                        }
                        result[i][i] = 1;
                    }
                }
            }
        }
        printNums(result);
        return c;
    }

    public void printNums(int[][] result) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void clear(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = 0;
        }
        return ;
    }
}
