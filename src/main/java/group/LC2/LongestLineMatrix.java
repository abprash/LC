package group.LC2;

public class LongestLineMatrix {
	
	//****************** BEtter DP approach

	
	
	class Solution {
	    public int longestLine(int[][] M) {
	        if(M == null || M.length == 0 || M[0].length == 0)
	            return 0;
	        int max = 0;
	        int [][][] dp = new int[M.length][M[0].length][4];
	        for(int i=0; i<M.length; i++){
	            for(int j=0; j<M[0].length; j++){
	                if(M[i][j] == 1){
	                    //check to the left
	                    //check up
	                    //check left diag
	                    //check right diag
	                    dp[i][j][0] = j > 0 ? dp[i][j - 1][0] + 1 : 1;
	                    dp[i][j][1] = i > 0 ? dp[i - 1][j][1] + 1 : 1;
	                    dp[i][j][2] = (i > 0 && j > 0) ? dp[i - 1][j - 1][2] + 1 : 1;
	                    dp[i][j][3] = (i > 0 && j < M[0].length - 1) ? dp[i - 1][j + 1][3]+1 : 1;
	                    max = Math.max(max, Math.max(Math.max(dp[i][j][0], dp[i][j][1]), Math.max(dp[i][j][2], dp[i][j][3])));
	                }
	            }
	        }
	        return max;
	    }
	}
	
	//********************************

    //the count
    int count = Integer.MIN_VALUE;
    
    public int longestLine(int[][] M) {
        if(M == null || M.length == 0)
            return 0;
        for(int i=0; i<M.length; i++){
            for(int j=0; j<M[0].length; j++){
                if(M[i][j] == 1){
                    //call method to go right
                    goRight(M, i, j, 0);
                    //go down
                    goDown(M, i, j, 0);
                    //go diagonally
                    goDiagonalRight(M, i, j, 0);
                    goDiagonalLeft(M, i, j, 0);
                }
            }
        }
        
        return count==Integer.MIN_VALUE ? 0 : count;
    }
    
    
    public void goRight(int[][] M, int i, int j, int countSoFar){
        if(i<0 || j<0 || i>M.length-1 || j>M[0].length-1 || M[i][j] == 0){
            //check the count so far
            if(countSoFar > count)
                count = countSoFar;
            return;
        }
        goRight(M, i, j+1, countSoFar+1);
    }
    
    public void goDown(int[][] M, int i, int j, int countSoFar){
        if(i<0 || j<0 || i>M.length-1 || j>M[0].length-1 || M[i][j] == 0){
            //check the count so far
            if(countSoFar > count)
                count = countSoFar;
            return;
        }
        goDown(M, i+1, j, countSoFar+1);
    }
    public void goDiagonalRight(int[][] M, int i, int j, int countSoFar){
        if(i<0 || j<0 || i>M.length-1 || j>M[0].length-1 || M[i][j] == 0){
            //check the count so far
            if(countSoFar > count)
                count = countSoFar;
            return;
        }
        goDiagonalRight(M, i+1, j+1, countSoFar+1);
    }
    public void goDiagonalLeft(int[][] M, int i, int j, int countSoFar){
        if(i<0 || j<0 || i>M.length-1 || j>M[0].length-1 || M[i][j] == 0){
            //check the count so far
            if(countSoFar > count)
                count = countSoFar;
            return;
        }
        goDiagonalLeft(M, i+1, j-1, countSoFar+1);
    }
}