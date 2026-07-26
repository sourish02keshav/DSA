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
    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        heightSum(root,maxSum);
        return maxSum[0];
    }
    public int heightSum(TreeNode root,int[] maxSum)
    {
        if(root == null)
        {
            return 0;
        }
        int leftSum = Math.max(0,heightSum(root.left,maxSum));
        int rightSum = Math.max(0,heightSum(root.right,maxSum));
        maxSum[0] = Math.max(maxSum[0],root.val + leftSum + rightSum);
        return root.val + Math.max(leftSum,rightSum);
    }
}