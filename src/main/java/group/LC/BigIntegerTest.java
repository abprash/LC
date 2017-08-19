package com.leetcode.www;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class BigIntegerTest {


	    public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        Scanner in = new Scanner(System.in);
	        BigInteger num = new BigInteger("0");
	        num = new BigInteger(num.toString());
	        num = in.nextBigInteger();
	        BigInteger res= new BigInteger("1");
	        BigInteger i = new BigInteger("0");
	        for(i = BigInteger.valueOf(1);((i.compareTo(num)) <= 0);i = i.add(BigInteger.ONE)){
	            res = res.multiply(i);
	        }
	        
	        System.out.println(res);
	        
	        /////////////////////////
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        /*Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int k = in.nextInt();
	        int[] arr = new int[n];
	        for(int j=0;j<n;j++){
	            arr[j] = in.nextInt();
	        }
	        //add them to a set
	        HashSet<Integer> set = new HashSet<Integer>();
	        for(int i=0;i<n;i++){
	            for(int j=i+1;j<n;j++){
	                if((arr[i]+arr[j])%k != 0){
	                    set.add(arr[i]);
	                    set.add(arr[j]);
	                }
	            }
	        }*/
	    }
	    
	    
	}