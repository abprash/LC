package group.LC;

public class UniqueAbbreviations {

}

class ValidWordAbbr {

    Map<String, List<String>> map;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        for(String s : dictionary){
            String temp = new String(s);
            s = s.length() > 2 ? Character.toString(s.charAt(0)) + (s.length()-2) + Character.toString(s.charAt(s.length()-1)) : s;
            List<String> list;
            if(!map.containsKey(s)){
                list = new ArrayList<>();
                list.add(temp);
            }
            else{
                list = map.get(s);
                if(!list.contains(s))
                    list.add(temp);
            }
            map.put(s, list);
        }
        System.out.println(map);
    }
    
    public boolean isUnique(String word) {
        String s =  new String(word);
        s = s.length() > 2 ? Character.toString(s.charAt(0)) + (s.length()-2) + Character.toString(s.charAt(s.length()-1)) : s;
        //if its not present in the dict at all, return true
        if(!map.containsKey(s))
            return true;
        //now, check if the string occurs more than once
        List<String> list = map.get(s);
        if(list.size() <= 1){
            if(list.get(0).equals(word))
                return true;
            else
                return false;
        }
        else
            return false;
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */