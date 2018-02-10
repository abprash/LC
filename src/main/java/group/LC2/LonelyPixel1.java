package group.LC2;

public class LonelyPixel1 {

    public int findLonelyPixel(char[][] picture) {
        if(picture == null || picture.length == 0)
            return 0;
        int ans = 0, col = 0, rowCount = 0;
        for(int i=0; i<picture.length; i++){
            for(int j=0; j<picture[0].length; j++){
                //check each row
                //if each row has only one pixel, then check that column, 
                //if both return true - yes lonely
                //else no
                if(picture[i][j] == 'B'){
                    col = j;
                    rowCount++;
                }
            }
            if(rowCount == 1){
                //check that col
                if(isLonelyCol(picture, col))
                    ans++;
            }
            //reset the rowcount
            rowCount = 0;
        }
        return ans;
    }
    
    public boolean isLonelyCol(char[][] picture, int col){
        int colCount = 0;
        for(int i=0; i<picture.length; i++){
            if(picture[i][col] == 'B')
                colCount++;
        }
        if(colCount == 1)
            return true;
        else
            return false;
    }
}