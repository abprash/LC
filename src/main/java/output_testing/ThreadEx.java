package output_testing;

import java.util.ArrayList;
import java.util.List;

public class ThreadEx extends Thread{

    public void run()
    {
        System.out.println("Hello..................."+this.getPriority());
    }
    
    public void exit(){
    	System.out.println("Bye.."+this.getPriority());
    }
	public static void main(String args[])
    {
        ThreadEx T1 = new ThreadEx();
        List<ThreadEx> l = new ArrayList<>();
        l.add(new ThreadEx());
        for(int i=1; i<=10; i++){
        	String name = Integer.toString(i);
        	l.add(new ThreadEx());
        	l.get(i).setPriority(i);
        	//temp.start();
        	//l.add(T1);
        }
        System.out.println(l.size());
        int i=0;
        while(!l.isEmpty()){
        	if(i>=0 && i<=9){
	        	(l.get(i)).start();
	        	i++;
        	}
        }
        System.out.println(l.size());
        //T1.start();
        //T1.stop();
        //T1.start();
    }
    /*Hello...................2
Hello...................1
Hello...................3
Hello...................5
Hello...................6
Hello...................4
Hello...................7
Hello...................8
Hello...................9
Hello...................10
     * 
     * 
    */
}
