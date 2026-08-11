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

class BstIterator{

    private Stack<TreeNode> st = new Stack<>();
    private boolean reverse = false;

    public BstIterator(TreeNode root,boolean reverse)
    {
        this.reverse = reverse;
        pushAll(root);
    }

    public int next()
    {
        TreeNode temp = st.pop();
        if(reverse == true)
        {
            pushAll(temp.left);
        }
        else
        {
            pushAll(temp.right);
        }
        return temp.val;
    }

    public boolean hasNext()
    {
        return !st.isEmpty();
    }

    private void pushAll(TreeNode root)
    {
        while(root != null)
        {
            st.push(root);
            if(reverse == true)
            {
                root = root.right;
            }
            else
            {
                root = root.left;
            }
        }
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {

        if(root == null)
        {
            return false;
        }   

        BstIterator nextIterator = new BstIterator(root,false);
        BstIterator beforeIterator = new BstIterator(root,true);

        int i = nextIterator.next();
        int j = beforeIterator.next();

        while(i < j)
        {
            if(i + j == k)
            {
                return true;
            }
            else if(i + j < k)
            {
                i = nextIterator.next();
            }
            else
            {
                j = beforeIterator.next();
            }
        }
        return false;
    }
}