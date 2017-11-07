package dp;

import java.util.Arrays;

public class LargestCommonSubsequence {
	
	public static int longestCommonSubsequence(String s1, String s2){
		//we have to have a 2d array
		//initial validation
		if(s1 == null || s2 == null)
			return 0;
		if(s1.length() == 0 || s2.length() == 0)
			return 0;
		
		int[][] ans = new int[s1.length()][s2.length()];
		for(int i=0; i<s1.length(); i++){
			ans[i][0] = 0;
		}
		int max = Integer.MIN_VALUE;
		for(int i=0; i<s1.length(); i++){
			for(int j=0; j<s2.length(); j++){
				if(s1.charAt(i) == s2.charAt(j)){
					//we simply increment the number from its diag upper left element on the table
					if(i-1 >=0 && j-1 >=0){
						ans[i][j] = ans[i-1][j-1]+1;
					}
					else
						ans[i][j] = 1;
				}
				else{
					if(i-1 >=0 && j-1 >=0){
						ans[i][j] = Math.max(ans[i][j-1], ans[i-1][j]);
					}
					else
						ans[i][j] = 0;
				}
				if(ans[i][j] > max)
					max = ans[i][j];
			}
		}
		
		for(int i=0; i<ans.length; i++){
			System.out.println(Arrays.toString(ans[i]));
		}
		
		return max;
	}
	
	public static void main(String[] args){
		System.out.println(longestCommonSubsequence("abcdef","dabdcefjagajg"));
	}
}
