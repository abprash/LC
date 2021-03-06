package group.LC;

public class AndroidUnlockPatterns {


	//https://leetcode.com/problems/android-unlock-patterns/description/
	
    public int numberOfPatterns(int m, int n) {
        //so we need to find the total number of android lock patterns possible
        //3x3 matrix
        
        //this will indicate the skip number between various pairs of nos
        int[][] skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;
        
        boolean[] visited = new boolean[10];
        
        int ans = 0;
        for(int i = m; i <= n ; i++){
            ans += helperDFS(visited, skip,  1 , i-1) * 4;//this is for 1,3,7,9
            ans += helperDFS(visited, skip,  2 , i-1) * 4; //for 2, 4, 6, 8
            ans += helperDFS(visited, skip, 5, i-1); //for 5
        }
        return ans;
        
    }
    
    public int helperDFS(boolean[] visited, int[][] skip, int cur, int remaining){
        //now we calc the number of combinations possible
        if(remaining < 0)
            return 0;
        if(remaining == 0)
            return 1;
        int ans = 0;
        //mark the cur position as visited
        visited[cur] = true;
        for(int i=1; i <= 9; i++){
            //should not be visited
            if(!visited[i]  && (skip[cur][i] == 0 || (visited[skip[cur][i]])))
                ans += helperDFS(visited, skip, i, remaining - 1);
        }
        //mark it back to non visited for the next iterations
        visited[cur] = false;
        return ans;
    }
}