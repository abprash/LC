package group.LC;

public class StrobogrammaticNumber3 {

}


class Solution {
    public int strobogrammaticInRange(String low, String high) {
        List<String> ans = new ArrayList<>();
        for(int i=low.length(); i<= high.length(); i++){
            ans.addAll(helper(i,i));
        }
        int count = 0;
        for(String s : ans){
            if((s.length() == low.length() && s.compareTo(low) < 0) || (s.length() == high.length() && s.compareTo(high) > 0))
                    continue;
                count++;
        }
        return count;
    }
    
    public List<String> helper(int n, int m){
        if(n == 0)
            return new ArrayList<String>(Arrays.asList(new String[]{""}));
        else if(n == 1)
            return new ArrayList<String>(Arrays.asList(new String[]{"0","1","8"}));
        List<String> list = helper(n-2, m);
        List<String> ans = new ArrayList<String>();
        
        for(int i=0; i<list.size(); i++){
            String center = list.get(i);
            if(m != n)
                ans.add("0"+center+"0");
            ans.add("1"+center+"1");
            ans.add("6"+center+"9");
            ans.add("8"+center+"8");
            ans.add("9"+center+"6");
        }
        return ans;
    }
}