package group.LC;

/*
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that 
 * the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container 
 * contains the most water.
Note: You may not slant the container and n is at least 2.
 * 
 * 
*/

//the intuition is simple
//we use a two pointer method
//find the extremities first
//once we calc the area, then we keep moving inwards
//we first move inward the one which has the lesser of the two values under comparison

public class MaxContainerArea {

	public int maxArea(int[] height) {
        if(height == null || height.length == 0 || height.length == 1)
            return 0;
        //keep two pointers at the extremes
        int p1 = 0, p2 = height.length -1;
            while(height[p1] == 0)
                p1++;
            while(height[p2] == 0)
                p2--;
        //now p1 and p2 point to the non zero  extremiities
        int maxArea = Math.min(height[p1],height[p2]) * (p2-p1);
        //now we try the other alternatives
        while(p1 < p2){
            if(height[p1] < height[p2]){
                p1++;
                
            }else{
                p2--;
            }
            //recalc the area everytime we make the change
            maxArea = Math.max(maxArea, Math.min(height[p1],height[p2]) * (p2-p1));
        }
        return maxArea;
    }
}