package com.eastnorth.Datastruct.SimpleSort;

import java.util.Arrays;

/**
 * 简单排序
 */
public class SimpleSort {

    public static void main(String[] args) {
        int[] a = {1, 4, 2, 13, 6, 7, 18, 14, 15, 28, 21};
        insertSort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void bubbleSort(int[] target) {
        int temp;
        for (int i = target.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j ++) {
                if (target[j] > target[j + 1]) {
                    temp = target[j + 1];
                    target[j + 1] = target[j];
                    target[j] = temp;
                }
            }
        }
    }

    private static void selectSort(int[] target) {
        int head = 0;
        int tail;
        int temp;
        for (int i = 0; i < target.length - 1; i++) {
            temp = target[head];
            tail = head;
            for (int j = head + 1; j < target.length; j++) {
                if (target[j] < temp) {
                    temp = target[j];
                    tail = j;
                }
            }
            target[tail] = target[head];
            target[head] = temp;
            head++;
        }
    }

    private static void insertSort(int[] target) {
        int temp;
        for (int i = 1; i < target.length; i++) {
            for (int j = i; j > 0; j--) {
                if (target[j] < target[j - 1]) {
                    temp = target[j - 1];
                    target[j - 1] = target[j];
                    target[j] = temp;
                }
            }
        }
    }
}
