package com.eastnorth.zuojianhou;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zuojianhou
 * @date   2020/5/13
 * @Description: 将整数按权重排序
 *
 *         我们将整数 x 的 权重 定义为按照下述规则将 x 变成 1 所需要的步数：
 *
 *         如果 x 是偶数，那么 x = x / 2
 *         如果 x 是奇数，那么 x = 3 * x + 1
 *         比方说，x=3 的权重为 7 。因为 3 需要 7 步变成 1 （3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1）。
 *
 *         给你三个整数 lo， hi 和 k 。你的任务是将区间 [lo, hi] 之间的整数按照它们的权重 升序排序 ，如果大于等于 2 个整数有 相同 的权重，那么按照数字自身的数值 升序排序 。
 *
 *         请你返回区间 [lo, hi] 之间的整数按权重排序后的第 k 个数。
 *
 *         来源：力扣（LeetCode）
 *         链接：https://leetcode-cn.com/problems/sort-integers-by-the-power-value
 *         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WeightSortQuestion {
    public static void main(String[] args) {
        SolutionWeight solutionWeight = new SolutionWeight();
        System.out.println(solutionWeight.getKth(1, 1000, 777));
    }
}
class SolutionWeight {
    public int getKth(int lo, int hi, int k) {
        int count = 0;
        List<Integer> weightList = new ArrayList<Integer>();
        List<Integer> keyList = new ArrayList<Integer>();
        for (int i = lo; i <= hi; i++) {
            int key = i;
            int ope = i;
            while (ope != 1) {
                if (ope % 2 == 1) {
                    ope = 3 * ope + 1;
                    count++;
                }
                if (ope % 2 == 0) {
                    ope = ope / 2;
                    count++;
                }
            }
            if (weightList.size() == 0) {
                weightList.add(count);
                keyList.add(key);
                count = 0;
            } else {
                for (int j = 0; j < weightList.size();) {
                    if (count > weightList.get(j)) {
                        if (j + 1 == weightList.size()) {
                            weightList.add(j + 1, count);
                            keyList.add(j + 1, key);
                            count = 0;
                            break;
                        } else {
                            j++;
                        }
                    } else if (count < weightList.get(j)) {
                        weightList.add(j, count);
                        keyList.add(j, key);
                        count = 0;
                        break;
                    } else {
                        if (key > keyList.get(j)) {
                            if (j + 1 == weightList.size()) {
                                weightList.add(j + 1, count);
                                keyList.add(j + 1, key);
                                count = 0;
                                break;
                            } else {
                                j++;
                            }
                        } else {
                            weightList.add(j, count);
                            keyList.add(j, key);
                            count = 0;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(weightList);
        System.out.println(keyList);
        return keyList.get(k - 1);
    }
}