package com.eastnorth.zuojianhou;

import java.util.Arrays;

/**
 * @author zuojianhou
 * @date   2020/5/13
 * @Description:
 */
public class DeleteRepeatItem {
    public static void main(String[] args) {
        DeleteRepeatItemSolution solution = new DeleteRepeatItemSolution();
        int[] a = {1, 1, 1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 7, 7, 7, 7};
        System.out.println(solution.removeDuplicates(a));
    }
}

// TODO: 2020/5/14 待改进
class DeleteRepeatItemSolution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1 - count; i++) {
            while (nums[i] == nums[i + 1] && i + 1 != nums.length - count) {
                if (nums.length - 1 - count - i >= 0) {
                    System.arraycopy(nums, i + 1, nums, i, nums.length - 1 - count - i);
                }
                count++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums.length - count;
    }
}