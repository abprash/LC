package group.LC3;

import java.util.*;

//faster solution, but still not AC

public class CountPrimes {


    
    Map<Integer, Integer> map = new HashMap<>();
    public int countPrimes(int n) {
        
        map.put(1, 0);
        map.put(2, 0);
        map.put(3, 1);
        map.put(4, 2);
        
        //check the map
        ///lets try a recursive function
        if(map.containsKey(n))
            return map.get(n);
        for(int i=5; i<=n; i++){
            int res = isPrime(i-1) + map.get(i-1);
            map.put(i, res);
            //System.out.println(map);
        }
        //System.out.println(map);
        return map.get(n);
    }
    
    public int isPrime(int n){
        boolean isComposite = false;
        for(int i=2; i<= (int) Math.sqrt(n); i++){
            if(isComposite)
                return 0;
            if(n%i == 0){
                isComposite = true;
                break;
            }
        }
        if(!isComposite)
            return 1;
        else
            return 0;
    }
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