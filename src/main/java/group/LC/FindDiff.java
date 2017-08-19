package com.leetcode.www;

public class FindDiff {
	public static void main(String[] args)
	{
		findTheDifference("adfasd", "aaddssf");
	}
	public static char findTheDifference(String s, String t) {
        //get the ascii sum of all the chars in s
        //get the ascii sum of all chars in t
        int sSum = 0, tSum = 0;
        for(int i=0;i<s.length();i++)
        {
            sSum+=s.charAt(i);
        }
        for(int i=0;i<t.length();i++)
        {
            tSum+=t.charAt(i);
        }
        System.out.println(tSum+","+sSum);
        System.out.println(tSum - sSum);
        char result = (char) ((char) tSum - sSum);
        return result;
    }

}
