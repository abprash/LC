package com.leetcode.www;

import java.util.Stack;

public class ReverseWordsInString {
	//given a string like "ajsg bnm asdf hjkl qwer"
	//reverse the words alone into - "gsja mnb fdsa lkjh rewq"
	
	public static void main(String[] args)
	{
		//
		wordsReverserInString("ajsg bnm asdf hjkl qwer");
	}
	//algo
	//parse thro the string once storing the length of each word
	//into a new array
	//next go to the exact number of spaces and reverse it
	
	public static String wordsReverserInString(String test)
	{
		String resultString = new String();
		String reversedWord = new String();
		//declare a stack for storing each word
		Stack<Character> s = new Stack<Character>();
		//find the number of words in the string
		//no. of spaces + 1 = no. of words
		int spaces = 0;
		for(int i=0;i<test.length();i++)
		{
			char c = test.charAt(i);
			if(c != ' ')
				s.push(c);
			else
			{
				//keep popping until the stack is empty
				while(!s.isEmpty())
				{
					//keep appending to the resultString
					reversedWord += "" + s.pop();
				}
				resultString+=reversedWord+" ";
				reversedWord = "";
			}
		}
		while(!s.isEmpty())
		{
			//keep appending to the resultString
			reversedWord += "" + s.pop();
		}
		resultString+=reversedWord;
		//reversedWord = "";
		System.out.println(resultString);
		return resultString;
		
	}
}
