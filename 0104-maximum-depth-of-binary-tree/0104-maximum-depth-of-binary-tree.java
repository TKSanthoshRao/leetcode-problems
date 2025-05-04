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
    public int maxDepth(TreeNode root) {
        // if(root== null) return 0;
        // Queue<TreeNode> q = new LinkedList<>();
        // q.offer(root);
        // int dpth = 0;
        // while(!q.isEmpty()){
        //     int size = q.size();
        //     dpth++;
        //     for(int i = 0;i<size;i++){
        //         TreeNode node = q.poll();
        //         if(node.left != null)q.offer(node.left);
        //         if(node.right!= null)q.offer(node.right);
        //     }
        // }
        // return dpth;

         if (root == null) return 0;
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}