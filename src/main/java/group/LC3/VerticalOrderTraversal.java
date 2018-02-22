package group.LC;

public class VerticalOrderTraversal {

}


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
    
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    List<List<Integer>> ans = new ArrayList<>();
    Map<Integer, List<Integer>> map = new HashMap<>();
    Queue<Integer> cols = new LinkedList<>();
    Queue<TreeNode> q = new LinkedList<>();
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        if(root == null)
            return ans;
        int verticalLevelNumber = 0;
       
        //iterative BFS
        q.offer(root);
        cols.offer(0);
        while(!q.isEmpty()){
            //poll the queue
            int col = cols.poll();
            TreeNode cur = q.poll();
            if(!map.containsKey(col))
                map.put(col, new ArrayList<>());
            map.get(col).add(cur.val);
            
            //now left and right children
            min = Math.min(min, col);
            max = Math.max(max, col);
            if(cur.left != null){
                q.offer(cur.left);
                cols.offer(col - 1);
                
            }
            if(cur.right != null){
                q.offer(cur.right);
                cols.offer(col + 1);
                
            }
        }
        
        System.out.println(map);
        for(int i=min; i<=max; i++ ){
            ans.add(map.get(i));
        }
        return ans;
    }
    
}