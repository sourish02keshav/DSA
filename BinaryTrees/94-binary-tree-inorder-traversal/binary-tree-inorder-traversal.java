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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode curr = root;
        while(curr != null)
        {
            if(curr.left == null)
            {
                ans.add(curr.val);
                curr = curr.right;
            }
            else
            {
                TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr)
                {
                    prev = prev.right;
                }
                if(prev.right == null)
                {
                    prev.right = curr;
                    curr = curr.left;
                }
                else
                {
                    prev.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
        }        
        // if(root == null)
        // {
        //     return ans;
        // }
        // Stack<TreeNode> st = new Stack<>();
        // TreeNode node = root;
        // while(true)
        // {
        //     if(node != null)
        //     {
        //         st.push(node);
        //         node = node.left;
        //     }
        //     else
        //     {
        //         if(st.isEmpty())
        //         {
        //             break;
        //         }
        //         node = st.pop();
        //         ans.add(node.val);
        //         node = node.right;
        //     }
        // }

        //helper(ans,root);
        return ans;
    }
    public void helper(List<Integer> ans,TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        helper(ans,root.left);
        ans.add(root.val);
        helper(ans,root.right);
    }
}