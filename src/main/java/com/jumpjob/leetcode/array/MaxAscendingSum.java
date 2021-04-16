package com.jumpjob.leetcode.array;

public class MaxAscendingSum {
    public static void main(String[] args) {
        int[] test = {10,20,30,5,10,50};
        System.out.println(maxSolution(test));
    }

    public static int maxSolution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int temp = nums[0];
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                temp += nums[i + 1];
            } else {
                res = Math.max(temp, res);
                temp = nums[i + 1];
            }
        }
        res = Math.max(temp, res);
        return res;
    }
}
