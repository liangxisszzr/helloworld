package com.jumpjob.leetcode.byteOperation;

public class SingleNumber {
    public static void main(String[] args) {

    }

    public static int solution(int[] nums) {
        int count = 0;
        for (int n : nums) {
            count = count ^ n;
        }
        return count;
    }
}
