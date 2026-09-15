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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
          while (root != null) {
            
            // If both p and q are greater than parent
            if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } 
            // If both p and q are lesser than parent
            else if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } 
            // We have found the split point (or root equals p or q)
            else {
                return root;
            }
        }
        
        return null; // Should only be reached if tree is empty
    }
}
