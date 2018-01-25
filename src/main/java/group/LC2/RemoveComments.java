package group.LC2;

public class RemoveComments {

	
	//***************Much better solution
	
	
	class Solution {
	    public List<String> removeComments(String[] source) {
	        List<String> ans = new ArrayList<>();
	        if(source == null || source.length == 0)
	            return ans;
	        boolean isIgnore = false;
	        StringBuilder sb = new StringBuilder();
	        for(String line : source){
	            for(int i=0; i<line.length(); i++){
	                //we iterate thro all the chars
	                if(isIgnore){
	                    if(line.charAt(i) == '*' && i < line.length()-1 && line.charAt(i+1) == '/'){
	                        //henceforth its all code. comments have ended.
	                        isIgnore = false;
	                        i++; // skip the next / char
	                    }
	                }
	                else{
	                    //could be code, single line comments or in between block comments
	                    if(line.charAt(i) == '/' && i < line.length()-1 && line.charAt(i+1) == '/'){
	                        break;
	                    }
	                    else if(line.charAt(i) == '/' && i < line.length()-1 && line.charAt(i+1) == '*'){
	                        isIgnore = true;
	                        i++;//skip the next * char
	                    }
	                    else
	                        sb.append(line.charAt(i));
	                }
	                
	                
	            }
	            //check and finally see if everything is right
	                if(!isIgnore && sb.length()>=1){
	                    ans.add(sb.toString());
	                    sb = new StringBuilder();
	                }
	        }
	        return ans;
	    }
	    
	    
	}
	
	//******************************Bad solution!!!!!!
	// passed only 25/50 cases
	
	    public List<String> removeComments(String[] source) {
	        List<String> ans = new ArrayList<>();
	        if(source == null || source.length == 0)
	            return ans;
	        boolean isIgnore = false;
	        for(String line : source){
	            //if there is a // in the line, remove it ans everything to the right until end
	            //if there is a /*, keep a flag and wait for the pairing */ so as to close it
	            if(isIgnore && !line.contains("*/"))
	                continue;//if its already a part of a block comment
	            //check if it ends
	            if(isIgnore && line.contains("*/")){
	                //it ends here
	                line = line.substring(line.indexOf("*/")+2);
	                isIgnore = false;
	            }
	            //else keep going
	            if(line.contains("//")){
	                //strip everything to its right
	                //System.out.println(line);
	                line = line.substring(0, line.indexOf("//"));
	                //System.out.println(line);
	            }
	            //check for block comment
	            if(line.contains("/*")){
	                if(line.contains("*/"))
	                    line = line.substring(0, line.indexOf("/*"));
	                else{
	                    line = line.substring(0, line.indexOf("/*"));
	                    isIgnore = true;
	                }
	                
	            }
	            if(!line.equals("") && line.length() >= 1){
	                // if(ans.size() >= 1){
	                // String test = ans.get(ans.size() - 1);
	                //     if(test.length() >=1 && test.charAt(test.length() - 1) != ';'){
	                //         ans.remove(ans.size() - 1);
	                //         ans.add(test+line);
	                //     }
	                // }
	                // else
	                    ans.add(line);
	            }
	        }
	        return ans;
	    }
	    
	    
	    //******************************
	    
	    //******************************
	    
	
	public static void main(String[] args) {
		String[] source = { "/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;",
				"/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}" };
		String line =   "// variable declaration";
		System.out.println(line.substring(0));
		System.out.println(line.substring(0,line.indexOf("//")));
		
	}
}
