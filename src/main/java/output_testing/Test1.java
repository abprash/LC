package output_testing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Test1 {	

	/*public static void m1()
    {
        String s1 = "abc";
        String s2 = s1;
        s1 += "d";
        System.out.println(s1 + " " + s2 + " " + (s1 == s2));
 
        StringBuffer sb1 = new StringBuffer("abc");
        StringBuffer sb2 = sb1;
        sb1.append("d");
        System.out.println(sb1 + " " + sb2 + " " + (sb1 == sb2));
    }
	
	public static void f2()
    {
        short s = 0;
        int x = 0x123;
        //int y = 08;
        int y1 = 01;
        int y2 = 02;
        int y3 = 03;
        int y4 = 04;
        int y5 = 05;
        int y6 = 06;
        
        
        //int z = 112345;
 
        //s += z;
        
        //careful when prefixing numbers with 0 or 0x
        //0 -> compiler automatically converts it into octal number
        //0x -> it is understood by the compiler as hex
        System.out.println(x);
        System.out.println(Integer.toOctalString(x));
        System.out.println(Integer.toHexString(x));
    }*/
	
	
	
	public static void main (String[] args) 
    {
        Object i = new ArrayList().iterator();
        Object num = 9;
        System.out.println( (num instanceof Object)+": int and Object");
        System.out.println( (num instanceof Integer)+": int and Integer");
        System.out.println( (num instanceof Long)+": int and Long");
        System.out.println( (num instanceof Double)+": int and Double");
        System.out.println( (num instanceof Float)+": int and Float");
/*        System.out.print((i instanceof List) + ", "); 
        System.out.print((i instanceof Iterator) + ", "); 
        System.out.print((i instanceof Object) + ", "); 
        System.out.print(i instanceof ListIterator); */
        
    } 
	
} 