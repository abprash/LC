package multithreading;

public class Tricky1 {    
	// constructor
	Tricky1()
    {
        System.out.println("Geeksforgeeks");
        
    }
     
	//its called only once
	//static variables are created and initialized when the class is loaded
	
    
	static Tricky1 a = new Tricky1(); //line 8
    
	
	//on the other hand
	//if there were no static keyword,
	//then, it would result in a stack overflow error
	// Tricky1 so = new Tricky1();
	
	
    public static void main(String args[])
    {
    	//Tricky1 b; //line 12
        //b = new Tricky1();
	 
        Integer a = 127, b = 127;
        System.out.println(a == b);
 
        Integer c = 100, d = 100;
        System.out.println(c == d);
	    
    }
}

class Tricky2{
	Tricky2()
    {
        System.out.println("Geeksforgeeks");
    }
}