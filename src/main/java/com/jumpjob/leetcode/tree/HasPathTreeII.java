package com.jumpjob.leetcode.tree;

/**
 * 求和（总条数）不限叶子节点，限制自上而下
 */
public class HasPathTreeII {
    public static void main(String[] args) {

    }

    public static int solution(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        return operation(root, targetSum) + solution(root.left, targetSum) + solution(root.right, targetSum);
    }

    public static int operation(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (targetSum - root.val == 0) {
            count++;
        }
        return count + operation(root.left, targetSum - root.val) + operation(root.right, targetSum - root.val);
    }
}
