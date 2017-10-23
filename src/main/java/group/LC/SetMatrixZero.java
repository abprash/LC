package group.LC;

public class SetMatrixZero {

	//Uses O(M+N) space
	
    public void setZeroes(int[][] matrix) {
        if(matrix == null | matrix.length == 0)
            return;
        Set<Integer> rows = new HashSet<Integer>(), cols = new HashSet<Integer>();
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        
        for(int i=0; i<matrix.length; i++){
            
            for(int j=0; j<matrix[i].length; j++){
                if(matrix[i][j] != 0 && rows.contains(i))
                    zeroIt(i, -1, matrix);
                if(matrix[i][j] != 0 && cols.contains(j))
                    zeroIt(-1, j, matrix);
            }
        }
        
        return;
        
    }
    
    public void zeroIt(int row, int col, int[][]matrix){
        if(row == -1){
            for(int i=0; i<matrix.length; i++)
                matrix[i][col] = 0;
        }
        if(col == -1){
            for(int j=0; j<matrix[0].length; j++)
                matrix[row][j] = 0;
        }
    }
}
