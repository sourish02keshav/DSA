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

class Pair{
    TreeNode node;
    int num;
    public Pair(TreeNode node,int num)
    {
        this.node = node;
        this.num = num;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root,0));
        while(!queue.isEmpty())
        {
            int currSize = queue.size();
            int currMin = queue.peek().num;
            int first = 0,last = 0;
            for(int i = 0;i < currSize;i++)
            {
                Pair pair = queue.poll();
                int currIdx = pair.num - currMin;
                TreeNode node = pair.node;
                if(i == 0)
                {
                    first = currIdx;
                }
                if(i == currSize - 1)
                {
                    last = currIdx;
                }
                if(node.left != null)
                {
                    queue.add(new Pair(node.left,2 * currIdx + 1));
                }
                if(node.right != null)
                {
                    queue.add(new Pair(node.right,2 * currIdx + 2));
                }
            }
            ans = Math.max(ans,last - first + 1);
        }
        return ans;
    }
}