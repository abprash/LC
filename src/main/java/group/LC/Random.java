package group.LC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Random {
	
	public static int getFirstRepeatingNumber(int[] arr ){
		if(arr == null || arr.length == 0)
			return Integer.MIN_VALUE;
		//try ORing everything, when the value does not change then return the number
		int ans = arr[0];
		for(int i=1; i<arr.length; i++){
			int temp = ans;
			ans &= arr[i];
			if(ans == temp)
				return arr[i];
		}
		return Integer.MIN_VALUE;
	}
	
	public static int getMaxNumberStoredInInteger(){
		int ans = 0;
		for(int i=0; i<(Integer.MAX_VALUE); i++){
			ans+=i;
		}
		return ans;
	}
	public static void main(String[] args){
		int[] arr = {1,2,3,4,5,6,7,8,8,9,10};
		int[] arr2 = {1,10,11,12,13,2,3,4,5,6,7,8,9};
		System.out.println(getFirstRepeatingNumber(arr));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(getMaxNumberStoredInInteger());
		List<String> l = new ArrayList<>();
		for(Integer i : arr2){
			//System.out.println(i);
			l.add(Integer.toString(i));
		}
		Collections.sort(l);
		System.out.println(l);
		String s = "sdjdf     jksfd sjdfhjs      jsdhdf   sjkdf                   kjsdfjs                !!";
		System.out.println(Arrays.toString(s.split("\\W+")));
		System.out.println(reverseWords("the     sky is blue!!"));
	}
	
	 public static String reverseWords(String s) {
	        //s may have trailing or leading spaces
	        //trim them
	        //separate based on spaces
	        if(s == null)
	            return null;
	        //s = s.trim();
	        String[] words = s.split("[ ]+");
	        StringBuilder sb = new StringBuilder();
	        for(int i=words.length-1; i>=0; i--){
	            if(i == 0)
	            	sb.append(words[i]);
	            else
	            	sb.append(words[i]+" ");
	        }
	        System.out.println(1*2*3*4*5*6*7*8*9*10*11);
	        return new String(sb);
	    }
}
