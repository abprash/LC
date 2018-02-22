package group.LC;

public class RemoveDuplicatesFromArray {
public int removeDuplicates(int[] nums) 
{
   if(nums == null)
       return 0;
    if(nums.length == 1)
        return 1;
    int p1 = 1;
    for( int i=1; i<nums.length; i++){
        if(nums[i] > nums[i-1]){
            nums[p1] = nums[i];
            p1++;
        }
    }
    return p1;
}

public static void main(String[] args){
	System.out.println(Integer.MAX_VALUE);
}
}