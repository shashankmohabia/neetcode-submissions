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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return Collections.emptyList();
        Queue<TreeNode> levelOrder = new ArrayDeque<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        levelOrder.offer(root);
        int currentLevelSize = levelOrder.size();
        while (!levelOrder.isEmpty()) {
            TreeNode front = levelOrder.poll();
            if(front.left != null)levelOrder.offer(front.left);
            if(front.right != null)levelOrder.offer(front.right);
            if (currentLevelSize == 1) {
                result.add(front.val);
                currentLevelSize = levelOrder.size();
            }
            else  {
                currentLevelSize--;
            }
        }
        return result;

    }
}
