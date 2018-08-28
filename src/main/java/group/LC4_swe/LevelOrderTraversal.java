package group.LC4_swe;

public class LevelOrderTraversal {

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        helperBfs(root, ans, 0);
        return ans;
    }
    
    
    public void helperBfs(TreeNode root, List<List<Integer>> ans , int level){
        if(root == null)
            return;
        //check if the inner list is present in the right level number
        // System.out.println(ans);
        if(ans.size() <= level){
            ans.add(level, new ArrayList<Integer>());
        }
        //add the current root val to the right pos list
        ans.get(level).add(root.val);
        if(root.left != null)
            helperBfs(root.left, ans, level+1);
        if(root.right != null)
            helperBfs(root.right, ans, level+1);
        
    }
    public List<List<Integer>> levelOrderIterative(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int qSize = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<qSize; i++){
                TreeNode curr = queue.poll();
                if(curr.left != null)
                    queue.offer(curr.left);
                if(curr.right != null)
                    queue.offer(curr.right);
                list.add(curr.val);
            }
            ans.add(list);
        }
        return ans;
    }
    
}