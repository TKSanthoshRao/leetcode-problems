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
    public boolean dfs(TreeNode root,int target,int sum){
        if(root == null){
            return false;
        } 
        sum += root.val; 
        if (root.left == null && root.right == null) {
            return sum == target;
        }
        return dfs(root.left,target,sum) || dfs(root.right,target,sum);

    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return dfs(root,targetSum,0);
    }
}