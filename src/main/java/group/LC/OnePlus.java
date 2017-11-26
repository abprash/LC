package group.LC;

public class OnePlus {

}

class Solution {
    public int[] plusOne(int[] digits) {
        
        //keep the number of digits
        int n = digits.length;
        //start from the edge
        for(int i=n-1; i>=0; i--) {
            //check if any num is less than 9, if so simply add 1 and return immediately
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            //if it comes out, then we confidently set the num to 0
            digits[i] = 0;
        }
        //we have stretched to more than the given num of digits
        int[] newNumber = new int [n+1];
        //set first num to 1 alone
        newNumber[0] = 1;
        return newNumber;
    }
}


//*********************ACCEPTED, yet shitty solution

class Solution {
    public int[] plusOne(int[] digits) {
        
        
        if(digits == null || digits.length == 0)
            return digits;
        //come from the right to left
        int[] ans ;
        if(!allNines(digits) && digits.length == 1){
            digits[0]++;
            return digits;
        }
        
        if(allNines(digits))
            ans = new int[digits.length + 1];
        else
            ans = new int[digits.length];
        
        int carry = 0;
        for(int i=0; i<ans.length-1; i++){
            if(i == 0)
                ans[ans.length - 1 - i] += digits[digits.length - 1 -i] + 1 + carry;
            else
                ans[ans.length - 1 - i] += digits[digits.length - 1 -i] + carry;
            if(ans[ans.length - 1 - i] >= 10){
                carry = 1;
                ans[ans.length - 1 - i] = ans[ans.length - 1 - i] %10;
            }
            else
                carry = 0;
            
            if(i == ans.length-2){
                //we are at the last digit
                if(digits[0] + carry < 10)
                    ans[0] = digits[0] + carry ;
                else{
                    ans[1] = (digits[0] + carry )% 10 ;
                    ans[0] = 1;
                }
            }
        }
        return ans;
        
    }
    
    public boolean allNines(int[] nums){
        for(int num : nums){
            if(num != 9)
                return false;
        }
        return true;
    }
}