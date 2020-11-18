package com.jumpjob.leetcode.array;

/**
 * 找出任意一个数组中重复的数字
 * @author zuojianhou
 * @Date: 2020/11/7
 * @Description:
 */
public class DuplicateNumberInArray {
    public static void main(String[] args) {
        int[] a = {1, 0, 2, 5, 3, 4,4};
        System.out.println(solution(a));
    }

    public static int solution(int[] a) {
        int temp;
        for (int i = 0; i < a.length; i++) {
            while (i != a[i]) {
                if (a[i] == a[a[i]]) {
                    return a[i];
                } else {
                    temp = a[i];
                    a[i] = a[a[i]];
                    a[temp] = temp;
                }
            }
        }
        return -1;
    }
}
