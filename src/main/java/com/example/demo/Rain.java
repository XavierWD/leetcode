package com.example.demo;

import java.util.Stack;

/**
 * Created by weixiaolong on 2019/1/16.
 */
public class Rain {

    public static void main(String... args) {
        Rain r=  new Rain();
        int sum = r.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        System.out.print(sum);
    }

    public int trap(int[] height) {
        int start = 0;
        int sum = 0;
        for (int i = 1; i < height.length; i++) {
            if (i + 1 >= height.length) {
                sum = sum + trapIn(height, start, i);
                start = i + 1;
            } else if (height[i] > height[i + 1]) {
                sum = sum + trapIn(height, start, i);
                start = i + 1;
            }
        }
        return sum;
    }

    public int trapIn(int[] height, int start, int end) {
        int low = height[start] > height[end] ? height[end] : height[start];
        int result = 0;
        for (int i = start + 1; i < end; i++) {
            if (low - height[i] > 0) {
                result = low - height[i];
            }
        }
        return result;
    }

    public int trap3(int[] height) {
        int length = height.length;
        if(length<=2){
            return 0;
        }

        Stack<Integer> s = new Stack<Integer>();
        Stack<Integer> index = new Stack<Integer>();
        s.push(0);
        index.push(1);

        int leftMost = 0;
        int result = 0;
        for(int i = 0 ; i<length ; i++){
            int currentVal = height[i];
            //如果当前值比最左值大，则说明形成了一个封闭的盛水区间
            if(currentVal >= leftMost){
                while(!s.isEmpty()){
                    result += (leftMost - s.pop()) * index.pop();
                }
                s.push(currentVal);
                index.push(1);
                leftMost = currentVal;
            }else{
                //如果当前值比最左值小，则说明该盛水区间仍然没到最右点
                int count = 1;
                //将所有比当前值小的区间填满，并将水平区间的个数插入栈中
                while(currentVal > s.peek()){
                    count += index.peek();
                    result += (currentVal - s.pop()) * index.pop();
                }
                s.push(currentVal);
                index.push(count);
            }
        }
        return result;
    }
}
