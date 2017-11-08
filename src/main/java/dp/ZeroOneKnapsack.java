package dp;

import java.util.Arrays;

public class ZeroOneKnapsack {
	/*
	 * Called 0/1 because we cannot split the items, they are binary in nature. Either they are in or out.
	 * Given: weights and their corresponding values, and max allowed weight
	 * Aim:
	 * To return the max value possible within the given weights
	 * 
	*/
	
	public static int zeroOneKnapsack(int[] weights, int[] values, int totalWeight){
		
		//initial validation
		
		//
		int[][] ans = new int[weights.length][totalWeight+1];
		/*for(int i=0; i<ans.length; i++){
			//because we cannot possibly fill any items if the max allowed weight itself is 0
			ans[i][0] = 0;
		}*/
		for(int i=0; i<ans.length; i++){
			for(int j=1; j<ans[i].length; j++){
				System.out.println(i+","+Arrays.toString(ans[i]));
				if(i == 0 || j == 0){
					ans[i][j] = 0;
					continue;
				}
				if(j - weights[i] >= 0){
					ans[i][j] = Math.max(ans[i-1][j],ans[i-1][j -  weights[i]] + values[i]);
				}
				else
					ans[i][j] = ans[i-1][j];
				
				
			}
		}
		
		for(int i=0; i<ans.length; i++){
			System.out.println(Arrays.toString(ans[i]));
		}
		
		return 1;
	}
	
	
	public  static int bottomUpDP(int wt[], int val[], int W){
        int K[][] = new int[val.length+1][W+1];
        for(int i=0; i <= val.length; i++){
            for(int j=0; j <= W; j++){
                if(i == 0 || j == 0){
                	//this will have to be 0, which means, 
                	// i==0 means is an element with 0 weight, and 
                	//j == 0, means the max allowed weight is 0
                    K[i][j] = 0;
                    continue;
                }
                //we should check if the weight is still below or equal to the max allowed limit
                if(j - wt[i-1] >= 0){
                	//we are calc the max between
                	//NOT including the newly calc weight, and incl the new weight (and cal the new value)
                    K[i][j] = Math.max(K[i-1][j], K[i-1][j-wt[i-1]] + val[i-1]);
                }else{
                	//if above condition fails, we do not include the new value
                	//we directly use the value immediately above
                    K[i][j] = K[i-1][j];
                }
            }
        }
        for(int i=0; i<K.length; i++){
			System.out.println(Arrays.toString(K[i]));
		}
        return K[val.length][W];
    }

	public static void main(String[] args){
		
		zeroOneKnapsack(new int[]{1,3,4,5}, new int[]{1,4,5,7}, 7);
		System.out.println("==================");
		bottomUpDP(new int[]{1,3,4,5}, new int[]{1,4,5,7}, 7);
	}

}
