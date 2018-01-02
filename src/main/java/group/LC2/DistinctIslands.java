package group.LC2;

public class DistinctIslands {

    boolean[][] visited;
    int count = 0;
    String s = "";
    public int numDistinctIslands(int[][] grid) {
        if(grid == null || grid.length == 0)
            return count;
        Set<String> set = new HashSet<>();
        visited = new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    dfs(i, j, grid);
                    count++;
                    //System.out.println(s);
                    set.add(s);
                    s = "";
                }
            }
        }
        return set.size();
    }
    
    public void dfs(int i, int j,  int[][] grid){
        if(i < 0 || j < 0 || i > grid.length-1 || j > grid[0].length-1 || visited[i][j] || grid[i][j]!=1){
            s+="O";
            return;
        }
        s+="X";
        visited[i][j] = true;
        dfs(i, j+1, grid);
        dfs(i, j-1, grid);
        dfs(i+1, j, grid);
        dfs(i-1, j, grid);
    }
}