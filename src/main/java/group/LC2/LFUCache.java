package group.LC2;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {
    
    Map<Integer, Integer> vals;
    Map<Integer, Integer> counts;
    Map<Integer, LinkedHashSet<Integer>> lists; 
    int capacity;
    int min = -1;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        vals = new HashMap<>();
        counts = new HashMap<>();
        lists = new HashMap<>();
        lists.put(1, new LinkedHashSet<>());
    }
    
    public int get(int key) {
        if(!vals.containsKey(key))
            return -1;
        int ans = vals.get(key);
        //update the lists and counts
        int count = counts.get(key);
        counts.put(key, count + 1);
        lists.get(count).remove(key);
        if(min == count && lists.get(count).size() == 0)
            min++;
        if(!lists.containsKey(count + 1))
            lists.put(count + 1, new LinkedHashSet<>());
        lists.get(count + 1).add(key);
        return ans;
    }
    
    public void put(int key, int value) {
        if(capacity <= 0)
            return;
        //putting a new k,v pair into the lfu cache
        //the following situations have to be handled...
        
        //one that already exists
        if(vals.containsKey(key)){
            //new pair
            vals.put(key, value);
            get(key);
            return;
        }
        
        //when the cap is exceeding the max_cap
        if(vals.size() >= capacity){
            //we need to remove the most stale element
            int evict = lists.get(min).iterator().next();
            //remove the element from the vals map
            //now we have to handle the counts and the lists maps
            vals.remove(evict);
            lists.get(min).remove(evict);
            //we are NOT returning here.... so they are updated below
            
        }
        //a new k,v pair
        vals.put(key, value);
        //update the counts
        counts.put(key, 1);
        //update the min
        min = 1;
        //update the lists
        lists.get(1).add(key);
        
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */