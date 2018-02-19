package group.LC3;

public class MostFrequentSubtreeSum {

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

//brute force algo
//TLE - 58/61 cases passed

class Solution {
    int[] ans;
    //have a hashmap for <sum, count>
    Map<Integer, Integer> map = new HashMap<>();
    int maxCount = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        
        if(root == null)
            return new int[0];
        
        //now start finding the sum everytime
        int sum = root.val + sum(root.left) + sum(root.right);
        if(!map.containsKey(sum)){
            maxCount = Math.max(maxCount, 1);
            map.put(sum,1);
        }
        else{
            maxCount = Math.max(map.get(sum)+1, maxCount);
            map.put(sum, map.get(sum)+1);
        }
        //go further down
        findFrequentTreeSum(root.left);
        findFrequentTreeSum(root.right);
        
        //get the max counts
        int len = 0;
        
        List<Integer> list = new ArrayList();
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            if(e.getValue() == maxCount)
                list.add(e.getKey());
        }
        
        //conv the list to an array and return
        ans = new int[list.size()];
        for(int i =0; i<list.size(); i++)
            ans[i] = list.get(i);
        
        return ans;
    }
    
    public int sum(TreeNode root){
        if(root == null)
            return 0;
        return root.val + sum(root.left) + sum(root.right);
    }
}