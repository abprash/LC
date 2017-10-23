package group.LC;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class MatrixSpiral {


    public List<Integer> spiralOrder(int[][] matrix) {
        char[] bluePrint = {'R','D','L','U'};
        if(matrix == null || matrix.length == 0)
            return new ArrayList<Integer>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        return startSpiral(matrix, visited,bluePrint);
    }
    
    public boolean isNonVisitedPlacesAvailable(boolean[][] visited){
        for(int i=0; i<visited.length; i++){
            for(int j=0; j<visited[0].length; j++){
                if(visited[i][j] == false)
                    return true;
            }
        }
        return false;
    }
    
    public List<Integer> startSpiral(int[][] matrix, boolean[][] visited, char[] bluePrint ){
        int i=0, j=0;
        //we start at 0,0
        //this is the list we will be returning
        List<Integer> ans = new ArrayList<>();
        //this method checks if the entire grid has been visited 
        while(i >= 0 && i <= matrix.length-1 && j >= 0 && j <= matrix[0].length-1 && !visited[i][j]){
            
            //go right first
            while(traverse(i, j, matrix, visited, ans)){
                j+= 1;
            }
            //this is to come back to the orig position from the invalid position
            j-=1;
            i++;
            
            //down
            while(traverse(i,j, matrix, visited, ans)){
                i+= 1;
            }
            
            //this is to come back to the orig position from the invalid position
            i-=1;
            j--;
            //left
            while(traverse(i,j, matrix, visited, ans)){
                j-= 1;
            }
            
            //this is to come back to the orig position from the invalid position
            j+=1;
            i--;
            
            //up
            while(traverse(i,j, matrix, visited, ans)){
                i-= 1;
            }
            //this is to come back to the orig position from the invalid position
            i+=1;
            j++;
        }
        //for(int row = 0; row < visited.length; row++)
        //System.out.println(Arrays.toString(visited[row]));
        return ans;
    }
    
    public boolean traverse( int i, int j, int[][] matrix, boolean[][] visited, List<Integer> list ){

        if(i < 0 || i > matrix.length-1 || j < 0 || j > matrix[0].length-1 || visited[i][j])
           return false;
        else{
            //System.out.println(matrix[i][j]);
            visited[i][j] = true;
            list.add(matrix[i][j]);
            return true;
        }

    }
}