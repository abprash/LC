package group.LC2;

public class PermutationSequence {


	//********************************** Very inefficient solution.........
	//TLE after 40/200 cases
	
	
	public String getPermutation(int n, int k) {
        if(n < 0)
            return "";
        if(n == 1)
            return "1";
        StringBuilder sb = new StringBuilder();
        List<String> temp = new ArrayList<>(), ans = new ArrayList<>();
        for(int i=1; i<=n; i++)
            temp.add(Integer.toString(i));
        backtrack(ans, temp, sb);
        
        //System.out.println(ans);
        return ans.get(k-1);
    }
    
    public void backtrack(List<String> ans, List<String> temp, StringBuilder sb){
        if(sb.length() == temp.size()){
            ans.add(new String(sb));
            return;
        }
        for(int i=0; i<temp.size(); i++){
            if(sb.toString().contains(""+temp.get(i)))
                continue;
            int prevLength = sb.length();
            backtrack(ans, temp, sb.append(temp.get(i)));
            //remove it
            sb.setLength(prevLength);
        }
    }
}
