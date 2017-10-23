package group.LC;

public class NumberOf1s {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        if(n == 0)
            return 0;
        int count = 0;
        //we should try right shifting and modulo by 2 each time-whever it is 0 - dont increase, but when remainder is 1, incr the count
        //return count
       while(n != 0){
           count = count+ (n&1);
           n = n>>>1;//this is for unsigned bit shifting
	       //System.out.println(Integer.toBinaryString(n));
        }
        return count;
    }
	    
}
