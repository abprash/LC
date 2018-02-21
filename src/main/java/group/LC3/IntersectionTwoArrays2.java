package group.LC3;

import java.util.*;

public class IntersectionTwoArrays2 {

	//https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
	
    public int[] intersect(int[] nums1, int[] nums2) {
        //use a hashmap
        int[] ans;
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return new int[0];
        //entry - <num, count>
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0; i<nums1.length; i++){
            if(!map.containsKey(nums1[i]))
                map.put(nums1[i], 1);
            else
                map.put(nums1[i], map.get(nums1[i])+1);
        }
        List<Integer> l = new ArrayList<>();
        for(int i=0; i<nums2.length; i++){
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0){
                l.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);
            }
        }
        //convert the list to an array
        ans = new int[l.size()];
        for(int i=0; i<l.size(); i++)
            ans[i] = l.get(i);
        return ans;
    }
}