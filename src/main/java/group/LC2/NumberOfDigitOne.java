package group.LC2;

public class NumberOfDigitOne {

}

class Solution2 {
    
    //https://leetcode.com/problems/number-of-digit-one/discuss/64382/JavaPython-one-pass-solution-easy-to-understand
    
    public int countDigitOne(int n) {
        if(n <= 0)
            return 0;
        //
        int restOfNum = n, x = 1, ans = 0;
        while(restOfNum > 0){
            int digit = restOfNum % 10;
            restOfNum /= 10;
            //based on the type of digit, do the foll operations
            
            ans += restOfNum*x;
            if(digit == 1)
                ans += n % x + 1;
            if(digit > 1)
                ans += x;
            
            //since we are coming from right to left, in every iteration, mult x by 10
            x *= 10;
        }
        return ans;
    }
}

//Brute force - TLE

class Solution {
    public int countDigitOne(int n) {
        //brute force
        if(n <= 0)
            return 0;
        int res = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            String num = Integer.toString(i);
            if(num.contains("1")){
                for(int j=0; j<num.length(); j++){
                    if(num.charAt(j) == '1')
                        res++;
                }        
                //sb.append(i);
            }
        }
        
        return res;
    }
}