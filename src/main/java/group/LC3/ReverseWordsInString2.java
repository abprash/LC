package group.LC;

public class ReverseWordsInString2 {


    public void reverseWords(char[] str) {
        
        //initial validation
        if(str == null || str.length <= 1)
            return;
        int len = str.length;
        for(int i=0; i<str.length/2; i++){
            char c = str[len - 1 - i];
            //swap curr char with c
            str[len-i-1] = str[i];
            str[i] = c;
        }
        int p1 = 0, p2 = 1;
        //now reverse each word individually
        while(p1 < str.length && p2 < str.length){
            while(p1 < str.length && str[p1] == ' ')
                p1++;
            while(p2 <str.length && str[p2] != ' ' )
                p2++;
            //System.out.println(p1+","+(p2-1));
            //invoke the reverse string here
            reverse(p1, p2-1, str);
            if(p1 == 0)
                p1++;
            //make p1 go to the nearest space
            while(p1 > 0 && p1 < str.length && str[p1] != ' '){
                p1++;
            }
            //p2 will be sitting on a space, so incr it
            p2++;
            
        }
        
        //System.out.println(Arrays.toString(str));
    }
    
    public void reverse(int start, int end, char[] str){
        //System.out.println("here!!");
        //we should reverse the words denoted by start and end on str
        if(start > end || str == null)
            return;
        int count = 0;
       for(int i=start; i<= start + (end-start)/2; i++){
           char temp = str[i];
           str[i] = str[end - count];
           str[end-count] = temp;
           count++;
       }
        return;
    }
}