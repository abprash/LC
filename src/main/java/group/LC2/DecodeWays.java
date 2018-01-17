package group.LC2;

import java.util.*;

public class DecodeWays {
	
	//TLE
	//222/260 cases passed
	//algorithm is correct, its just taking a lot of time to run

    Set<String> set = new HashSet<>();
    Map<Integer, Character > map;
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 )
            return 0;
        map = new HashMap<>();
        int num=1;
        for(char c='A'; c<='Z'; c++){
            map.put(num,c);
            num++;
        }
        if(s.length() == 1){
            if(map.containsKey(Integer.parseInt(s)))
                return 1;
            else 
                return 0;
        }
        //load all alphabets into the hmap
        
        String letter = "";
        //System.out.println(map);
        //now start decoding
        recurse("", s);
        //System.out.println(set);
        return set.size();
    }
    
    public void recurse(String letterSoFar, String s){
        //System.out.println(letterSoFar+", s ="+s);
        if(s == null || s.equals("") || s.length() == 0){
            set.add(letterSoFar);
            return;
        }
        if(s.length() == 1){
            if(map.containsKey(Integer.parseInt(s)))
                set.add(letterSoFar + map.get(Integer.parseInt(s)));
            return;
        }
        if(s.length() >= 2){
            char c1 = s.charAt(0);
            //put this in the ans
            String letter = "";
            if(map.containsKey(Integer.parseInt(c1 + ""))){
                letter = map.get(Integer.parseInt(c1 + "")) + "";
                recurse(letterSoFar + letter, s.substring(1));
                if(c1 <= '2'){
                    char c2 = s.charAt(1);
                    //put this in the ans
                    int num2 = Integer.parseInt(c1+"")*10 +Integer.parseInt(c2+""); 
                    //System.out.println(num2);
                    if(map.containsKey(num2)){
                        letter = map.get(num2)+"";
                        recurse(letterSoFar + letter, s.substring(2));
                    }
                }
            }
            // else{
            //     recurse(letterSoFar + letter, s.substring(1));
            // }
        }
    }
    
    public static void main(String[] args){
    	String s = "4757562545844617494555774581341211511296816786586787755257741178599337186486723247528324612117156948";
    	System.out.println(new DecodeWays().numDecodings(s));
    }
}