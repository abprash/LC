package group.LC4_swe;

//https://leetcode.com/problems/max-area-of-island/description/

public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        //validate the input
        //ensure the grid is not null or empty
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int maxArea = 0;
        //now we start a dfs whenever we encounter a 1
        //have a separate visited grid (boolean) to keep track of where we have already visited.
        //time complexity and space complexity would be - O(N)
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    int area = helper(grid, i, j, visited);
                    //update the max area value
                    maxArea = Math.max(area, maxArea);
                    //we just visited this point, mark it
                    visited[i][j] = true;
                }
            }
        }
        return maxArea;

    }

    public int helper(int[][] grid, int i, int j, boolean[][] visited){
        if(i > grid.length-1 || j>grid[0].length-1 || i<0 || j<0 ||  visited[i][j] || grid[i][j] == 0)
            return 0;
        //mark the current point as visited
        visited[i][j] = true;
        //add 1 and spread in all 4 directions and keep adding.
        return 1 + helper(grid, i+1, j, visited) + helper(grid, i, j-1, visited) + helper(grid, i, j+1, visited) + helper(grid, i-1, j, visited);
    }
}
