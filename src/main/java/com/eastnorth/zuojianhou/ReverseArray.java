package com.eastnorth.zuojianhou;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: zuojianhou
 * @Date: 2019/11/27
 * @Description:
 *
 *        给定一个长度为n的整数数组a，元素均不相同，问数组是否存在这样一个片段，
 *
 *        只将该片段翻转就可以使整个数组升序排列。
 *
 *        FROM:赛码
 */
public class ReverseArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //获取值的个数
        int n = input.nextInt();
        List<Integer> copy = new ArrayList<Integer>();
        int[] a = new int[n];
        //初始化数组
        for (int z = 0; z < n; z++) {
            a[z] = input.nextInt();
        }
        int count = 0;
        //记录开始位置
        int record = 0;
        //定义一个差值,保证只在一个递减区间
        int sub = 0;
        boolean judge = true;
        for (int i = 0; i < a.length - 1; i++) {
            //找到第一个递减就开始记录,不符合差值条件的即跳过了第一个区间,此时直接跳出循环
            //验证找到的第一个区间即可验证结果
            if (a[i] > a[i + 1]) {
                if (count == 0) {
                    record = i;
                    copy.add(count, a[i]);
                    count++;
                    copy.add(count, a[i + 1]);
                    count++;
                    sub = i - 1;
                } else {
                    if ((i - count) == sub) {
                        copy.add(count, a[i + 1]);
                        count++;
                    } else {
                        break;
                    }
                }
            }
        }
        //区间翻转赋值
        if (copy.size() > 0) {
            for (int j = copy.size() - 1; j >= 0; j--) {
                a[record] = copy.get(j);
                record++;
            }
        }
        //得出验证结果
        for (int m = 0; m < a.length - 1; m++) {
            if (a[m] > a[m + 1]) {
                judge = false;
                break;
            }
        }
        if (judge) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
