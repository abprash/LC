package group.LC;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        if(board == null)
            return false;
        //check the 9 sub squares if there are repating nos
        return checkSubSquares(board);
    }
    
    public boolean checkSubSquares(char[][] board){
        boolean isOkay = false;
        int count = 0;
        Set<Integer> set = new HashSet<Integer>();
        int[] x = {0,3,6};
        int[] y = {0,3,6};
        for(int i=0; i<x.length; i++){
            for(int j=0; j<y.length; j++){
                for(int k=0; k<3; k++){
                    for(int l=0; l<3; l++){
                        if(board[i+k][j+l] != '.'){
                            set.add(Character.getNumericValue(board[i+k][j+l]));
                            count++;
                        }
                    }
                }
                if(count != set.size())
                    return false;
                else{
                    set.clear();
                    count = 0;
                }
                }
            }
        return true;
        }
    }