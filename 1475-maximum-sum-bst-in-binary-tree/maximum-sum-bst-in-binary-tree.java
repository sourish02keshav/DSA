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

class TreeNodeHelper{
    int minValue,maxValue,size,sum = 0;
    public TreeNodeHelper(int minValue,int maxValue,int size,int sum)
    {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.size = size;
        this.sum = sum;
    }
}

class Solution {
    int ans = 0;
    public TreeNodeHelper maxSumBSTHelper(TreeNode root)
    {
        if(root == null)
        {
            return new TreeNodeHelper(Integer.MAX_VALUE,Integer.MIN_VALUE,0,0);
        }
        TreeNodeHelper leftTreeNode = maxSumBSTHelper(root.left);
        TreeNodeHelper rightTreeNode = maxSumBSTHelper(root.right);
        if(leftTreeNode.maxValue < root.val && root.val < rightTreeNode.minValue)
        {
            int currSum = root.val + leftTreeNode.sum + rightTreeNode.sum;
            if(ans < currSum)
            {
                ans = currSum;
            }
            return new TreeNodeHelper(Math.min(leftTreeNode.minValue,root.val),
            Math.max(root.val,rightTreeNode.maxValue),
            1 + leftTreeNode.size + rightTreeNode.size,currSum);
        }
        return new TreeNodeHelper(Integer.MIN_VALUE,Integer.MAX_VALUE,
        Math.max(leftTreeNode.size,rightTreeNode.size),
        Math.max(leftTreeNode.sum,rightTreeNode.sum));
    }

    public int maxSumBST(TreeNode root) {
        maxSumBSTHelper(root);
        return ans;
    }
}