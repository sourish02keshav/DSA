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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // if(preorder.length != inorder.length)
        // {
        //     return null;
        // }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        TreeNode root = buildTreeHelper(0,preorder.length - 1,preorder,0,inorder.length - 1,inorder,map);
        return root;
    }
    public TreeNode buildTreeHelper(int preStart,int preEnd,int[] preorder,int inStart,
    int inEnd,int[] inorder,HashMap<Integer,Integer> map)
    {
        if(preStart > preEnd || inStart > inEnd)
        {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inorderRootIdx = map.get(root.val);
        int numLeft = inorderRootIdx - inStart;
        root.left = buildTreeHelper(preStart + 1,preStart + numLeft,preorder,inStart,
        inorderRootIdx - 1,inorder,map);
        root.right = buildTreeHelper(preStart + numLeft + 1,preEnd,preorder,
        inorderRootIdx + 1,inEnd,inorder,map);
        return root;
    }
}