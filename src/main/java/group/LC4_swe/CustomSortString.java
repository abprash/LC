package group.LC4;

//https://leetcode.com/problems/custom-sort-string/description/

public class CustomSortString {

    public String customSortString(String s, String t) {
        if(s == null || s.length() == 0)
            return s;
        StringBuilder sb = new StringBuilder();
        Map<Character, Boolean> map = new HashMap<>();
        //now count the number occurrences of each letter in the t string
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            //now find the all occurrences of c in t - get count and build the string
            int pos = 0;
            if(t.indexOf(Character.toString(c), pos) >= 0){
                map.put(c, true);
                while(t.indexOf(Character.toString(c), pos) >= 0){
                    pos = t.indexOf(Character.toString(c), pos);
                    pos++;
                    sb.append(c);
                }
            }
        }
        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);
            if(!map.containsKey(c))
                sb.append(c);
        }
        return sb.toString();
    }
}