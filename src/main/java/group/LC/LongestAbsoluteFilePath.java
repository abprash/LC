package group.LC;

import java.util.*;
import java.util.concurrent.*;

public class LongestAbsoluteFilePath {
	
	
	    public int lengthLongestPath(String input) {
	        if(input == null || input.length() == 0)
	            return 0;
	        String[] parts = input.split("\n");
	        if(parts.length == 1){
	            if(parts[0].contains("."))
	                return parts[0].length();
	            else
	                return 0;
	        }
	        
	        //trim off any trailing and leading white spaces
	        input = input.trim();
	        
	        //now lets start splitting
	        //and manipulating
	        Map<Integer,String> map = new HashMap<>();
	        
	        for(int i=0; i<parts.length; i++){
	            //check if there is a \t if not add it as 1 and add to hmap
	            if(!parts[i].contains("\t")){
	                map.put(0, parts[i]);
	            }
	            else{
	                int count = checkOccurrences(parts[i],"\t");
	                if(map.containsKey(count-1)){
	                    //retrieve the val from hmap and append with current string
	                    String prefix = map.get(count-1);
	                    //replace all occurrences with ""
	                    String newString = parts[i].replaceAll("\t","");
	                    //append it
	                    //System.out.println("**"+newString+"**");
	                    parts[i] = prefix+"/"+newString;
	                    //put the count, new string into map
	                    map.put(count, parts[i]);
	                }
	                else{
	                    //System.out.println("Something wrong happened here");
	                }
	                //after appending, check if it again has \t
	            }
	        }
	        int maxLen = 0;
	        for(int i=0; i<parts.length; i++){
	            int len = parts[i].length();
	            if(len > maxLen && parts[i].contains("."))
	                maxLen = len;
	        }
	        //System.out.println(map.entrySet());
	        //System.out.println(Arrays.toString(parts));
	        //now if it is more than two
	        return maxLen;
	    }
	    
	    public int checkOccurrences(String target, String pattern){
	        if(target == null || target.length() == 0 || pattern == null)
	            return 0;
	        if(target.length() < pattern.length())
	            return 0;
	        int count = 0, index = 0;
	        
	        index = target.indexOf(pattern,index);
	        if(index >= 0)
	            count++;
	        while(index != -1){
	            index = target.indexOf(pattern,index+1);
	            if(index >= 0)
	                count++;
	        }
	        
	        return count;
	    }
	    
	    
	    public static void main(String[] args){
			ConcurrentHashMap<String, String> s = new ConcurrentHashMap<>();
			
		}
	}