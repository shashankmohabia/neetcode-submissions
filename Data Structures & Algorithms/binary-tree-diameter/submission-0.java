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
    private int maxDiameter = 0;

    private int depth(TreeNode root){
        if (root == null) {
            return 0;
        }
        
        int rd = depth(root.right);
        int ld = depth(root.left);
        int depth = Math.max(rd, ld) + 1;

        maxDiameter = Math.max(maxDiameter, rd+ld);

        return depth;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxDiameter;
    }
}
