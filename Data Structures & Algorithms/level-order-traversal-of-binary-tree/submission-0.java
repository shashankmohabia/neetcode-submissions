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
    public List<List<Integer>> levelOrder(TreeNode root) {
         List<List<Integer>> answer = new ArrayList<List<Integer>> ();
        if (root == null) return answer;
        
        Queue<TreeNode> q = new ArrayDeque<TreeNode>();
        q.offer(root);
        int currentLevelCount = 1;

        while (!q.isEmpty()) {
            List<Integer> row = new ArrayList<Integer> ();
            while (currentLevelCount-- > 0){
                TreeNode front = q.poll();
                row.add(front.val);
                if (front.left != null) {
                    q.offer(front.left);
                }
                if (front.right != null) {
                    q.offer(front.right);
                }
            }
            currentLevelCount = q.size();
            answer.add(row);
        }
        
        return answer;
    }
}
