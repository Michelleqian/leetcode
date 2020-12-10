package com.michelle.study.answers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 求给定二叉树的最小深度。最小深度是指树的根结点到最近叶子结点的最短路径上结点的数量。
 * Given a binary tree, find its minimum depth.The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * 输入：
 * {1,2,3,4,5}
 *
 * 输出：
 * 2
 *
 */
public class Leetcode111 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public int run(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int nodeNum = 1;
        if (root.left == null && root.right == null) {
            return nodeNum;
        } else {
            if (root.left != null && root.right == null) {
                return count(root.left, nodeNum);
            } else if (root.left == null && root.right != null) {
                return count(root.right, nodeNum);
            } else {
                return Math.min(count(root.left, nodeNum), count(root.right, nodeNum));
            }
        }
    }

    private int count(TreeNode node, int nodeNum) {
        nodeNum++;
        if (node.left == null && node.right == null) {
            return nodeNum;
        } else {
            if (node.left != null && node.right == null) {
                return count(node.left, nodeNum);
            } else if (node.left == null && node.right != null) {
                return count(node.right, nodeNum);
            } else {
                return Math.min(count(node.left, nodeNum), count(node.right, nodeNum));
            }
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int num = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return num;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            num++;
        }
        return num;
    }
}
