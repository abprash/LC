package group.LC;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {
	
    private boolean isFound = false;
    public boolean exist(char[][] board, String word) {
        if(board == null || word == null)
            return false;
        if(word.length() == 0)
            return true;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    //call further search
                    furtherSearch(i,j,word,0,4, board);
                }
            }
        }
        if(isFound)
            return true;
        return false;
    }
    public void furtherSearch(int i, int j, String word, int startPos, int incomingDir, char[][] board){
        List<Integer> availableDirections = new ArrayList<>();
        availableDirections.add(1);
        availableDirections.add(2);
        availableDirections.add(3);
        availableDirections.add(4);
        availableDirections.remove(Integer.valueOf(incomingDir));
        //we have the other 3 directions to go
        if(word.charAt(startPos) == board[i][j]){
            if(startPos == word.length() - 1){
                isFound=true;
                return;
            }
            for(int i1 : availableDirections){
                if(i1 == 1){
                    //we have to go up
                    //but we will be incoming as down in the next cell
                    if(j-1 >= 0 )
                        furtherSearch(i,j-1,word, startPos+1, 3, board);
                }
                else if(i1 == 2){
                    //we have to go right
                    //but we will be incoming as left in the next cell
                    if(i+1 < board.length)
                        furtherSearch(i+1,j,word, startPos+1, 4, board);
                }
                else if(i1 == 3){
                    //we have to go down
                    //but we will be incoming as up in the next cell
                    if(j+1 < board[0].length)
                        furtherSearch(i,j+1,word, startPos+1, 1, board);
                }
                else if(i1 == 4){
                    //we have to go left
                    //but we will be incoming as right in the next cell
                    if(i-1 >= 0)
                        furtherSearch(i-1,j,word, startPos+1, 2, board);
                }
            }
        }
    }
    
}