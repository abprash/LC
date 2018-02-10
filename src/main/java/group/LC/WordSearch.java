package group.LC;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {
	
    
    
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
    
    //*********************** Another implementation using SB
    //is not working... use indices itself.. much simpler
    
   //boolean[][] visited ;
        public boolean exist(char[][] board, String word) {
            if(board == null)
                return false;
            StringBuilder sb = new StringBuilder();
            int m = board.length, n = board[0].length;
            visited = new boolean[m][n];
            for(int i=0; i<m ; i++){
                for(int j=0; j<n; j++){
                    if(word.charAt(0) == board[i][j] && deepSearch(i,j,word,board, sb)) 
                        return true;
                    sb = new StringBuilder();
                }
            }
            return false;
            
        }
        
        public boolean deepSearch(int i, int j, String word, char[][] board, StringBuilder sb){
            System.out.println(sb);
            //check validity
            if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j])
                return false;
            //add the curr letter
            sb.append(board[i][j]);
            int prevLen = sb.length();
            //compare
            if(sb.length() == word.length() && sb.toString().equals(word))
                return true;
            if(sb.length() > word.length())
                return false;
            //mark this as a visited node
            visited[i][j] = true;
            
            //go in all 4 directions
            if(deepSearch(i, j+1, word, board, sb)||
            deepSearch(i+1, j, word, board, sb) ||
            deepSearch(i, j-1, word, board, sb) || 
            deepSearch(i-1, j, word, board, sb))
                return true;
            
            //if it comes here, it means that we need to reset visited
            visited[i][j] = false;
            sb.setLength(prevLen);
            return false;
            
        }
        
        public static void main(String[] args){
        	char[][] board = {{'A','C','W','R'},
        					  {'Q','A','D','E'},
        					  {'W','B','C','D'},
        					  {'W','Q','A','E'}};
        	String word = "ABCDE";
        	System.out.println(new WordSearch().exist2(board, word));
        }
    
}