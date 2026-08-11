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

    TreeNode first,middle,last,prev;

    public void inorder(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        inorder(root.left);
        if(prev != null && root.val < prev.val)
        {
            if(first == null)
            {
                first = prev;
                middle = root;
            }
            else
            {
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }

    public void swap(TreeNode node1,TreeNode node2)
    {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    public void recoverTree(TreeNode root) {
        if(root == null)
        {
            return;
        }
        inorder(root);
        if(first != null && last != null)
        {
            swap(first,last);
        }
        else if(first != null && middle != null)
        {
            swap(first,middle);
        }
    }
}