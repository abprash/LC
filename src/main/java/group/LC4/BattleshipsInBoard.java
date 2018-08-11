package group.LC4;

public class BattleshipsInBoard {

	//https://leetcode.com/problems/battleships-in-a-board/description/

    public int countBattleships(char[][] board) {
        if(board == null || board.length == 0)
            return 0;
        int ans = 0;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                
                if(board[i][j] == 'X' && ((i == 0 || board[i-1][j] == '.') && (j == 0 || board[i][j-1] == '.')))
                    ans++; //based on the shape, this will consider either the first X or the last X in the battleship
            }
        }
        return ans;
    }
}