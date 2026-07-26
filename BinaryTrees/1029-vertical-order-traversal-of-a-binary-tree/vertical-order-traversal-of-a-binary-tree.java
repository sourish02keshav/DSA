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

class Tuple{
    TreeNode node;
    int row,col;
    public Tuple(TreeNode node,int row,int col)
    {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Tuple> queue = new LinkedList<>();
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        queue.add(new Tuple(root,0,0));
        while(!queue.isEmpty())
        {
            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;
            if(!map.containsKey(y))
            {
                map.put(y,new TreeMap<>());
            }
            if(!map.get(y).containsKey(x))
            {
                map.get(y).put(x,new PriorityQueue<>());
            }
            map.get(y).get(x).add(node.val);
            if(node.left != null)
            {
                queue.add(new Tuple(node.left,x + 1,y - 1));
            }
            if(node.right != null)
            {
                queue.add(new Tuple(node.right,x + 1,y + 1));
            }
        }
        for(TreeMap<Integer,PriorityQueue<Integer>> innerMap : map.values())
        {
            List<Integer> temp = new ArrayList<>();
            for(PriorityQueue<Integer> pq : innerMap.values())
            {
                while(!pq.isEmpty())
                {
                    temp.add(pq.poll());
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}