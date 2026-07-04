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
    public int countNodes(TreeNode root) {
        if(root == null)
        {
            return 0;
        }  
        int leftHeight = findLeftHeight(root);
        int rightHeight = findRightHeight(root);
        if(leftHeight == rightHeight)
        {
            return (int)Math.pow(2,leftHeight) - 1;
        }
        else
        {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
    public int findLeftHeight(TreeNode root)
    {
        TreeNode curr = root;
        int count = 0;
        while(curr != null)
        {
            count++;
            curr = curr.left;
        }
        return count;
    }
    public int findRightHeight(TreeNode root)
    {
        TreeNode curr = root;
        int count = 0;
        while(curr != null)
        {
            count++;
            curr = curr.right;
        }
        return count;
    }
}