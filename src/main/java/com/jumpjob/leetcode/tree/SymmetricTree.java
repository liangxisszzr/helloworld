package com.jumpjob.leetcode.tree;

/**
 * 对称二叉树
 */
public class SymmetricTree {
    public static void main(String[] args) {

    }

    public static boolean solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        return operation(root.left, root.right);
    }

    public static boolean operation(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val == right.val) {
            return operation(left.left, right.right) && operation(left.right, right.left);
        }
        return false;
    }
}
