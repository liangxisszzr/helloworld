package com.jumpjob.LeatCode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * N-叉树前序遍历
 * @author zuojianhou
 * @Date: 2020/11/13
 * @Description:
 */
public class NthTreePreOrderTravel {
    public static void main(String[] args) {

    }

    public static List<Integer> solution(Node root) {
        List<Integer> res = new ArrayList<>();
        func(root, res);
        return res;
    }

    public static void func(Node root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            if (root.children.size() > 0) {
                for (Node node : root.children) {
                    func(node, list);
                }
            }
        }
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
};
