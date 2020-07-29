package com.eastnorth.Datastruct.GuardExample;

public class GuardSearch {

    static int find(int[] a, int x) {
        //判断为空
        if (a == null) {
            return -1;
        }
        //遍历查找
        int i = 0;
        while (i < a.length) {
            if (a[i] == x) {
                return i;
            }
            i++;
        }
        return -1;
    }

    static int findx(int[] a, int x) {
        //判断空值
        if (a == null) {
            return -1;
        }
        //判断最后一个数值情况：设置为哨兵
        if (a[a.length - 1] == x) {
            return a.length - 1;
        }
        //设置临时值，用于还原数组
        int temp = a[a.length - 1];
        a[a.length - 1] = x;
        //遍历查找，相比上面方法减少了一个比较操作
        int i = 0;
        while (a[i] != x) {
            i++;
        }
        a[a.length - 1] = temp;
        if (i == a.length - 1) {
            return -1;
        } else {
            return i;
        }
    }
}
