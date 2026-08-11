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

    int i = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorderHelper(preorder,Integer.MAX_VALUE);
    }
    
    public TreeNode bstFromPreorderHelper(int[] preorder,int upperBound)
    {
        if(i == preorder.length || preorder[i] > upperBound)
        {
            return null;
        }
        TreeNode root = new TreeNode(preorder[i++]);
        root.left = bstFromPreorderHelper(preorder,root.val);
        root.right = bstFromPreorderHelper(preorder,upperBound);
        return root;
    }
}