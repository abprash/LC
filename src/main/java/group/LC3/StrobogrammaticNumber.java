package group.LC;

public class StrobogrammaticNumber {
	
	public static void main(String[] args){
		System.out.println(Integer.toBinaryString(69));
		System.out.println(Integer.toBinaryString(818));
		System.out.println(Integer.toBinaryString(88));
		System.out.println(Integer.toBinaryString(888));
	}

	
	class Solution {
	    public boolean isStrobogrammatic(String num) {
	        int l = 0, r = num.length() -1 ;
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
}
