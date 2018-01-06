package group.LC2;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if(amount < 0)
            return 0;
        int[] count = new int[amount];
        return helper(coins, amount, count);
    }
    
    public int helper(int[] coins, int balance, int[] count){
        //count will store the min coins from [1 to amount]
        //balance is the balance amount to account for
        //coins are the coins provided
        
        if(balance < 0)
            return -1;
        if(balance == 0)
            return 0;
        if(count[balance - 1] != 0)
            return count[balance - 1]; //return the best calc value so far
        int min = Integer.MAX_VALUE;
        for(int coin : coins){
            int tempRes =  helper(coins, balance - coin, count);
            if(tempRes >= 0 && tempRes < min) //replace the min value with the calc min value
                min = 1 + tempRes;//add one more coin
        }
        count[balance - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[balance - 1];
    }
}