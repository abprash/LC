package group.LC3;

//https://leetcode.com/problems/minimum-factorization/discuss/104661/Java-Solution-result-array

public class MinimumFactorization {


    public int smallestFactorization(int a) {
        
        if(a < 10)
            return a;
        
        StringBuilder sb = new StringBuilder();
        //start getting the digits which are divisible
        //better to start from 9
        int i = 0;
        for(i=9; i>1; i--){
            //check if i is a factor
            while(a%i == 0){
                sb.append(i);
                a /= i;
            }
        }
        System.out.println(sb);
        //now check if we reached 1
        if(a != 1)
            return 0;
        String s = sb.toString();
        long ans = 0;
        //now get the nos in the reverse
        for(int j=s.length()-1; j>=0; j--){
            ans = ans*10 + Character.getNumericValue(s.charAt(j));
            if(ans > Integer.MAX_VALUE)
                return 0;
        }
        return (int) ans;
    }
}