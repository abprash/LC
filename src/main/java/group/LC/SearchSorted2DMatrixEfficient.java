package MMM;

//Again as usual, very shitty method
public class SearchSorted2DMatrixEfficient {
    public boolean searchMatrix(int[][] matrix, int target) {
        //initial validation
        if(matrix == null || matrix.length == 0)
            return false;
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                //first the rows
                if(matrix[i][0] <= target){
                    //do a bin search on the row
                    boolean res1 = binarySearch(true, false, i,j,matrix, target);
                    if(res1)
                        return true;
                }
                
                //then the row now
                if(matrix[0][j]<= target){
                    //do a bin search on the cols
                    boolean res2 = binarySearch(false, true, i,j,matrix, target);
                    if(res2)
                        return true;
                }
            }
        }
        return false;
    }
    
    public boolean binarySearch(boolean isRow, boolean isColumn, int i, int j, int[][] matrix, int target){
        if(isRow){
            //should search row
            //i is our main variable
            int low = 0, high = matrix[0].length;
            while(low < high){
                int mid = (low + high)/2;
                if(matrix[i][mid] == target)
                    return true;
                if(matrix[i][mid] < target)
                    low = mid+1;
                else
                    high = mid;
            }
            return false;
        }
        else{
            //should search col
            //j is our main variable
            int low = 0, high = matrix.length;
            while(low < high){
                int mid = (low + high)/2;
                if(matrix[mid][j] == target)
                    return true;
                if(matrix[mid][j] < target)
                    low = mid+1;
                else
                    high = mid;
            }
            return false;
        }
    }
}
