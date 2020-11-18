package com.jumpjob.leetcode.string;

/**
 * 替换字符串中的空格
 * @Auther: zuojianhou
 * @Date: 2020/11/7
 * @Description:
 */
public class ReplaceSpaceInString {
    public static void main(String[] args) {
        System.out.println(solution("a b   c"));
    }

    /**
     * 偷懒解法
     * @param a
     * @return
     */
    public static String solution(String a) {
        return a.replace(" ", "%20");
    }
}
