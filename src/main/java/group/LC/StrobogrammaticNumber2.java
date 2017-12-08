package group.LC;

public class StrobogrammaticNumber2 {

}

//AC Solution !!!!!!!!!!!!!!!!!!!!
//MASSSSSSS


class Solution {
    //
    public List<String> findStrobogrammatic(int n){
        //using math and recursion
        return helper(n,n);
    }
    //

    public List<String> helper(int n, int m){
        if(n == 0)
            return new ArrayList<String>(Arrays.asList(new String[]{""}));
        if(n == 1)
            return new ArrayList<String>(Arrays.asList(new String[]{"0","1","8"}));
        //now the recursive magic
        
        //will construct the central list for us 
        List<String> list = helper(n-2, m);
        
        List<String> ans = new ArrayList<>();
        for(String center : list){
            if(n < m)
                ans.add("0"+center+"0"); //this indicates that the digit formed is still incomplete, more nos. will be added, so this can be entirely 0 too
            ans.add("1"+center+"1");
            ans.add("6"+center+"9");
            ans.add("8"+center+"8");
            ans.add("9"+center+"6");
        }
        return ans;
    }
    public boolean isStrobogrammatic(String num){
        int l = 0, r = num.length() -1 ;
        if((num.indexOf("2") >= 0) || (num.indexOf("3") >= 0) || (num.indexOf("4") >= 0) || (num.indexOf("5") >= 0) || (num.indexOf("7") >= 0))
            return false;
        while(l<=r){
            if(num.charAt(l) == '6' && num.charAt(r) == '9' || num.charAt(l) == '9' && num.charAt(r) == '6'){}
            else if(num.charAt(l) == '8' && num.charAt(r) == '8'){}
            else if(num.charAt(l) == '1' && num.charAt(r) == '1'){}
            else if(num.charAt(l) == '0' && num.charAt(r) == '0'){}
            else
                return false;
            l++;
            r--;
        }
        return true;
    }
    //

}
//Medium difficulty
//***************************************

//TIME LIMIT EXCEEDED!!!!!!!!
//7/13 cases passed

class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> ans = new ArrayList<>();
        if(n == 0)
            return ans;
        //we need to find the start number based on n
        long start;
        if(n == 1)
            start = 0;
        else
            start = (long) Math.pow(10, (n-1));
        long end = (long)  Math.pow(10, n);
        for(long i=start; i<end; i++){
            if(isStrobogrammatic(Long.toString(i)))
                ans.add(Long.toString(i));
        }
        return ans;
    }
    
    public boolean isStrobogrammatic(String num) {
        int l = 0, r = num.length() -1 ;
        if((num.indexOf("2") >= 0) || (num.indexOf("3") >= 0) || (num.indexOf("4") >= 0) || (num.indexOf("5") >= 0) || (num.indexOf("7") >= 0))
            return false;
        while(l<=r){
            if(num.charAt(l) == '6' && num.charAt(r) == '9' || num.charAt(l) == '9' && num.charAt(r) == '6' ){}
            else if(num.charAt(l) == '8' && num.charAt(r) == '8'  ){}
            else if(num.charAt(l) == '1' && num.charAt(r) == '1'  ){}
            else if(num.charAt(l) == '0' && num.charAt(r) == '0'  ){}
            else
                return false;
            l++;
            r--;
        }
        return true;
    }
}