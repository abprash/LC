package group.LC;

public class ValidSudoku {
     public boolean isValidSudoku(char[][] board) {
         if(board == null)
            return false;
         //check the 9 sub squares if there are repating nos
         boolean result1 = checkSubSquares(board);
         //check each square's row and column for repeating nos
         boolean result2 = checkRowAndColumn(board);
         return result1 && result2;
    }
    
    public boolean checkRowAndColumn(char[][] board){
        
        for(int i=0; i<board.length; i++){
            Set<Integer> set = new HashSet<Integer>();    
            int count=0;
            for(int j=0 ; j<board[i].length; j++){
                if(board[i][j] != '.'){
                    set.add(Character.getNumericValue(board[i][j]));
                    count++;
                }
            }
            if(count != set.size()){
                System.out.println(set);
                return false;
            }
            else
            {
                count = 0;
                set.clear();
            }
        }
        for(int i=0; i<board.length; i++){
            Set<Integer> set = new HashSet<Integer>();    
            int count=0;
            for(int j=0 ; j<board[i].length; j++){
                if(board[j][i] != '.'){
                    set.add(Character.getNumericValue(board[j][i]));
                    count++;
                }
            }
            if(count != set.size()){
                System.out.println(set);
                return false;
            }
            else
            {
                count = 0;
                set.clear();
            }
        }
        return true;
    }
    
    public boolean checkSubSquares(char[][] board){
        boolean isOkay = false;
        int count = 0;
        
        int[] x = {0,3,6};
        int[] y = {0,3,6};
        for(int i=0; i<x.length; i++){
            for(int j=0; j<y.length; j++){
                //System.out.println(x[i]+","+y[j]);
                if(!addToSetAndCheck(x[i], y[j], board))
                    return false;
                }
            }
        return true;
        }
    
    public boolean addToSetAndCheck(int x, int y, char[][] board){
        Set<Integer> set = new HashSet<Integer>();
        int startx = x, stopx = x+2, starty = y, stopy = y+2, count = 0; 
        for(int i=startx; i<=stopx; i++){
            for(int j=starty; j<=stopy; j++){
                //System.out.println(i+","+j);
                if(board[i][j] != '.'){
                    count++;
                    set.add(Character.getNumericValue(board[i][j]));
                }
                //System.out.println(i+","+j);
            }
            
        }
        if(count != set.size())
            return false;
        return true;
    }
}
