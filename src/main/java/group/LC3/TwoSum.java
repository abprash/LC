package group.LC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> tracker = new HashMap<Integer, Integer>();
        int[] single = {0};
        int[] empty = {};
        if(nums.length == 0)
            return nums;
        if(nums.length==1 && nums[0] == target)
            return single;
        for(int i=0; i<nums.length;i++){
            if(tracker.containsKey(nums[i]) && (tracker.get(nums[i])!=i) )
                return new int[] {i,tracker.get(nums[i])};
            else
                tracker.put(target - nums[i],i);
        }
        return empty;
    }

}

//class from leetcode
class TwoSum2 {

    static int counter = 0;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    List<Integer> list = new ArrayList<>();
    /** Initialize your data structure here. */
    public TwoSum2() {
        super();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        list.add(number);
        map.put(number,counter);
        counter++;
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        //loop thro the list
        int count = 0;
        for(int i : list){
            if(map.containsKey(value - i) && (count != map.get(value-i)))
                return true;
            count++;
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
