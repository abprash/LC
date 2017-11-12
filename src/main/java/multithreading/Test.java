package multithreading;

public class Test {
	public void method1(){
		System.out.println("p");
	}
	
	public static void main(String[] args){
		Test t = new child();
		t.method1();
	}
}


class child extends Test{
	public void method1(int a){
		System.out.println("p");
	}
}

class T extends Thread{
	
	public void run(){
		System.out.println("In new thread>....");
	}
}