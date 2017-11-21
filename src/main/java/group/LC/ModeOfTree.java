package group.LC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModeOfTree {


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	Map<Integer, Integer> map = new HashMap<>();
	    int max = 0;
	    public int[] findMode(TreeNode root) {
	        if(root == null)
	            return new int[]{};
	        //invoke helper
	        helper(root);
	        System.out.println(max);
	        //return mode from map
	        return calcMode(map);
	    }
	    
	    public void helper(TreeNode root){
	        //
	        if(root == null)
	            return;
	        if(map.containsKey(root.val)){
	            int temp = map.get(root.val) + 1;
	            if(temp > max)
	                max = temp;
	            map.put(root.val, temp);
	        }
	        else{
	            map.put(root.val, 1);
	            if(1 > max)
	                max = 1;
	        }
	        helper(root.left);
	        helper(root.right);
	    }
	    
	    public int[] calcMode(Map<Integer, Integer> map){
	        //iterate thro the map
	        List<Integer> list = new ArrayList<>();
	        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
	            if(entry.getValue() == max){
	                list.add(entry.getKey());
	            }
	        }
	        //conv list to array
	        int[] ans = new int[list.size()];
	        for(int i=0; i<list.size(); i++)
	        	ans[i] = list.get(i);
	        return ans;
	    }
	}