package group.LC4_swe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupShiftedStrings {


    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> ans = new ArrayList<>();
        if(strings == null || strings.length == 0)
            return ans;
        Map<Integer, Set<String>> map = new HashMap<>();
        
        for(String s : strings){
            if(!map.containsKey(s.length()))
                map.put(s.length(), new HashSet<String>());
            map.get(s.length()).add(s);
        }
        for(Map.Entry<Integer, Set<String>> entry : map.entrySet()){
            Set<String> clone = new HashSet(entry.getValue());
            Set<String> set = entry.getValue();
            for(String word : clone){
                if(!set.contains(word))
                    continue;
                List<String> temp = new ArrayList<>();
                temp.add(word);
                char[] arr = word.toCharArray();
                for(int i=0; i<arr.length; i++){
                    for(int j=1; j<26; j++){
                        //start adding the nos.
                        char newChar = (char) (arr[i] + j > 'z' ? (arr[i] + j)%26 : arr[i] + j);
                        arr[i] = newChar;
                    }
                }
                if(set.contains(String.valueOf(arr))){
                    temp.add(String.valueOf(arr));
                    set.remove(String.valueOf(arr));
                }
            }
        }
        return ans;
    }
}