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
    public boolean isValidBST(TreeNode root) {
        if(isValidBSTHelper(root,Long.MIN_VALUE,Long.MAX_VALUE))
        {
            return true;
        }
        return false;
    }

    public boolean isValidBSTHelper(TreeNode root,long minVal,long maxVal)
    {
        if(root == null)
        {
            return true;
        }
        if(root.val <= minVal || root.val >= maxVal)
        {
            return false;
        }
        return isValidBSTHelper(root.left,minVal,root.val) && 
        isValidBSTHelper(root.right,root.val,maxVal);
    }
}