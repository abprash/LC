package group.LC2;

public class MinimumPathSum {
    

	    
	    int sum = Integer.MAX_VALUE;
	    
	    public int minPathSum(int[][] grid) {
	        if(grid == null || grid.length == 0)
	            return 0;
	        //
	        int row = grid.length;
	        int col = grid[0].length;
	        //we can only go right and down
	        //non negative nos.
	        for(int i=0; i<row; i++){
	            for(int j=0; j<col; j++){
	                if(i == 0 && j == 0 )
	                    grid[i][j] = grid[i][j];//this is the starting node
	                
	                //the general rule being,
	                //for the current cell, we take the min of the prev aka the upper and the left cell
	                //if we are inner to the matrix, then we take the min of the left and up to the current cell
	                
	                else if(i==0 && j!=0)
	                    grid[i][j] = grid[i][j] + grid[i][j-1];//there is no upper cell, so by default we take the left cell and run with it 
	                
	                else if(i!=0 && j==0)
	                    grid[i][j] = grid[i][j] + grid[i-1][j];//there is no left cell, so by default we take the upper cell and run with it
	                
	                else{
	                    grid[i][j] = grid[i][j] + Math.min(grid[i-1][j], grid[i][j-1]);
	                }
	            }
	        }
	        //
	        return grid[row-1][col-1];
	    }

}