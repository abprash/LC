package group.LC;

public class PowerOfThree {

}


class Solution {
    public boolean isPowerOfThree(int n) {
        //find the max power of 3 that can be represented in an integer
        //this is the max number which can be represented with 3
        return (n>0) && ((1162261467%n) == 0);
    }
}