package com.jumpjob.leetcode.binarysearch;

public class BadVersion {
    public static void main(String[] args) {

    }

    public static int solution(int n) {
        int low = 1;
        int high = n;
        int mid = low + (high - low) / 2;
        while (low <= high) {
            if (isBadVersion(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            mid = low + (high - low) / 2;
        }
        return low;
    }

    public static boolean isBadVersion(int n) {
        return n == 0;
    }
}
