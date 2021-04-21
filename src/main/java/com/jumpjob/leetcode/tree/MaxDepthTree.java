package com.jumpjob.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 求树高
 */
public class MaxDepthTree {
    public static void main(String[] args) {

    }

    public static int solution(TreeNode root) {
        return root == null ? 0 : Math.max(solution(root.left), solution(root.right)) + 1;
    }

    public static int anotherSolution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size != 0) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                size--;
            }
            depth++;
        }
        return depth;
    }
}
