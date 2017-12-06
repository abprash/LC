package group.LC;

public class MissingRanges {

}
//Accepted solution
//************************************

class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        if(nums == null || nums.length == 0){
            String x = (upper != lower) ? lower+"->"+upper : lower+"";
            ans.add(x);
            return ans;
        }
        if(nums.length == 1){
            long l = nums[0] - lower;
            long r = upper - nums[0];
            if(l != 0 && r != 0){
                if(lower != (nums[0]-1))
                        ans.add(lower +"->"+(nums[0]-1));
                    else
                        ans.add(lower+"");
                if((nums[0] + 1) != upper)
                        ans.add((nums[0] + 1) +"->"+upper);
                    else
                        ans.add(upper+"");
            }
            if(l == 0 && r == 0)
                return ans;
            else if(l == 0 || r == 0){
                if(l != 0){
                    if(lower != (nums[0]-1))
                        ans.add(lower +"->"+(nums[0]-1));
                    else
                        ans.add(lower+"");
                }
                else{
                    if((nums[0] + 1) != upper)
                        ans.add((nums[0] + 1) +"->"+upper);
                    else
                        ans.add(upper+"");
                }
            }
            return ans;
        }
        //****************************************
        
        
        //handle the first element diffeently
        if(nums[0] != lower){
            if(lower != nums[0]-1)
                ans.add(lower+"->"+(nums[0]-1));
            else
                ans.add(lower+"");
        }
       for(int i=0; i<nums.length-1; i++){
           //we will compare pairs of elements
           long res =(long) nums[i+1] - nums[i];
           //System.out.println((long) nums[i+1] - nums[i]);
           //System.out.println(res);
           if(res == 2 ){
               //there is just one element
               ans.add((nums[i]+1)+"");
           }
           else if(res > 2){
               ans.add((nums[i] + 1) +"->"+(nums[i+1] - 1));
           }
       }
        if(nums.length > 1 && nums[nums.length-1] != upper ){
            if((nums[nums.length-1] + 1) != upper)
                ans.add((nums[nums.length-1] + 1)+"->"+(upper));
            else
                ans.add((nums[nums.length-1] + 1)+"");
        }
        return ans;
            
    }
}

//Passed 30/40 solutions - not efficient enough
//TLE on the last one

class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        if(nums == null || nums.length == 0){
            String x = (upper != lower) ? lower+"->"+upper : lower+"";
            ans.add(x);
            return ans;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< nums.length; i++){
            map.put(nums[i],1);
        }
        List<Integer> temp = new ArrayList<>();
        for(int i=lower; i<= upper; i++){
            if(map.containsKey(i)){
                //check if it is present - its present in the map,
                //so add the list formed so far
                
                if(temp.size() >= 2){
                    //get first and last elements
                    ans.add(temp.get(0)+"->"+temp.get(temp.size()-1));
                }
                else if(temp.size()==1)
                    ans.add(temp.get(0)+"");
                
                temp = new ArrayList<>();
                //so reinitialize it
            }
            else{
                temp.add(i);
            }
        }
        if(temp.size() >= 2){
            //get first and last elements
            ans.add(temp.get(0)+"->"+temp.get(temp.size()-1));
        }
        else if(temp.size() == 1)
            ans.add(temp.get(0)+"");
        return ans;
            
    }
}