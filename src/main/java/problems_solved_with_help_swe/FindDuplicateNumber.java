package problems_solved_with_help_swe;

//https://leetcode.com/problems/find-the-duplicate-number/description/
//pigeon hole principle. basically using the same method as finding the loop in a linked list. because only finite spaces from 1 to n nos. in array.
//https://leetcode.com/articles/find-the-duplicate-number/

public class FindDuplicateNumber {


    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        //detect the cycle first
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        //find the entrance to the circle now
        //reset the fast to 0
        fast = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}