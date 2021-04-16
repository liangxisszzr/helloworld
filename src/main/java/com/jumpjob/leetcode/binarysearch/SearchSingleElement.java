package com.jumpjob.leetcode.binarysearch;

/**
 * 查找单一元素
 */
public class SearchSingleElement {
    public static void main(String[] args) {

    }

    public static int solution(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = low + (high - low) / 2;
        while (low < high) {
            if (mid % 2 == 1) {
                mid--;
            }
            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            } else {
                high = mid;
            }
            mid = low + (high - low) / 2;
        }
        return nums[low];
    }
}
