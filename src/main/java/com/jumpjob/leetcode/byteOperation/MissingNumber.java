package com.jumpjob.leetcode.byteOperation;

public class MissingNumber {
    public static void main(String[] args) {
        int[] a = {1, 0, 2, 4, 3, 5};
        System.out.println(anotherSolution(a));
        System.out.println(Integer.MAX_VALUE);
    }

    public static int solution(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ i ^ nums[i];
        }
        return result ^ nums.length;
    }

    public static int anotherSolution(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i] - i + sum;
        }
        sum -= nums.length;
        return Math.abs(sum);
    }
}
