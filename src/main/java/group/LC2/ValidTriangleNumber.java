package group.LC2;
import java.util.*;

//https://leetcode.com/problems/valid-triangle-number/discuss/104174/Java-O(n2)-Time-O(1)-Space
public class ValidTriangleNumber {


    public int triangleNumber(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        //sort them
        Arrays.sort(nums);
        int res = 0;
        for(int i=2; i<nums.length; i++){
            int left = 0, right = i - 1;
            while(left < right){
                if(isTriangle(nums[i], nums[left], nums[right])){
                    res+= right-left;
                    right--;
                }
                else
                    left++;
            }
        }
        return res;
    }
    
    public boolean isTriangle(int a, int b, int c){
        return a+b>c && b+c>a && a+c>b;
    }
}