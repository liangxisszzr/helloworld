package com.jumpjob.leetcode.tree;

/**
 * 是否存在路径
 */
public class HasPathTree {
    public static void main(String[] args) {

    }

    public static boolean solution(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return operation(root, targetSum, 0);
    }

    public static boolean operation(TreeNode root, int targetNum, int temp) {
        if (root.left == null && root.right == null) {
            return targetNum == root.val + temp;
        }
        if (root.left == null) {
            return operation(root.right, targetNum, root.val + temp);
        }
        if (root.right == null) {
            return operation(root.left, targetNum, root.val + temp);
        }
        return operation(root.right, targetNum, root.val + temp) || operation(root.left, targetNum, root.val + temp);
    }
}
