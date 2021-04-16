package com.jumpjob.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PathWithObstacles {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        List<List<Integer>> res = new ArrayList<>();
        int count = 0;
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length;) {
                if (obstacleGrid[i][j + 1] == 0) {
                    temp.add(i);
                    temp.add(j);
                    res.add(count, temp);
                    count++;
                    j++;
                } else if (obstacleGrid[i + 1][j] == 0) {
                    temp.add(i);
                    temp.add(j);
                    res.add(count, temp);
                    count++;
                    i++;
                } else {
                    int x = res.get(count).get(0);
                    int y = res.get(count).get(1);
                    if (i > x) {
                        res.remove(count);
                        count--;
                    } else {

                    }

                }
            }
        }
        return res;
    }
}
