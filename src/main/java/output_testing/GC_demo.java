package output_testing;

public class GC_demo {
	
	public static void main(String[] args) throws InterruptedException{
		GC_demo obj = new GC_demo();
		String s = new String();
		obj = null;
		s = null;
		//or the GC can also be invoked by Runtime.runtime.gc();
		System.gc();
		//Thread.sleep(1000);
		System.out.println("main ends here");
	}
	
	@Override
	public void finalize(){
		System.out.println("finalize called");
	}

}
