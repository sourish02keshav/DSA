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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans,root);
        return ans;
    }
    public void helper(List<List<Integer>> ans,TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0;i < levelSize;i++)
            {
                TreeNode currNode = queue.poll();
                if(currNode.left != null)
                {
                    queue.add(currNode.left);
                }
                if(currNode.right != null)
                {
                    queue.add(currNode.right);
                }
                level.add(currNode.val);
            }
            ans.add(level);
        }
    }
}