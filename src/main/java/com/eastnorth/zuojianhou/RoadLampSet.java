package com.eastnorth.zuojianhou;

import java.util.Scanner;

/**
 * @Auther: zuojianhou
 * @Date: 2019/11/29
 * @Description:
 *
 *          V先生有一天工作到很晚，回家的时候要穿过一条长l的笔直的街道，
 *
 *         这条街道上有n个路灯。假设这条街起点为0，终点为l，第i个路灯坐标为ai。
 *
 *         路灯发光能力以正数d来衡量，其中d表示路灯能够照亮的街道上的点与路灯的最远距离，所有路灯发光能力相同。
 *
 *         为了让V先生看清回家的路，路灯必须照亮整条街道，又为了节省电力希望找到最小的d是多少？
 *
 *         FROM:赛码
 */

//todo:需要将桶排序换成其他，否则内存溢出
public class RoadLampSet {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int l = input.nextInt();
        int[] receive = new int[n];
        int[] resolve = new int[l + 1];
        int distance;
        int temp = 110;
        int actual = 0;
        //计算左边界的值
        int left = 0;
        double result;
        for (int i = 0; i < n; i++) {
            receive[i] = input.nextInt();
            resolve[receive[i]]++;
        }
        //15,3,7,9,14,0
        for (int j = 0; j <= l; j++) {
            if (resolve[j] != 0) {
                if (temp == 110) {
                    temp = j;
                    left = j;
                } else {
                    distance = j - temp;
                    if (left != 0) {
                        actual = Math.max(distance, left);
                    }
                    temp = j;
                    if (distance > actual) {
                        actual = distance;
                    }
                }
            }
        }
        for (int z = 0; z <= l; z++) {
            if (resolve[z] != 0) {
                left = l - z;
            }
        }
        actual = Math.max(actual, left);
        result = actual / 2.0;
        System.out.println(String.format("%.2f", result));
    }
}
