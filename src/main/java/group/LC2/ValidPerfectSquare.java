package group.LC2;

public class ValidPerfectSquare {


	
    public boolean isPerfectSquare(int num) {
        if(num == 0)
            return true;
        //we can do binary search
        long low = 0, high = num;
        double rhs = num;
        while(low < high){
            double mid = (low + high)/2;
            double prod = mid * mid;
            //base case in the loop
            if(high - low == 1){
                if(low*low == rhs || high*high == rhs)
                    return true;
                else
                    return false;
            }
            //System.out.println(prod);
            if(prod == rhs)
                return true;
            else if(prod > rhs){
                //go left side
                high = (long) mid;
            }
            else
                low = (long) mid+1;
        }
        return false;
    }
}