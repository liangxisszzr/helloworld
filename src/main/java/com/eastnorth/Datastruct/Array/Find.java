package com.eastnorth.Datastruct.Array;

/**
 * 二分查找
 */
public class Find {

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 10, 11, 13, 20};
        System.out.println(find(a, 11));
    }

    static int find(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        int cur;
        while (true) {
            cur = (low + high) / 2;
            if (target == array[cur]) {
                return cur;
            } else if (low > high) {
                return -1;
            } else {
                if (array[cur] > target) {
                    high = cur - 1;
                } else {
                    low = cur + 1;
                }
            }
        }
    }
}
