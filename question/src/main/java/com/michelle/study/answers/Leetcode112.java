package com.michelle.study.answers;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 举例：
 * 输入：
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 *  sum = 22
 *
 *  输出：
 *  true
 *
 */
public class Leetcode112 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) {
                return false;
            }
            if (root.left == null && root.right == null && root.val == sum) {
                return true;
            }
            boolean result = false;
            if (root.left != null) {
                result = hasPathSum(root.left, sum - root.val);
                if (result) {
                    return true;
                }
            }
            if (root.right != null) {
                result = hasPathSum(root.right, sum - root.val);
                if (result) {
                    return true;
                }
            }
            return result;
        }

        public boolean hasPathSum1(TreeNode root, int sum) {
            if (root == null) {
                return false;
            }
            if (root.left == null && root.right == null) {
                return root.val == sum;
            }
            return hasPathSum1(root.left, sum - root.val) || hasPathSum1(root.right, sum - root.val);
        }

    }
}
