package group.LC;


//All test cases passed.. finished in record time

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if(s == null || s.equals("") || numRows <= 0)
            return s;
        //generate our blueprint array ie our recurriing pattern to use
        List<Integer> bluePrint = new ArrayList<>();
        for(int i=0; i<numRows; i++){
            bluePrint.add(i);
        }
        for( int i=numRows-2 ; i>0; i--){
            bluePrint.add(i);
        }
       
        String[] ans = new String[numRows];
        for(int i=0, j=0; i<s.length(); i++, j++){
            //get the position in the ans array
            int pos = bluePrint.get(j % bluePrint.size());
            //get the current char
            char c = s.charAt(i);
            //append it at that point
            if(ans[pos] == null)
                ans[pos]=c+"";
            else
                ans[pos]+=c;
        }
        return stringify(ans);
    }
    
    //helper method to convert a string array to one string
    public String stringify(String[] arr){
        StringBuilder ans  = new StringBuilder();
        for(int i=0; i<arr.length; i++){
            if(arr[i]!= null)
            ans.append(arr[i]);
        }
        return new String(ans);
    }
}