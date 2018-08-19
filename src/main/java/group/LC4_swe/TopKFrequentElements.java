package group.LC4;

//https://leetcode.com/problems/top-k-frequent-elements/description/

public class TopKFrequentElements {


    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return ans;
        //get a hashmap of the nos and their counts
        Map<Integer, Integer> map = new HashMap<>();
        //max heap of size k
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
               return b.count - a.count;
        }
        });
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i])+1);//incr and put it again
            else
                map.put(nums[i],1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            maxHeap.add(new Pair(entry.getKey(), entry.getValue()));
        }
        for(int i=0; i<k; i++)
            ans.add(maxHeap.poll().val);
        // System.out.println(maxHeap);
        return ans;
        
    }
}

class Pair{
    public int val;
    public int count;
    public Pair(int val, int count){
        this.val = val;
        this.count = count;
    }
}