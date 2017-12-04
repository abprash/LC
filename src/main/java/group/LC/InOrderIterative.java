package group.LC;

public class InOrderIterative {

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
        Stack<TreeNode> toVisit = new Stack<>();
        
        TreeNode cur = root; 
        while(cur != null || !toVisit.isEmpty()){
            
            //put all the left nodes of the current node in first
            while(cur != null){
                toVisit.push(cur);
                cur = cur.left;
            }
            //now pop it
            cur = toVisit.pop();
            //print it
            ans.add(cur.val);
            //assign cur node to its right child
            cur = cur.right;
        }
        return ans;
    }
}
