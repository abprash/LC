package group.LC2;

public class BiggestIsland {


    int maxArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length==0)
            return 0;
        //
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    int area = dfs(grid, visited, i, j, 1);
                    if(area > maxArea)
                        maxArea = area;
                }
            }
        }
        return maxArea;
    }
    
    public int dfs(int[][] grid, boolean[][] visited, int i, int j, int area){
        if(i<0 || j<0 || i>grid.length-1 || j>grid[0].length-1 || visited[i][j] || grid[i][j] == 0 )
            return 0;
        visited[i][j] = true;
        return 1 + dfs(grid, visited, i, j+1, area+1) +dfs(grid, visited, i+1, j, area+1) 
            + dfs(grid, visited, i-1, j, area+1) + dfs(grid, visited, i, j-1, area+1);
    }
}