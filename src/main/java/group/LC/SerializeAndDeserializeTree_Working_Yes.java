package group.LC;

public class SerializeAndDeserializeTree_Working_Yes {

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


    private static final String spliter = ",";
    private static final String NN = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        constructString(root, sb);
        //System.out.println(sb);
        return sb.toString();
    }
    public void constructString(TreeNode root, StringBuilder sb){
        //do a pre-order traversal
        if(root == null)
            sb.append(NN).append(spliter);
        else{
            //root
            sb.append(root.val).append(spliter);
            //left
            constructString(root.left, sb);
            //right
            constructString(root.right, sb);
        }
    }
    
    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(spliter);
        } else {
            sb.append(node.val).append(spliter);
            buildString(node.left, sb);
            buildString(node.right,sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
        
        
    }
    
    public TreeNode buildTree(Queue<String> q){
        if(!q.isEmpty()){
            //pop the value
            String temp = q.remove();
            if(temp.equals(NN))
                return null;
            else
            {
                //create a new tree node
                //its in the preordered form so - we should go Root - Left and Right
                TreeNode root = new TreeNode(Integer.parseInt(temp));
                //
                root.left = buildTree(q);
                root.right = buildTree(q);
                return root;
            }
        }
        else
            return null;
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));