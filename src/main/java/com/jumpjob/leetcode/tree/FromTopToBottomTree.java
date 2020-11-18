package com.jumpjob.leetcode.tree;

import java.util.*;

/**
 * @Auther: zuojianhou
 * @Date: 2020/11/17
 * @Description:
 */
public class FromTopToBottomTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.left = new TreeNode(3);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(9);
        System.out.println(Arrays.toString(solution(treeNode)));
    }

    public static int[] solution(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return new int[0];
        }
        queue.add(root);
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode tem = queue.remove();
            res.add(tem.val);
            if (tem.left != null) {
                queue.add(tem.left);
            }
            if (tem.right != null) {
                queue.add(tem.right);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
