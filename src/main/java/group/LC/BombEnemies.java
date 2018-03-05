package group.LC;

public class BombEnemies {


    int max = Integer.MIN_VALUE;
    
    public int maxKilledEnemies(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        //now whenever we find a 0, we will look for the max number of destruction possible
        for(int i=0; i < grid.length; i++){
            for(int j=0; j < grid[0].length; j++){
                if(grid[i][j] == '0'){
                    //System.out.println("here");
                    calcDamage(grid,i,j);
                }
            }
        }
        if(max == Integer.MIN_VALUE)
            return 0;
        else
            return max;
    }
    
    
    public void calcDamage(char[][] grid,int i, int j){
        if(i < 0 || i >= grid.length || j< 0 || j >= grid[0].length)
            return;
        int ans = helper(grid, i, j, true, false, -1) + helper(grid, i, j, true, false, +1) + helper(grid, i, j, false, true, -1) + helper(grid, i, j,  false, true, 1);
        //System.out.println(ans);
        if(ans > max)
            max = ans;
        
    }
    
    public int helper(char[][] grid, int i, int j, boolean isRow, boolean isColumn, int direction){
        if(i < 0 || i >= grid.length || j< 0 || j >= grid[0].length)
            return 0;
        int count = 0;
        if(grid[i][j] == 'E'){
            count = 1;
        }
        if(grid[i][j] == 'W')
            return count;//stop recursion
        if(isRow)
            return count + helper(grid, i + direction, j, isRow, isColumn, direction);
        else
            return count + helper(grid, i , j + direction, isRow, isColumn, direction);
    }
    
    
}