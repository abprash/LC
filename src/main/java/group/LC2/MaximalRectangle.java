package group.LC2;

public class MaximalRectangle {


    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;
        int[] heights = new int[matrix[0].length];
        //copy the initial row from matrix
        for(int i=0; i<matrix[0].length; i++)
            if(matrix[0][i] == '1')
                heights[i]  = 1;
        
        //now we go from row to row and calc the area as we go
        
        //calc the tentative area first
        int maxArea = largestHeight(heights);
        for(int i=1; i<matrix.length; i++){
            heights = slideAndMerge(heights, matrix[i]);
            int area = largestHeight(heights);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
    
    public int[] slideAndMerge(int[] heights, char[] row){
        for(int i=0; i<row.length; i++){
            if(row[i] == '1')
                heights[i]++;
            else
                heights[i] = 0;
        }
        return heights;
    }
    
    public int largestHeight(int[] nums){
        if(nums == null || nums.length == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int i=0; i<=nums.length; i++){
            int height = (i < nums.length) ? nums[i] : 0;
            if(stack.isEmpty() || height >= nums[stack.peek()])
                stack.push(i);
            else{
                //we will go on popping until we encounter a val >= height
                int top = stack.pop();
                maxArea = Math.max(maxArea, nums[top] * (stack.isEmpty() ?  i : i - 1 - stack.peek()));
                //to keep i at the current place
                i--;
            }
        }
        return maxArea;
    }
}