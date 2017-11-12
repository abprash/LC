package output_testing;

public class MyEqualityTest {
	
	public static void main(String[] args){
		A a1 = new A();
		A a2 = new A();
		A a3 = new A();
		System.out.println(a1==a3);
		a1 = a3;
		System.out.println(a1==a3);
		a1.s = "sdf";
		System.out.println(a3.s);
		Integer a = new Integer(12), b=new Integer(12);
		System.out.println(a == b); // will print false
		System.out.println(a == b);
	}
}

class A{
	public String s;
}

class B{
	public String s;
}
