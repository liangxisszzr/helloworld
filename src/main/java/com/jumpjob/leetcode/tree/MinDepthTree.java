package com.jumpjob.leetcode.tree;

/**
 * 二叉树的最小深度
 */
public class MinDepthTree {
    public static void main(String[] args) {

    }

    public static int solution(TreeNode root) {
        return operation(root);
    }

    public static int operation(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null || root.right == null) {
            return Math.max(operation(root.left), operation(root.right)) + 1;
        }
        return Math.min(operation(root.left), operation(root.right)) + 1;
    }
}
