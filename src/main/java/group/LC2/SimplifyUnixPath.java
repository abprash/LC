package group.LC2;
import java.util.*;

public class SimplifyUnixPath {


    public String simplifyPath(String path) {
        if(path == null || path.equals("/"))
            return path;
        
        //rules to simplify
        //parse the string and evaluate the path...
        //this is not a problem of simple string substitution
        String[] components = path.split("/");
        Stack<String> stack = new Stack<>();
        for(int i=0; i<components.length; i++){
            String component = components[i];
            if(component.equals(".") || component.equals("")){
                //just carry on
            }
            else if(component.equals("..")){
                //go to parent - so we pop the stack
                if(!stack.isEmpty())
                    stack.pop();
            }
            else
                stack.push(component);
        }
        //now start unravelling them back
        String ans = "";
        while(!stack.isEmpty()){
            ans = "/"+stack.pop() + ans;
        }
        //if stack was empty
        if(ans.equals(""))
            return "/";
        return ans;
    }
}