package group.LC2;



//The most optimal solution
//*************************
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i< 1<<n; i++){
            ans.add(i ^ i>>1);
        }
        return ans;
    }
}

public class GrayCode {

	//Works correct but, its not accepted by the OJ
    public List<Integer> grayCode(int n) {
        //to convert a binary string to an int
        //Integer.parseInt("bin_string", 2);
        List<Integer> ans = new ArrayList<>();
        if(n == 0){
            ans.add(0);
            return ans;
        }
        //first get the start string
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++)
            sb.append("0");
        backtrack(sb, ans, sb.length()-1);
        return ans;
    }
    
    public void backtrack(StringBuilder sb, List<Integer> list, int start){
        System.out.println(sb);
        if(!list.contains(Integer.parseInt(sb.toString(), 2)))
            list.add(Integer.parseInt(sb.toString(), 2));
        for(int i = start ; i >= 0 ; i--){
            if(sb.charAt(i) == '1'){
                    sb.replace(i, i+1, "0");
            }
            else{
                    sb.replace(i, i+1, "1");
            }
            
            backtrack(sb, list, i-1);
            //reverting back
            
            if(sb.charAt(i) == '1'){
                    sb.replace(i, i+1, "0");
            }
            else{
                    sb.replace(i, i+1, "1");
            }
            
        }
    }
}