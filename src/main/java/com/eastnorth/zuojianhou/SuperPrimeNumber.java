package com.eastnorth.zuojianhou;

import java.util.Scanner;

/**
 * @Auther: zuojianhou
 * @Date: 2019/11/25
 * @Description:
 *
 *   一个素数，依次从最高位去掉一位，两位……若得到的都是素数，且各数字不为0，则称为超级素数。
 */
public class SuperPrimeNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        solution(n);
    }
    private static void solution(int n) {
        // 个位时一定是2,3,5,7
        int[] a = {2 ,3, 5, 7};
        for (int x : a) {
            calculate(x, n);
        }
    }
    //判断是否为质数
    private static boolean judge(int x) {
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
    private static void calculate(int x, int n) {
        // n用来控制乘以10的次数
        n = n - 1;
        for (int i = 1; i <= 5; i++) {
            // 0,2,4,6,8一定不符合条件,故只考虑1,3,5,7,9
            int a = x * 10 + i * 2 - 1;
            // 如果a为质数且位数不符条件,递归
            if (judge(a) && n != 1) {
                calculate(a, n);
            }
            // 如果a为质数且符合位数条件,打印结果
            if (judge(a) && n == 1) {
                System.out.println(a);
            }
        }
    }
}
