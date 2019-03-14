package com.example.demo;

/**
 * Created by weixiaolong on 2019/1/13.
 * K
 */
public class KSum {
    public static void main(String... args) {
        KSum k = new KSum();
        System.out.println(k.kSum3(new int[]{1,2,3,4}, 3, 4));

    }

    public int kSum1(int[] A, int k, int target) {
        int result[][] = new int[k + 1][target + 1];
        result[0][0] = 1;
        for (int i = 1; i <= k; i++) {
            result[0][i] = 0;
        }
        for (int h = 0; h < A.length; h++) {
            for (int i = 1; i <= k; i++) {
                for (int j = A[h]; j <= target; j++) {
//                    if (j - A[h] >= 0) {
                    result[i][j] = result[i][j] + result[i - 1][j - A[h]];
//                    } else {
//                        result[i][j] = result[i - 1][j];
//                    }
                }
            }
        }

        printNums(result, k + 1, target + 1);
        return result[k][target];
    }

    public int kSum2(int[] A, int k, int target) {
        int[][] num = new int[k + 1][target + 1];
        num[0][0] = 1;
        for (int i = 0; i < A.length; i++) {
            for (int j = k; j >= 1; j--) {
                for (int z = target; z >= A[i]; z--) {
                    num[j][z] = num[j][z] + num[j - 1][z - A[i]];
                }
            }
        }
        printNums(num, k + 1, target + 1);
        return num[k][target];

    }

    public void printNums(int[][] result, int row, int columns) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int kSum3(int[] A, int k, int target) {
        int result[][][] = new int[A.length + 1][k + 1][target + 1];
        for (int i = 0; i < A.length + 1; i++) {
            result[i][0][0] = 1;
        }
        for (int h = 1; h < A.length + 1 ; h++) {
            int min = Math.min(h, k);
            for (int i = 1; i <= min; i++) {
                for (int j = 1; j <= target; j++) {
                    if(j >= A[h - 1]) {
                        result[h][i][j] = result[h - 1][i][j] + result[h - 1][i - 1][j - A[h- 1]];
                    }else {
                        result[h][i][j] = result[h - 1][i][j];
                    }
                }
            }
        }
        printNums(result[A.length], k + 1, target +1);
        return result[A.length ][k][target];
    }

    public  int kSum4(int[] A, int k, int target) {
        int[][] num = new int[k+1][target+1];
        num[0][0] = 1;
        for (int i = 0; i < A.length; i++) {
            for (int j = k; j >= 1; j--) {
                for (int z = target; z >= A[i]; z--) {
                    num[j][z] = num[j][z] + num[j-1][z-A[i]];
                }
            }
        }
        printNums(num, k + 1, target + 1);
        return num[k][target];
    }
}

