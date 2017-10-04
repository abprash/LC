package group.LC;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {
	//****
	//79/87 test cases passing
	//****
	//we have the other 3 directions to go
    //we need to have a visited flag
    //to store the positions visited
    //or some mechanism to keep track of the positions visited
	
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
                    deepSearch(i,j,word,0,0, board);
                    if(isFound)
                        return true;
                }
            }
        }
        return false;
    }
    public void deepSearch(int i, int j, String word, int startPos, int incomingDir, char[][] board){
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
                    if(j-1 >= 0 && startPos < word.length())
                    	deepSearch(i,j-1,word, startPos+1, 3, board);
                }
                else if(i1 == 2){
                    //we have to go right
                    //but we will be incoming as left in the next cell
                    if(i+1 < board.length && startPos < word.length())
                    	deepSearch(i+1,j,word, startPos+1, 4, board);
                }
                else if(i1 == 3){
                    //we have to go down
                    //but we will be incoming as up in the next cell
                    if(j+1 < board[0].length && startPos < word.length())
                    	deepSearch(i,j+1,word, startPos+1, 1, board);
                }
                else if(i1 == 4){
                    //we have to go left
                    //but we will be incoming as right in the next cell
                    if(i-1 >= 0 && startPos < word.length())
                    	deepSearch(i-1,j,word, startPos+1, 2, board);
                }
            }
        }
    }
    
    
    //*****************************************************
    //actual right implementation
    //all cases passed !!!!!!!!!!!
    static boolean[][] visited ;
    public boolean exist2(char[][] board, String word) {
        if(board == null)
            return false;
        
        int m = board.length, n = board[0].length;
        visited = new boolean[m][n];
        for(int i=0; i<m ; i++){
            for(int j=0; j<n; j++){
                if(word.charAt(0) == board[i][j] && deepSearch(i,j,word,board, 0)) return true;
            }
        }
        return false;
        
    }
    
    public boolean deepSearch(int i, int j, String word, char[][] board, int index){
        if(index == word.length())    
            return true;//we are over the word
        //all bounds checking
        if(i<0 || j <0 || i>=board.length || j>=board[0].length || word.charAt(index) != board[i][j] || visited[i][j])
            return false;
        visited[i][j] = true;
        if(deepSearch(i+1,j,word,board,index+1) || 
          deepSearch(i-1,j,word,board,index+1) || 
          deepSearch(i,j-1,word,board,index+1) || 
          deepSearch(i,j+1,word,board,index+1))
            return true;
        
        //resetting it so that we know that starting point is now fresh to parse again
        visited[i][j] = false;
        return false;
    }
}