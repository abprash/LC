package group.LC2;

public class SpiralMatrix2 {


	
	//https://leetcode.com/problems/spiral-matrix-ii/discuss/22292/
	
	
	
    int val = 1;
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        if(n == 0)
            return ans;
        //***
        //core concept
        //we will go right, then down, then left and up
        
        fill(ans);
        for(int[] row : ans){
            System.out.println(Arrays.toString(row));
        }
        return ans;
    }
    
    public void fill(int[][] ans){
        int top = 0, left = 0, right = ans.length-1, down = ans[0].length-1;
        while(left <= right){
            //go right
            for(int i=left; i <= right; i++)
                ans[top][i] = val++;
            //go left and down one level
            //go down
            top++;
            for(int i=top; i<=down; i++)
                ans[i][right] = val++;
            //go left
            right--;
            for(int i=right; i>=left; i--)
                ans[down][i] = val++;
            down--;
            //go up
            for(int i = down; i >= top; i--)
                ans[i][left] = val++;
            left++;
        }
    }
    
    
}