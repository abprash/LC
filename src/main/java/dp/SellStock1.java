package dp;

public class SellStock1 {


    public int maxProfit(int[] prices) {
        //initial validation
        if(prices == null || prices.length <= 1)
            return 0;
        int min = Integer.MAX_VALUE, maxProfit = Integer.MIN_VALUE;
        for(int i=0; i<prices.length; i++){
        	//we should always find the min first, the min should occur before the max
            if(prices[i] < min)
                min = prices[i];
            //we then calc the profit wrt to the min
            int profit = prices[i] - min;
            //then we see the max profit
            if(profit > maxProfit)
                maxProfit = profit;
        }
        return maxProfit;
    }
}