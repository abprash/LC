package group.LC4_swe;

//https://leetcode.com/problems/max-increase-to-keep-city-skyline/description/

public class SkylineIncreasing {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int[] rowMax = new int[grid.length];
        int[] colMax = new int[grid[0].length];
        int ans = 0;
        for(int i=0; i<grid.length; i++){
            int max = Integer.MIN_VALUE;
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] > max)
                    max = grid[i][j];
            }
            rowMax[i] = max;
        }
        
        for(int i=0; i<grid[0].length; i++){
            int max = Integer.MIN_VALUE;
            for(int j=0; j<grid.length; j++){
                if(grid[j][i] > max)
                    max = grid[j][i];
            }
            colMax[i] = max;
        }
        // System.out.println(Arrays.toString(colMax));
        // System.out.println(Arrays.toString(rowMax));
        //now we have the skyline for the row wise and colwise view
        for(int i=0; i < grid.length; i++){
            for(int j=0; j < grid[0].length; j++){
                //now compute the difference
                int min = Math.min(rowMax[i], colMax[j]);
                ans += (min - grid[i][j]);
            }
        }
        return ans;
    }
}
