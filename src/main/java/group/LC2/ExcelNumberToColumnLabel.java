package group.LC2;

public class ExcelNumberToColumnLabel {

}
class Solution {
    public String convertToTitle(int n) {
        String template = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if(n <= 26)
            return template.charAt(n-1)+"";
        String ans = "";
        boolean isExit = false;
        //n-=26;
        //its bigger than 26
        //
        while(n > 0){
            char c;
            //get the position of the char mod 26 -> this is the result's first char from the right
            int pos = (n%26) - 1;
            //pos can be negative, handle that
            //when its negative, decrement n by 1
            if(pos == -1){
                pos = 25;
                n--;
            }
            c = template.charAt(pos);
            //thats why we attach it from the right
            ans = c + ans ;
            n/=26;
        }
        return ans;
    }
}