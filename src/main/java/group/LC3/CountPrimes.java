package group.LC3;

public class CountPrimes {

}


//Algo is right
//brute force algo - TLE
//18/20 cases passed

class Solution0 {
    public int countPrimes(int n) {
        //lets try a brute force algo
        int res = 0;
        if(n <= 2)
            return res;
        
        if(n == 3)
            return 1;
        boolean isComposite = false;
        for(int i=2; i< n; i++){
            for(int j=2; j<= (int) Math.sqrt(n); j++){
                if(isComposite)
                    break;
                if(i > j && i % j == 0)
                    isComposite = true;
                
            }
            if(!isComposite){
                //System.out.println(i);
                res++;
            }
            isComposite = false;
        }
        return res;
    }
}