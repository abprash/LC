package group.LC;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
	
	////**********************only 8% faster method
	public List<List<String>> groupAnagrams1(String[] strs) {
        if(strs == null)
            return null;
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<List<String>>();
        for(String s : strs){
            //getUniqueCounts()
            //put the string and returned string into hashmap
            //System.out.println(getCountsOfAllCharacters(s));
            String countString = getCountsOfAllCharacters(s);
            if(map.containsKey(countString)){
                List<String> tempList = map.get(countString);
                tempList.add(s);
                map.put(countString, tempList);
            }
            else{
                List<String> tempList = new ArrayList<>();
                tempList.add(s);
                map.put(countString, tempList);
            }
        }
        //System.out.println(map);
        Collection<List<String>> values = map.values();
        for(List<String> l: values){
            ans.add(l);
        }
        return ans;
    }
    
    public String getCountsOfAllCharacters(String str){
        int[] arr = new int[26];
        //this is only lower case
        for(int i=0; i<str.length(); i++){
            int pos = str.charAt(i) - 'a';
            arr[pos]+=1;
        }
        StringBuilder sb  = new StringBuilder();
        for(int i=0; i<arr.length; i++){
            if(i != arr.length-1)
                sb.append(arr[i]+",");    
            else
                sb.append(arr[i]);
        }
        return new String(sb);
    }
    
    //**********************************************************
    //*************23% faster method
    public List<List<String>> groupAnagrams2(String[] strs) {
        if(strs == null)
            return null;
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<List<String>>();
        for(String s : strs){
            //getUniqueCounts()
            //put the string and returned string into hashmap
            //System.out.println(getCountsOfAllCharacters(s));
            String countString = getCountsOfAllCharacters2(s);
            if(map.containsKey(countString)){
                List<String> tempList = map.get(countString);
                tempList.add(s);
                map.put(countString, tempList);
            }
            else{
                List<String> tempList = new ArrayList<>();
                tempList.add(s);
                map.put(countString, tempList);
            }
        }
        //System.out.println(map);
        Collection<List<String>> values = map.values();
        for(List<String> l: values){
            ans.add(l);
        }
        return ans;
    }
    
    public String getCountsOfAllCharacters2(String str){
        int[] arr = new int[26];
        //this is only lower case
        for(int i=0; i<str.length(); i++){
            int pos = str.charAt(i) - 'a';
            arr[pos]+=1;
        }
        StringBuilder sb  = new StringBuilder();
        for(int i=0; i<arr.length; i++){
            // if(i != arr.length-1)
            //     sb.append(arr[i]+",");    
            // else
                sb.append(arr[i]);
        }
        return new String(sb);
    }
}
