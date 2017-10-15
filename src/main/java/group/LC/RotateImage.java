package group.LC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RotateImage {

    public void rotate(int[][] matrix) {
        if(matrix == null)
			return;
        //step 1 - do a transpose
        //it will be an nxn matrix
        for(int i=0; i<matrix.length; i++){
            //j should start at i, otherwise the transpose would not take place - ie it will be swapped back twice
            for(int j=i; j<matrix[i].length; j++){
                //swap them
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //step 2 - do a horizontal flip
        for(int i=0; i<matrix.length; i++){
            //this j should go only until rowlen/2 because then it'll flip everything back twice
            for(int j=0; j<matrix.length/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length-j-1];
                matrix[i][matrix[0].length-j-1] = temp;
            }
        }
    }
    
    public static void main(String[] args){
    	List<String> l = new ArrayList<String>();
    	l.add(null);
    	l.add("1");
    	l.add(null);
    	System.out.println(l);
    	String ll = l.toString();
    	System.out.println(ll);
    	List<String> l2 = new ArrayList<String>();
    	//have no option but to parse it as a list
    	 Queue<String> q = new LinkedList<>();
         //parse the string into a list
         q.addAll(Arrays.asList("df,s,d,f,sdf".split(",")));
    }
}
