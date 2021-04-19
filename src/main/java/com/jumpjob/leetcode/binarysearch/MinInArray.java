package com.jumpjob.leetcode.binarysearch;

public class MinInArray {
    public static void main(String[] args) {

    }

    public static int solution(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int low = 0;
        int high = nums.length - 1;
        int mid = low + (high - low) / 2;
        while (low < high) {
            if (nums[mid] <= nums[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return nums[low];
    }
}
