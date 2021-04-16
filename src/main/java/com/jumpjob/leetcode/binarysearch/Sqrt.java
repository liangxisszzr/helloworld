package com.jumpjob.leetcode.binarysearch;

/**
 * 查找开方
 */
public class Sqrt {
    public static void main(String[] args) {

    }

    public static int sqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int low = 1;
        int high = x;
        int mid = low + (high - low) / 2;
        while (low <= high) {
            if (mid == x / mid) {
                return mid;
            } else if (mid > x / mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = low + (high - mid) / 2;
        }
        return high;
    }
}
