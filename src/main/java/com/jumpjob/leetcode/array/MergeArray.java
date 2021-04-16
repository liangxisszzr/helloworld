package com.jumpjob.leetcode.array;

/**
 * @Auther: zuojianhou
 * @Date: 2021/3/24
 * @Description:
 */
public class MergeArray {
    public static void main(String[] args) {

    }

    public static int[] merge(int[] a, int[] b, int m, int n) {
        int temp = a[0];
        int init = 0;
        for (int x : b) {
            if (temp > x) {
                a[init] = x;
            }
        }
        return null;
    }
}
