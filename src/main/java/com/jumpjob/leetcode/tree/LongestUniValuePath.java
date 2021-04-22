package com.jumpjob.leetcode.tree;

/**
 * 最长同值路径
 */
public class LongestUniValuePath {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(1);;
        root.right.left.left = new TreeNode(1);
        root.right.left.right = new TreeNode(1);
        root.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(1);
        System.out.println(operation(root));
    }

    public static int solution(TreeNode root, TreeNode temp) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        int cnt = 0;
        if (temp != null && root.val == temp.val) {
            count += solution(temp, temp.left) + 1;
            cnt += solution(temp, temp.right) + 1;
        }
        return Math.max(count, cnt);
    }

    public static int operation(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(solution(root, root.left) + solution(root, root.right), Math.max(operation(root.left), operation(root.right)));
    }
}
