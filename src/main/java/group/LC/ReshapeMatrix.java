package group.LC;

public class ReshapeMatrix {

	//a very simple straightforward method - but not the good method to do by
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        //do initial validations
        //check if the input values are all valid
        if(nums == null || nums.length == 0 || r == 0 || c == 0)
            return nums;
        if(nums.length * nums[0].length != r*c)
            return nums;//the transformation is not possible
        int[][] ans = new int[r][c];
        int[] list = new int[r*c];
        //int i=0, j=0, i1 = 0, j1 = 0;
        int count = 0;
//         int oldC = nums[0].length, r = nums.length;
//         for(int i=0; i<r*c; i++){
            
//         }
        for(int i=0; i<nums.length;i++){
            for(int j=0; j<nums[0].length; j++){
                list[count] = nums[i][j];
                count++;
            }
        }
        count = 0;
        for(int i=0; i<ans.length;i++){
            for(int j=0; j<ans[0].length; j++){
                ans[i][j] = list[count];
                count++;
            }
        }
        return ans;
    }
    
    
    

    //*******************much better solution and this is what will be expected
    
        public int[][] matrixReshape_betterSolution(int[][] nums, int r, int c) {
        	
            //do initial validations
            //check if the input values are all valid
            if(nums == null || nums.length == 0 || r == 0 || c == 0)
                return nums;
            if(nums.length * nums[0].length != r*c)
                return nums;//the transformation is not possible
            int[][] ans = new int[r][c];
            int count = 0;
            int oldC = nums[0].length, oldR = nums.length;
            for(int i=0; i<r*c; i++){
               ans[i/c][i%c] = nums[i/oldC][i%oldC]; 
            }

            return ans;
        }
}