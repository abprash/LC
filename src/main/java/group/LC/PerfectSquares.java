package group.LC;

public class PerfectSquares {


    public int numSquares(int n) {
        
        int[] ans = new int[n+1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        //fill the first value alone with 0 - because 0 has 0 sq. roots
        ans[0] = 0;
        //we iterate from 1 to n (inclusive)
        for(int i=1; i<=n; i++){
            //assign j = 1
            //j will always iterate from 1 to j*j where the diff is +ve
            int j = 1;
            int min = Integer.MAX_VALUE;
            while(i - j*j >= 0){
                //we will compare and update min accordingly with ans
                //i - j*j should be greater or equal to 0
                //so that we can find the correspoding value in the array
                min = Math.min(min, ans[i - j*j] + 1);
                j++;
            }
            //set the ith value in the ans array
            ans[i] = min;
        }
        return ans[n];
    }
}