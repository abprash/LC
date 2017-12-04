package group.LC;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
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
    		/*String x = "PORT:AXN,0,10;BGT,20,30;CXZ,10,30|BENCH:AXN,50,10;BGT,30,30;DFG,30,20;XYZ,0,10";
    		System.out.println(Arrays.toString(x.split("\\|",2)));
    		List<Asset> list = new ArrayList<>();
    		Collections.sort(list, (Asset a, Asset b) -> a.a.compareTo(b.a));
    		double navFinal = (double) Math.round(30 * 100) /100;
    		System.out.println(navFinal);
    		String x1 = String.format("%.2f",navFinal);
    		System.out.println(x1);
    		StringBuilder sb = new StringBuilder();
    		new String(sb);
    		//System.out.printf("%.2f",navFinal);
    		System.out.println(gcd(2,20));
    		 try {
    		        System.out.println("hello");
    		        System.exit(0);
    		    }
    		    finally {
    		        System.out.println("bye");
    		    } */
    		
    	String a = "0123456";
    	System.out.println(a.substring(7));
    }
    
    public static int gcd(int a, int b){
    	if(a == 0 || b == 0)
    		return a+b;
    	else
    		return gcd(a,b%a);
    }
    
    public void process() {
		isUpdate = false;
		 System.out.println("Reached here");
		 System.out.println(eventBuffer.length);

		for (String line : eventBuffer) {

			String[] split = split(s, "@");
			String date = split(split[0], " ")[0];
        String time = split(split[0], " ")[1];
        //xx:xx:xx.yyy
        String delay = split(split[1], ":")[1].trim();
        String accValues = split[2];
        String[] xyz = split(accValues, ",");

        String x = xyz[0].split(":")[1].trim();
        String y = xyz[1].split(":")[1].trim();
        String z = xyz[2].split(":")[1].trim();

        //System.out.println(" x = " + x +" ,y = " + y + ",z = " + z + ",Time = " + time + ",Delay = " + delay);
        SimpleDateFormat sdf = new SimpleDateFormat("MM-DD HH:mm:ss.SSS");
        Calendar c = Calendar.getInstance();
				
				 Calendar c = Calendar.getInstance();
	         String[] splitTime = time.split(" ");
	         java.util.Date d = null;
	         try {
	               d = sdf.parse(date+" "+time);
	         } catch (Exception e) {
	               e.printStackTrace();
	         }
	         c.setTime(d);
	         System.out.println(c);
	         //extracting and putting in the time values
	         long timeArr[] = new long[4];
	         timeArr[0] = Long.valueOf(c.get(Calendar.SECOND));
	         timeArr[1] = Long.valueOf(c.get(Calendar.SECOND));
	         timeArr[2] = Long.valueOf(c.get(Calendar.MILLISECOND));
	         timeArr[3] = Long.valueOf(c.get(Calendar.MILLISECOND));
	         sensor.currEvent.readSecond = timeArr[0];
			 sensor.currEvent.readMicroSecond = timeArr[1];
			 sensor.currEvent.second = timeArr[2];
			 sensor.currEvent.microSenond = timeArr[3];
	
	         //extracting and putting in the accelerometer values
	         sensor.currEvent.values[0] = Float.parseFloat(x)
			 					* SensorNativeNexusImpl.CONVERT_SI;
			 sensor.currEvent.values[1] = Float.parseFloat(y)
			 				* SensorNativeNexusImpl.CONVERT_SI;
			 sensor.currEvent.values[2] = Float.parseFloat(z)
			 				* SensorNativeNexusImpl.CONVERT_SI;
		}
		
		public static String[] split(String s, String c){
			   
	        List<String> res = new ArrayList<>();
	        int start = 0;
	 
	        for(int i = 0; i < s.length(); i++){
	            if(s.charAt(i) == c.charAt(0)){
	                String iter = s.substring(start, i);
	                if(sanityCheck(iter)){
	                    res.add(iter);
	                }
	                start = i + 1;
	            }
	        }
	       
	        String iter = s.substring(start);
	        if(sanityCheck(iter)){
	            res.add(iter);
	        }
	       
	        return res.toArray(new String[res.size()]);
	    }
		
		public static boolean sanityCheck(String s){
	        return s.length() == 0 ? false:true;
	    }
}

class Asset{
	public String a;
	public int b;
	public int c;
}
