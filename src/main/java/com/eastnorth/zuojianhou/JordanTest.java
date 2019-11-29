package com.eastnorth.zuojianhou;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Auther: zuojianhou
 * @Date: 2019/11/28
 * @Description:
 *
 *        约德尔人测试
 *
 *        FROM：赛码
 */
public class JordanTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s1 = input.nextLine();
        String s2 = input.nextLine();
        int n = s1.length();
        char[] asc = new char[n];
        int[] number = new int[n];
        int[] transfer = new int[n];
        double result;
        int count = 0;
        for (int i = 0; i < n; i++) {
            asc[i] = s1.charAt(i);
            if (s2.codePointAt(i) == 48) {
                number[i] = 0;
            } else {
                number[i] = 1;
            }
        }
        //wqey21$%$#
        System.out.println(asc);
        //1101010101
        System.out.println(Arrays.toString(number));
        for (int j = 0; j < n; j++) {
            if ((asc[j] >= 65 && asc[j] <= 90) || (asc[j] >= 97 && asc[j] <= 122) || (asc[j] >= 48 && asc[j] <= 57)) {
                transfer[j] = 1;
            } else {
                transfer[j] = 0;
            }
        }
        for (int m = 0; m < n; m++) {
            if (number[m] == transfer[m]) {
                count++;
            }
        }
        result = (count / (double) n) * 100;
        System.out.println(String.format("%.2f", result) + "%");
    }
}
