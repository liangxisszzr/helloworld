package com.eastnorth.zuojianhou;

import java.util.Scanner;

/**
 * @Auther: zuojianhou
 * @Date: 2019/11/25
 * @Description:
 *
 *        从买股票的那天开始，股票会有以下变化：第一天不变，以后涨一天，跌一天，涨两天，跌一天，涨三天，跌一天...依此类推。
 *
 *        为方便计算，假设每次涨和跌皆为1，股票初始单价也为1，请计算买股票的第n天每股股票值多少钱？
 *
 *        FROM：赛码
 */
public class StockGod {
    public static void main(String[] args) {
        //初始化从第二天开始计算
        int i = 2;
        //记录涨幅的大小
        int j = 1;
        //控制涨幅的大小
        int k = 1;
        //初始化股票值
        int a = 1;
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (; i <= n; i++) {
            if (k > 0) {
                a++;
                k--;
            } else {
                a--;
                j++;
                k = j;
            }
        }
        System.out.println(a);
    }
}
