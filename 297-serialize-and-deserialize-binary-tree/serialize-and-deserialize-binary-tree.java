/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
        {
            return "";
        }
        StringBuilder str = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            if(node == null)
            {
                str.append("n ");
                continue;
            }
            str.append(node.val + " ");
            queue.add(node.left);
            queue.add(node.right);
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(""))
        {
            return null;
        }
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for(int i = 1;i < values.length;i++)
        {
            TreeNode node = queue.poll();
            if(!values[i].equals("n"))
            {
                node.left = new TreeNode(Integer.parseInt(values[i]));
                queue.add(node.left);
            }
            if(!values[++i].equals("n"))
            {
                node.right = new TreeNode(Integer.parseInt(values[i]));
                queue.add(node.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));