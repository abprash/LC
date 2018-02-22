package group.LC;

/*
 * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Example:
Given "bcabc"
Return "abc"

Given "cbacdcbc"
Return "acdb"


 * 
 * 
 * 
*/

public class RemoveDuplicateLetters_Hard {


    public String removeDuplicateLetters(String s) {
        if(s == null || s.length() == 0)
            return  s;
       //store the counts and visited status in arrays
        int[] counts = new int[26];
        boolean[] visited = new boolean[26];
        //store the counts
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            counts[c-'a']++;
        }
        Stack<Character> stack = new Stack<>();
        //now iterate again over the string
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int index = c-'a';
            //decrement the count now that we just visited this
            counts[index]--;
            
            //if already visited do not bother
            if(visited[index])
                continue;
            //if not, lets try putting into the stack
            //we will only allow it in the stack if it is smaller than the one already present
            //and the count of the char in the stack is GE than 0
            while(!stack.isEmpty() && c < stack.peek() && counts[stack.peek()-'a'] > 0){
                //which means, the char inside is greater than c, and there are more of peeked later in the string
                //pop the fuker
                visited[stack.pop() - 'a'] = false;
                
            }
            stack.push(c);
            //mark c as visited
            visited[index]= true;
            
        }
        //
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.insert(0,stack.pop());
        return sb.toString();
    }
}