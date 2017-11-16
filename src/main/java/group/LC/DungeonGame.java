package group.LC;

public class DungeonGame {

    int[][] cache;
    public int calculateMinimumHP(int[][] dungeon) {
        cache = new int[dungeon.length][dungeon[0].length];
        int ret = search(dungeon, 0, 0);
        return ret > 0 ? 1 : -ret + 1;
        //dfs + caching
    }
    private int search(int[][] matrix, int x, int y) {
        
        //initial validation
        if(x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length)
            return Integer.MIN_VALUE;
        //we have reached the princess
        if(x == matrix.length - 1 && y == matrix[0].length-1)
            return matrix[x][y] > 0 ? 0 : matrix[x][y];
        if(cache[x][y] != 0 )
            return cache[x][y] > 0 ? 0 : cache[x][y];
        
        //search further
        int down = search(matrix, x+1, y);
        int right = search(matrix, x, y+1);
        
        //we will be choosing only one of the directions, so calc the min for now
        int cur = matrix[x][y] + Math.max(right,down);
        cache[x][y] = cur;
        //if it is +ve, we shd return 0, else return original number
        return cur > 0 ? 0 : cur;
    }
}