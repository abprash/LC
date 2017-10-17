package group.LC;

public class ShittyGenerateParentheses {

	
	//*** very shitty brute force solution
	

	    List<String> ans = new ArrayList<>();
	    Set<String> set = new HashSet<>();
	    public List<String> generateParenthesis(int n) {
	        //one approach is to brute force thro all the permutations
	        //and then independently verify each entry if its valid or not
	        StringBuilder sb = new StringBuilder();
	        for(int i=0; i<n; i++){
	            sb.append("()");
	        }
	        //lets generate all permutations
	        generateAll(sb.toString(), 0 , sb.length()-1);
	        for(String s : set){
	            if(isValidParen(s))
	                ans.add(s);
	        }
	        return ans;
	    }
	    
	    public void generateAll(String str, int start, int end){
	        if(start == end){
	            //System.out.println(str);
	            //check if the parentheses are valid
	            //put them in a stack and return
	            set.add(str);
	        }
	        else{
	             for (int i = start; i <= end; i++)
	            {
	                str = swap(str,start,i);
	                generateAll(str, start+1, end);
	                str = swap(str,start,i);
	            }
	            
	        }
	    }
	    
	    public String swap(String s, int start, int end){
	        char[] charArray = s.toCharArray();
	        char temp = charArray[start];
	        charArray[start] = charArray[end];
	        charArray[end] = temp;
	        return String.valueOf(charArray);
	    }
	    
	    public boolean isValidParen(String paren){
	        Stack<Character> stack = new Stack<>();
	        for(int i=0; i<paren.length(); i++){
	            char c = paren.charAt(i);
	            if(c == '(')
	                stack.push(')');
	            else if(c == ')'){
	                if(!stack.isEmpty() && stack.pop()==')')
	                    ;
	                else
	                    return false;
	            }
	        }
	        if(!stack.isEmpty())
	            return false;
	        else
	            return true;
	    }
}
