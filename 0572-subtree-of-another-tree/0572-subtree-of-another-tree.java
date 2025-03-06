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
    public boolean is(TreeNode node,TreeNode subRoot){
        if((node == null && subRoot == null)){
            return true;
        }
        else if(node == null || subRoot == null||node.val != subRoot.val){
            return false;
        }
         return is(node.left , subRoot.left) && is(node.right,subRoot.right);


    }
    public boolean preOrder(TreeNode root,TreeNode subRoot){
        if(root == null){
            return false;
        }
        if(root.val == subRoot.val && is(root,subRoot)){
            return true;
        }
        return preOrder(root.left,subRoot) || preOrder(root.right,subRoot);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return preOrder(root,subRoot);
    }
}