package group.LC;

public class SerializeAndDeserializeBST {


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    public void buildString(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("X").append(",");
        }
        else{
            sb.append(root.val).append(",");
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(data.split(",")));
        return buildTree(q);
        
    }
    
    public TreeNode buildTree(Queue<String> q){
        if(q == null){
            return null;
        }else{
            if(q.isEmpty()){
                
                return null;
            }
            else{
                String num = q.remove();
                if(num.equals("X"))
                    return null;
                TreeNode root = new TreeNode(Integer.parseInt(num));
                root.left = buildTree(q);
                root.right = buildTree(q);
                return root;
                
            }
        }
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));