package group.LC2;


//https://leetcode.com/problems/sum-of-square-numbers/discuss/104930/Java-Two-Pointers-Solution
public class SumOfSquares {

//2 pointers AC solution

    public boolean judgeSquareSum(int c) {
        //
        if(c <= 1)
            return true;
        //two pointer solution
        int left = 0, right = (int) Math.sqrt(c);
        while(left <= right){
            int cur = left*left + right*right;
            if(cur < c)
                left++;
            else if(cur > c)
                right--;
            else
                return true;
        }
        return false;
    }
}

//brute force
class Solution {
    public boolean judgeSquareSum(int c) {
        //
        for(int i=1; i<c; i++){
            long lhs = c - i*i;
            long root = (long) Math.sqrt(lhs);
            if( root * root == lhs)
                return true;
        }
        return false;
    }
}