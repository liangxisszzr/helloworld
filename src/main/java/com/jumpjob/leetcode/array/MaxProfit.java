package com.jumpjob.leetcode.array;

/**
 * @Auther: zuojianhou
 * @Date: 2021/3/24
 * @Description:
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] a = {8, 10, 11, 12, 9, 6, 2, 7};
        System.out.println(solution(a));
    }

    public static int solution(int[] a) {
        //不存在收益情况
        if (a == null || a.length < 2) {
            return 0;
        }
        //第二天收益
        int res = Math.max(a[1] - a[0], 0);
        int temp;
        //第三天如果存在
        int min = Math.min(a[0], a[1]);
        if (a.length == 3) {
            return Math.max(a[2] - min, res);
        }
        //第三天之后收益情况
        if (a.length > 3) {
            for (int i = 3; i < a.length; i++) {
                min = Math.min(a[i - 1], min);
                temp = a[i] - min;
                if (temp > res) {
                    res = temp;
                }
            }
        }
        return res;
    }
}
