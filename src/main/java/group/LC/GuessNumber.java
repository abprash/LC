package group.LC;

public class GuessNumber {

}


/* The guess API is defined in the parent class GuessGame.
@param num, your guess
@return -1 if my number is lower, 1 if my number is higher, otherwise return 0
   int guess(int num); */

class Solution extends GuessGame {
 public int guessNumber(int n) {
     return helper(1,n);
 }
 
 
 public int helper(int start, int end){
     int ans = 0;
     
     while(start < end){
         int mid = start + (end-start)/ 2;
         int resp = guess(mid);
         if(resp == 0){
             return mid;
             //break;
             //return mid;
         }
         else if(resp == 1)
             start = mid+1;
         else
             end = mid;
     }
     return start;
 }
}