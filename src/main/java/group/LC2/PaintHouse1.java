package group.LC2;

public class PaintHouse1 {

}
class Solution {
    public int minCost(int[][] costs) {
        //no cost given
        if(costs == null || costs.length == 0)
            return 0;
        //store the costs of R, B and G
        int lastR = costs[0][0];
        int lastB = costs[0][1];
        int lastG = costs[0][2];
        for(int i=1; i<costs.length; i++){
            
            //if you want to paint cur house red,
            //then you have to take the min of lastB and lastG, and add cost of R
            int curR = Math.min(lastB, lastG) + costs[i][0];
            //similarly for the rest also
            int curB = Math.min(lastR, lastG) + costs[i][1];
            int curG = Math.min(lastB, lastR) + costs[i][2];
            
            lastR = curR;
            lastG = curG;
            lastB = curB;
            
        }
        //return the min of the 3
        return Math.min(Math.min(lastR, lastB), lastG);
    }
}