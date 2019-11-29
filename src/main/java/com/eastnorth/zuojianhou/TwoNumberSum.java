package com.eastnorth.zuojianhou;

/**
 * @Auther: zuojianhou
 * @Date: 2019/11/25
 * @Description:
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoNumberSum {
    public static void main(String[] args) {
        int[] a = {2, 5, 5, 11};
        int b = 10;
        int[] x = Solution.twoSum(a, b);
        for (int m : x) {
            System.out.println(m);
        }
    }

    static class Solution {
        static int[] twoSum(int[] nums, int target) {
            //申请数组用来存放结果
            int[] result = new int[2];
            //遍历查找
            for (int i = 0; i < nums.length - 1; i++)
                for (int j = i + 1; j < nums.length; j++) {
                    //符合条件录入结果并退出
                    if (target == nums[i] + nums[j]) {
                        result[0] = i;
                        result[1] = j;
                        break;
                    }
                }
            return result;
        }
    }
}
