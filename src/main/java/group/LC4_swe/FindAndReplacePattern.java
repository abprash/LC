package group.LC4_swe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern {


    //much more readable and better solution

    public List<String> findAndReplacePattern(String[] words, String pattern) {

        //this time we will convert the pattern into a template and then generate a template and do the comparison
        List<String> ans = new ArrayList<>();
        if(words == null || pattern == null)
            return ans;
        //generate the template for the pattern first
        String patternTemplate = generateTemplate(pattern);
        for(String word : words){
            String wordTemplate = generateTemplate(word);
            if(word.length() != pattern.length())
                continue;
            if(wordTemplate.equals(patternTemplate))
                ans.add(word);
        }
        return ans;
    }

    public String generateTemplate(String word){
        Map<Character, Integer> map = new HashMap<>();
        int counter = 0;
        String template = "";
        for(char c : word.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c,counter);
                counter++;
            }
            template += map.get(c);
        }
        return template;
    }



    public List<String> findAndReplacePattern_notefficient1(String[] words, String pattern) {
        //we need to maintain a dictionary (or hashmap ) of mappings for every iteration
        List<String> ans = new ArrayList<>();
        if(words == null || pattern == null)
            return ans;
        pattern = pattern.trim();
        for(String word : words){
            //establish a mapping between the pattern and the actual word
            //if the lengths don't match, no need to even check
            word = word.trim();
            Map<Character, Character> map = new HashMap<>();
            if(word.length() != pattern.length())
                continue;
            boolean flag1 = false, flag2 = false;
            //
            for(int i=0; i<word.length(); i++){
                char wordChar = word.charAt(i);
                char patternChar = pattern.charAt(i);
                if(!map.containsKey(patternChar)){
                    map.put(patternChar, wordChar);
                    flag1 = true;
                }
                else{
                    flag1 = map.get(patternChar).equals(wordChar);
                }
                if(!flag1){
                    break;
                }
            }
            map.clear();
            for(int i=0; i<word.length(); i++){
                char wordChar = word.charAt(i);
                char patternChar = pattern.charAt(i);
                if(!map.containsKey(wordChar)){
                    map.put(wordChar, patternChar);
                    flag2 = true;
                }
                else{
                    flag2 = map.get(wordChar).equals(patternChar);
                }
                if(!flag2){
                    break;
                }
            }
            if(flag1 && flag2)
                ans.add(word);
        }
        return ans;
    }
}