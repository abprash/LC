package group.LC4;

//https://leetcode.com/problems/design-hit-counter/description/

class HitCounter {
    Map<Integer, Integer> map ;
    /** Initialize your data structure here. */
    public HitCounter() {
        map = new HashMap<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if(map.containsKey(timestamp))
            map.put(timestamp, map.get(timestamp)+1);
        else
            map.put(timestamp, 1);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        //go back the past 5 mins alone
        int start = timestamp-300 < 0 ? 0 : timestamp-300;
        int ans = 0;
        // System.out.println("Starting -> "+start+", till ->"+timestamp);
        // System.out.println(map);
        for(int i=start+1; i <= timestamp; i++){
            ans += map.containsKey(i) ? map.get(i) : 0;
        }
        return ans;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
