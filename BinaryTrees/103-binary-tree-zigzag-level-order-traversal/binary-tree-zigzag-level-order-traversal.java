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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> dq = new LinkedList<>();
        if(root == null)
        {
            return ans;
        }
        dq.add(root);
        boolean leftToRight = true;
        while(!dq.isEmpty())
        {
            int size = dq.size();
            List<Integer> row = new ArrayList<>();
            for(int i = 0;i < size;i++)
            {
                TreeNode node;
                if(leftToRight)
                {
                    node = dq.pollFirst();
                    if(node.left != null)
                    {
                        dq.addLast(node.left);
                    }
                    if(node.right != null)
                    {
                        dq.addLast(node.right);
                    }
                }
                else
                {
                    node = dq.pollLast();
                    if(node.right != null)
                    {
                        dq.addFirst(node.right);
                    }
                    if(node.left != null)
                    {
                        dq.addFirst(node.left);
                    }
                }
                row.add(node.val);
            }
            leftToRight = !leftToRight;
            ans.add(row);
        }
        return ans;
    }
}