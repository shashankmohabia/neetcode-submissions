/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int getGoodNodes(TreeNode node, int maxTillNow) {
        if (node == null) return 0;
        if (maxTillNow < node.val) {maxTillNow = node.val;}
        return (maxTillNow == node.val?1:0) + getGoodNodes(node.left, maxTillNow) + getGoodNodes(node.right, maxTillNow);
    }

    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        return getGoodNodes(root, root.val);
    }
}
