package com.eastnorth;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("hello world");
        solution(3);
    }
    private static void solution(int n) {
        int[] a = {2 ,3, 5, 7};
        for (int x : a) {
            calculate(x, n);
        }
    }
    private static boolean judge(int x) {
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void calculate(int x, int n) {
        n = n -1;
        for (int i = 1; i <= 5; i++) {
            int a = x * 10 + i * 2 - 1;
            if (judge(a) && n != 1) {
                calculate(a, n);
            }
            if (judge(a) && n == 1) {
                System.out.println(a);
            }
        }
    }
}
