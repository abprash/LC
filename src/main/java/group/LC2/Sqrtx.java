package group.LC2;


//https://leetcode.com/problems/sqrtx/discuss/

//better solution
public class Sqrtx {


    public int mySqrt(int x) {
        if(x <= 1)
            return x;
        long low = 0, high = x; //, mid = x/2;
        while(true){
        	//this is the base case
            if(high - low <= 1)
                break;
            //recursive case
            long mid = (low+high)/2;
            if(mid * mid <= x){
                low = mid;
            }
            else
                high = mid-1;
        }
        return high * high <= x ? (int) high : (int) low;
    }
}

//AC solution
//not so good
class Solution2 {
    public int mySqrt(int x) {
        if(x <= 1)
            return x;
        long newX = x;
        long mid = x/2;
        int ans = 0;
        while(true){
            //System.out.println(mid);
            if(mid*mid <= newX){
                if((mid+1) * (mid+1) > x){
                    ans = (int) mid;
                    break;
                }
                mid++;
            }
            else
                mid = mid/2;
        }
        return ans;
    }
}