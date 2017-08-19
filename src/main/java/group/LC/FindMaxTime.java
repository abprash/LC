package com.leetcode.www;

import java.util.ArrayList;
import java.util.Arrays;

public class FindMaxTime {
	static ArrayList<String> times = new ArrayList<String>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(8,1,2,3);
		//Arrays.sort(a);
		String s = "asdfgh";
		StringBuilder newS = new StringBuilder(s).reverse();
		String t = newS.toString();
		System.out.println(s.substring(0,4));
	}

	public static String solution(int A, int B, int C, int D) {
        // write your code in Java SE 8
        //convert it into a string
        //find all the permutations
        String digits = new String();
        digits = ""+A+B+C+D;
        System.out.println(digits);
        //findPermutations(
        findPermutations("",digits);
        int maxmm = 0, maxhh = 0;
        String maxTime = "0000";
        for(String t : times){
        	System.out.println(t);
        	int mm = Integer.parseInt(""+t.charAt(2) + t.charAt(3));
        	int hh = Integer.parseInt(""+t.charAt(0) + t.charAt(1));
        	if(hh >= maxhh && hh<=23 && mm<=59 && Integer.parseInt(t) >= Integer.parseInt(maxTime)){
        		maxTime = t;
        		maxhh = hh;
        		maxmm = mm;
        	}
        }
        System.out.println("max time "+maxTime);
        return digits;
    }
    public static void findPermutations(String prefix, String str){
        //find all the permutations
        int len = str.length();
        if(len==0){
            //System.out.println(prefix);
            times.add(prefix);
        }
        else{
            for(int i=0;i<len;i++){
                findPermutations(prefix+str.charAt(i),str.substring(0,i)+str.substring(i+1,len));
                }
            
            }
        }
}
