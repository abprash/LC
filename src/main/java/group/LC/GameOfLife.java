package group.LC;

public class GameOfLife {

	    //hardcode all the 8 directions to check
	    int[][] dir ={{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
	    
	    public void gameOfLife(int[][] board) {
	        //initial validation
	        if(board == null || board.length == 0)
	            return;
	        //navigate the board
	        for(int i=0;i<board.length;i++){
	            for(int j=0;j<board[0].length;j++){
	                int live=0;
	                for(int[] d:dir){
	                    //checking the bounds, if invalid, we move on
	                    if(d[0]+i< 0 || d[0]+i>=board.length || d[1]+j<0 || d[1]+j>=board[0].length) continue;
	                    //we check for each direction, if there are at least 1 or 2 neightbours, then we incr the live counter
	                    if(board[d[0]+i][d[1]+j]==1 || board[d[0]+i][d[1]+j]==2) live++;
	                }
	                //we toggle the current cell based on the live status
	                //if the current cell is dead and there are 3 live neighbours surrounding it, we make it live
	                if(board[i][j]==0 && live==3) 
	                    board[i][j]=3;
	                //similarly again
	                //if the current cell is live, and there are <2 or >3 live neighbours, make it dead
	                if(board[i][j]==1 && (live<2 || live>3)) 
	                    board[i][j]=2;
	            }
	        }
	        //this is where we toggle the state,
	        //if it is live denoted by 3, dead denoted by 2, so simply mod by 2 to get the final ans
	        //second round, where we do the toggling of live and dead into 1/0
	        for(int i=0;i<board.length;i++){
	            for(int j=0;j<board[0].length;j++){
	                board[i][j] %=2;
	            }
	        }
	    }
	}