package group.LC2;

public class RectangleArea {


    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        
        //https://leetcode.com/problems/rectangle-area/discuss/62301/check-the-overlapping-area-of-two-rectangles-tricky
        
        int res = 0;
        //compute the areas of r1 and r2
        int r1 = (C-A) * (D-B);
        int r2 = (G-E) * (H-F) ;
        
        //res += r1+r2;
        
        //now subtract the common overlap area and return the ans
        int overlap = 0;
        //checking if the rightmost point in R1 is less than the leftmost point in R2
        //and checking if the leftmost point in R1 is to the right of the rightmost point in R2
        if( (C <= E) || (D <= F) || (G <= A) || (H <= B))
            return r1+r2;
        //compute the overlap coords
        //bottom left
        int bl_x = Math.max(A,E);
        int bl_y = Math.max(B,F);
        //top right
        int tr_x = Math.min(C,G);
        int tr_y = Math.min(D,H);
        
        overlap = (tr_x - bl_x) * (tr_y - bl_y);
        return r1 + r2 - overlap;
    }
}