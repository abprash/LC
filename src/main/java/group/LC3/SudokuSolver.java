package group.LC;

public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        //this is a basic bruteforce and backtracking algo
        if(board == null || board.length == 0)
            return;
        solve(board);
    }
    
    public boolean solve(char[][] board){
        //this will only test each blank square with values from 1-9 and check validity in each step
        for(int i=0; i<board.length; i++){
            //navigating the cols
            for(int j=0; j<board[0].length; j++){
                //navigating each square in each selected row
                if(board[i][j] == '.'){
                    //we will start modifying only if the char is empty at that square
                    for(char c='1'; c<='9'; c++){
                        if(isValid(board, i, j, c)){
                            board[i][j] = c;
                            if(solve(board))
                                return true;
                            else
                                board[i][j] = '.';
                        }
                        
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isValid(char[][] board, int i, int j, char c){
        for(int iter=0; iter<9; iter++){
            //this method will check all the rows
            if(board[i][iter] != '.' && board[i][iter]== c)
                return false;
            //all the columns
            if(board[iter][j] != '.' && board[iter][j]== c)
                return false;
            //all the 3x3 boxes
            if(board[3* (i/3) + iter/3 ][3* (j/3) + iter%3] != '.' && board[3* (i/3) + iter/3 ][3* (j/3) + iter%3]== c)
                return false;
        }
        
        return true;
    }
}