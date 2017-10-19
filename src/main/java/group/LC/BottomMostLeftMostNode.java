package group.LC;

public class BottomMostLeftMostNode {

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

    int val = 0;
    int depth = Integer.MAX_VALUE, maxDepth = Integer.MAX_VALUE;
    public int findBottomLeftValue(TreeNode root) {
        if(root == null)
            return 0;
       
        //lets do a bfs 
        //and return the first element in the last list of the total list
        
        
        List<List<Integer>> ans = new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> l = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode temp = q.remove();
                l.add(temp.val);
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
            }
            ans.add(l);
        }
        //System.out.println(ans);
        return ans.get(ans.size()-1).get(0);
    }
}
