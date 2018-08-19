package group.LC4;

public class Minesweeper {

    public char[][] updateBoard(char[][] board, int[] click) {
        if(board == null || click == null)
            return board;
        boolean[][] visited = new boolean[board.length][board[0].length];
        if(board[click[0]][click[1]] == 'M'){
            //game over
            board[click[0]][click[1]] = 'X';
        }
        else if(board[click[0]][click[1]] == 'E'){
            //recursively reveal all other squares as well
            //if there are any neighboring mines, change it to a number and then stop recursing
            dfs(board, click[0], click[1], visited);
        }
        return board;
    }
    
    public void dfs(char[][] board, int i, int j, boolean[][] visited){
        if(i < 0 || j < 0 || i > board.length-1 || j > board[0].length-1 || visited[i][j] || board[i][j] != 'E')
            return;
        //mark current sq as visited
        visited[i][j] = true;
        //now change the board based on the condition below
        //if there are no neighboring mines - recursive reveal
        //else - replace with a sign
        //check for neighbors
        int mineCount = getNeighborMineCount(board, i, j);
        if(mineCount > 0){
            board[i][j] =  Integer.toString(mineCount).charAt(0);
            // System.out.println("pos - "+i+","+j+" - "+mineCount);
            return;
        }
        else{
            if(board[i][j] == 'E')//change it to a b if its unrevealed mine
                board[i][j] = 'B';
            //recursively change all neighbors
            dfs(board, i-1, j-1, visited);
            dfs(board, i-1, j, visited);
            dfs(board, i-1, j+1, visited);
            dfs(board, i, j-1, visited);
            
            dfs(board, i, j+1, visited);
            dfs(board, i+1, j-1, visited);
            dfs(board, i+1, j, visited);
            dfs(board, i+1, j+1, visited);
        }
    }
    
    public int getNeighborMineCount(char[][] board, int i, int j){
        int count = 0;
        
        if(i-1 >= 0 && j >= 0 && i-1 <= board.length-1 && j <= board[0].length-1 && board[i-1][j] == 'M')
            count++;
        if(i-1 >= 0 && j-1 >= 0 && i-1 <= board.length-1 && j-1 <= board[0].length-1 && board[i-1][j-1] == 'M')
            count++;
        if(i-1 >= 0 && j+1 >= 0 && i-1 <= board.length-1 && j+1 <= board[0].length-1 && board[i-1][j+1] == 'M')
            count++;
        
        if(i+1 >= 0 && j >= 0 && i+1 <= board.length-1 && j <= board[0].length-1 && board[i+1][j] == 'M')
            count++;
        if(i+1 >= 0 && j-1 >= 0 && i+1 <= board.length-1 && j-1 <= board[0].length-1 && board[i+1][j-1] == 'M')
            count++;
        if(i+1 >= 0 && j+1 >= 0 && i+1 <= board.length-1 && j+1 <= board[0].length-1 && board[i+1][j+1] == 'M')
            count++;
        
        if(i >= 0 && j-1 >= 0 && i <= board.length-1 && j-1 <= board[0].length-1 && board[i][j-1] == 'M')
            count++;
        if(i >= 0 && j+1 >= 0 && i <= board.length-1 && j+1 <= board[0].length-1 && board[i][j+1] == 'M')
            count++;
        return count;
    }
}