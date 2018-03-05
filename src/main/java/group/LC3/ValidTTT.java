package group.LC3;

public class ValidTTT {


	//https://leetcode.com/problems/valid-tic-tac-toe-state/description/
	
	
	
    public boolean validTicTacToe(String[] board) {
        //lets validate it
        //to check
        if(board.length != 3)
            return false;
        if(board[0].length() != 3 || board[1].length() != 3 || board[2].length() != 3  )
            return false;
        //check if its player 1
        String moves = (board[0] + board[1] + board[2]).trim();
        if(moves.length() == 1 && moves.equals("O"))
            return false;
        int x = 0, o = 0;
        //number of xs and os
        for(int i=0; i < moves.length(); i++){
            if(moves.charAt(i) == 'X')
                x++;
            if(moves.charAt(i) == 'O')
                o++;
        }
        if(x!= o && x < o + 1)
            return false;
        if(x > o && x > o+1)
            return false;
        //check for wins
        int p1Win = 0, p2Win = 0;
        //check the diag
        if(board[0].charAt(0) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(2) == 'X')
            p1Win++;
        if(board[0].charAt(0) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(2) == 'O')
            p2Win++;
        
        //anti diag
        if(board[0].charAt(2) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(0) == 'X')
            p1Win++;
        if(board[0].charAt(2) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(0) == 'O')
            p2Win++;
        
        //check the rows
        for(String row : board){
            if(row.charAt(0) == 'X' && row.charAt(1) == 'X' && row.charAt(2) == 'X')
                p1Win++;
            if(row.charAt(0) == 'O' && row.charAt(1) == 'O' && row.charAt(2) == 'O')
                p2Win++;
        }
        
        //check for cols
        
        for(int i=0; i<board.length; i++){
            if(board[0].charAt(i) == 'X' && board[1].charAt(i) =='X' && board[2].charAt(i) == 'X')
                p1Win++;
            if(board[0].charAt(i) == 'O' && board[1].charAt(i) =='O' && board[2].charAt(i) == 'O')
                p2Win++;
        }
        
        if(p1Win == 0 && p2Win == 0)
            return true;
        if(p1Win > 0 && p2Win > 0)
            return false;
        if((p1Win == 1 && p2Win == 0) || (p1Win == 0 && p2Win == 1)){
            if(p1Win == 1){
                if(x == o+1)
                    return true;
                else
                    return false;
            }
            if(p2Win == 1){
                if(o == x)
                    return true;
                else
                    return false;
            }
        }
        return true;        
    }
}