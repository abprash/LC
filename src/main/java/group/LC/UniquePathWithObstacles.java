package group.LC;

public class UniquePathWithObstacles {
	
	  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	        if(obstacleGrid == null || obstacleGrid.length == 0)
	            return 0;
	        //get length and breadth
	        int m = obstacleGrid.length, n=obstacleGrid[0].length;
	        int[][] floor = new int[m][n];
	        for(int i=0; i<m; i++){
	            //then we check if its an obstacle
	            //then we check if its the start point
	            //then we check if its in the first row or column
	            //then we calc the paths
	            for(int j=0; j<n; j++){
	                if(obstacleGrid[i][j] == 1)
	                    obstacleGrid[i][j] = 0;
	                else if(i == 0 && j == 0)
	                    obstacleGrid[i][j] = 1;
	                //this ordering is important
	                //keep in mind
	                else if(i == 0 && j>= 1){
	                    //this is for the first row
	                    obstacleGrid[i][j] = obstacleGrid[i][j-1];
	                }
	                else if(j==0 && i>= 1 ){
	                    //for the first column
	                    obstacleGrid[i][j] = obstacleGrid[i-1][j];
	                }
	                else
	                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
	            }
	        }
	        return obstacleGrid[m-1][n-1];
	    }
	  
	  public static void main(String[] args){
		  //this is an iterative solution
	  }

}
