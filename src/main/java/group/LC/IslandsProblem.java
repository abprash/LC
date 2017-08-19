package com.leetcode.www;

import java.util.Arrays;

public class IslandsProblem {
	public static void main(String[] args) {
		int grid[][]=  new int[][] {{1, 1, 0, 0, 0},
            {1$
			, 1, 0, 0, 1},
            {1, 0, 0, 1, 1},
            {1, 0, 0, 0, 0},
            {1, 0, 1, 0, 1}
           };
		getNumberOfIslands(grid);
	}

	/*
	 * public static int getNumberOfIslands(int[][] grid) {
	 * ArrayList<IslandCoordinate> visited= new ArrayList<IslandCoordinate>();
	 * //iterate through all the locations in the grid //keep a list of
	 * coordinates which are 1 and add them to the visited list //before going
	 * into loop, check if the object is present in the list int countIslands =
	 * 0; Iterator<IslandCoordinate> iter = visited.iterator(); for(int
	 * i=0;i<grid.length;i++) { for(int j=0;j<grid[i].length;j++) { //now i,j is
	 * your coordinate system if(grid[i][j] == 1) { int visitedFlag = 0; //check
	 * if we have already visited it
	 * 
	 * while(iter.hasNext()) { IslandCoordinate temp = iter.next(); if(temp.x ==
	 * i && temp.y == j) { visitedFlag = 1; break; } } if(visitedFlag == 1)
	 * continue; visited.add(new IslandCoordinate(i, j)); //we have an island
	 * people //check the other 4 parts of it if(i-1 >= 0 && grid[i-1][j] == 1)
	 * visited.add(new IslandCoordinate(i-1, j)); if(i+1 < grid.length &&
	 * grid[i+1][j] == 1) visited.add(new IslandCoordinate(i+1, j)); if(j-1 >= 0
	 * && grid[i][j-1] == 1) visited.add(new IslandCoordinate(i, j-1)); if(j+1 <
	 * grid[i].length && grid[i][j+1] == 1) visited.add(new IslandCoordinate(i,
	 * j+1));
	 * 
	 * if(i+1 >grid.length && j+1 < grid[i].length && grid[i][j+1] == 1)
	 * visited.add(new IslandCoordinate(i+1, j+1)); if(i-1 >grid.length && j-1
	 * >=0 && grid[i][j+1] == 1) visited.add(new IslandCoordinate(i-1, j-1));
	 * if(i+1 >grid.length && j-1 >=0 && grid[i][j+1] == 1) visited.add(new
	 * IslandCoordinate(i+1, j-1)); if(i-1 >=0 && j+1 < grid[i].length &&
	 * grid[i][j+1] == 1) visited.add(new IslandCoordinate(i-1, j+1));
	 * countIslands++; } }
	 * 
	 * } System.out.println(countIslands); return countIslands; } }
	 * 
	 * class IslandCoordinate { int x; int y; public IslandCoordinate(int a, int
	 * b) { x = a; y = b; }
	 */

	// issafe
	// dfs
	public static boolean isSafe(int[][] grid, int i, int j, boolean[][]visited)
	{
		return (i >= 0 && j >= 0 && i < grid.length && j < grid[i].length && grid[i][j] == 1 && !visited[i][j]);
	}

	public static void DFS(int[][] grid,int i, int j, boolean[][] visited)
	{
		//
		int[] rowNbrs = {-1, +1, 0, 1, -1, +1, 0, -1};
		int[] colNbrs = {-1, +1, 1, 0, +1, -1, -1, 0};
		
		//mark this as visited
		visited[i][j] = true;
		//now check all the other neighbours
		for(int k = 0; k < 8; k++){
			if(isSafe(grid,i+ rowNbrs[k], j +colNbrs[k], visited))
				DFS(grid,i + rowNbrs[k], j +colNbrs[k], visited);
		}
	}

	public static int getNumberOfIslands(int[][] grid)
	{
		int rows = grid.length;
		int cols = grid[1].length;
		int count = 0;
		boolean[][] visited = new boolean[rows][cols];
		for(int i=0;i<grid.length;i++)
		{
			for(int j=0;j<grid[i].length;j++)
			{
				if(grid[i][j]==1 && !visited[i][j])
				{	
					DFS(grid,i,j,visited);
					++count;
				}
			}
		}
		System.out.println(count);
		System.out.println(Arrays.toString(visited[0]));
		
		return count;
	}
}
