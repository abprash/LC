package group.LC;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        
        if(n == 0)
            return new ArrayList<>();
        List<String> list = new ArrayList<>();
        helperBacktrack(list, new String(),0, 0, n);
        return list;
    }
    
    public void helperBacktrack(List<String> list, String s, int open, int close, int max){
        if(s.length() == max*2){
            System.out.println("-->"+s);
            list.add(s);
            return;
        }
        System.out.println(s);
        if(open < max)
        	helperBacktrack(list, s+"(", open+1, close, max);
        if(close < open)
        	helperBacktrack(list, s+")", open, close+1, max);
    }
}