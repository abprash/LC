package group.LC;

public class UniquePaths_1 {

	public int uniquePaths(int m, int n) {
        int[][] floor = new int[m][n];
        if(m == 1 || n == 1)
            return 1;
        for(int i=0; i<m; i++)
            floor[i][0] = 1;
        for(int i=0; i<n; i++)
            floor[0][i] = 1;
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                floor[i][j] = floor[i-1][j] + floor[i][j-1];
            }
        }
        return floor[m-1][n-1];
    }
	
	public static void main(String[] args){
		
	}
}
