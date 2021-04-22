package com.jumpjob.leetcode.tree;

/**
 * 左叶子之和
 */
public class LeftLeavesSumTree {
    public static void main(String[] args) {

    }

    public static int solution(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return 0;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            return root.left.val + solution(root.right);
        }
        return solution(root.left) + solution(root.right);
    }
}
