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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length != postorder.length)
        {
            return null;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        TreeNode root = buildTreeHelper(0,inorder.length - 1,inorder,0,postorder.length - 1,
        postorder,map);
        return root;
    }
    public TreeNode buildTreeHelper(int inStart,int inEnd,int[] inorder,int postStart,
    int postEnd,int[] postorder,HashMap<Integer,Integer> map)
    {
        if(inStart > inEnd || postStart > postEnd)
        {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inorderRootIdx = map.get(root.val);
        int numLeft = inorderRootIdx - inStart;
        root.left = buildTreeHelper(inStart,inorderRootIdx - 1,inorder,postStart,
        postStart + numLeft - 1,postorder,map);
        root.right = buildTreeHelper(inorderRootIdx + 1,inEnd,inorder,postStart + numLeft,
        postEnd - 1,postorder,map);
        return root;
    }
}