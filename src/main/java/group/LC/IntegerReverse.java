package group.LC;

public class IntegerReverse {
	
	public int reverse(int x) {
        boolean isNegative = false;
        if(x < 0)
            isNegative = true;
        int copy = Math.abs(x);
        int counter = 0;
        int rev = 0;
        while(copy > 0){
            int lastDigit = copy % 10;
            copy = copy/10;
            rev = rev*10 + lastDigit;
            if(rev%10 != lastDigit)
                return 0;
            counter++;
            
        }
        //System.out.println(rev);
        //System.out.println(Integer.MAX_VALUE);
        if(isNegative)
            rev = -rev;
        return rev;
    }

}
