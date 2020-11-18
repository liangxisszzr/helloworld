package com.jumpjob.leetcode.array;

/**
 * 在二维数组中查找
 * @Auther: zuojianhou
 * @Date: 2020/11/7
 * @Description:
 */
public class SearchInDoubleArray {
    public static void main(String[] args) {
        int[][] a = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(solution(a, 5));
        System.out.println(solution(a, 20));
        System.out.println(solution(a, 30));
        int[][] b = {{}};
        System.out.println(solution(b, 10));
        int[][] c = {};
        System.out.println(solution(c, 20));
    }

    public static boolean solution(int[][] a, int goat) {
        if (a == null || a.length == 0 || a[0].length == 0) {
            return false;
        }
        int x = a[0].length - 1;
        int y = 0;
        while (x >= 0 && y <= a.length - 1) {
            if (a[x][y] == goat) {
                return true;
            } else if (a[x][y] > goat) {
                x--;
            } else {
                y++;
            }
        }
        return false;
    }
}
