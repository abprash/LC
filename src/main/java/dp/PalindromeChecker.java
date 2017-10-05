package dp;

import java.util.ArrayList;
import java.util.List;

public class PalindromeChecker {
	private static List<Integer> ans = new ArrayList<Integer>();
	
	public boolean checkPalindrome(String s){
		if(s.length() == 1)
			return true;
		if(s.length() == 2){
			if(s.charAt(0)==s.charAt(1))
				return true;
			else
				return false;
		}
		if(s.charAt(0) == s.charAt(s.length()-1))
			return checkPalindrome(s.substring(1,s.length()-1));
		else
			return false;
		
	}
	
	public static void main(String[] args){
		//System.out.println(new PalindromeChecker().checkPalindrome("asdfghjkhgfdsa"));
		System.out.println(new PalindromeChecker().fib(10));
		//System.out.println(ans);
		int[][] grid = new int[][] {
			{0,0,0,0,0,0,0},
			{0,1,1,0,0,0,0},
			{0,0,1,0,0,0,0},
			{0,0,0,1,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,1,1,0,0},
			{0,0,0,0,1,0,0},
			{0,0,0,0,0,1,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0}};
		System.out.println(new PalindromeChecker().countPaths(grid,0,0));
	}
	
	public int fib(int n){
		if(n == 0)
			return 0;
		else if(n == 1)
			return 1;
		else{
			int temp = fib(n-1) + fib(n-2);
			System.out.println(temp);
			return temp;
		}
	}
	
	public int countPaths(int[][] grid, int i, int j){
		//invalid cases - eliminate
		if(i < 0 || j < 0 || i >= grid.length ||   j >= grid[0].length)
			return 0;
		//base case
		if(i == grid.length-1 && j == grid[0].length-1)
			return 1;
		if(grid[i][j] != 1){
			//we go right and down
			return countPaths(grid, i,j+1) +countPaths(grid, i+1,j); 
		}
		else
			return 0;
	}

}
