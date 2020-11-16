package com.jumpjob.LeatCode.array;

/**
 * @author zuojianhou
 * @Date: 2020/11/12
 * @Description:
 */
public class TransposeMatrix {
    public static void main(String[] args) {

    }

    /**
     * 解法一：遍历 省时费内存 方阵情况可直接在原矩阵修改
     * @param A
     * @return
     */
    public static int[][] solution(int[][] A) {
        int x = A.length;
        int y = A[0].length;
        int[][] res = new int[y][x];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                res[j][i] = A[i][j];
            }
        }
        return res;
    }
}
