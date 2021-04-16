package com.jumpjob.leetcode.tree;

import sun.misc.Queue;

import java.util.List;

/**
 * @Auther: zuojianhou
 * @Date: 2021/3/25
 * @Description:
 */
public class MirrorTree {
    public static void main(String[] args) {
        boolean[] res = new boolean[2];
//        res[0] = searchTree(root);
//        res[1] = wholeTree(root);
    }

    public static TreeNode solution(TreeNode pRoot) {
        if (pRoot == null) {
            return pRoot;
        }
        TreeNode res = new TreeNode(pRoot.val);
        deal(pRoot, res);
        return res;
    }

    public static void deal(TreeNode root, TreeNode newRoot) {
        if (root.left != null) {
            newRoot.right = new TreeNode(root.left.val);
            deal(root.left, newRoot.right);
        }
        if (root.right != null) {
            newRoot.left = new TreeNode(root.right.val);
            deal(root.right, newRoot.left);
        }
    }

    public static void anotherDeal(TreeNode root) {
        TreeNode temp;
        if (root!= null) {
            temp = root.left;
            root.left = root.right;
            root.right = temp;
            anotherDeal(root.left);
            anotherDeal(root.right);
        }
    }

    public static void thirdDeal(Queue<TreeNode> queue, List<Integer> list, int i) throws InterruptedException {
        while (!queue.isEmpty()) {
            TreeNode root = queue.dequeue();
            root.val = list.get(1);
        }
    }

    public static List<Integer> levelSearch(Queue<TreeNode> queue, List<Integer> list) throws InterruptedException {
        while (!queue.isEmpty()) {
            TreeNode root = queue.dequeue();
            if (root.left != null) {
                queue.enqueue(root.left);
            }
            if (root.right != null) {
                queue.enqueue(root.right);
            }
            list.add(root.val);
        }
        return list;
    }

    public static boolean wholeTree(TreeNode root) {
        if (root.right != null && root.left != null) {
            return wholeTree(root.left) && wholeTree(root.right);
        } else {
            return (root.right != null || root.left == null) && root.right == null;
        }
    }

    public static boolean searchTree(TreeNode root) {
        if (root.right != null && root.left != null) {
            if (root.right.val > root.val && root.left.val < root.val) {
                return searchTree(root.left) && searchTree(root.right);
            } else {
                return false;
            }
        } else if (root.right == null && root.left != null) {
            if (root.left.val < root.val) {
                return searchTree(root.left);
            } else {
                return false;
            }
        } else if (root.right != null) {
            if (root.right.val > root.val) {
                return searchTree(root.right);
            } else {
                return false;
            }
        } else {
            return true;
        }
    }
}
