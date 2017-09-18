package group.LC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Integer[] a = {1,2,3,4,5,6,7};
        List<Integer> l = Arrays.asList(a);
        Iterator<Integer> iter = l.iterator();
        while(iter.hasNext()){
        	int val = iter.next();
        	System.out.println(val);
        	l.add(19);
        	if(val == 19)
        		break;
        }
        
    }
}
