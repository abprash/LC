package com.leetcode.www;

public class NumberComplementTester {
	public static void main(String[] args)
	{
		System.out.println(new NumberComplementTester().findComplement(99));
	}
	public int findComplement(int num) {
        //first get the binary representation of the number
        //convert to string
        //keep reading the number.. as you keep reading, invert the bits and keep attaching to the string
        //return the number converted into a decimal number
        String binaryString = Integer.toBinaryString(num).toString();
        System.out.println(binaryString);
        String newComplementString = new String();
        for(int i=0;i<binaryString.length();i++)
        {
            if(binaryString.charAt(i) == '1')
                newComplementString+="0";
            else
                newComplementString+="1";
        }
        System.out.println(newComplementString);
        int result = 0;
        for(int i=newComplementString.length() - 1 ;i>=0;i--)
        {
            result+=(Integer.parseInt(Character.toString(newComplementString.charAt(i))) * Math.pow(2,i));
        }
        return result;
        //return 1;
    }

}
