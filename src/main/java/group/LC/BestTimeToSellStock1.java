package group.LC;



class Solution {
    public int maxProfit(int[] prices) {
        //initial validation
        if(prices == null || prices.length <= 1)
            return 0;
        int min = Integer.MAX_VALUE, maxProfit = Integer.MIN_VALUE;
        for(int i=0; i<prices.length; i++){
           
            //check if the element is lesser than min
            //this has to be done first
            if(prices[i] < min)
                min = prices[i];
            
            //first lets see if the current profit is bigger than the maxProfit
            if(prices[i] - min > maxProfit)
                maxProfit = prices[i] - min;
           
            
        }
        return maxProfit;
    }
}

public class BestTimeToSellStock1 {

	public int maxProfit(int[] prices) {
        if(prices == null)
            return 0;
        int profit = 0, min = Integer.MAX_VALUE;
        for(int i=0; i<prices.length; i++){
            if(prices[i] < min)
                min = prices[i];
            int tempDiff = prices[i] - min;
            if(tempDiff > profit )
                profit = tempDiff;
        }
        return profit;
    }
}
