package output_testing;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class GC_Demo2 {
    static GC_Demo2 t ;
     
    static int count =0;
     
    public static void main(String[] args) throws InterruptedException
    {
    	GC_Demo2 t1 = new GC_Demo2(), t2 = new GC_Demo2();
             
        // making t1 eligible for garbage collection
        t1 = null; // line 12
        
        t1 = new GC_Demo2();
        t1 = null;
        
        t2 = null;
        t2 = null;
             
        // calling garbage collector
        System.gc(); // line 15
             
        // waiting for gc to complete
        Thread.sleep(1000); 
     
        // making t eligible for garbage collection,
        t = null; // line 21
             
        // calling garbage collector
        System.gc(); // line 24
     
        // waiting for gc to complete
        Thread.sleep(1000); 
             
        System.out.println("finalize method called "+count+" times");
         
    }
     
    @Override
    protected void finalize() 
    { 
        count++;
         
        t = this; // line 38
             
    }
    
    public boolean checkIfTimeValid(String time, Set<Integer> table){
    	Set<Integer> table2 = new HashSet<>();
        //should be 2 digit
        if(time != null && time.length() == 2){
            int dig1 = Character.valueOf(time.charAt(0));
            int dig2 = Character.valueOf(time.charAt(1));
            if(table.contains(dig1) && table.contains(dig2))
                return true;
            else
                return false;
        }
        return false;
    }
     
}