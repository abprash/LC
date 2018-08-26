package group.LC4_swe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/group-shifted-strings/description/

//the below solution works for all input with duplicates also . YAYYYY!! 

class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> ans = new ArrayList<>();
        if(strings == null || strings.length == 0)
            return ans;
        Map<String, Integer> map = new HashMap<>();
        Set<String> visited = new HashSet<>();
        //add the given list to a set. for faster lookups.
        for(String s : strings){
            if(!map.containsKey(s))
                map.put(s,1);
            else
                map.put(s,map.get(s)+1);
        }
        // System.out.println(map);
        for(String s : strings){
            //check if this word has already been done
            if(visited.contains(s)){
                continue;
            }
            List<String> current = new ArrayList<>();
            current.add(s);
            map.put(s, map.get(s)-1);//deduct this occurrence
            //handle the possible duplicates
            while(map.get(s) > 0){
                current.add(s);
                map.put(s, map.get(s)-1);//decrement the occurrence in map    
            }
            visited.add(s);
            //else, start shifting around
            List<String> shiftList = shift(s);
            //check if any of the strings are present in the set
            for(String shiftedString : shiftList){
                if(map.containsKey(shiftedString) && !shiftedString.equals(s)){
                    //first time deduction
                    if(map.containsKey(shiftedString))
                        map.put(shiftedString, map.get(shiftedString)-1);
                    current.add(shiftedString);//add to the answer list
                    visited.add(shiftedString);//add to the lookup list, so that we don't repeat the check again
                    //handle the duplicates now
                    while(map.containsKey(shiftedString) && map.get(shiftedString) > 0){
                        current.add(shiftedString);
                        map.put(shiftedString, map.get(shiftedString)-1);//decrement the occurrence in map    
                    }
                }
            }
            ans.add(current);
        }
        return ans;
    }
    
    public List<String> shift(String s){
        //only lower case alphabets are present
        //start shifting around
        List<String> shifted = new ArrayList<>();
        char[] charString = s.toCharArray();
        for(int i=1; i<=26; i++){
            for(int j=0; j<charString.length; j++){
                charString[j]++;
                if(charString[j] > 'z')
                    charString[j] = (char) ('z' - charString[j] + 'a' + 1);
            }
            shifted.add(String.valueOf(charString));
        }
        // System.out.println(shifted);
        return shifted;
    }
}

//the below solution works for input with no duplicates. but fails for ones with duplicate entries

public class GroupShiftedStrings {
	
	    public List<List<String>> groupStrings(String[] strings) {
	        List<List<String>> ans = new ArrayList<>();
	        if(strings == null || strings.length == 0)
	            return ans;
	        Set<String> set = new HashSet<>();
	        Set<String> visited = new HashSet<>();
	        //add the given list to a set. for faster lookups.
	        for(String s : strings)
	            set.add(s);
	        for(String s : strings){
	            //check if this word has already been done
	            if(visited.contains(s))
	                continue;
	            List<String> current = new ArrayList<>();
	            current.add(s);
	            visited.add(s);
	            //else, start shifting around
	            List<String> shiftList = shift(s);
	            //check if any of the strings are present in the set
	            for(String shiftedString : shiftList){
	                if(set.contains(shiftedString) && !shiftedString.equals(s)){
	                    current.add(shiftedString);//add to the answer list
	                    visited.add(shiftedString);//add to the lookup list, so that we don't repeat the check again
	                }
	            }
	            ans.add(current);
	        }
	        return ans;
	    }
	    
	    public List<String> shift(String s){
	        //only lower case alphabets are present
	        //start shifting around
	        List<String> shifted = new ArrayList<>();
	        char[] charString = s.toCharArray();
	        for(int i=1; i<=26; i++){
	            for(int j=0; j<charString.length; j++){
	                charString[j]++;
	                if(charString[j] > 'z')
	                    charString[j] = (char) ('z' - charString[j] + 'a' + 1);
	            }
	            shifted.add(String.valueOf(charString));
	        }
	        // System.out.println(shifted);
	        return shifted;
	    }
	
}