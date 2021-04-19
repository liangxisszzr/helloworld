package com.jumpjob.leetcode.byteOperation;

public class HammingDistance {
    public static void main(String[] args) {

    }

    public static int solution(int x, int y) {
        int z = x ^ y;
        int count = 0;
        while (z != 0) {
            if ((z & 1) == 1) {
                count++;
            }
            z = z >> 1;
        }
        return count;
    }

    public static int otherSolution(int x, int y) {
        return Integer.bitCount(x ^ y);
    }


}
