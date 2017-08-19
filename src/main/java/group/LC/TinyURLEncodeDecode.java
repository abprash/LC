package com.leetcode.www;

public class TinyURLEncodeDecode {
	public static String encodeIntoTiny(String url){
		url = "https://leetcode.com/problems/design-tinyurl";
		System.out.println(url.hashCode());
		//now convert this hashcode into hex
		
		String hashVal = Integer.toHexString(url.hashCode()*-1);
		//hashVal = "123421";
		///////////1192993
		//int hex = Integer.toHexString(hashVal,16);
		System.out.println(hashVal);
		return "";
	}
	
	public static String decodeIntoURL(String tiny){
		return "";
	}
	
	public static void main(String[] args){
		TinyURLEncodeDecode obj = new TinyURLEncodeDecode();
		obj.encodeIntoTiny("Ad");

	}

}
