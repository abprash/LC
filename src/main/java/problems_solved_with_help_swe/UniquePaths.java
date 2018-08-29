package problems_solved_with_help_swe;

//https://leetcode.com/problems/unique-paths/discuss/22954/0ms-5-lines-DP-Solution-in-C++-with-Explanations
//https://leetcode.com/problems/unique-paths/description/
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        if(m == 0 && n == 0)
            return 0;
        if(m ==  0 || n == 0)
            return 1;
        int[][] board = new int[m][n];
        int ans = 1;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(i == 0 || j == 0)
                    board[i][j] = 1;//initialize the border cells with 1, because there is only 1 way of going thro it
                else
                    board[i][j] = board[i-1][j] + board[i][j-1];
            }
        }
        return board[m-1][n-1];
    }
}