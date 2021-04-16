package com.jumpjob.leetcode.binarysearch;

/**
 * 查找比目标数大的最小数
 */
public class TheLeastInLager {
    public static void main(String[] args) {

    }

    public static char solution(char[] letters, char target) {
        int n = letters.length;
        int l = 0, h = n - 1;
        int m = l + (h - l) / 2;

        while (l <= h) {
            if (letters[m] <= target) {
                l = m + 1;
            } else {
                h = m - 1;
            }
            m = l + (h - l) / 2;
        }
        return l < n ? letters[l] : letters[0];
    }
}
