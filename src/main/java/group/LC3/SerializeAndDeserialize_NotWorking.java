package group.LC;

public class SerializeAndDeserialize_NotWorking {

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //do a bfs, for each level, should increase the list size by 2^the level number (or simply multiply by 2 every level)
        if(root == null)
            return null;
        List<Integer> l = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            //remove from the queue
            TreeNode temp = q.remove();
            //get the left and right child and add to queue
            if(temp == null){
                l.add(null);
                System.out.println("null");
            }
            else{
                l.add(temp.val);
                System.out.println(temp.val);
                if(temp.left != null)
                    q.add(temp.left);
                else
                    q.add(null);
                if(temp.right != null)
                    q.add(temp.right);
                else
                    q.add(null);
            }
        }
        //keep adding them to a list
        //then remove the unnecessary nulls at the end
        //Iterator<Integer> iter = l.getIterator();
        for(int i=l.size()-1; i>=0; i--){
            if(l.get(i) == null)
                l.remove(i);
            else
                break;
        }
        //return the list as a string finally
        System.out.println(l);
        return l.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //take the string of data and parse it
        //put them all in a queue
        //start polling it and adding them as a child for each node in the queue
        if(data  == null || data.length==0)
            return null;
        Queue<TreeNode> q = new LinkedList<>();
        //parse the given string first
        String[] numbers = data.substring(i+1, data.length-1).split(",");
        //now we should iterate over it
        for(String s : numbers){
            //convert each from string into number
            int num = Integer.parseInt(s);
            q.add(new TreeNode(num));
        }
        //peek and fix the node
        TreeNode root = q.peek();
        //now start polling the queue
        //go by sizes
        int counter = 1, i=0;
        while(!q.isEmpty()){
            Node temp = q.poll();
            while(i< counter*2){
                if(q.peek() != null)
                    temp.left = q.poll();
                if(q.peek() != null)
                    temp.right = q.poll();
                i++;
            }
            counter = counter*2;
        }
            
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));