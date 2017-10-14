package group.LC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
	
	public static boolean validateEmailID(String email_id){
		if(email_id == null || email_id.equals(" ") || email_id.length() <= 2 || !email_id.contains("@") || !email_id.contains(".") || email_id.contains(" ")){
			return false;
		}
		if(email_id.length() >= 300){
			return false;
		}
		return true;
	}
	
    public static void main( String[] args )
    {

    		/*String[] invalidEmails = {null,"   jennymecca@yahoo.co mmm ","   jennymecca@yahoo.commm   ", "","jennymeccayahoo.com","jhgfjsgfsj@kjsdhfksjdf",new String(new char[301]),"jennymecca@yahoo.com"};
    		for(String invalidEmail : invalidEmails){
    			System.out.println(validateEmailID(invalidEmail));
    		}*/
    		
    		////////////
    		String x = "PORT:AXN,0,10;BGT,20,30;CXZ,10,30|BENCH:AXN,50,10;BGT,30,30;DFG,30,20;XYZ,0,10";
    		System.out.println(Arrays.toString(x.split("\\|",2)));
    		List<Asset> list = new ArrayList<>();
    		Collections.sort(list, (Asset a, Asset b) -> a.a.compareTo(b.a));
    		double navFinal = (double) Math.round(30 * 100) /100;
    		System.out.println(navFinal);
    		String x1 = String.format("%.2f",navFinal);
    		System.out.println(x1);
    		//System.out.printf("%.2f",navFinal);
    		
    }
}

class Asset{
	public String a;
	public int b;
	public int c;
}
