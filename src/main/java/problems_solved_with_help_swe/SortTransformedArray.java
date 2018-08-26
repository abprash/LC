package problems_solved_with_help_swe;

//https://leetcode.com/problems/sort-transformed-array/description/
//https://leetcode.com/problems/sort-transformed-array/discuss/146549/simple-java-solution-beats-100-solutions.

public class SortTransformedArray {


    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
    int[] result = new int[nums.length];
    int start = 0;
    int end = nums.length - 1;
    for(int i=0; i<nums.length; i++){
        int startVal = calculateQuadracticValue(nums[start], a, b, c);
        int endVal = calculateQuadracticValue(nums[end], a, b, c);
        if(a < 0){
            //parabola is open downwards
            //res will be small
            result[i] = Math.min(startVal, endVal);
            if(startVal <= endVal)
                start++;
            else
                end--;
        }
        else{
            //parabola open upwards
            //res will be big
            result[nums.length - 1 - i] = Math.max(startVal, endVal);
            //we will do the reverse of the above section
            if(startVal <= endVal)
                end--;
            else
                start++;
        }
    }
    
    return result;
}

private int calculateQuadracticValue(int x, int a, int b, int c) {
    return a * x * x + b * x + c;
}
}
