/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            if(node.left != null)
            {
                queue.add(node.left);
                parentMap.put(node.left,node);
            }
            if(node.right != null)
            {
                queue.add(node.right);
                parentMap.put(node.right,node);
            }
        }
        HashMap<TreeNode,Boolean> vis = new HashMap<>();
        queue.add(target);
        vis.put(target,true);
        while(k > 0 && !queue.isEmpty())
        {
            int currSize = queue.size();
            for(int i = 0;i < currSize;i++)
            {
                TreeNode node = queue.poll();
                if(node.left != null && !vis.containsKey(node.left))
                {
                    queue.add(node.left);
                    vis.put(node.left,true);
                }
                if(node.right != null && !vis.containsKey(node.right))
                {
                    queue.add(node.right);
                    vis.put(node.right,true);
                }
                if(parentMap.containsKey(node) && !vis.containsKey(parentMap.get(node)))
                {
                    queue.add(parentMap.get(node));
                    vis.put(parentMap.get(node),true);
                }
            }
            k--;
        }
        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty())
        {
            ans.add(queue.poll().val);
        }
        return ans;
    }
}