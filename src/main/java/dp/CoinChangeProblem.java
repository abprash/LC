package dp;

import java.util.Arrays;

public class CoinChangeProblem {
	
	//assuming that each denominations are of infinte supply
	public static void coinChangeProblem(int[] denominations, int target){
		
		//now we define the recursive pattern as follows
		//this will contain the answer
		int[] ans = new int[target+1];
		int[] constituents = new int[target+1];
		ans[0] = 0;
		for(int i=1; i<ans.length; i++){
			
			ans[i] = Integer.MAX_VALUE;
		}
		for(int i=0; i<denominations.length; i++){
			//fill it with the int max value
			for(int j=1; j<ans.length; j++){
				
				System.out.println(Arrays.toString(ans));
				//the recurrence is basically 
				//the count if we do not include the coin, or else if we include the current coin
				if(j - denominations[i] < ans.length && j - denominations[i] >= 0){
					ans[j] = Math.min(ans[j], 1 + ans[j - denominations[i]]);
					
					//then we need to update the last used coin
					constituents[j] = i;
				}
			}
		}
		System.out.println(" Number of coins for individual totals == "+Arrays.toString(ans));
		System.out.println("constituents == "+Arrays.toString(constituents));
		System.out.println(ans[target]);
	}
	
	public static void main(String[] args){
		coinChangeProblem(new int[]{7,3,1,6},13);
	}

}
