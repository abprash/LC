package group.LC;

public class PathSum2 {

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        helper(root, sum, new ArrayList<>(), ans);
        return ans;
    }
    
    public void helper(TreeNode root, int sum, List<Integer> tempList,  List<List<Integer>> ans){
        if(root == null)
            return;
        if(root.left == null && root.right == null && sum - root.val == 0){
            List<Integer> l = new ArrayList<>();
            l.addAll(tempList);
            l.add(root.val);
            //tempList.add(root.val);
            ans.add(l);
            return;
        }
        List<Integer> l = new ArrayList<>();
        l.addAll(tempList);
        l.add(root.val);
        
        helper(root.left, sum - root.val, l, ans);
        helper(root.right, sum - root.val, l, ans);
    }
}