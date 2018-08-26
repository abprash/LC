package group.LC4_swe;

import java.util.Random;

//https://leetcode.com/problems/shuffle-an-array/description/
//https://leetcode.com/problems/shuffle-an-array/discuss/85958/First-Accepted-Solution-Java

public class ShuffleArray {

    int[] nums;
    private Random random;

    public ShuffleArray(int[] nums) {
        this.nums = nums;
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        //lets clone
        int[] temp = nums.clone();
        for(int i=1; i<nums.length; i++){
            //swap curr index and a random index
            int swapIndex = random.nextInt(i+1);
            swap(i, swapIndex, temp);
        }
        return temp;
    }
    
    public void swap(int i1, int i2, int[] nums){
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */

// TLE solved, but - getting a wrong answer for a 9th/10 test case
//dont understand why... :(

class Solution2 {
    int[] originalNums ;
    int[] shuffledNums ;
    List<List<Integer>> allPermutations;
    
    public Solution2(int[] nums) {
        this.originalNums = nums;
        this.shuffledNums = new int[nums.length];
        this.allPermutations = new ArrayList<>();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return originalNums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        //lets have a backtrack method - which will be called once - and will generate all of the permutations
        if(this.allPermutations.size() == 0){
            //empty - generate the perms now
            backtrack(this.allPermutations, new ArrayList<Integer>(), 0, this.originalNums);
            // System.out.println(allPermutations);
        }
        //now pick a random number between 0 and size of the allPermutations list
        int randomIndex = (int) (Math.random() * this.allPermutations.size());
        // System.out.println(randomIndex);
        int count = 0;
        for(int i : this.allPermutations.get(randomIndex)){
            this.shuffledNums[count] = i;
            count++;
        }
        return this.shuffledNums;
    }
    
    public void backtrack(List<List<Integer>> superList, List<Integer> list, int start, int[] nums){
        if(superList.size() >= 50)
            return;
        if(list.size() == nums.length){
            superList.add(new ArrayList(list));
            return;
        }
        for(int i=start; i<nums.length; i++){
            if(list.contains((Integer) nums[i]))
                continue;
            list.add(nums[i]);
            backtrack(superList, list, start, nums);
            list.remove(list.size()-1);
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */

//********************** TLE with the below approach
class Solution {
    int[] originalNums ;
    int[] shuffledNums ;
    List<List<Integer>> allPermutations;
    
    public Solution(int[] nums) {
        this.originalNums = nums;
        this.shuffledNums = new int[nums.length];
        this.allPermutations = new ArrayList<>();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.originalNums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        //lets have a backtrack method - which will be called once - and will generate all of the permutations
        if(this.allPermutations.size() == 0){
            //empty - generate the perms now
            backtrack(this.allPermutations, new ArrayList<Integer>(), 0, this.originalNums);
            // System.out.println(allPermutations);
        }
        //now pick a random number between 0 and size of the allPermutations list
        int randomIndex = (int) (Math.random() * this.allPermutations.size());
        // System.out.println(randomIndex);
        int count = 0;
        for(int i : this.allPermutations.get(randomIndex)){
            this.shuffledNums[count] = i;
            count++;
        }
        return this.shuffledNums;
    }
    
    public void backtrack(List<List<Integer>> superList, List<Integer> list, int start, int[] nums){
        if(list.size() == nums.length){
            superList.add(new ArrayList(list));
            return;
        }
        for(int i=start; i<nums.length; i++){
            if(list.contains((Integer) nums[i]))
                continue;
            list.add(nums[i]);
            backtrack(superList, list, start, nums);
            list.remove(list.size()-1);
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
