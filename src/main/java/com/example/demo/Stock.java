package com.example.demo;

import java.util.List;

/**
 * Created by weixiaolong on 2019/1/12.
 */
public class Stock {

    public static void main(String... args) {
        Stock stock = new Stock();
        int[] s = {1, 10, 0, 5};
        int result = stock.maxProfit3(s);
        System.out.println(result);
    }

    public int maxProfit(Integer[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int sell1 = 0, sell2 = 0, buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            System.out.println(sell1);
            sell1 = Math.max(sell1, prices[i] + buy1);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, prices[i] + buy2);
        }
        return sell2;
    }

    //1 5 6 7 4 2  3 5
    public int maxProfit2(int[] prices) {
        int sum = 0;
        if (prices == null || prices.length == 0) {
            return sum;
        }
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                sum = sum + diff;
            }
        }
        return sum;
    }

    //1 5 6 7 4 2  3 5
    public int maxProfit3(int[] prices) {
        int sum = 0;
        if (prices == null || prices.length == 0) {
            return sum;
        }
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            int one = maxProfitIn(prices, 0, i);
            int two = maxProfitIn(prices, i, prices.length - 1);
            if (max < one + two) {
                max = one + two;
            }
        }
        return max;
    }

    public int maxProfitIn(int[] prices, int start, int end) {
        int n = prices.length;
        if (n == 0) return 0;
        int min = prices[start];
        int max = 0;
        for (int i = start + 1; i <= end; i++) {
            if (prices[i] > min && prices[i] - min > max) {
                max = prices[i] - min;
            }
            if (prices[i] < min) {
                min = prices[i];
            }
        }
        return max;
    }
}
