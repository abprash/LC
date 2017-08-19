package com.leetcode.www;

public class MissingNumber {
	
	public static void main(String[] args){
		int a[] = {1,2,4,5,6};
	    int miss = getMissingNo(a);
	    System.out.println(miss);
	    numSetBits(3l);
	}
	
	public static int getMissingNo(int[] arr){
		if(arr == null)
			return 0;
		int x1 = arr[0], x2 = 1, res3 = 0;
		 for (int i = 1; i< arr.length; i++)
		        x1 = x1^arr[i];
		            
		    for (int i = 2; i <= arr.length+1; i++)
		        x2 = x2^i;         
		    
		    return (x1^x2);
	}
	
	public static int numSetBits(long a) {
	    String binary = Integer.toBinaryString((int)a);
	    System.out.println(binary);
	    int count = 0;
	    for(int i=0;i<binary.length();i++)
	    {	if(binary.charAt(i) == '1')
	    		count++;
	    }
	    System.out.println(count);
	    return count;
	}

}
