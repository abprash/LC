package group.LC;

import java.util.Arrays;

public class Segregate0s1sand2s {
	static int sum = 0;
	public static void main(String[] args){
		int[] arr = {2,1,0,1,1,1,2,2,1,0};
		//System.out.println(Arrays.toString(segregate(arr)));
		fibo(6);
		System.out.println("sum is"+sum);
		System.out.println(fact(50));
		checkingBitwiseOperators(4,4);
		System.out.println("=============");
		checkingBitwiseOperators(3,3);
		System.out.println("=============");
		checkingBitwiseOperators(5,5);
		System.out.println("=============");
		checkingBitwiseOperators(6,6);
	}
	
	public static double fact(double x){
		//base case
		if(x == 1)
			return x;
		else
			return x * fact(x-1);
	}
	
	public static void fibo(int n){
		int a = -1, b=1, c=0;
		for(int i=0; i<n ;i++){
			c = a+b;
			a = b;
			b = c;
			sum = sum + c;
			System.out.println(c);
		}
	}
	
	public static void checkingBitwiseOperators(int dividend, int divisor){
		for(int i=1; i<=10; i++)
			System.out.println((dividend*i) & divisor);
	}
	public static int[] pushZerosToLeft(int[] arr){
		if(arr == null)
			return null;
		System.out.println(Arrays.toString(arr));
		//keep two pointers
		int p1 = 0;
		int p2 = arr.length-1;
		int num1 = 0;
		while(p1 < p2){
			int temp = 0;
			if(arr[p1]!= num1 && arr[p2]== num1){
				temp = arr[p1];
				arr[p1] = arr[p2];
				arr[p2] = temp;
				p1++;
				p2--;
			}
			else if(arr[p1]== num1 && arr[p2]> num1){
				p2--;
				p1++;
			}
			else{
				p2--;
			}
			System.out.println("p1 and p2 - "+p1+","+p2);
		}
		return arr;
	}
	
	public static int[] segregate(int[] arr){
		if(arr == null)
			return null;
		System.out.println(Arrays.toString(arr));
		//keep two pointers
		int p1 = 0;
		int p2 = arr.length-1;
		int num1 = 0;
		int pos = 0;
		int[] contents = {0,1,2};
		while(p1 < arr.length){
			int temp = 0;
			if(arr[p1]!= num1 && arr[p2]== num1){
				temp = arr[p1];
				arr[p1] = arr[p2];
				arr[p2] = temp;
				p1++;
				p2--;
			}
			else if(arr[p1]== num1 && arr[p2]> num1){
				p2--;
				p1++;
			}
			else{
				p2--;
			}
			
			if(p1>p2 || p1 == p2){
				//reset p2
				p2 = arr.length-1;
				pos++;
				if(pos > contents.length-1)
					break;
				num1 = contents[pos];
				System.out.println("num1--"+num1);
				//now sort 1s and 2s
			}
			System.out.println("p1 and p2 - "+p1+","+p2);
		}
		return arr;
	}

}
