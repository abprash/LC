package group.LC;

public class FractionToRecurringDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        //has a lot of edge and corner cases to be considered
        StringBuilder ans = new StringBuilder();
        //check if numberator is == 0
        long n = numerator, d = denominator;
        if(n == 0)
            return "0";
        //handle divide by zero exception
        if(d == 0)
            return "";
        //take care of the sign
        //using XOR because, if either numerator or denominator is neg then its true else there is no sign
        ans.append(((n < 0) ^ (d < 0)) ? "-" : "");
        
        n = Math.abs(n);
        d = Math.abs(d);
        //now the integral part
        ans.append(Long.toString(n/d));
        if((n%d) == 0)
            return ans.toString();
        Map<Long, Integer> map = new HashMap<>();
        long num = n%d;
        //now, if it is not zero then
        
        //now the fractional part
        ans.append(".");
        
        map.put(num, ans.length());
        while(num != 0){
            //now multiply the num by 10
            num *=10;
            long rem = num%d;
            long q = num/d;
            ans.append(q);
            num%=d;
            //calc the remainder again
            //if present in the map
            //put the ( and ), and return
            if(map.containsKey(rem)){
                int index = map.get(rem);
                ans.insert(index,"(");
                ans.append(")");
                break;
            }
            else{
                map.put(num, ans.length());
            }
            
        }
        return ans.toString();
    }
}