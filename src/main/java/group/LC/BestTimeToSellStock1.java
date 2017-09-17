package group.LC;

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
